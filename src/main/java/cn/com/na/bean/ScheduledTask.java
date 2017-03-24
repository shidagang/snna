package cn.com.na.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 排程任务实体类
 * @author David
 * 
 * Table：scheduledtask；
 *
 */
public class ScheduledTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sid; //ID 自增
	private Integer deviceId;//设备ID
	private String taskTime;//执行时间
	private Integer userId;//用户ID
	private Date setTime;//设置任务日期。默认插入操作当前日期
	private String note;//备注
	private Integer isActive;//任务是否激活
	private String message; //发送消息	
	private String mac; //设备mac
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public String getTaskTime() {
		return taskTime;
	}
	public void setTaskTime(String taskTime) {
		this.taskTime = taskTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getSetTime() {
		return setTime;
	}
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "ScheduledTask [sid=" + sid + ", deviceId=" + deviceId
				+ ", taskTime=" + taskTime + ", userId=" + userId
				+ ", setTime=" + setTime + ", note=" + note + ", isActive="
				+ isActive + ", message=" + message + ", mac=" + mac + "]";
	}

	 
	
	
	

}
