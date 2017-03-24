package cn.com.na.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.na.bean.Authorization;
import cn.com.na.bean.MultiDBPageUtil;
import cn.com.na.bean.QueryParam;
import cn.com.na.bean.QueryResult;
import cn.com.na.bean.SnnaLogger;
import cn.com.na.mapper.AuthorizationMapper;
import cn.com.na.service.AuthorizationService;

@Service("authorizationService")
public class AuthorizationServiceImpl extends MultiDBPageUtil implements AuthorizationService {
	private final static SnnaLogger logger = SnnaLogger.getLogger(AuthorizationServiceImpl.class);
	@Autowired
	private AuthorizationMapper authorizationMapper;
	
	
	@Override
	public void addAuthorization(List<Authorization> param) {
		authorizationMapper.addAuthorization(param);
	}
	
	@Override
	public void delAuthorization(Map<String, Object> param) {
		authorizationMapper.delAuthorization(param);
	}
	
	@Override
	public List<Authorization> queryAuthByUserId(String buserId) {
		return authorizationMapper.queryAuthByUserId(buserId);
	}

	@Override
	public List<Long> countQuery(QueryParam queryParam) {
		try {
			return  authorizationMapper.queryAuthorizationCountByParam((Authorization) queryParam);
		} catch (Exception e) {
			logger.error("查询满足条件的记录数异常",e);
		}
		return null;
	}

	@Override
	public List<?> queryData(QueryParam queryParam) {
		return authorizationMapper.queryAuthorizationByParam((Authorization) queryParam);
	}


	@Override
	public QueryResult queryAuth(Authorization param) {
	    return getPageData(param);
	}
	
	
	
}
