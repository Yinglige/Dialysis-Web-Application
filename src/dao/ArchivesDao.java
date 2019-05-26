package dao;
import java.util.List;

import model.Archives;

public interface ArchivesDao {

	
	//Insert a new record
	public void insertBean(Archives bean);
	
	// Delete records
	public void deleteBean(Archives bean);
	
	//Update records 
	public void updateBean(Archives bean);

	// Get a list of information with query function.
	public List<Archives> selectBeanList(final int start,final int limit,final String where);

	//Query total number of records
	public long selectBeanCount(final String where);
	
	//Query vitals Information
	public Archives selectBean(String where);
	

}
