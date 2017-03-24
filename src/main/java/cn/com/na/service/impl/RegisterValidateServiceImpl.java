package cn.com.na.service.impl;

import org.springframework.stereotype.Service;

import cn.com.na.bean.Constants;
import cn.com.na.bean.EmailMessage;
import cn.com.na.bean.TUser;
import cn.com.na.bean.VerificationCode;
import cn.com.na.service.RegisterValidateService;
import cn.com.na.utils.PhapiAesUtil;
import cn.com.na.utils.SendEmail;

@Service("registerValidateService")
public class RegisterValidateServiceImpl implements RegisterValidateService {

	@Override
	public void sendRegisteremail(TUser tuser,String language){
		System.out.println("SendRegisteremail User:"+tuser.toString());
		String encode = PhapiAesUtil.encode(String.valueOf(tuser.getUserId()),Constants.ACC_KEY);
		StringBuffer sb = new StringBuffer();
		if("0".equals(language)){
		///邮件的内容{
		 sb.append("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活!</br>");
         sb.append("<a href=\"http://112.74.59.45:8080/SNNA/sendEmail/validate?cp=");
         sb.append(encode);
         sb.append("&la=");
         sb.append(language);
         sb.append("\">立即激活");
         sb.append("</a>");
		}else{
			 sb.append("Click on the link below to activate the account, 48 hours to take effect, otherwise the register account, link can be used only once, please activate as soon as possible!</br>");
	         sb.append("<a href=\"http://112.74.59.45:8080/SNNA/sendEmail/validate?cp=");
	         sb.append(encode);
	         sb.append("&la=");
	         sb.append(language);
	         sb.append("\">Immediately active .");
	         sb.append("</a>");
		}
		EmailMessage message = new EmailMessage("账号激活邮件",tuser.getAccount(),sb.toString(),language);
        //发送邮件
        SendEmail.send(message);
	}

	
	@Override
	public void sendResetPwdmail(TUser tuser,VerificationCode code,String language) {
		StringBuffer sb = new StringBuffer();
		if("0".equals(language)){
			//邮件的内容
			 sb.append("重置密码的验证码为:");
			 sb.append(code.getCode());
			 sb.append(" 请尽快验证!");
		}else{
			 sb.append("Reset password authentication code is:");
			 sb.append(code.getCode());
			 sb.append(" Please verify as soon as possible!");
		        
		}
		EmailMessage message = new EmailMessage("重置密码邮件",tuser.getAccount(),sb.toString(),language);
		 //发送邮件
        SendEmail.send(message);
	}
	
	
	
}

	