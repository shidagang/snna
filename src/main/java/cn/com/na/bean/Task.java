package cn.com.na.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author David
 * 
 */
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Id;
	private int scheuldeId; //排程
	private int deviceId;//设备
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	public int getScheuldeId() {
		return scheuldeId;
	}
	public void setScheuldeId(int scheuldeId) {
		this.scheuldeId = scheuldeId;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	@Override
	public String toString() {
		return "Task [Id=" + Id + ", scheuldeId=" + scheuldeId + ", deviceId="
				+ deviceId + "]";
	}
	
	
	
	
}
