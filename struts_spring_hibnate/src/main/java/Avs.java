import bean.CategoryEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class Avs extends HibernateDaoSupport {
	public CategoryEntity find() {
		CategoryEntity from_categoryEntity_ = getHibernateTemplate().execute(new HibernateCallback<CategoryEntity>() {

			@Override
			public CategoryEntity doInHibernate(Session session) throws HibernateException {
//				会把原声的session传递进来，先书写hql语句
				Query query = session.createQuery("from CategoryEntity where cid=?");
				query.setParameter(0, 5L);
				CategoryEntity o = (CategoryEntity) query.uniqueResult();
				return o;
			}
		});
		return from_categoryEntity_;
	}
}
