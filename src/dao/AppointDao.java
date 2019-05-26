package dao;
import java.util.List;

import model.Appoint;

public interface AppointDao {

	
	// Insert a new record
	public void insertBean(Appoint bean);
	
	// Delete records 
	public void deleteBean(Appoint bean);
	
	// Update records
	public void updateBean(Appoint bean);

	//Get a list of information with query function. 
	public List<Appoint> selectBeanList(final int start,final int limit,final String where);
	
	
	// Query total number  records
	public long selectBeanCount(final String where);
	
	//Query appoitment Information
	public Appoint selectBean(String where);
	
	public List<Appoint> selectBeanList2(final int start,final int limit,final String where) ;
	

}
