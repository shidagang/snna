package cn.com.na.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.na.bean.Authorization;
import cn.com.na.bean.DeviceInfo;
import cn.com.na.bean.MultiDBPageUtil;
import cn.com.na.bean.QueryParam;
import cn.com.na.bean.QueryResult;
import cn.com.na.bean.ScheduledTask;
import cn.com.na.bean.SnnaLogger;
import cn.com.na.mapper.AuthorizationMapper;
import cn.com.na.mapper.DeviceInfoMapper;
import cn.com.na.mapper.ScheduledMapper;
import cn.com.na.service.DeviceInfoService;
import cn.com.na.utils.ErrorCodeUtils;
import cn.com.na.utils.ServiceException;

@Service("deviceInfoService")
public class DeviceInfoServiceImpl extends MultiDBPageUtil implements DeviceInfoService {

	private final static SnnaLogger logger = SnnaLogger.getLogger(DeviceInfoServiceImpl.class);
	@Autowired
	private DeviceInfoMapper deviceInfoMapper;
	
	@Autowired
	private AuthorizationMapper authorizationMapper;
	
	@Autowired
	private ScheduledMapper scheduledMapper;
	
	
	@Override
	public int queryDeviceInfoByUnique(String unique) {
		DeviceInfo info = (DeviceInfo) deviceInfoMapper.queryDeviceInfoByUnique(unique);
		return info ==null ? 0: info.getDeviceId();
	}

	@Override
	public void addDeviceInfo(DeviceInfo deviceInfo) {
		deviceInfoMapper.addDeviceInfo(deviceInfo);
	}

	@Override
	public String queryDeviceMacInfoByDeviceId(int deviceId) {
		
		return deviceInfoMapper.queryDeviceMacInfoByDeviceId(deviceId);
	}

	@Override
	public List<DeviceInfo> queryDeviceMacInfoByDeviceIds(List<Integer> scheduledId) {
		// TODO Auto-generated method stub
		return deviceInfoMapper.queryDeviceMacInfoByDeviceIds(scheduledId);
	}

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public void delDeviceInfo(DeviceInfo deviceInfo) throws ServiceException {
		try{
			//查询被授权设备
			Authorization auth = new Authorization();
			auth.setaUserId(deviceInfo.getUserId());
			auth.setDeviceId(deviceInfo.getDeviceId());
			List<Authorization> list = queryAuthByUserIdAndDeviceId(auth);
			//如果查询被授权设备列表为空，则删除设备本身,同时删除已授权的设备权限
			if(CollectionUtils.isEmpty(list)){
				//查询已授权设备
				auth = new Authorization();
				auth.setbUserId(deviceInfo.getUserId());
				auth.setDeviceId(deviceInfo.getDeviceId());
				list = queryAuthByUserIdAndDeviceId(auth);
				//删除已授权设备权限
				if(!CollectionUtils.isEmpty(list)){
					delAuthorization(list);
				}
				//删除设备本身
				deviceInfoMapper.delDeviceInfo(deviceInfo);
				//删除设备定时任务
				ScheduledTask scheduledTask = new ScheduledTask();
				scheduledTask.setDeviceId(deviceInfo.getDeviceId());
				scheduledMapper.delScheduled(scheduledTask);
			}else{
				//删除被授权设备权限
				delAuthorization(list);
			}
		}catch(ServiceException se){
			throw se;
		}catch(Exception ex){
			throw new ServiceException(ErrorCodeUtils.OPER_FAILED,"删除设备异常！",ex);
		}
		
	}
	
	public List<Authorization> queryAuthByUserIdAndDeviceId(Authorization auth){
		return authorizationMapper.queryAuthByUserIdAndDeviceId(auth);
	}
	
	public void delAuthorization(List<Authorization> list){
		Map<String, Object> param = new HashMap<String, Object>();
		List aIds = new ArrayList();
		for(Authorization au:list){
			aIds.add(au.getaId());
		}
		param.put("aIds", aIds);
		authorizationMapper.delAuthorization(param);
	}


	@Override
	public List<Long> countQuery(QueryParam queryParam) {
		try {
			return  deviceInfoMapper.queryDeviceInfoCountByParam((DeviceInfo) queryParam);
		} catch (Exception e) {
			logger.error("查询满足条件的记录数异常",e);
		}
		return null;
	}

	@Override
	public List<?> queryData(QueryParam queryParam) {
		return deviceInfoMapper.queryDeviceInfoByParam((DeviceInfo) queryParam);
	}
	
	@Override
	public QueryResult queryDeviceInfo(DeviceInfo deviceInfo) {
		 return getPageData(deviceInfo);
	}



}
