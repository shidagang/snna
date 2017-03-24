package cn.com.na.service;

import java.util.List;

import cn.com.na.bean.DeviceClass;

public interface DeviceClassService {
	public void addDeviceClass(DeviceClass deviceClass);
	public void delDeviceClass(DeviceClass deviceClass);
	public List<DeviceClass> queryDeviceClass(DeviceClass deviceClass);
}
