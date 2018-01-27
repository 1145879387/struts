package dao;

import bean.CstCustomerEntity;
import bean.SaleVisitEntity10;
import bean.UserEntity10;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerDao {
	Integer gettotalcount(DetachedCriteria dc);

	List<CstCustomerEntity> getpagelist(DetachedCriteria dc, int getstart, Integer pagesize);

	void save(CstCustomerEntity customer);

	UserEntity10 save(UserEntity10 customer);

	CstCustomerEntity getById(long custId);

	void saveorupdate(CstCustomerEntity customer);

	UserEntity10 regist(String u);

	UserEntity10 login(UserEntity10 user);

	void saveorupdate(UserEntity10 user);

	void saveorupdate(SaleVisitEntity10 saleVisit);

	List<Object[]> groupbylist();
}
