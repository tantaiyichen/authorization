package com.admin.service;

import com.admin.entity.SysDept;
import com.core.service.CurdService;

import java.util.List;

public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param
	 * @return
	 */
	List<SysDept> findTree();
}
