package cn.com.na.service;

import cn.com.na.bean.DeviceOnline;

public interface DeviceOnlineService {
	
	public void updateDeviceOnlineStates(DeviceOnline deviceOnline);
	
	public void updateDeviceOfflineStates(int deviceId);
	
	public void addOnlineDeviceInfo(DeviceOnline deviceOnline);
	
	public int queryDeviceOnlineById(int deviceId);

}
