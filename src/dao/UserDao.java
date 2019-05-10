package dao;
import java.util.List;

import model.User;

public interface UserDao {

	
	
	public void insertBean(User bean);
	
	
	public void deleteBean(User bean);
	
	
	public void updateBean(User bean);

	
	public List<User> selectBeanList(final int start,final int limit,final String where);
	
	
	
	public long selectBeanCount(final String where);
	
	
	public User selectBean(String where);
	

}
