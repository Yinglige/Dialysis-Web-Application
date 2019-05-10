package dao;

import java.util.List;

import model.Kaoshijilu;


public interface KaoshijiluDao  {
	
	
	
	public void insertBean(Kaoshijilu Kaoshijilu);
	
	public void deleteBean(Kaoshijilu Kaoshijilu);
	
	public void updateBean(Kaoshijilu Kaoshijilu);

	public Kaoshijilu selectBean(String where);
	
	public List<Kaoshijilu> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
