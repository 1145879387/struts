import bean.UserEntity10;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import jiekou.CustomerService;

public class UserAction extends ActionSupport implements ModelDriven<UserEntity10> {
	UserEntity10 u = new UserEntity10();
	CustomerService customerService;

	public String regist() {
//		ctrl+alt+T,如果没有就用ctrl+alt+shift+T
		try {
			customerService.regist(u);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		return "toLogin";
	}

	public String login() throws Exception {
		//1 调用Service执行登陆逻辑
		UserEntity10 userEntity10 = null;
		try {
			userEntity10 = customerService.getUserByCodePassword(u);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("message", e.getMessage());
			return "toLogin";
		}
		//2 将返回的User对象放入session域
		ActionContext.getContext().getSession().put("user", userEntity10);
		//3 重定向到项目首页
		return "toHome";
	}

	@Override
	public UserEntity10 getModel() {
		return u;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
