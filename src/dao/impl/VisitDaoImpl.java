package dao.impl;
import java.sql.SQLException;
import java.util.List;

import model.Visit;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.VisitDao;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	

	public void deleteBean(Visit bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Visit bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Visit selectBean(String where) {
		List<Visit> list = this.getHibernateTemplate().find("from Visit "+where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(final String where) {
		long count = (Long)this.getHibernateTemplate().find(" select count(*) from Visit  "+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Visit> selectBeanList(final int start,final int limit,final String where) {
		return (List<Visit>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				List<Visit> list = session.createQuery(" from Visit"+where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
		});
		
	}

	public void updateBean(Visit bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
	
	
	
	
	
}
