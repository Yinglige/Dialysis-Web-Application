package dao;

import java.util.List;

import model.Product;


public interface ProductDao  {
	
	
	//Insert a new record
	public void insertBean(Product Product);
	//Delete records
	public void deleteBean(Product Product);
	//Update records 
	public void updateBean(Product Product);
	
	public Product selectBean(String where);
	//Get a list of information with query function.
	public List<Product> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
