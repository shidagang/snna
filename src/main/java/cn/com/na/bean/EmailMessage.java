package cn.com.na.bean;

import java.io.Serializable;

/**
 * EmailMessage类
 * @author liuyong
 *
 */
public class EmailMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 邮件标题
	 */
	private String subject;
	/**
	 * 邮件接收者
	 */
	private String receiver;
	/**
	 * 邮件内容
	 */
	private String content;

	/**
	 * 语言
	 */
	private String language;
	
	public EmailMessage(String subject, String receiver, String content,
			String language) {
		super();
		this.subject = subject;
		this.receiver = receiver;
		this.content = content;
		this.language = language;
	}
	

	public String getContent() {
		return content;
	}

	

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
