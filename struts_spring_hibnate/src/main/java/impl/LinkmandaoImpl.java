package impl;

import bean.CstLinkmanEntity;
import jiekou.Linkmandao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class LinkmandaoImpl extends HibernateDaoSupport implements Linkmandao {
	@Override
	public void save(CstLinkmanEntity cstLinkmanEntity) {
		getHibernateTemplate().save(cstLinkmanEntity);
	}
}
