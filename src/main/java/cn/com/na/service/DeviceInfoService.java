package cn.com.na.service;

import java.util.List;

import cn.com.na.bean.Authorization;
import cn.com.na.bean.DeviceInfo;
import cn.com.na.bean.QueryResult;

public interface DeviceInfoService {
	
	public int queryDeviceInfoByUnique(String mac);
	/**
	 * 添加设备
	 * @param deviceInfo
	 */
	public void addDeviceInfo(DeviceInfo deviceInfo);
	
	public void delDeviceInfo(DeviceInfo deviceInfo);
	
	public String queryDeviceMacInfoByDeviceId(int deviceId);
	
	public List<DeviceInfo> queryDeviceMacInfoByDeviceIds(List<Integer> scheduledId);

	public QueryResult queryDeviceInfo(DeviceInfo deviceInfo);
	
	public List<Authorization> queryAuthByUserIdAndDeviceId(Authorization auth);
}
