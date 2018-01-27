package impl;

import bean.BaseDictEntity;
import jiekou.BaseDictDao;
import jiekou.Baseservice;

import java.util.List;

public class BaseserviceImpl implements Baseservice {
	@Override
	public List<BaseDictEntity> getlistByTypeCode(String dictTypeCode) {
		return baseDictDao.getlistByTypeCode(dictTypeCode);
	}

	private BaseDictDao baseDictDao;

	public BaseDictDao getBaseDictDao() {
		return baseDictDao;
	}

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
}
