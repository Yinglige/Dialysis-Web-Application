package dao;
import java.util.List;

import model.Shiti;

public interface ShitiDao {

	
	//Insert a new record
	public void insertBean(Shiti bean);
	
	//Delete records
	public void deleteBean(Shiti bean);
	
	//Update records 
	public void updateBean(Shiti bean);

	//Get a list of information with query function.
	public List<Shiti> selectBeanList(final int start,final int limit,final String where);
	
	
	//Query total number of records
	public long selectBeanCount(final String where);
	
	//Query question Information
	public Shiti selectBean(String where);
	

}
