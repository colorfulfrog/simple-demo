package com.yxcoach.common.base.easypoi.excel.config;

import java.util.ArrayList;
import java.util.List;

import com.yxcoach.common.base.easypoi.excel.parsing.ExcelHeader;

/**
 * Excel定义
 * 
 * @author elead-rd
 *
 */
public class ExcelDefinition {
	/** ID,必须 */
	private String id;

	/** 全类名,必须 */
	private String className;

	/** Class信息 */
	private Class<?> clazz;

	/**导出时,sheet页的名称,可以不设置*/
	private String sheetname;
	
	/**导出时,sheet页所有的默认列宽,可以不设置*/
	private Integer defaultColumnWidth;

	/**导出时,cell默认对其方式:支持,center,left,right*/
	private Short defaultAlign;
	
	/** Field属性的全部定义 */
	private List<FieldValue> fieldValues = new ArrayList<FieldValue>();
	
	/** 是否开启导出样式支持,(数据量很大时,不建议开启),底层可能会抛出异常,具体查询底层实现WorkBook.createCellStyle */
	//关于大数据量,已经修复,可以放心使用样式了,目前经过测试(一百万)数据不会有任何错误
	private Boolean enableStyle = false;
	
	/** Excel 文件sheet索引，默认为0即，第一个 */
	private int sheetIndex = 0;
	
	/** Excel sheet title行索引，默认为0即，第一个 */
	private int titleIndex = 0;
	
	/** Sheet自定义表头 */
	private ExcelHeader header = null;
	
	/**类型检查，导入时生效，非必填，如果该属性有值，则会检查导入excel的标记是否一致， 不一致则提示 */
	private String type;
	
	private List<String> fields = new ArrayList<String>();
	
	public ExcelDefinition() {
	}
	
	public ExcelDefinition(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTitleIndex() {
		return titleIndex;
	}

	public void setTitleIndex(int titleIndex) {
		this.titleIndex = titleIndex;
	}

	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public List<FieldValue> getFieldValues() {
		return fieldValues;
	}

	public void setFieldValues(List<FieldValue> fieldValues) {
		this.fieldValues = fieldValues;
	}

	public String getSheetname() {
		return sheetname;
	}
	
	public void setSheetname(String sheetname) {
		this.sheetname = sheetname;
	}

	public Integer getDefaultColumnWidth() {
		return defaultColumnWidth;
	}

	public void setDefaultColumnWidth(Integer defaultColumnWidth) {
		this.defaultColumnWidth = defaultColumnWidth;
	}

	public Boolean getEnableStyle() {
		return enableStyle;
	}

	public void setEnableStyle(Boolean enableStyle) {
		this.enableStyle = enableStyle;
	}

	public Short getDefaultAlign() {
		return defaultAlign;
	}

	public void setDefaultAlign(Short defaultAlign) {
		this.defaultAlign = defaultAlign;
	}
	
	public int getSheetIndex() {
		return sheetIndex;
	}
	
	public void setSheetIndex(int sheetIndex) {
		this.sheetIndex = sheetIndex;
	}
	
	public ExcelHeader getHeader() {
		return header;
	}

	public void setHeader(ExcelHeader header) {
		this.header = header;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
