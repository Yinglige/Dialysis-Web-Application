package dao;
import java.util.List;

import model.Visit;

public interface VisitDao {

	
	
	public void insertBean(Visit bean);
	
	
	public void deleteBean(Visit bean);
	
	
	public void updateBean(Visit bean);

	
	public List<Visit> selectBeanList(final int start,final int limit,final String where);
	
	
	
	public long selectBeanCount(final String where);
	
	
	public Visit selectBean(String where);
	

}
