package cn.com.na.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.na.bean.TUserInfo;
import cn.com.na.bean.VerificationCode;
import cn.com.na.mapper.TUserInfoMapper;
import cn.com.na.service.TUserInfoService;

@Service("tUserInfoService")
public class TUserInfoServiceImpl implements TUserInfoService {

	@Autowired
	private TUserInfoMapper userInfoMapper;
	
	
	@Override
	public TUserInfo getUserInfoById(int userId){
		return userInfoMapper.getUserInfo(userId);
	}
	
	@Override
	public void updateUserInfo(TUserInfo userInfo){
		userInfoMapper.updateUserInfo(userInfo);
	}
	/**
	 * 添加验证码
	 */
	public void addVerificationCode(VerificationCode code){
		userInfoMapper.addVerificationCode(code);
	}
	/**
	 * 根据用户id删除验证码
	 * @param userId
	 */
	public void delVerificationCodeByAccount(String account){
		userInfoMapper.delVerificationCodeByAccount(account);
	}
	/**
	 * 根据用户id 查询严重码
	 * @param userId
	 * @return
	 */
	public VerificationCode queryVerificationCodeByAccount(String account){
		return userInfoMapper.queryVerificationCodeByAccount(account);
	}
	
}
