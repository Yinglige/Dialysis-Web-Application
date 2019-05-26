package dao;
import java.util.List;

import model.User;

public interface UserDao {

	
	//Insert a new record
	public void insertBean(User bean);
	
	//Delete records
	public void deleteBean(User bean);
	
	//Update records 
	public void updateBean(User bean);

	//Get a list of information with query function.
	public List<User> selectBeanList(final int start,final int limit,final String where);
	
	
	//Query total number of records
	public long selectBeanCount(final String where);
	
	//Query User Information
	public User selectBean(String where);
	

}
