package cn.com.na.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.na.bean.DeviceOnline;
import cn.com.na.mapper.DeviceInfoMapper;
import cn.com.na.mapper.DeviceOnlineMapper;
import cn.com.na.service.DeviceOnlineService;



@Service("deviceOnlineService")
public class DeviceOnlineServiceImpl implements DeviceOnlineService {
	
	
	@Autowired
	private DeviceOnlineMapper deviceOnlineMapper;
	@Override
	public void updateDeviceOnlineStates(DeviceOnline deviceOnline) {
		
		deviceOnlineMapper.updateDeviceOnlineStates(deviceOnline);
		
	}
	@Override
	public void addOnlineDeviceInfo(DeviceOnline deviceOnline) {
		deviceOnlineMapper.addOnlineDeviceInfo(deviceOnline);
		
	}
	@Override
	public int queryDeviceOnlineById(int deviceId) {
		
		return deviceOnlineMapper.queryDeviceOnlineById(deviceId);
	}

	@Override
	public void updateDeviceOfflineStates(int deviceId) {
		deviceOnlineMapper.updateDeviceOfflineStates(deviceId);
		
	}

}
