package cn.com.na.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.na.bean.DeviceInstruct;
import cn.com.na.bean.SnnaLogger;
import cn.com.na.mapper.DeviceInstructMapper;
import cn.com.na.service.DeviceInstructService;

@Service("deviceInstructService")
public class DeviceInstructServiceImpl implements DeviceInstructService {

	private final static SnnaLogger logger = SnnaLogger.getLogger(DeviceInstructServiceImpl.class);
	@Autowired
	private DeviceInstructMapper deviceInstructMapper;


	@Override
	public void addDeviceInstruct (DeviceInstruct deviceInstruct) {
		deviceInstructMapper.addDeviceInstruct(deviceInstruct);
		
	}

	@Override
	public void delDeviceInstruct (DeviceInstruct deviceInstruct) {
		deviceInstructMapper.delDeviceInstruct(deviceInstruct);
		
	}

	@Override
	public List<DeviceInstruct> queryDeviceInstructByDcId(int dcId) {
		return deviceInstructMapper.queryDeviceInstructByDcId(dcId);
	}

}
