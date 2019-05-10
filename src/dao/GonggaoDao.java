package dao;
import java.util.List;

import model.Gonggao;

public interface GonggaoDao {

	
	
	public void insertBean(Gonggao bean);
	
	
	public void deleteBean(Gonggao bean);
	
	
	public void updateBean(Gonggao bean);

	
	public List<Gonggao> selectBeanList(final int start,final int limit,final String where);
	
	
	
	public long selectBeanCount(final String where);
	
	
	public Gonggao selectBean(String where);
	

}
