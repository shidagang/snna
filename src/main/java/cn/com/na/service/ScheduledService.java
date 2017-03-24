package cn.com.na.service;

import java.util.List;

import cn.com.na.bean.ScheduledTask;
import cn.com.na.bean.Task;

public interface ScheduledService {
	
	public void addScheduled(ScheduledTask scheduled);
	public void delScheduled(ScheduledTask scheduled);
	public void addTaskToScheuled(ScheduledTask task);
	public List<ScheduledTask> queryscheduledId();
	public List<Task>queryTaskDeviceId(int scheduledId);
	public List<ScheduledTask> queryScheduled(ScheduledTask task);
	public void updateScheduled(ScheduledTask scheduled);

}
