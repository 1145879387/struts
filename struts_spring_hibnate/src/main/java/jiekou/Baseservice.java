package jiekou;

import bean.BaseDictEntity;

import java.util.List;

public interface Baseservice {
	//	根据数据字典的类型来获得数据字典对象
	List<BaseDictEntity> getlistByTypeCode(String dictTypeCode);
}
