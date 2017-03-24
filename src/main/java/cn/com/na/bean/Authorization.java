package cn.com.na.bean;

import java.io.Serializable;

/**
 * 
 * @author David
 * 用户之间的授权
 * Table: authorized
 *
 */
public class Authorization extends QueryParam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer aId;//授权ID 自增长
	private Integer deviceId;//设备ID
	private String deviceName;//设备名称
	private Integer bUserId;//设备所属用户ID
	private Integer aUserId;//被授权用户ID
	private String aUserName;//被授权用户账户
	private String note;//备注
	
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	
	
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public Integer getbUserId() {
		return bUserId;
	}
	public void setbUserId(Integer bUserId) {
		this.bUserId = bUserId;
	}
	public Integer getaUserId() {
		return aUserId;
	}
	public void setaUserId(Integer aUserId) {
		this.aUserId = aUserId;
	}
	public String getaUserName() {
		return aUserName;
	}
	public void setaUserName(String aUserName) {
		this.aUserName = aUserName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "Authorization [aId=" + aId + ", deviceId=" + deviceId
				+ ", bUserId=" + bUserId + ", aUserId=" + aUserId + ", note="
				+ note + "]";
	}
}
