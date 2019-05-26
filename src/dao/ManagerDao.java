package dao;
import java.util.List;

import model.Manager;

public interface ManagerDao {

	
	//Insert a new record
	public void insertBean(Manager bean);
	
	//Delete records
	public void deleteBean(Manager bean);
	
	//Update records 
	public void updateBean(Manager bean);

	//Get a list of information with query function.
	public List<Manager> selectBeanList(final int start,final int limit,final String where);
	
	
	//Query total number of records
	public long selectBeanCount(final String where);
	
	
	public Manager selectBean(String where);
	

}
