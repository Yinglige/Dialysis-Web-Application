package dao;
import java.util.List;

import model.Jichu;

public interface JichuDao {

	
	//Insert a new record
	public void insertBean(Jichu bean);
	
	//Delete records
	public void deleteBean(Jichu bean);
	
	
	public void updateBean(Jichu bean);

	
	public List<Jichu> selectBeanList(final int start,final int limit,final String where);
	
	
	
	public long selectBeanCount(final String where);
	
	
	public Jichu selectBean(String where);
	

}
