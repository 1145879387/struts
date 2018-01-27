package impl;

import bean.CstLinkmanEntity;
import jiekou.Linkmandao;
import jiekou.Linkmanservice;

public class LinkmanserviceImpl implements Linkmanservice {
	private Linkmandao linkmandao;

	public Linkmandao getLinkmandao() {
		return linkmandao;
	}

	public void setLinkmandao(Linkmandao linkmandao) {
		this.linkmandao = linkmandao;
	}

	@Override
	public void save(CstLinkmanEntity cstLinkmanEntity) {
		linkmandao.save(cstLinkmanEntity);
	}
}
