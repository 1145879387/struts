package impl;

import bean.CstCustomerEntity;
import bean.SaleVisitEntity10;
import bean.UserEntity10;
import dao.CustomerDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	//	我需要操作数据库，用hib模版对象
	@Override
	public Integer gettotalcount(DetachedCriteria dc) {
//		查询总记录数，并不是所有对象，而是一个long行的数字,这实际上是一个聚合函数，dc实际上是前台传递多来的模糊查询的like语句
		dc.setProjection(Projections.rowCount());
		List<?> byCriteria = getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);
		if (byCriteria != null && byCriteria.size() > 0) {
			Long o = (Long) byCriteria.get(0);
			return o.intValue();
		} else {
			return null;
		}
	}

	@Override
	public List<CstCustomerEntity> getpagelist(DetachedCriteria dc, int getstart, Integer pagesize) {
//		获得list,这里的dc实际上仍然是前台的模糊查询语句，不过被spring自带的模版给封装了罢了
		List<CstCustomerEntity> byCriteria = (List<CstCustomerEntity>) getHibernateTemplate().findByCriteria(dc, getstart, pagesize);
		return byCriteria;
	}

	@Override
	public void save(CstCustomerEntity customer) {
		getHibernateTemplate().save(customer);
	}

	@Override
	public UserEntity10 save(UserEntity10 customer) {
		getHibernateTemplate().save(customer);
		return customer;
	}

	@Override
	public CstCustomerEntity getById(long custId) {
		return getHibernateTemplate().get(CstCustomerEntity.class, custId);
	}

	@Override
	public void saveorupdate(CstCustomerEntity customer) {
//		根据ID来判断保存或更新，有ID执行UPDATE,无ID执行SAVE方法
		getHibernateTemplate().saveOrUpdate(customer);
	}

	@Override
	public UserEntity10 regist(final String u) {
		return getHibernateTemplate().execute(new HibernateCallback<UserEntity10>() {
			@Override
			public UserEntity10 doInHibernate(Session session) throws HibernateException {
				String hql = "from UserEntity10 where code = ? ";
				Query query = session.createQuery(hql);
				query.setParameter(0, u);
				UserEntity10 user = (UserEntity10) query.uniqueResult();
				return user;
			}
		});
		//Criteria
		/*DetachedCriteria dc = DetachedCriteria.forClass(UserEntity10.class);

		dc.add(Restrictions.eq("user_code", usercode));

		List<UserEntity10> list = (List<UserEntity10>) getHibernateTemplate().findByCriteria(dc);

		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}*/
	}

	@Override
	public UserEntity10 login(final UserEntity10 user) {
		return getHibernateTemplate().execute(new HibernateCallback<UserEntity10>() {
			@Override
			public UserEntity10 doInHibernate(Session session) throws HibernateException {
				String hql = "from UserEntity10 where code = ? ";
				Query query = session.createQuery(hql);
				query.setParameter(0, user.getCode());
				UserEntity10 user = (UserEntity10) query.uniqueResult();
				return user;
			}
		});
	}

	@Override
	public void saveorupdate(UserEntity10 user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	@Override
	public void saveorupdate(SaleVisitEntity10 saleVisit) {
		getHibernateTemplate().saveOrUpdate(saleVisit);
	}

	@Override
	public List<Object[]> groupbylist() {
		return getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				Query query = session.createSQLQuery("SELECT b.dict_item_name ,count(*) FROM base_dict b ,cst_customer c WHERE c.cust_industry = b.dict_id GROUP BY c.cust_industry");
				return query.list();
			}
		});
	}

}
