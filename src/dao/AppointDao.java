package dao;
import java.util.List;

import model.Appoint;

public interface AppointDao {

	
	
	public void insertBean(Appoint bean);
	
	
	public void deleteBean(Appoint bean);
	
	
	public void updateBean(Appoint bean);

	
	public List<Appoint> selectBeanList(final int start,final int limit,final String where);
	
	
	
	public long selectBeanCount(final String where);
	
	
	public Appoint selectBean(String where);
	

}
