package cn.com.na.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.na.bean.DeviceClass;
import cn.com.na.bean.SnnaLogger;
import cn.com.na.mapper.DeviceClassMapper;
import cn.com.na.service.DeviceClassService;

@Service("deviceClassService")
public class DeviceClassServiceImpl implements DeviceClassService {

	private final static SnnaLogger logger = SnnaLogger.getLogger(DeviceClassServiceImpl.class);
	@Autowired
	private DeviceClassMapper deviceClassMapper;


	@Override
	public void addDeviceClass(DeviceClass deviceClass) {
		deviceClassMapper.addDeviceClass(deviceClass);
		
	}

	@Override
	public void delDeviceClass(DeviceClass deviceClass) {
		deviceClassMapper.delDeviceClass(deviceClass);
		
	}

	@Override
	public List<DeviceClass> queryDeviceClass(DeviceClass deviceClass) {
		return deviceClassMapper.queryDeviceClass(deviceClass);
	}

}
