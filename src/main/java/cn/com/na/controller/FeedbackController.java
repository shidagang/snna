package cn.com.na.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.na.bean.FeedBack;
import cn.com.na.bean.ResponseBean;
import cn.com.na.bean.Task;
import cn.com.na.service.FeedBackService;
import cn.com.na.service.ScheduledService;
import cn.com.na.utils.ErrorCodeUtils;

/**
 * 
 * @author David
 *
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	
	
	@Autowired
	private FeedBackService feedbackService;
	
	private String msg = "";
	private int retCode = 201;

	 @RequestMapping(value="/addFeedBack",method=RequestMethod.POST)
	 @ResponseBody
	 public ResponseBean addFeedBack(@RequestBody  FeedBack feedBack){ 
		 ResponseBean bean  = new ResponseBean();
		 bean.setRetCode(201);
		 if(null == feedBack){
			  return bean;
		 }
		try{
			feedbackService.addFeedBack(feedBack);
			retCode = ErrorCodeUtils.SUCCESS;
			msg = ErrorCodeUtils.GET_SUESS_MSG;
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		bean.setRetCode(retCode);
		bean.setMsg(msg);
		 return bean;
	 }
}
