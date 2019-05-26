package dao;

import java.util.List;

import model.Kaoshijilu;


public interface KaoshijiluDao  {
	
	
	//Insert a new record
	public void insertBean(Kaoshijilu Kaoshijilu);
	//Delete records
	public void deleteBean(Kaoshijilu Kaoshijilu);
	//Update records 
	public void updateBean(Kaoshijilu Kaoshijilu);
	//Get a list of information with query function.
	public Kaoshijilu selectBean(String where);
	//Query total number of records
	public List<Kaoshijilu> selectBeanList(final int start, final int limit,final String where);
	//Query User Information
	public int selectBeanCount(final String where);
	
	
}
