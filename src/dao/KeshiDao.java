package dao;
import java.util.List;

import model.Keshi;

public interface KeshiDao {

	
	//Insert a new record
	public void insertBean(Keshi bean);
	
	//Delete records
	public void deleteBean(Keshi bean);
	
	//Update records 
	public void updateBean(Keshi bean);

	//Query total number of records
	public List<Keshi> selectBeanList(final int start,final int limit,final String where);
	
	//Get a list of information with query function.
	public long selectBeanCount(final String where);
	
	
	public Keshi selectBean(String where);
	

}
