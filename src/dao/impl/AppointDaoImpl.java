package dao.impl;
import java.sql.SQLException;
import java.util.List;

import model.Appoint;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.AppointDao;

public class AppointDaoImpl extends HibernateDaoSupport implements AppointDao {

	

	public void deleteBean(Appoint bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Appoint bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Appoint selectBean(String where) {
		List<Appoint> list = this.getHibernateTemplate().find("from Appoint "+where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(final String where) {
		long count = (Long)this.getHibernateTemplate().find(" select count(*) from Appoint  "+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Appoint> selectBeanList(final int start,final int limit,final String where) {
		return (List<Appoint>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				List<Appoint> list = session.createQuery(" from Appoint"+where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
		});
		
	}

	public void updateBean(Appoint bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
	
	
	
	
	
}
