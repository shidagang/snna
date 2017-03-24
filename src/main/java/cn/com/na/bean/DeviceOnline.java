package cn.com.na.bean;

import java.io.Serializable;

/**
 * 设备在线表
 * @author David
 * Table：deviceonline
 *  优化：之后不存在表中
 *
 */
public class DeviceOnline implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int doId;//自增ID
	private int deviceId;//设备ID
	private boolean isOnline;//0为不在线 1为在线
	private String isOpen;//设备是否打开，0 为关闭，1为打开


	private String note;//备注
	public int getDoId() {
		return doId;
	}
	public void setDoId(int doId) {
		this.doId = doId;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "DeviceOnline [doId=" + doId + ", deviceId=" + deviceId
				+ ", isOnline=" + isOnline + ", isOpen=" + isOpen + ", note="
				+ note + "]";
	}
	

	

}
