package dao;

import java.util.List;

import model.Kaoshi;


public interface KaoshiDao  {
	
	
	
	public void insertBean(Kaoshi Kaoshi);
	
	public void deleteBean(Kaoshi Kaoshi);
	
	public void updateBean(Kaoshi Kaoshi);

	public Kaoshi selectBean(String where);
	
	public List<Kaoshi> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	public List<Kaoshi> selectCount2(final Kaoshi r);
	
	
}
