package cn.com.na.service;

import java.util.List;
import java.util.Map;

import cn.com.na.bean.Authorization;
import cn.com.na.bean.QueryResult;

/**
 * 
 * @author zhangjun
 *
 */
public interface AuthorizationService {
	
	public void addAuthorization(List<Authorization> param);
	
	public void delAuthorization(Map<String, Object> param);
	
	public List<Authorization> queryAuthByUserId(String buserId);
	
	public QueryResult queryAuth(Authorization param);
}
