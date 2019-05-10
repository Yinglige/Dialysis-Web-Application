package dao;
import java.util.List;

import model.Archives;

public interface ArchivesDao {

	
	
	public void insertBean(Archives bean);
	
	
	public void deleteBean(Archives bean);
	
	
	public void updateBean(Archives bean);

	
	public List<Archives> selectBeanList(final int start,final int limit,final String where);
	
	
	
	public long selectBeanCount(final String where);
	
	
	public Archives selectBean(String where);
	

}
