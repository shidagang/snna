package cn.com.na.service;

import cn.com.na.bean.TUserInfo;
import cn.com.na.bean.VerificationCode;

public interface TUserInfoService {

	/**
	 * 根据用户id，查询用户信息
	 * @param userId
	 * @return
	 */
	public TUserInfo getUserInfoById(int userId);
	
	/**
	 * 修改用户信息
	 * @param userInfo
	 */
	public void updateUserInfo(TUserInfo userInfo);
	
	/**
	 * 添加验证码
	 */
	public void addVerificationCode(VerificationCode code);
	/**
	 * 根据用户id删除验证码
	 * @param userId
	 */
	public void delVerificationCodeByAccount(String Account);
	/**
	 * 根据用户名 查询验证码
	 * @param userId
	 * @return
	 */
	public VerificationCode queryVerificationCodeByAccount(String Account);
}
