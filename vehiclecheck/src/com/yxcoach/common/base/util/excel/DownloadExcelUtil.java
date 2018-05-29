package com.yxcoach.common.base.util.excel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadExcelUtil {

	/**
	 * 下载导入模板
	 * 
	 * @param request
	 * @param response
	 * @param excelName
	 *            excel命名
	 * @param realPath
	 *            模版路径
	 * @throws Exception
	 */
	public void downLoad(HttpServletRequest request, HttpServletResponse response, String excelName, String realPath,
			String localPath) throws Exception {
		try {
			response.reset();
			response.setContentType("application/msexcel");
//			response.setContentType("application/msdoc");
			response.setHeader("Content-disposition",
					"attachment;filename=" + new String(excelName.getBytes(), "ISO8859-1"));

			String downloadPath = realPath != null ? request.getRealPath(realPath) : localPath;
			InputStream is = new FileInputStream(downloadPath);
			OutputStream os = response.getOutputStream();
			int b;
			while ((b = is.read()) != -1) {
				os.write(b);
			}
			is.close();
			os.flush();
			os.close();
		} catch (Exception e) {
			throw e;
		}

	}

}
