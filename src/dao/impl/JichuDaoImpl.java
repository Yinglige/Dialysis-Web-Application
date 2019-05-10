package dao.impl;
import java.sql.SQLException;
import java.util.List;

import model.Jichu;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.JichuDao;

public class JichuDaoImpl extends HibernateDaoSupport implements JichuDao {

	

	public void deleteBean(Jichu bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Jichu bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Jichu selectBean(String where) {
		List<Jichu> list = this.getHibernateTemplate().find("from Jichu "+where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(final String where) {
		long count = (Long)this.getHibernateTemplate().find(" select count(*) from Jichu  "+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Jichu> selectBeanList(final int start,final int limit,final String where) {
		return (List<Jichu>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				List<Jichu> list = session.createQuery(" from Jichu"+where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
		});
		
	}

	public void updateBean(Jichu bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
	
	
	
	
	
}
