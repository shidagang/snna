package cn.com.na.mapper;
import cn.com.na.bean.User;

/**
 * 
 * @author David
 *
 */
public interface UserMapper {
	
	public int addUser(User user);
	
    public int deleteUser(int Id);
    
    public int updateUser(User user);
	
    public User getUserInfo(User user);
    
}
