package dao;
import java.util.List;

import model.Shiti;

public interface ShitiDao {

	
	
	public void insertBean(Shiti bean);
	
	
	public void deleteBean(Shiti bean);
	
	
	public void updateBean(Shiti bean);

	
	public List<Shiti> selectBeanList(final int start,final int limit,final String where);
	
	
	
	public long selectBeanCount(final String where);
	
	
	public Shiti selectBean(String where);
	

}
