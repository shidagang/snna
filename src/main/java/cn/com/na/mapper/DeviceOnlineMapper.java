package cn.com.na.mapper;

import cn.com.na.bean.DeviceOnline;

public interface DeviceOnlineMapper {
	
	public void updateDeviceOnlineStates(DeviceOnline  deviceOnline);
	
	public void updateDeviceOfflineStates(int deviceId);
	
	public void addOnlineDeviceInfo(DeviceOnline deviceOnline);
	
	public int queryDeviceOnlineById(int deviceId);

}
