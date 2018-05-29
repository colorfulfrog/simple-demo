package com.yxcoach.common.base.util.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yxcoach.common.base.util.Util;


/**
 */
public class ExcelWrite {

	private FileOutputStream fileOutputStream = null;
	private XSSFWorkbook workbook = null;
	private List<String> header = null;
	private int i = 0, j = 1;
	private Sheet dataSheet = null;
	private File dataFile = null;

	public ExcelWrite(String sheetTitle, String dataFilePath, List<String> header) {
		this.header = header;
		if (Util.isNotNull(dataFilePath)) {
			workbook = new XSSFWorkbook();
			dataFile = new File(dataFilePath);
			if (!dataFile.getParentFile().exists()) {
				dataFile.getParentFile().mkdirs();
			}
			dataSheet = workbook.createSheet(sheetTitle);
			Row dataHeader = dataSheet.createRow(0);
			for (String head : this.header) {
				Cell headCell = dataHeader.createCell(i);
				headCell.setCellValue(head);
				i++;
			}

		} else {
			throw new RuntimeException("No file defined.");
		}
	}

	public void writeRow(ReadData e) {
		Row dataRow = dataSheet.createRow(j);
		Map<String, String> dataData = e.getData();
		i = 0;
		for (String head : header) {
			Cell createCell = dataRow.createCell(i);
			createCell.setCellValue(dataData.get(head));
			i++;
		}
		dataData.clear();
		j++;
	}

	public void close() {
		try {
			if (!dataFile.exists() || !dataFile.isFile()) {
				dataFile.createNewFile();
			}
			fileOutputStream = new FileOutputStream(dataFile);
			workbook.write(fileOutputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (fileOutputStream != null) {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
