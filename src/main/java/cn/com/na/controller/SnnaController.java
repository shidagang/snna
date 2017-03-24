package cn.com.na.controller;

import io.netty.channel.ChannelHandlerContext;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.na.bean.Authorization;
import cn.com.na.bean.Message;
import cn.com.na.bean.ResponseBean;
import cn.com.na.bean.User;
import cn.com.na.netty5.echo.server.EchoServerHandler;
import cn.com.na.service.AuthorizationService;
import cn.com.na.service.UserService;
import cn.com.na.utils.ErrorCodeUtils;

/**
 * 移动用户接入
 * 
 * @author David
 * 
 */
@Controller
@RequestMapping("/snna")
public class SnnaController {

	public ConcurrentHashMap<String, ChannelHandlerContext> sessionHandler = EchoServerHandler.sessionHandler;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getOnline", method = RequestMethod.GET)
	@ResponseBody
	public String getOnlineDevice() {
		if (null != sessionHandler) {
			for (ConcurrentHashMap.Entry<String, ChannelHandlerContext> entry : sessionHandler.entrySet()) {
				System.out.println(entry.getKey() + "--->" + entry.getValue());
				ChannelHandlerContext ctx1 = entry.getValue();
				System.out.println("Channel:" + ctx1);
			}
		}
		return "" + sessionHandler.size();
	}

	@RequestMapping(value = "/sendMessageToOnlineDevice", method = RequestMethod.POST)
	@ResponseBody
	public void SendMessageToOnlineDevice(@RequestBody Message msg) {

		if (null != msg) {
			if (null != sessionHandler) {
				for (ConcurrentHashMap.Entry<String, ChannelHandlerContext> entry : sessionHandler.entrySet()) {
					System.out.println("Controller: " + entry.getKey() + "--->" + entry.getValue());
					ChannelHandlerContext ctx1 = entry.getValue();
					ctx1.writeAndFlush(msg.getDeviceId());
				}
			}
		}
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestBody User user) {
		if (null != user) {
			userService.addUser(user);
		}

		return "OK";
	}

	@RequestMapping(value = "/getResponseBean", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getResponseBean() {
		ResponseBean bean = new ResponseBean();
		bean.setRetCode(200);
		bean.setMsg("OK");
		return bean;

	}


}
