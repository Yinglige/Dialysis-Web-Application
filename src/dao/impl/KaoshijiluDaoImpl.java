package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Kaoshijilu;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.KaoshijiluDao;









public class KaoshijiluDaoImpl extends HibernateDaoSupport implements  KaoshijiluDao{


	public void deleteBean(Kaoshijilu Kaoshijilu) {
		this.getHibernateTemplate().delete(Kaoshijilu);
		
	}

	public void insertBean(Kaoshijilu Kaoshijilu) {
		this.getHibernateTemplate().save(Kaoshijilu);
		
	}

	@SuppressWarnings("unchecked")
	public Kaoshijilu selectBean(String where) {
		List<Kaoshijilu> list = this.getHibernateTemplate().find("from Kaoshijilu " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Kaoshijilu "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Kaoshijilu> selectBeanList(final int start,final int limit,final String where) {
		return (List<Kaoshijilu>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Kaoshijilu> list = session.createQuery("from Kaoshijilu "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Kaoshijilu Kaoshijilu) {
		this.getHibernateTemplate().update(Kaoshijilu);
		
	}
	
	
}
