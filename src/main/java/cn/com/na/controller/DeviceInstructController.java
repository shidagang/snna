package cn.com.na.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.na.bean.DeviceInstruct;
import cn.com.na.bean.ResponseBean;
import cn.com.na.service.DeviceInstructService;
import cn.com.na.utils.ErrorCodeUtils;

/**
 * 
 * @author liuyong
 * 设备分类指令controller
 */
@Controller
@RequestMapping("/instruct")
public class DeviceInstructController {
	
	@Autowired
	private DeviceInstructService deviceInstructService;
	
	private int resCode = 201;
	private String msg = "";
	
	/**
	 * 添加设备分类指令
	 * @param DeviceInstruct
	  {
		"dcId":1,     //设备分类id
		"instruct":2,  //指令
		"note":"关闭"   //指令描述
	 }  
	 * @return
	 */
	@RequestMapping(value="/addDeviceInstruct",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean addDeviceInstruct(@RequestBody DeviceInstruct deviceInstruct){
		  ResponseBean bean = new ResponseBean();
		  if(null == deviceInstruct){
			  msg = ErrorCodeUtils.PARAMETER_IS_NULL;
			  resCode = ErrorCodeUtils.PARAM_ERROR;
		  }else{
			  try{
				  deviceInstructService.addDeviceInstruct(deviceInstruct);
				  resCode = ErrorCodeUtils.SUCCESS;
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
	 * @param DeviceInstruct
	  {
		"id":5
	  }
	 * @return
	 */
	@RequestMapping(value="/delDeviceInstruct",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean delDeviceInstruct(@RequestBody DeviceInstruct deviceInstruct){
		  ResponseBean bean = new ResponseBean();
		  if(null == deviceInstruct){
			  return bean;
		  }
		  try{
			  deviceInstructService.delDeviceInstruct(deviceInstruct);
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
	 * 根据设备分类id查询指令列表
	 * @param dcId   设备分类id
	 *  queryDeviceInstructByDcId?dcId=1
	 * @return
	 */
	@RequestMapping(value="/queryDeviceInstructByDcId",method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean queryDeviceInstructByDcId(Integer dcId){
		  ResponseBean bean = new ResponseBean();
		  List<DeviceInstruct> list = null ;
		  if(null == dcId){
			  return bean;
		  }
		  try{
			  list = deviceInstructService.queryDeviceInstructByDcId(dcId);
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
