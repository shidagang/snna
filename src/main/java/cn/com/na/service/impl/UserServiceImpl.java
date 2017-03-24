package cn.com.na.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.na.bean.User;
import cn.com.na.mapper.UserMapper;
import cn.com.na.service.UserService;
/**
 * 
 * @author David
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public int deleteUser(int Id) {
		
		return userMapper.deleteUser(Id);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public User getUserInfo(User user) {
		return userMapper.getUserInfo(user);
	}


	

	

}
