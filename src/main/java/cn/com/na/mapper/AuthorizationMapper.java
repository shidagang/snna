package cn.com.na.mapper;

import java.util.List;
import java.util.Map;

import cn.com.na.bean.Authorization;

public interface AuthorizationMapper {
	
	public void addAuthorization(List<Authorization> authorization);
	
	public void delAuthorization(Map<String, Object> param);
	
	public List<Authorization> queryAuthByUserId(String buserId);
	
	public List<Authorization> queryAuthorizationByParam(Authorization authorization);
	
	public List<Long> queryAuthorizationCountByParam(Authorization authorization);
	
	public List<Authorization> queryAuthByUserIdAndDeviceId(Authorization auth);
}
