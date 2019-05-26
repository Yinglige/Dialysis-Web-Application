package dao;

import java.util.List;

import model.Kaoshi;


public interface KaoshiDao  {
	
	
	//Insert a new record
	public void insertBean(Kaoshi Kaoshi);
	//Delete records
	public void deleteBean(Kaoshi Kaoshi);
	//Update records 
	public void updateBean(Kaoshi Kaoshi);
	//Query question Information
	public Kaoshi selectBean(String where);
	//Get a list of information with query function.
	public List<Kaoshi> selectBeanList(final int start, final int limit,final String where);
	//Query total number of records
	public int selectBeanCount(final String where);
	
	public List<Kaoshi> selectCount2(final Kaoshi r);
	
	
}
