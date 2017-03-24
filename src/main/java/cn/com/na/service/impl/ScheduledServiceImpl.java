package cn.com.na.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.na.bean.ScheduledTask;
import cn.com.na.bean.Task;
import cn.com.na.mapper.ScheduledMapper;
import cn.com.na.service.ScheduledService;

/**
 * 
 * @author David
 *
 */
@Service("scheduledService")
public class ScheduledServiceImpl implements ScheduledService {
	
	@Autowired
	private ScheduledMapper scheduledMapper;

	@Override
	public void addScheduled(ScheduledTask scheduled) {
		scheduledMapper.addScheduled(scheduled);

	}

	@Override
	public void addTaskToScheuled(ScheduledTask task) {
		
		scheduledMapper.addTaskToScheuled(task);
		
	}

	@Override
	public List<ScheduledTask> queryscheduledId() {
		return scheduledMapper.queryscheduledId();
	}

	@Override
	public List<Task> queryTaskDeviceId(int scheduledId) {
		return scheduledMapper.queryTaskDeviceId(scheduledId);
	}

	@Override
	public void delScheduled(ScheduledTask scheduled) {
		scheduledMapper.delScheduled(scheduled);
	}

	@Override
	public List<ScheduledTask> queryScheduled(ScheduledTask scheduled) {
		return scheduledMapper.queryScheduled(scheduled);
	}

	@Override
	public void updateScheduled(ScheduledTask scheduled) {
		scheduledMapper.updateScheduled(scheduled);
	}

}
