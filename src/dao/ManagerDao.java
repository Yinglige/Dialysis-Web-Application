package dao;
import java.util.List;

import model.Manager;

public interface ManagerDao {

	
	
	public void insertBean(Manager bean);
	
	
	public void deleteBean(Manager bean);
	
	
	public void updateBean(Manager bean);

	
	public List<Manager> selectBeanList(final int start,final int limit,final String where);
	
	
	
	public long selectBeanCount(final String where);
	
	
	public Manager selectBean(String where);
	

}
