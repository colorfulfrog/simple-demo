package com.yxcoach.common.push;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.LoggerFactory;

import com.yxcoach.common.base.util.HttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 亿美软通发短信客户端
 */
public class YMRTHttpClient {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(YMRTHttpClient.class);


    // 下发
    public static String regist(String url, String param) throws IOException {
        String ret = "失败";
        url = url + "?" + param;
        logger.debug("【YMRTHttpClient】发送MT到SDK->" + url);
        String responseString = HttpUtil.doRequest(url, null, HttpUtil.GET);
        responseString = responseString.trim();
        if (null != responseString && !"".equals(responseString)) {
            ret = xmlResponse(responseString);
        }
        return ret;
    }

    // 获取mo
    public static List<Mo> getMos(String url, String sn, String key) throws IOException {
        List<Mo> _Mos = new ArrayList<Mo>();

        if ("".equals(url)) {
            return _Mos;
        }
        String param = "cdkey=" + sn + "&password=" + key;
        url = url + "?" + param;
        logger.debug("【YMRTHttpClient】Request-Url:" + url);
        String responseString = HttpUtil.doRequest(url, null, HttpUtil.GET);


        responseString = responseString.trim();
        if (null != responseString && !"".equals(responseString)) {
            List<Element> elements = xmlDoc(responseString);
            for (Element element : elements) {
                if (null != element) {
                    logger.debug("【YMRTHttpClient】上行请求->" + responseString);
                    Mo mo = new Mo();
                    mo.setMobileNumber(element.elementText("srctermid"));
                    mo.setSmsContent(element.elementText("msgcontent"));
                    mo.setAddSerial(element.elementText("addSerial"));
                    mo.setAddSerialRev(element.elementText("addSerialRev"));
                    mo.setSentTime(element.elementText("sendTime"));
                    _Mos.add(mo);
                }
            }
        }
        return _Mos;
    }

    // 获取report
    public static List<StatusReport> getReports(String url, String sn, String key) throws IOException {
        List<StatusReport> _Reports = new ArrayList<StatusReport>();
        if ("".equals(url)) {
            return _Reports;
        }
        String param = "cdkey=" + sn + "&password=" + key;
        url = url + "?" + param;
        logger.debug("【YMRTHttpClient】Request-Url:" + url);
        String responseString = HttpUtil.doRequest(url, null, HttpUtil.GET);
        responseString = responseString.trim();
        if (null != responseString && !"".equals(responseString)) {
            List<Element> elements = xmlDoc(responseString);
            for (Element element : elements) {
                if (null != element) {
                    logger.debug("【YMRTHttpClient】REPORT->" + element.elementText("seqid"));
                    StatusReport report = new StatusReport();
                    report.setMobile(element.elementText("srctermid"));
                    report.setErrorCode(element.elementText("state"));
                    report.setSeqID(Long.parseLong(element.elementText("seqid")));
                    report.setReceiveDate(element.elementText("receiveDate"));
                    report.setSubmitDate(element.elementText("submitDate"));
                    report.setServiceCodeAdd(element.elementText("addSerialRev"));
                    _Reports.add(report);
                }
            }

        }
        return _Reports;
    }

    // 下发
    public static String sendSMS(String url, String param) throws IOException {
        String ret = "";
        url = url + "?" + param;
        logger.debug("【YMRTHttpClient】发送MT到SDK->" + url);
        String responseString = HttpUtil.doRequest(url, null, HttpUtil.GET);
        responseString = responseString.trim();
        if (null != responseString && !"".equals(responseString)) {
            ret = xmlMt(responseString);
        }
        return ret;
    }

    // 获取余额
    public static String getBalance(String url, String param) throws IOException {
        String ret = "失败";
        url = url + "?" + param;
        // logger.info("【YMRTHttpClient】Balance->"+url);
        String responseString = HttpUtil.doRequest(url, null, HttpUtil.GET);
        responseString = responseString.trim();
        if (null != responseString && !"".equals(responseString)) {
            ret = xmlResponse(responseString);
        }
        return ret;
    }

    // 统一解析格式
    public static String xmlResponse(String response) {
        String result = "失败";
        Document document = null;
        try {
            document = DocumentHelper.parseText(response);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        result = root.elementText("message");
        return result;
    }

    // 解析状态、上行
    private static List<Element> xmlDoc(String response) {
        boolean result = false;
        Document document = null;
        try {
            document = DocumentHelper.parseText(response);
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
        Element root = document.getRootElement();
        List<Element> list = root.elements();
        List<Element> elemets = new ArrayList();
        // 增强for循环来遍历所有的U8ArrivalVouch节点
        for (Element element : list) {
            String message = element.getName();
            if ("message".equalsIgnoreCase(message)) {
                if (element.elements().size() > 0) {
                    // System.out.println("--------------------"+element.elements().size());
                    elemets.add(element);
                }
            }

        }
        return elemets;
    }

    // 解析下发response
    public static String xmlMt(String response) {
        String result = "0";
        Document document = null;
        try {
            document = DocumentHelper.parseText(response);
        } catch (DocumentException e) {
            e.printStackTrace();
            result = "-250";
        }
        Element root = document.getRootElement();
        result = root.elementText("error");
        if (null == result || "".equals(result)) {
            result = "-250";
        }
        return result;
    }


}
