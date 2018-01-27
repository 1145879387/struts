package impl;

import bean.CstCustomerEntity;
import bean.SaleVisitEntity10;
import bean.UserEntity10;
import dao.CustomerDao;
import jiekou.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import util.PageBean;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public PageBean getbean(DetachedCriteria dc, Integer currentpage, Integer pagesize) {
//		查询总记录数量
		int gettotalcount = customerDao.gettotalcount(dc);
//		创建pagebean对象
		PageBean pageBean = new PageBean(currentpage, gettotalcount, pagesize);
//		查询list的列表数据
		List<CstCustomerEntity> getpagelist = customerDao.getpagelist(dc, pageBean.getstart(), pageBean.getPagesize());
//		将列表数据放入pagebean中并返回
		pageBean.setList(getpagelist);
		return pageBean;
	}

	@Override
	public void save(CstCustomerEntity customer) {
//		维护customer与数据字典的关系
		customerDao.saveorupdate(customer);
	}

	@Override
	public CstCustomerEntity getbyid(long custId) {
		return customerDao.getById(custId);
	}

	@Override
	public void regist(UserEntity10 u) {
//		调用Dao根据注册获得用户对象，如果或得到用户对象，说明用户已经存在，抛出异常
		UserEntity10 regist = customerDao.regist(u.getCode());
		if (regist != null) {
			throw new RuntimeException("用户名已经存在");
		} else {
			customerDao.save(u);
		}
//		调用Dao执行保存
	}

	@Override
	public UserEntity10 getUserByCodePassword(UserEntity10 user) {
		UserEntity10 login = customerDao.login(user);
		if (login != null) {
			return login;
		} else {
			throw new RuntimeException("用户不存在");
		}
	}

	@Override
	public void save(UserEntity10 user) {
		customerDao.saveorupdate(user);
	}

	@Override
	public void save(SaleVisitEntity10 saleVisit) {
		customerDao.saveorupdate(saleVisit);
	}

	//	获得客户统计记录
	@Override
	public List<Object[]> getincount() {
		return customerDao.groupbylist();
	}


}
