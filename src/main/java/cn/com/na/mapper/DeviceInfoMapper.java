package cn.com.na.mapper;

import java.util.List;

import cn.com.na.bean.Authorization;
import cn.com.na.bean.DeviceInfo;
import cn.com.na.bean.DeviceInfoVo;

public interface DeviceInfoMapper {
	
	public DeviceInfo queryDeviceInfoByUnique(String unique);

	/**
	 * 添加设备
	 * @param deviceInfo
	 */
	public void addDeviceInfo(DeviceInfo deviceInfo);
	
	public void delDeviceInfo(DeviceInfo deviceInfo);
	
	public String queryDeviceMacInfoByDeviceId(int deviceId);
	
	public List<DeviceInfo> queryDeviceMacInfoByDeviceIds(List<Integer> scheduledId);
	
	public List<DeviceInfoVo>queryDevicesInfos(int userId);
	
	public List<DeviceInfo> queryDeviceInfoByParam(DeviceInfo deviceInfo);
	
	public List<Long> queryDeviceInfoCountByParam(DeviceInfo deviceInfo);

}
