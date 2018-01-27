package util;

import bean.CstLinkmanEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import jiekou.Linkmanservice;

public class LinkmanAction extends ActionSupport implements ModelDriven<CstLinkmanEntity> {
	//	注意，这里用模型驱动，千万不要对cstLink生成get和set方法
	CstLinkmanEntity cstLinkmanEntity = new CstLinkmanEntity();
	Linkmanservice linkmanservice;

	public Linkmanservice getLinkmanservice() {
		return linkmanservice;
	}

	public void setLinkmanservice(Linkmanservice linkmanservice) {
		this.linkmanservice = linkmanservice;
	}

	public String add() {
		linkmanservice.save(cstLinkmanEntity);
		return "tolist";
	}

	@Override
	public CstLinkmanEntity getModel() {
		return cstLinkmanEntity;
	}
}
