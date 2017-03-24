package cn.com.na.mapper;

import java.util.List;

import cn.com.na.bean.DeviceClass;

public interface DeviceClassMapper {
	public void addDeviceClass(DeviceClass deviceClass);
	public void delDeviceClass(DeviceClass deviceClass);
	public List<DeviceClass> queryDeviceClass(DeviceClass deviceClass);
}
