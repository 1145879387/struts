package jiekou;

import bean.CstCustomerEntity;
import bean.SaleVisitEntity10;
import bean.UserEntity10;
import org.hibernate.criterion.DetachedCriteria;
import util.PageBean;

import java.util.List;

public interface CustomerService {
	//	查询条件，当前页数，每页显示条数
	PageBean getbean(DetachedCriteria detachedCriteria, Integer currentpage, Integer pagesize);

	//保存客户方法
	void save(CstCustomerEntity customer);

	//根据id获得用户对象方法
	CstCustomerEntity getbyid(long custId);

	void regist(UserEntity10 u);

	UserEntity10 getUserByCodePassword(UserEntity10 user);

	//保存客户拜访记录
	void save(UserEntity10 user);

	void save(SaleVisitEntity10 saleVisit);

	//	按行业统计客户数量
	List<Object[]> getincount();
}
