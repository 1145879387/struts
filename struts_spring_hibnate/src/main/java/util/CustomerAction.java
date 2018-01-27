package util;

import bean.CstCustomerEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import jiekou.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;
import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<CstCustomerEntity> {
	private CstCustomerEntity customer = new CstCustomerEntity();
	//	这个属性被set注入了，相当于CustomerService customerService = new CustomerServiceImpl
	private CustomerService customerService;
	//	这里利用属性驱动来进行赋值
	private Integer currentpage;
	private Integer pagesize;
	//	上传文件会直接变成file对象
	private File photo;
	private String photoFileName;
	private String photoContentType;

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public Integer getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(Integer currentpage) {
		this.currentpage = currentpage;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public java.lang.String list() {
		//		封装离线查询对象，演示+1
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CstCustomerEntity.class);
		if (StringUtils.isNotBlank(customer.getCustName())) {
//			注意，这里写的话要与CstCustomerEntity里的属性名一致，而不是和数据库里的表名一致
			detachedCriteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
		}
		//		调用service查询分页数据（）
		PageBean pageBean = customerService.getbean(detachedCriteria, currentpage, pagesize);
		// 将pagebean放入requst狱转发到页面显示
		ActionContext.getContext().put("pagebean", pageBean);
		System.out.println(CustomerService.class);
		return "list";
	}


	public String add() {
		System.out.println(photoContentType + photoFileName);
//		将文件保存到指定位置
		if (photo != null) {
			photo.renameTo(new File("F:/BaiduYunDownload/java2/"));
		}
//	    调用service，保存对象
		customerService.save(customer);
		return "tolist";
	}

	public String toEdit() {
//		调用service，根据ID获得客户对象，然后放到REQUEST域对象
		CstCustomerEntity cstCustomerEntity = customerService.getbyid(customer.getCustId());
		ActionContext.getContext().put("cstCustomerEntity", cstCustomerEntity);
		return "edit";
	}

	@Override
	public CstCustomerEntity getModel() {
//		ModelDrivenInterceptor 源码类
//		实际上这是将操作压倒栈顶，然后就可以赋值了，另外struts用？来传递参数，类似于这样
//		/CustomerAction_toEdit?custId=<s:property value="#cust.custId" />"
		return customer;
	}


	public String kehutongji() throws Exception {
		List<Object[]> getincount = customerService.getincount();
		ActionContext.getContext().put("list", getincount);
		System.out.println(getincount);
		return "inducount";
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
