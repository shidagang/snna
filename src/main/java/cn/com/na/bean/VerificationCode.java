package cn.com.na.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author liuyong
 * 验证码实体类
 * Table: verificationcode
 */
public class VerificationCode  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
		private Integer vid; //验证码id
		private String account;//用户id
		private String code;//验证码
		private Date effecttime;//失效日期
		
		
		
		public Integer getVid() {
			return vid;
		}
		public void setVid(Integer vid) {
			this.vid = vid;
		}
		
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Date getEffecttime() {
			return effecttime;
		}
		public void setEffecttime(Date effecttime) {
			this.effecttime = effecttime;
		}
		
		
		
		
		

}
