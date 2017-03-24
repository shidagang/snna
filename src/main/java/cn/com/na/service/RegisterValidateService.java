package cn.com.na.service;

import cn.com.na.bean.TUser;
import cn.com.na.bean.VerificationCode;

public interface RegisterValidateService {

	
	public void sendRegisteremail(TUser tuser,String language);
	/**
	 * 发送重置密码 验证码 邮件
	 * @param message
	 */
	public void sendResetPwdmail(TUser tuser,VerificationCode code,String language);
	
}
