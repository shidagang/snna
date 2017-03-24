package cn.com.na.bean;

import java.io.Serializable;

public class DeviceInfoVo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int devicdId;
	private int dcld;
	private String dName;
	private int userId;
	private String fVersion;
	private String hVersion;
	private String mac;
	private String note;
	private int isOnline;
	private int isOpen;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	
	public int getDevicdId() {
		return devicdId;
	}
	public void setDevicdId(int devicdId) {
		this.devicdId = devicdId;
	}
	public int getDcld() {
		return dcld;
	}
	public void setDcld(int dcld) {
		this.dcld = dcld;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getfVersion() {
		return fVersion;
	}
	public void setfVersion(String fVersion) {
		this.fVersion = fVersion;
	}
	public String gethVersion() {
		return hVersion;
	}
	public void sethVersion(String hVersion) {
		this.hVersion = hVersion;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}
	public int getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}
	@Override
	public String toString() {
		return "DeviceInfoVo [devicdId=" + devicdId + ", dcld=" + dcld
				+ ", dName=" + dName + ", userId=" + userId + ", fVersion="
				+ fVersion + ", hVersion=" + hVersion + ", mac=" + mac
				+ ", note=" + note + ", isOnline=" + isOnline + ", isOpen="
				+ isOpen + "]";
	}
	
	

}
