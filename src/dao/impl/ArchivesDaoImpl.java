package dao.impl;
import java.sql.SQLException;
import java.util.List;

import model.Archives;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ArchivesDao;

public class ArchivesDaoImpl extends HibernateDaoSupport implements ArchivesDao {

	

	public void deleteBean(Archives bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Archives bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Archives selectBean(String where) {
		List<Archives> list = this.getHibernateTemplate().find("from Archives "+where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(final String where) {
		long count = (Long)this.getHibernateTemplate().find(" select count(*) from Archives  "+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Archives> selectBeanList(final int start,final int limit,final String where) {
		return (List<Archives>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				List<Archives> list = session.createQuery(" from Archives"+where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
		});
		
	}

	public void updateBean(Archives bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
	
	
	
	
	
}
