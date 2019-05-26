package dao;
import java.util.List;

import model.Visit;

public interface VisitDao {

	
	
	public void insertBean(Visit bean);
	
	//Delete records
	public void deleteBean(Visit bean);
	
	//Update records 
	public void updateBean(Visit bean);

	//Get a list of information with query function.
	public List<Visit> selectBeanList(final int start,final int limit,final String where);
	
	//Query total number of records
	public long selectBeanCount(final String where);
	
	//Query appoitment Information
	public Visit selectBean(String where);
	

}
