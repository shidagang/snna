package cn.com.na.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.na.bean.TUser;
import cn.com.na.bean.TUserInfo;
import cn.com.na.bean.User;
import cn.com.na.mapper.TUserMapper;
import cn.com.na.mapper.TUserInfoMapper;
import cn.com.na.service.TUserService;

/**
 * 
 * @author David
 *
 */
@Service("TUserService")
public class TUserServiceImpl implements TUserService {

	@Autowired
	private TUserMapper tUserMapper;

	@Autowired
	private TUserInfoMapper userInfoMapper;

	@Override
	public User isLogin(TUser tuser) {
		User user = new User();
		TUser tu = tUserMapper.isLogin(tuser);
		if (null != tu) {
			user.setActivate(tu.getActivate());
		}

		if (null != tu && 1 == tu.getActivate()) {
			TUserInfo userinfo = userInfoMapper.getUserInfo(tu.getUserId());
			user.setUserId(tu.getUserId());
			user.setAccount(tu.getAccount());
			user.setRoleId(tu.getRoleId());
			if (null != userinfo) {
				user.setMphone(userinfo.getmPhone());
				user.settPhone(userinfo.gettPhone());
				user.setEmail(userinfo.geteMail());
				user.setNickName(userinfo.getNickName());
				user.setImg(userinfo.getImg());
				user.setAddress(userinfo.getAddress());
				user.setUrl(userinfo.getUrl());
			}
		}

		return user;
	}

	@Override
	public TUser userisExistence(TUser tuser) {
		return tUserMapper.userisExistence(tuser);
	}

	@Override
	public TUser getUserById(int userId) {
		return tUserMapper.getUserById(userId);
	}

	@Override
	public TUser getUserByAccount(String account) {
		return tUserMapper.getUserByAccount(account);
	}

	@Override
	public void updateUser(TUser tuser) {
		tUserMapper.updateUser(tuser);
	}

	@Override
	public TUser addUser(User user) {
		TUser tuser = new TUser();
		tuser.setUserId(user.getUserId());
		tuser.setAccount(user.getAccount());
		tuser.setPassword(user.getPassword());
		tuser.setRoleId(2);
		tuser.setNote(user.getNote());
		tuser.setActivate(0);
		tuser.setCreateTime(new Date());
		try {
			tUserMapper.addUser(tuser);
			if (0 < tuser.getUserId()) {
				TUserInfo info = new TUserInfo();
				info.setUserId(tuser.getUserId());
				userInfoMapper.addUserInfo(info);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return tuser;
	}

	@Override
	public int getUser(User user) {
		return tUserMapper.getUser(user);
	}

	@Override
	public int getUserId(User user) {
		return tUserMapper.getUserId(user);
	}

}
