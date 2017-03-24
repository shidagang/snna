package cn.com.na.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.na.bean.DeviceInfoVo;
import cn.com.na.bean.ResponseBean;
import cn.com.na.netty5.echo.server.EchoServerHandler;
import cn.com.na.utils.ErrorCodeUtils;

/**
 * 
 * @author David
 *
 */
@Controller
public class SendMessageController {
	
	private int resCode = 201;
	private String msg = "";
	
	 @RequestMapping(value="/sendMessage",method=RequestMethod.POST)
	 @ResponseBody
	 public ResponseBean sendMessage(@RequestBody DeviceInfoVo deviceInfoVo){ 
		 ResponseBean bean = new ResponseBean();
		 if(null == deviceInfoVo || null == deviceInfoVo.getMac() || null == deviceInfoVo.getMessage()){
			 msg = ErrorCodeUtils.PARAMETER_EXCEPTION;
			 resCode = ErrorCodeUtils.PARAM_ERROR;
		 }else{
			 try{
				 EchoServerHandler.sendMessageToClient(deviceInfoVo.getMac(), deviceInfoVo.getMessage());
				 resCode = ErrorCodeUtils.SUCCESS;
			 }catch(Exception e){
				 e.printStackTrace();
				 msg = ErrorCodeUtils.PARAMETER_EXCEPTION;
				 resCode = ErrorCodeUtils.UNKNOWN_ERR;
			 }
		 }
		 
		 bean.setRetCode(resCode);
		 bean.setMsg(msg);
		 return bean;
	 }
}
