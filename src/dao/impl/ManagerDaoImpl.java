package dao.impl;
import java.sql.SQLException;
import java.util.List;

import model.Manager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ManagerDao;

public class ManagerDaoImpl extends HibernateDaoSupport implements ManagerDao {

	

	public void deleteBean(Manager bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Manager bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Manager selectBean(String where) {
		List<Manager> list = this.getHibernateTemplate().find("from Manager "+where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(final String where) {
		long count = (Long)this.getHibernateTemplate().find(" select count(*) from Manager  "+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Manager> selectBeanList(final int start,final int limit,final String where) {
		return (List<Manager>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				List<Manager> list = session.createQuery(" from Manager"+where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
		});
		
	}

	public void updateBean(Manager bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
	
	
	
	
	
}
