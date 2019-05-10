package dao;
import java.util.List;

import model.Keshi;

public interface KeshiDao {

	
	
	public void insertBean(Keshi bean);
	

	public void deleteBean(Keshi bean);
	
	
	public void updateBean(Keshi bean);

	
	public List<Keshi> selectBeanList(final int start,final int limit,final String where);
	
	
	
	public long selectBeanCount(final String where);
	
	
	public Keshi selectBean(String where);
	

}
