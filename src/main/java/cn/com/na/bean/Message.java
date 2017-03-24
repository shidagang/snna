package cn.com.na.bean;

import java.io.Serializable;

/**
 * message类
 * @author David
 *
 */
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String DeviceId;
	private boolean OnlineStatus;
	private String lot;
	
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public String getDeviceId() {
		return DeviceId;
	}
	public void setDeviceId(String deviceId) {
		DeviceId = deviceId;
	}
	public boolean isOnlineStatus() {
		return OnlineStatus;
	}
	public void setOnlineStatus(boolean onlineStatus) {
		OnlineStatus = onlineStatus;
	}
	@Override
	public String toString() {
		return "Message [DeviceId=" + DeviceId + ", OnlineStatus="
				+ OnlineStatus + ", lot=" + lot + "]";
	}

}
