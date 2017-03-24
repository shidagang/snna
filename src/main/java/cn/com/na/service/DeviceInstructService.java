package cn.com.na.service;

import java.util.List;

import cn.com.na.bean.DeviceInstruct;

public interface DeviceInstructService {
	/**
	 * 添加设备分类指令
	 * @param deviceInstruct
	 */
	public void addDeviceInstruct(DeviceInstruct deviceInstruct);
	/**
	 * 删除设备分类指令
	 * @param deviceInstruct
	 */
	public void delDeviceInstruct(DeviceInstruct deviceInstruct);
	/**
	 * 根据设备分类id查询指令
	 * @param dcId
	 * @return
	 */
	public List<DeviceInstruct> queryDeviceInstructByDcId(int dcId);
}
