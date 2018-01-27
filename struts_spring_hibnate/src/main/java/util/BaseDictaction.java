package util;

import bean.BaseDictEntity;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import jiekou.Baseservice;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class BaseDictaction extends ActionSupport {
	//	利用属性驱动，必须要有get,set方法才可以接受参数！
	private String dictTypeCode;
	private Baseservice baseservice;

	@Override
	public String execute() throws Exception {
//		调用service层来获得数据字典对象list,并将List转换成json格式
		List<BaseDictEntity> baseDictEntities = baseservice.getlistByTypeCode(dictTypeCode);
		Gson gson = new Gson();
		String s = gson.toJson(baseDictEntities);
//		告诉浏览器是json类型的东西，防止乱码
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
//		ServletActionContext.getResponse().addHeader("Cache-Control: no-cache, must-revalidate");
		ServletActionContext.getResponse().getWriter().write(s);
		System.out.println(s);
		return null;
	}

	public String getDictTypeCode() {
		return dictTypeCode;
	}

	public void setDictTypeCode(String dictTypeCode) {
		this.dictTypeCode = dictTypeCode;
	}

	public void setBaseservice(Baseservice baseservice) {
		this.baseservice = baseservice;
	}
}
