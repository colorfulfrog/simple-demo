package com.yxcoach.common.base.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * excel 导出 工具类
 */
public class ExcelExportUtil {
	/**
	 * @param response 
	 * @param fileName 下载文件名
	 * @param sheetName sheet名
	 * @param title 标题
	 * @param tj 条件
	 * @param subT 子条件
	 * @param colums 字段(第一列 用于合并单元格)
	 * @param columsName 字段中文(第一列 用于合并单元格)
	 * @param list 数据
	 */
	public static void exportExcel(HttpServletResponse response,String fileName,String sheetName,String title,String tj,String subT,String[]colums,String[]columsName,List<java.util.Map<String, Object>> list){
		// 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        
        
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet(sheetName);
        
        Font font=wb.createFont();
        font.setBold(true);
        CellStyle cellStyle = wb.createCellStyle(); 
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setFont(font);
        
        
        CellRangeAddress cra=new CellRangeAddress(0, 0, 0, (colums.length-2)); 
        sheet.addMergedRegion(cra);
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellStyle(cellStyle);
        titleCell.setCellValue(title);
        
        cra=new CellRangeAddress(1, 1, 0, (colums.length-2)); 
        sheet.addMergedRegion(cra);
        Row tjRow = sheet.createRow(1);
        Cell tjCell = tjRow.createCell(0);
        tjCell.setCellStyle(cellStyle);
        tjCell.setCellValue(tj);
        
        int nexRow=2;
        if(subT!=null){
        	CellStyle cellStyle2 = wb.createCellStyle(); 
        	cellStyle2.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        	cellStyle2.setFont(font);
            
        	cra=new CellRangeAddress(2, 2, 0, (colums.length-2)); 
            sheet.addMergedRegion(cra);
            
        	Row subTRow = sheet.createRow(2);
        	Cell subTCell = subTRow.createCell(0);
        	subTCell.setCellStyle(cellStyle2);
        	subTCell.setCellValue(subT);
        	nexRow=3;
        }
        
        CellStyle cellStyle3 = wb.createCellStyle(); 
    	cellStyle3.setAlignment(CellStyle.ALIGN_CENTER);//水平居中  
    	cellStyle3.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中 
        
        // 定义表头
        Row headRow = sheet.createRow(nexRow);
        for (int i=1;i<columsName.length;i++) {
            Cell cell = headRow.createCell(i-1);
            cell.setCellStyle(cellStyle3);
            cell.setCellValue(createHelper.createRichTextString(columsName[i]));
        }
        
        nexRow=nexRow+1;
        
        String firstCelVal="";
        // 填充表单内容
        for(int i=0;i<list.size();i++){
        	Row row = sheet.createRow(i+nexRow);
        	Map<String, Object> map=list.get(i);
        	for (int j=1;j<colums.length;j++) {
        		sheet.setColumnWidth((short) (j-1), (short) 4500);
                Cell cell = row.createCell(j-1);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(createHelper.createRichTextString(map.get(colums[j])==null?"":map.get(colums[j]).toString()));
            }
        	if(firstCelVal.equals(map.get(colums[0]).toString())){
        		CellRangeAddress tem=new CellRangeAddress((i+nexRow-1), i+nexRow, 0, 0); 
                sheet.addMergedRegion(tem);
        	}
        	firstCelVal=map.get(colums[0]).toString();
        }
        
        try{
        	response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName+".xls").getBytes(), "iso-8859-1"));
            wb.write(response.getOutputStream());
        }catch (Exception e) {
        	e.printStackTrace();
		}
	}
	/**
	 * @param response 
	 * @param fileName 下载文件名
	 * @param sheetName sheet名
	 * @param title 标题
	 * @param tj 条件
	 * @param subT 子条件
	 * @param colums 字段(第一列 用于合并单元格)
	 * @param columsName 字段中文(第一列 用于合并单元格)
	 * @param list 数据
	 */
	public static void exportExcel2(HttpServletResponse response,String fileName,String sheetName,String title,String tj,String[]colums,String[][]columsName,List<java.util.Map<String, Object>> list){
		// 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        
        
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet(sheetName);
        
        Font font=wb.createFont();
        font.setBold(true);
        CellStyle cellStyle = wb.createCellStyle(); 
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setFont(font);
        
        
        CellRangeAddress cra=new CellRangeAddress(0, 0, 0, (colums.length-2)); 
        sheet.addMergedRegion(cra);
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellStyle(cellStyle);
        titleCell.setCellValue(title);
        
        cra=new CellRangeAddress(1, 1, 0, (colums.length-2)); 
        sheet.addMergedRegion(cra);
        Row tjRow = sheet.createRow(1);
        Cell tjCell = tjRow.createCell(0);
        tjCell.setCellStyle(cellStyle);
        tjCell.setCellValue(tj);
        
        int nexRow=2;
        
        CellStyle cellStyle3 = wb.createCellStyle(); 
    	cellStyle3.setAlignment(CellStyle.ALIGN_CENTER);//水平居中  
    	cellStyle3.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中 
        
        // 定义表头
    	if(columsName.length==1){
    		Row headRow = sheet.createRow(nexRow);
            for (int i=0;i<columsName[0].length;i++) {
                Cell cell = headRow.createCell(i);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(createHelper.createRichTextString(columsName[0][i]));
            }
    	}else{
    		if(columsName[0].length==6){
    			Row headRow = sheet.createRow(nexRow);
        		CellRangeAddress t1=new CellRangeAddress(nexRow,nexRow+1, 0, 0); 
                sheet.addMergedRegion(t1);
        		Cell cell = headRow.createCell(0);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][0]);
                
                t1=new CellRangeAddress(nexRow,nexRow, 1, 3); 
                sheet.addMergedRegion(t1);
                Cell cell1 = headRow.createCell(1);
                cell1.setCellStyle(cellStyle3);
                cell1.setCellValue(columsName[0][1]);
                
                t1=new CellRangeAddress(nexRow,nexRow, 4, 6); 
                sheet.addMergedRegion(t1);
                Cell cell2 = headRow.createCell(4);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(columsName[0][2]);
                
                t1=new CellRangeAddress(nexRow,nexRow, 7,9); 
                sheet.addMergedRegion(t1);
                Cell cell3 = headRow.createCell(7);
                cell3.setCellStyle(cellStyle3);
                cell3.setCellValue(columsName[0][3]);
                
                t1=new CellRangeAddress(nexRow,nexRow, 10, 12); 
                sheet.addMergedRegion(t1);
                Cell cell4 = headRow.createCell(10);
                cell4.setCellStyle(cellStyle3);
                cell4.setCellValue(columsName[0][4]);
                
                t1=new CellRangeAddress(nexRow,nexRow+1, 13, 13); 
                sheet.addMergedRegion(t1);
                Cell cell5 = headRow.createCell(13);
                cell5.setCellStyle(cellStyle3);
                cell5.setCellValue(columsName[0][5]);
                
                nexRow=nexRow+1;
                
                headRow = sheet.createRow(nexRow);
                for (int i=0;i<columsName[1].length;i++) {
                	 Cell cell6 = headRow.createCell(i+1);
                     cell6.setCellStyle(cellStyle3);
                     cell6.setCellValue(createHelper.createRichTextString(columsName[1][i]));
                }
               
    		}
    		if(columsName[0].length==3){
    			Row headRow = sheet.createRow(nexRow);
        		CellRangeAddress t1=new CellRangeAddress(nexRow,nexRow+1, 0, 0); 
                sheet.addMergedRegion(t1);
        		Cell cell = headRow.createCell(0);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][0]);
                
                t1=new CellRangeAddress(nexRow,nexRow, 1, 3); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(1);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][1]);
                
                t1=new CellRangeAddress(nexRow,nexRow+1, 4, 4); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(4);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][2]);
                
				nexRow=nexRow+1;
                
                headRow = sheet.createRow(nexRow);
                for (int i=0;i<columsName[1].length;i++) {
               	 Cell cell6 = headRow.createCell(i+1);
                    cell6.setCellStyle(cellStyle3);
                    cell6.setCellValue(createHelper.createRichTextString(columsName[1][i]));
               }
    		}
    	}
        
        
        nexRow=nexRow+1;
        
        // 填充表单内容
        for(int i=0;i<list.size();i++){
        	Row row = sheet.createRow(i+nexRow);
        	Map<String, Object> map=list.get(i);
        	for (int j=0;j<colums.length;j++) {
        		sheet.setColumnWidth((short) (j), (short) 4500);
                Cell cell = row.createCell(j);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(createHelper.createRichTextString(map.get(colums[j])==null?"":map.get(colums[j]).toString()));
            }
        }
        
        try{
        	response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName+".xls").getBytes(), "iso-8859-1"));
            wb.write(response.getOutputStream());
        }catch (Exception e) {
        	e.printStackTrace();
		}
	}
	/**
	 * @param response 
	 * @param fileName 下载文件名
	 * @param sheetName sheet名
	 * @param title 标题
	 * @param tj 条件
	 * @param subT 子条件
	 * @param colums 字段(第一列 用于合并单元格)
	 * @param columsName 字段中文(第一列 用于合并单元格)
	 * @param list 数据
	 */
	public static void exportExcel3(HttpServletResponse response,String fileName,String sheetName,String title,String tj,String[]colums,String[][]columsName,List<java.util.Map<String, Object>> list){
		// 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        
        
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet(sheetName);
        
        Font font=wb.createFont();
        font.setBold(true);
        CellStyle cellStyle = wb.createCellStyle(); 
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setFont(font);
        
        
        CellRangeAddress cra=new CellRangeAddress(0, 0, 0, (colums.length-2)); 
        sheet.addMergedRegion(cra);
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellStyle(cellStyle);
        titleCell.setCellValue(title);
        
        cra=new CellRangeAddress(1, 1, 0, (colums.length-2)); 
        sheet.addMergedRegion(cra);
        Row tjRow = sheet.createRow(1);
        Cell tjCell = tjRow.createCell(0);
        tjCell.setCellStyle(cellStyle);
        tjCell.setCellValue(tj);
        
        int nexRow=2;
        
        CellStyle cellStyle3 = wb.createCellStyle(); 
    	cellStyle3.setAlignment(CellStyle.ALIGN_CENTER);//水平居中  
    	cellStyle3.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中 
        
        // 定义表头
    	if(columsName.length==1){
    		Row headRow = sheet.createRow(nexRow);
            for (int i=1;i<columsName[0].length;i++) {
                Cell cell = headRow.createCell(i-1);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(createHelper.createRichTextString(columsName[0][i]));
            }
    	}else{
    		if(columsName[0].length==8){
    			Row headRow = sheet.createRow(nexRow);
        		CellRangeAddress t1=new CellRangeAddress(nexRow,nexRow+1, 0, 0); 
                sheet.addMergedRegion(t1);
        		Cell cell = headRow.createCell(0);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][1]);
                
                t1=new CellRangeAddress(nexRow,nexRow+1, 1, 1); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(1);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][2]);
                
                t1=new CellRangeAddress(nexRow,nexRow, 2, 4); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(2);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][3]);
                
                t1=new CellRangeAddress(nexRow,nexRow, 5, 7); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(5);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][4]);
                
                t1=new CellRangeAddress(nexRow,nexRow, 8,10); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(8);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][5]);
                
                t1=new CellRangeAddress(nexRow,nexRow, 11, 13); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(11);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][6]);
                
                t1=new CellRangeAddress(nexRow,nexRow+1, 14, 14); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(14);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][7]);
                
                nexRow=nexRow+1;
                
                headRow = sheet.createRow(nexRow);
                for (int i=0;i<columsName[1].length;i++) {
                  	 Cell cell6 = headRow.createCell(i+2);
                     cell6.setCellStyle(cellStyle3);
                     cell6.setCellValue(createHelper.createRichTextString(columsName[1][i]));
               }
               
    		}
    		if(columsName[0].length==5){
    			Row headRow = sheet.createRow(nexRow);
        		CellRangeAddress t1=new CellRangeAddress(nexRow,nexRow+1, 0, 0); 
                sheet.addMergedRegion(t1);
        		Cell cell = headRow.createCell(0);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][1]);
                
                t1=new CellRangeAddress(nexRow,nexRow+1, 1, 1); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(1);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][2]);
                
                t1=new CellRangeAddress(nexRow,nexRow, 2, 4); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(2);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][2]);
                
                t1=new CellRangeAddress(nexRow,nexRow+1, 5, 5); 
                sheet.addMergedRegion(t1);
        		cell = headRow.createCell(5);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(columsName[0][3]);
                
				nexRow=nexRow+1;
                
                headRow = sheet.createRow(nexRow);
                for (int i=0;i<columsName[1].length;i++) {
                 	 Cell cell6 = headRow.createCell(i+2);
                    cell6.setCellStyle(cellStyle3);
                    cell6.setCellValue(createHelper.createRichTextString(columsName[1][i]));
               }
    		}
    	}
        
        
        nexRow=nexRow+1;
        
        String firstCelVal="";
        // 填充表单内容
        for(int i=0;i<list.size();i++){
        	Row row = sheet.createRow(i+nexRow);
        	Map<String, Object> map=list.get(i);
        	for (int j=1;j<colums.length;j++) {
        		sheet.setColumnWidth((short) (j-1), (short) 4500);
                Cell cell = row.createCell(j-1);
                cell.setCellStyle(cellStyle3);
                cell.setCellValue(createHelper.createRichTextString(map.get(colums[j])==null?"":map.get(colums[j]).toString()));
            }
        	
        	if(firstCelVal.equals(map.get(colums[0]).toString())){
        		CellRangeAddress tem=new CellRangeAddress((i+nexRow-1), i+nexRow, 0, 0); 
                sheet.addMergedRegion(tem);
        	}
        	firstCelVal=map.get(colums[0]).toString();
        }
        
        try{
        	response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName+".xls").getBytes(), "iso-8859-1"));
            wb.write(response.getOutputStream());
        }catch (Exception e) {
        	e.printStackTrace();
		}
	}
}
