package impl;

import bean.BaseDictEntity;
import dao.BaseDaoImpl;
import jiekou.BaseDictDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDictEntity> implements BaseDictDao {
	@Override
	public List<BaseDictEntity> getlistByTypeCode(String dictTypeCode) {
//		根据表中的某一列进行搜索，推荐用Creater的离线查询对象进行查询
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BaseDictEntity.class);
		detachedCriteria.add(Restrictions.eq("dictTypeCode", dictTypeCode));
		List<BaseDictEntity> byCriteria = (List<BaseDictEntity>) getHibernateTemplate().findByCriteria(detachedCriteria);
		return byCriteria;
	}
//	15714515823
}
