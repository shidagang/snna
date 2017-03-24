package cn.com.na.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.na.bean.Authorization;
import cn.com.na.bean.QueryResult;
import cn.com.na.bean.ResponseBean;
import cn.com.na.service.AuthorizationService;
import cn.com.na.service.DeviceInfoService;
import cn.com.na.utils.ErrorCodeUtils;

/**
 * 
 * @author liuyong
 * 用户授权
 */
@Controller
@RequestMapping("/auth")
public class AuthorizationController {

	private String msg = "";
	private int resCode = 201;
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private DeviceInfoService deviceInfoService;

	/**
	 * 添加用户授权
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/addAuthorization", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean addAuthorization(String params) {
		ResponseBean bean = new ResponseBean();
		List<Authorization> auths = null;
		if(null != params){
			List<Authorization> list = JSONObject.parseArray(params, Authorization.class);
			for(int i=0;i<list.size();i++){
				Authorization auth = (Authorization)list.get(i);
				auth.setaUserId(auth.getaUserId());
				auth.setbUserId(auth.getbUserId());
				auth.setDeviceId(auth.getDeviceId());
				List<Authorization> authList = deviceInfoService.queryAuthByUserIdAndDeviceId(auth);
				//可添加授权信息
				if(CollectionUtils.isEmpty(authList)){
					auths = new ArrayList<Authorization>();
					auths.add(auth);
				}
			}
			if(!CollectionUtils.isEmpty(auths) && auths.size()>0){
				authorizationService.addAuthorization(auths);
				msg = ErrorCodeUtils.GET_SUESS_MSG;
				resCode = ErrorCodeUtils.SUCCESS;
			}else{
				msg = ErrorCodeUtils.AUTH_IS_EXIST_MSG;
				resCode = ErrorCodeUtils.AUTH_IS_EXIST;
			}
			
		}else{
			msg = ErrorCodeUtils.PARAMETER_IS_NULL;
			resCode = ErrorCodeUtils.UNKNOWN_ERR;
		}
		bean.setRetCode(resCode);
		bean.setMsg(msg);  
		return bean;
	}

	/**
	 * 取消用户授权
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/cancelAuthorization", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean cancelAuthorization(@RequestBody Map param) {
		ResponseBean bean = new ResponseBean();
		if(null == param){
			msg = ErrorCodeUtils.PARAMETER_IS_NULL;
			resCode = ErrorCodeUtils.UNKNOWN_ERR;
		}else{
			authorizationService.delAuthorization(param);
			msg = ErrorCodeUtils.GET_SUESS_MSG;
			resCode = ErrorCodeUtils.SUCCESS;
		}
		
		bean.setRetCode(resCode);
		bean.setMsg(msg);
		return bean;
	}

	/**
	 * 通过设备所属用户ID，查询授权信息
	 * 
	 * @param buserId
	 * @return
	 */
	@RequestMapping(value = "/queryAuthByUserId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean queryAuthByUserId(String buserId) {
		ResponseBean bean = new ResponseBean();
		List<Authorization> authorization = authorizationService.queryAuthByUserId(buserId);
		bean.setData(authorization);
		bean.setRetCode(ErrorCodeUtils.SUCCESS);
		bean.setMsg("查询授权设备信息");
		return bean;
	}
	
	
	/**
	 * 分页查询授权信息
	 * @param Authorization param
	 * @return
	 */
	@RequestMapping(value = "/queryAuth", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean queryAuth(@RequestBody Authorization param) {
		ResponseBean bean = new ResponseBean();
		List<Authorization> authorization = null;
		QueryResult result  = null;
		if(null == param){
			msg = ErrorCodeUtils.PARAMETER_IS_NULL;
			resCode = ErrorCodeUtils.UNKNOWN_ERR;
		}else{
			result = authorizationService.queryAuth(param);
			if(CollectionUtils.isEmpty(result.getResult())){
				resCode = ErrorCodeUtils.SUCCESS;
				msg = ErrorCodeUtils.NO_DATA_FOUND;
				return bean;
			}
			authorization = result.getResult();
			resCode = ErrorCodeUtils.SUCCESS;
			msg = ErrorCodeUtils.GET_SUESS_MSG;
			bean.setCurrentPageIndex(result.getCurrentPageIndex());
			bean.setTotalPage(result.getTotalPage());
			bean.setTotalNum(result.getTotalNum());
		}
		bean.setData(authorization);
		bean.setRetCode(resCode);
		bean.setMsg(msg);
		return bean;
	}

}
