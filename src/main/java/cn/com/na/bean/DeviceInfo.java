package cn.com.na.bean;

import java.io.Serializable;

/**
 * 设备实体类
 * @author David
 * 
 * Table:deviceinfo
 *
 */
public class DeviceInfo extends QueryParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int deviceId;//设备ID
	private int dcld;//设备分类ID
	private String dName;//设备名称
	private int userId;//用户ID
	private String fVersion;//固件版本
	private String hVersion;//硬件版本
	private String mac;//设备唯一标识（MAC）
	private String note;//备注
	private String userName; //用户名称
	private int isOnline; //是否在线   1：在线   0：不在线
	private int isOpen; //0为关闭状态，1为打开状态

	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
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
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
		return "DeviceInfo [deviceId=" + deviceId + ", dcld=" + dcld
				+ ", dName=" + dName + ", userId=" + userId + ", fVersion="
				+ fVersion + ", hVersion=" + hVersion + ", mac=" + mac
				+ ", note=" + note + "]";
	}
	
}
