package cn.com.na.netty5.echo.server;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandler.Skip;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

import java.util.concurrent.ConcurrentHashMap;

import cn.com.na.bean.DeviceOnline;
import cn.com.na.service.DeviceInfoService;
import cn.com.na.service.DeviceOnlineService;
import cn.com.na.utils.ApplicationContextUtils;

/**
 * 
 * @author David
 *
 */
@Sharable
public class EchoServerHandler extends ChannelHandlerAdapter{

	public static ConcurrentHashMap<String, ChannelHandlerContext> sessionHandler = 
			new ConcurrentHashMap <String, ChannelHandlerContext>();
	
	public DeviceInfoService ds = (DeviceInfoService)ApplicationContextUtils.getBean("deviceInfoService");
	public DeviceOnlineService dos = (DeviceOnlineService)ApplicationContextUtils.getBean("deviceOnlineService");
	
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		//根据设备ID判断下改设备是否非法。通过设备ID表查询下是否存在。
		if(null == msg){
			ctx.close(); 
			return;
		}
		String infos = msg.toString();
		System.out.println("infos = " + infos);
		if(!infos.contains(",")){
			ctx.close();
			return;
		}
		 String [] info = infos.split(",");
		 String mac = "";		  // mac地址
		 String fVersion = "";	  // 固件版本
		 String hVersion = "";	  // 硬件版本
		 String deviceClass = ""; // 数据分类
		 String isOnOrOff = "";   // 设备是否打开关闭的状态

		 if(info.length == 5){
			 mac = info[0];
			 fVersion = info[1];
			 hVersion = info[2];
			 deviceClass = info[3];
			 isOnOrOff = info[4];
		 }else{
			 ctx.close();
			 return;
		 }
		 sessionHandler.put(mac,ctx);
		 queryUnique(mac, deviceClass, isOnOrOff);

		// ctx.writeAndFlush(msg);
	}
	
	
	/**
	 * 
	 * @param unique
	 */
	public void queryUnique(String mac, String dvType,String isOnOrOff){
		if(null == mac || null == isOnOrOff){
			return;
		}
		int deviceId = ds.queryDeviceInfoByUnique(mac);
		int doId = dos.queryDeviceOnlineById(deviceId);
		DeviceOnline dol = new DeviceOnline();
		dol.setDeviceId(deviceId);
		dol.setIsOpen(isOnOrOff);
		
		if(deviceId >0 && doId >0){ //设备之前存在在线表中
			dos.updateDeviceOnlineStates(dol);
		}else if (deviceId >0){ //设备没有第一次上线
			DeviceOnline deviceOnline = new DeviceOnline();
			deviceOnline.setDeviceId(deviceId);
			deviceOnline.setOnline(true);
			deviceOnline.setNote("test MAC "+deviceId);
			dos.addOnlineDeviceInfo(deviceOnline);
		}
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		
	}
	
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		for(ConcurrentHashMap.Entry<String,ChannelHandlerContext> e: sessionHandler.entrySet() ){
	        if(ctx == e.getValue()){
	        	System.out.println("MAC: "+e.getKey()+" off line");
	        	int deviceId = ds.queryDeviceInfoByUnique(e.getKey().toString());
	        	sessionHandler.remove(e.getKey());
	    		if(deviceId >0){ //设备下线
	    			dos.updateDeviceOfflineStates(deviceId);
	    		}
	        }
	    }
		ctx.close();
	}
	
	/**
	 * 发送信息
	 * @param toAcc
	 * @param message
	 */
	public static void sendMessageToClient(String toAcc, String message){
		if(null == toAcc || null == message){
			return;
		}
		ChannelHandlerContext ctx = sessionHandler.get(toAcc);
		if(null != ctx){
			ctx.writeAndFlush(message);
		}
	}

}
