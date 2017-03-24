package cn.com.na.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.na.bean.DeviceClass;
import cn.com.na.bean.DeviceInfo;
import cn.com.na.bean.QueryResult;
import cn.com.na.bean.ResponseBean;
import cn.com.na.service.DeviceClassService;
import cn.com.na.utils.ErrorCodeUtils;

/**
 * 
 * @author liuyong
 * 设备分类controller
 */
@Controller
@RequestMapping("/class")
public class DeviceClassController {
	
	@Autowired
	private DeviceClassService deviceClassService;
	
	private int resCode = 201;
	private String msg = "";
	
	/**
	 * 
	 * @param DeviceInfo
	 {
		"dcName":"灯具",    //设备分类名称
		"description":"灯具",    //设备分类描述
		"note":"灯具"      //设备分类备注
	}
	 * @return
	 */
	@RequestMapping(value="/addDeviceClass",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean addDeviceClass(@RequestBody DeviceClass deviceClass){
		  ResponseBean bean = new ResponseBean();
		  if(null == deviceClass){
			  msg = ErrorCodeUtils.PARAMETER_IS_NULL;
			  resCode = ErrorCodeUtils.PARAM_ERROR;
		  }else{
			  try{
				  deviceClassService.addDeviceClass(deviceClass);
				  resCode = ErrorCodeUtils.SUCCESS;
				  msg = ErrorCodeUtils.OPER_SUCCESS;
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
	 *  删除设备分类
	 * @param DeviceClass
	 {
		"dcld":4     // 设备分类id
	 }
	 * @return
	 */
	@RequestMapping(value="/delDeviceClass",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean delDeviceClass(@RequestBody DeviceClass deviceClass){
		  ResponseBean bean = new ResponseBean();
		  if(null == deviceClass){
			  return bean;
		  }
		  try{
			  deviceClassService.delDeviceClass(deviceClass);
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
	 * 
	 * @param deviceClass
	 {
	       //为空查询全部
	 }
	 * @return
	 */
	@RequestMapping(value="/queryDeviceClass",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean queryDeviceClass(@RequestBody DeviceClass deviceClass){
		  ResponseBean bean = new ResponseBean();
		  List<DeviceClass> list = null;
		  try{
			  list =  deviceClassService.queryDeviceClass(deviceClass);
			  resCode = ErrorCodeUtils.SUCCESS;
			  msg = ErrorCodeUtils.OPER_SUCCESS;
		   }catch(Exception e){
			  e.printStackTrace();
			  resCode = ErrorCodeUtils.OPER_FAILED;
			  msg = ErrorCodeUtils.OPER_FAILED_MSG;
		  }
		  bean.setData(list);
		  bean.setRetCode(resCode);
		  bean.setMsg(msg);
		  return bean;
	}
	
	
}
