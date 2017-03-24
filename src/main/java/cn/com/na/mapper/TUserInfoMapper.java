package cn.com.na.mapper;

import cn.com.na.bean.TUserInfo;
import cn.com.na.bean.VerificationCode;

public interface TUserInfoMapper {

	public TUserInfo getUserInfo(int userId);
	
	public int addUserInfo(TUserInfo info);
	
	/**
	 * 修改用户信息
	 * @param info
	 */
	public void updateUserInfo(TUserInfo info);
	
	/**
	 * 添加验证码
	 */
	public void addVerificationCode(VerificationCode code);
	/**
	 * 根据用户id删除验证码
	 * @param userId
	 */
	public void delVerificationCodeByAccount(String account);
	/**
	 * 根据用户id 查询严重码
	 * @param userId
	 * @return
	 */
	public VerificationCode queryVerificationCodeByAccount(String account);
}
