package cn.com.na.timer;

import java.util.ArrayList;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.com.na.bean.DeviceInfo;
import cn.com.na.bean.ScheduledTask;
import cn.com.na.netty5.echo.server.EchoServerHandler;
import cn.com.na.service.DeviceInfoService;
import cn.com.na.service.ScheduledService;
import cn.com.na.utils.ApplicationContextUtils;

/**
 * 
 * @author David
 *
 */
public class TimerAction extends QuartzJobBean{


	private int timeout;  
	
	public DeviceInfoService ds = (DeviceInfoService)ApplicationContextUtils.getBean("deviceInfoService");
    public ScheduledService sc = (ScheduledService)ApplicationContextUtils.getBean("scheduledService");
  
    public void setTimeout(int timeout) {  
        this.timeout = timeout;  
    }  
  
    @Override  
    public void executeInternal(JobExecutionContext ctx) throws JobExecutionException {  
    	
    }  
      
    public void start() {  
    	System.out.println("Start....");
    	 new TimerAction().init();
    	System.out.println("End....");
    }  
    
    public  void init(){
		List<ScheduledTask> scheduleds = sc.queryscheduledId();
		if (null != scheduleds && scheduleds.size() > 0) {
			for(ScheduledTask scheduled : scheduleds){
				EchoServerHandler.sendMessageToClient(scheduled.getMac(), scheduled.getMessage());
			}
		}
//		List<Integer> scheduledId = new ArrayList<Integer>();
//		if (null != scheduleds && scheduleds.size() > 0) {
//			for (int i = 0; i < scheduleds.size(); i++) {
//				int Id = scheduleds.get(i).getSid();
//				System.out.println("ScheudlID:" + Id);
//				scheduledId.add(Id);
//			}
//		}
//		if (null != scheduledId && scheduledId.size() > 0) {
//			List<DeviceInfo> devices = ds
//					.queryDeviceMacInfoByDeviceIds(scheduledId);
//			if (null != devices && devices.size() > 0) {
//				for (int j = 0; j < devices.size(); j++) {
//					EchoServerHandler.sendMessageToClient(devices.get(j).getMac(), "");
//				}
//			}
//		}
    
    }

}
