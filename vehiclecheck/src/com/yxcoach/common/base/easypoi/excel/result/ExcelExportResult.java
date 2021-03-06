package com.yxcoach.common.base.easypoi.excel.result;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * Excel导出结果
 * 
 * @author elead-rd
 *
 */
public class ExcelExportResult {
	private Workbook workbook ;
	private String outPath;
	public ExcelExportResult(String outPath, Workbook workbook) {
		super();
		this.outPath = outPath;
		this.workbook = workbook;
	}
	
	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	public String getOutPath() {
		return outPath;
	}

	public void setOutPath(String outPath) {
		this.outPath = outPath;
	}

}
