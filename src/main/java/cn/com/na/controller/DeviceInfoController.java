package cn.com.na.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.na.bean.Authorization;
import cn.com.na.bean.DeviceInfo;
import cn.com.na.bean.QueryResult;
import cn.com.na.bean.ResponseBean;
import cn.com.na.service.DeviceInfoService;
import cn.com.na.utils.ErrorCodeUtils;

/**
 * 
 * @author David
 *
 */
@Controller
@RequestMapping("/device")
public class DeviceInfoController {
	
	@Autowired
	private DeviceInfoService deviceInfoService;
	
	private int resCode = 201;
	private String msg = "";
	
	/**
	 * 
	 * @param DeviceInfo
	 * @return
	 */
	@RequestMapping(value="/addDeviceInfo",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean addDeviceInfo(@RequestBody DeviceInfo deviceInfo){
		  ResponseBean bean = new ResponseBean();
		  if(null == deviceInfo){
			  msg = ErrorCodeUtils.PARAMETER_IS_NULL;
			  resCode = ErrorCodeUtils.PARAM_ERROR;
		  }else{
			  try{
				  int count = deviceInfoService.queryDeviceInfoByUnique(deviceInfo.getMac());
				  if(0 == count){
					  deviceInfoService.addDeviceInfo(deviceInfo);
					  resCode = ErrorCodeUtils.SUCCESS;
					  msg = ErrorCodeUtils.OPER_SUCCESS;
				  }else{
					  msg = ErrorCodeUtils.DEVICE_IS_EXISTENCE_MSG;
					  resCode = ErrorCodeUtils.DEVICE_IS_EXISTENCE;
				  }
			   }catch(Exception e){
				  e.printStackTrace();
				  msg = ErrorCodeUtils.DEVICE_ADD_FAILED_MSG;
				  resCode = ErrorCodeUtils.DEVICE_ADD_FAILED;
			  }
		  }
		  
		  bean.setRetCode(resCode);
		  bean.setMsg(msg);
		  return bean;
	}

	/**
	 * 
	 * @param DeviceInfo
	 * @return
	 */
	@RequestMapping(value="/getDeviceInfo",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean getDeviceInfo(@RequestBody DeviceInfo deviceInfo){
		  ResponseBean bean = new ResponseBean();
		  if(null == deviceInfo) return bean;
		  
		  try{
			  deviceInfoService.addDeviceInfo(deviceInfo);
			   bean.setRetCode(200);
		   }catch(Exception e){
			  e.printStackTrace();
		  }
		  
		  bean.setRetCode(resCode);
		  return bean;
	}
	
	
	/**
	 *  删除设备
	 * @param DeviceInfo
	 * {
		"deviceId":1,   //设备id
		"userId":2      //当前登录用户id
		}
	 * @return
	 */
	@RequestMapping(value="/delDeviceInfo",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean delDeviceInfo(@RequestBody DeviceInfo deviceInfo){
		  ResponseBean bean = new ResponseBean();
		  if(null == deviceInfo){
			  return bean;
		  }
		  
		  try{
			  deviceInfoService.delDeviceInfo(deviceInfo);
			  resCode = ErrorCodeUtils.SUCCESS;
			  msg = ErrorCodeUtils.OPER_SUCCESS;
		   }catch(Exception e){
			  e.printStackTrace();
			  resCode = ErrorCodeUtils.OPER_FAILED;
			  msg = ErrorCodeUtils.OPER_FAILED_MSG;
		  }
		  
		  bean.setRetCode(resCode);
		  bean.setMsg(msg);
		  return bean;
	}
	
	/**
	 * 分页查询设备列表
	 * @param DeviceInfo deviceInfo
	 * @return
	 * 
	 * {
		"userId":1, //用户ID
		"queryDeviceType":1,   // 1:查询所有设备，包括授权设备，其他值就查询属于自己的设备
		"currentPageIndex":1,  // 当前页数1开始
		"pageSize":10		   // 每页数据大小
	   }
	 */
	@RequestMapping(value = "/queryDeviceInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean queryDeviceInfo(@RequestBody DeviceInfo param) {
		ResponseBean bean = new ResponseBean();
		bean.setRetCode(201);
		List<DeviceInfo> deviceInfos = null;
		QueryResult result  = null;
		if(null == param){
			msg = ErrorCodeUtils.PARAMETER_IS_NULL;
			resCode = ErrorCodeUtils.UNKNOWN_ERR;
		}else{
			result = deviceInfoService.queryDeviceInfo(param);
			
			if(null == result || CollectionUtils.isEmpty(result.getResult())){
				resCode = ErrorCodeUtils.SUCCESS;
				msg = ErrorCodeUtils.NO_DATA_FOUND;
			}else{
				deviceInfos = result.getResult();
				resCode = ErrorCodeUtils.SUCCESS;
				msg = ErrorCodeUtils.GET_SUESS_MSG;
				bean.setData(deviceInfos);
				bean.setCurrentPageIndex(result.getCurrentPageIndex());
				bean.setTotalPage(result.getTotalPage());
				bean.setTotalNum(result.getTotalNum());
			}
		}
		bean.setRetCode(resCode);
		bean.setMsg(msg);
		return bean;
	}
}
