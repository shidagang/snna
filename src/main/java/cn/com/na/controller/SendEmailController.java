package cn.com.na.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.na.bean.Constants;
import cn.com.na.bean.ResponseBean;
import cn.com.na.bean.TUser;
import cn.com.na.service.TUserService;
import cn.com.na.utils.PhapiAesUtil;
import cn.com.na.utils.SendEmail;


@Controller
@RequestMapping("/sendEmail")
public class SendEmailController {
	
	@Autowired
	private TUserService tUserService;
	
	//http://112.74.59.45:8080/SNNA/sendEmail/validate?cp=046A340C9E1BB7835904670B9882A5EF&la=1
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public String validate(HttpServletRequest request, String cp,String la) {
		String forward = "validate_success";
		String message="该账号已经激活，无需再次激活!";
		String message2 ="激活时间已经超过48小时!";
		String decode = PhapiAesUtil.decode(cp,Constants.ACC_KEY);
		if("1".equals(la)){
			forward = "validate_success_en";
			message="The account has been activated, Do't need to activate";
			message2="Activation time has been more than 48 hours";
		}
		
		TUser tu = tUserService.getUserById(Integer.parseInt(decode));
		if(null == tu && "1".equals(la)){
			forward = "validate_failed_en";
			request.setAttribute("message", "Account activate Exception! Please contacts us");
			return forward;
		}
		
		if(null == tu && "0".equals(la)){
			forward = "validate_failed";
			request.setAttribute("message", "激活用户异常，请联系我们！");
			return forward;
		}
		
		if(0 == tu.getActivate() && "0".equals(la)){
        	tu.setActivate(1);
        	tUserService.updateUser(tu);
			forward = "validate_success";
        	request.setAttribute("message", message);

        	return forward;
		}
		
		if(0 == tu.getActivate() && "1".equals(la)){
        	tu.setActivate(1);
        	tUserService.updateUser(tu);
			forward = "validate_success_en";
        	request.setAttribute("message", message);
        	return forward;
		}
		
		if(tu.getActivate() == 1 && "0".equals(la) ){
			forward = "validate_failed";
        	request.setAttribute("message", message);
        	return forward;
		}
		if(tu.getActivate() == 1 && "1".equals(la) ){
			forward = "validate_failed_en";
        	request.setAttribute("message", message);
        	return forward;
		}
		
		Date ct = tu.getCreateTime();
		Date nt = new Date();
        long diff = nt.getTime() - ct.getTime(); 
        long diffTime = diff/(1000 * 60 * 60); 
        if(diffTime > 48){
        	if("0".equals(la)){
        		forward = "validate_failed";
        	}else{
        		forward = "validate_failed_en";
        	}
        	request.setAttribute("message", message2);
        }
		return forward;
	}
	
	
	
}
