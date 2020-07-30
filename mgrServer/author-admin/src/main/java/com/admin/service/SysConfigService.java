package com.admin.service;

import com.admin.entity.SysConfig;
import com.core.service.CurdService;

import java.util.List;

public interface SysConfigService extends CurdService<SysConfig> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
