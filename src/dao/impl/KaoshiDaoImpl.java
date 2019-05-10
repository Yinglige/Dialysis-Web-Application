package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Kaoshi;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.KaoshiDao;


public class KaoshiDaoImpl extends HibernateDaoSupport implements  KaoshiDao{


	public void deleteBean(Kaoshi Kaoshi) {
		this.getHibernateTemplate().delete(Kaoshi);
		
	}

	public void insertBean(Kaoshi Kaoshi) {
		this.getHibernateTemplate().save(Kaoshi);
		
	}

	@SuppressWarnings("unchecked")
	public Kaoshi selectBean(String where) {
		List<Kaoshi> list = this.getHibernateTemplate().find("from Kaoshi " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Kaoshi "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Kaoshi> selectBeanList(final int start,final int limit,final String where) {
		return (List<Kaoshi>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Kaoshi> list = session.createQuery("from Kaoshi "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Kaoshi Kaoshi) {
		this.getHibernateTemplate().update(Kaoshi);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Kaoshi> selectCount2(final Kaoshi r) {
		return (List<Kaoshi>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				 String hql="select u.fenlei.name,sum(u.fenshu)/count(u.fenshu),max(u.fenshu),min(u.fenshu) from Kaoshi u group by u.fenlei.id"; 
				List<Kaoshi> list = session.createQuery(hql).list();
				return list;
			}
		});
	}
	
	
}
