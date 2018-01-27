package util;

import bean.SaleVisitEntity10;
import bean.UserEntity10;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import jiekou.CustomerService;

public class Salevisitaction extends ActionSupport implements ModelDriven<SaleVisitEntity10> {
	private SaleVisitEntity10 saleVisit = new SaleVisitEntity10();
	private CustomerService customerService;

	@Override
	public SaleVisitEntity10 getModel() {
		return saleVisit;
	}

	public String add() throws Exception {
//		添加客户拜访记录，调用service保存客户拜访记录，重定向到拜访记录列表action
		UserEntity10 user = (UserEntity10) ActionContext.getContext().getSession().get("user");
		saleVisit.setUserByVisitUserId(user);
//		调用service
		customerService.save(saleVisit);
		return "toList";
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
