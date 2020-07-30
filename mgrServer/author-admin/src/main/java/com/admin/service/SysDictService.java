package com.admin.service;

import com.admin.entity.SysDict;
import com.core.service.CurdService;

import java.util.List;

public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
