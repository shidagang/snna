package cn.com.na.service;
import cn.com.na.bean.User;

/**
 * 
 * @author David
 *
 */
public interface UserService {

	public int addUser(User user);
	
    public int deleteUser(int Id);
    
    public int updateUser(User user);
	
    public User getUserInfo(User user);
    
}
