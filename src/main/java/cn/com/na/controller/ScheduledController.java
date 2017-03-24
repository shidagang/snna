package cn.com.na.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.na.bean.ResponseBean;
import cn.com.na.bean.ScheduledTask;
import cn.com.na.bean.TUserInfo;
import cn.com.na.bean.Task;
import cn.com.na.service.ScheduledService;
import cn.com.na.utils.ErrorCodeUtils;

/**
 * 
 * @author David
 * 定时任务
 */
@Controller
@RequestMapping("/scheduled")
public class ScheduledController {
	
	private String msg = "";
	private int resCode = 201;
	
	@Autowired
	private ScheduledService scheduledService;
	
//	 @RequestMapping(value="/addTaskToScheduled",method=RequestMethod.POST)
//	 @ResponseBody
//	 public String addTaskToScheduled(@RequestBody ScheduledTask scheduled){ 
//		 scheduledService.addTaskToScheuled(scheduled);
//		 return "OK";
//	 }
	 
	 @RequestMapping(value="/addScheduled",method=RequestMethod.POST)
	 @ResponseBody
	 public ResponseBean addScheduled(@RequestBody ScheduledTask scheduled){ 
		 ResponseBean bean  = new ResponseBean();
		 if(null == scheduled){
			 msg = ErrorCodeUtils.PARAMETER_IS_NULL;
		 }else{
			 try{
				 scheduledService.addScheduled(scheduled);
				 resCode = ErrorCodeUtils.SUCCESS;
				 msg = ErrorCodeUtils.GET_SUESS_MSG;
			 }catch(Exception e){
				 e.printStackTrace();
				 resCode = ErrorCodeUtils.UNKNOWN_ERR;
				 msg = ErrorCodeUtils.PARAMETER_EXCEPTION;
			 }
		 }

		bean.setMsg(msg);
		bean.setRetCode(resCode);
		return bean;
	 }

	 @RequestMapping(value="/delScheduled",method=RequestMethod.POST)
	 @ResponseBody
	 public ResponseBean delScheduled(@RequestBody ScheduledTask scheduled){ 
		 ResponseBean bean  = new ResponseBean();
		 if(null == scheduled){
			 msg = ErrorCodeUtils.PARAMETER_IS_NULL;
		 }else{
			 try{
				 scheduledService.delScheduled(scheduled);
				 resCode = ErrorCodeUtils.SUCCESS;
				 msg = ErrorCodeUtils.GET_SUESS_MSG;
			 }catch(Exception e){
				 e.printStackTrace();
				 resCode = ErrorCodeUtils.UNKNOWN_ERR;
				 msg = ErrorCodeUtils.PARAMETER_EXCEPTION;
			 }
		 }

		bean.setMsg(msg);
		bean.setRetCode(resCode);
		return bean;
	 }
	 
	 
	 /**
	  * 查询定时任务列表
	  * @param scheduled
	  {
		"deviceId":1,
		"userId":1
	  }
	  * @return
	  */
	 @RequestMapping(value="/queryScheduled",method=RequestMethod.POST)
	 @ResponseBody
	 public ResponseBean queryScheduled(@RequestBody ScheduledTask scheduled){ 
		 ResponseBean bean  = new ResponseBean();
		 List<ScheduledTask> list = null;
		 if(null == scheduled){
			 msg = ErrorCodeUtils.PARAMETER_IS_NULL;
		 }else if(null == scheduled.getDeviceId() || null == scheduled.getUserId()){
			 msg = ErrorCodeUtils.PARAMETER_IS_NULL_WITHUSERID_OR_DEVICEID;
		 }else{
			 try{
				 list = scheduledService.queryScheduled(scheduled);
				 resCode = ErrorCodeUtils.SUCCESS;
				 msg = ErrorCodeUtils.GET_SUESS_MSG;
			 }catch(Exception e){
				 e.printStackTrace();
				 resCode = ErrorCodeUtils.UNKNOWN_ERR;
				 msg = ErrorCodeUtils.PARAMETER_EXCEPTION;
			 }
		 }
		bean.setData(list);
		bean.setMsg(msg);
		bean.setRetCode(resCode);
		return bean;
	 }
	 
	 
	 
	 /**
		 * 
		 * @param userInfo
		 * 
		   {
				"taskTime":"2016-12-29 20:03",     //执行时间
				"note":"修改定时任务",					//备注
				"isActive":0,						//是否激活
				"message":"修改定时任务",				//发送消息
				"mac":"dd",							//设备mac
				"sid":2								//定时任务id
		   }
		 * @return
		 */
		@RequestMapping(value = "/updateScheduled", method = RequestMethod.POST)
		@ResponseBody
		public ResponseBean updateUserInfo(@RequestBody ScheduledTask scheduled) {
			ResponseBean bean = new ResponseBean();	
			try{
				scheduledService.updateScheduled(scheduled);
				bean.setMsg("更新成功!");
				bean.setRetCode(ErrorCodeUtils.SUCCESS);
			}catch(Exception e){
				bean.setMsg("更新失败!");
				bean.setRetCode(ErrorCodeUtils.UNKNOWN_ERR);
			}
			return bean;
		}
	 
	 
	 
}
