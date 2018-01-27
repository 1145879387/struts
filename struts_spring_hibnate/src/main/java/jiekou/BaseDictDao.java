package jiekou;

import bean.BaseDictEntity;
import dao.BaseDao;

import java.util.List;

public interface BaseDictDao extends BaseDao<BaseDictEntity> {
	//根据类型获得数据字典
	List<BaseDictEntity> getlistByTypeCode(String dictTypeCode);
}
