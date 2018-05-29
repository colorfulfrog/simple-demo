package com.yxcoach.common.base.easypoi.excel;

import java.util.Map;

import com.yxcoach.common.base.easypoi.excel.config.ExcelDefinition;

/**
 * Excel定义接口
 * @author elead-rd
 *
 */
public interface ExcelDefinitionReader {
	/**
	 * 获取 ExcelDefinition注册信息
	 * @return
	 */
	Map<String, ExcelDefinition> getRegistry();
}
