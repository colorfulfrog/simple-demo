package com.yxcoach.common.base.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Created by fengruxiao on 16/1/6.
 * xml和bean互相转换方法
 */
public class XmlObjectTransfer {



    /**
     * bean转xml
     *
     * @param model
     * @return
     */
    public static String objectToXmlForCommon(Object model) {
        XStream xstream = new XStream(new DomDriver());
        xstream.autodetectAnnotations(true);
        return xstream.toXML(model);
    }

    /**
     * xml转bean公共方法
     *
     * @param xmlString
     * @return
     */
    public static Object xmlToObject(String xmlString, Class clas) {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(clas);
        Object ob = xstream.fromXML(xmlString);
        return ob;
    }

    /**
     * 微信相关转换
     *
     * @param xml
     * @param tClass
     * @return
     */
    public static Object getObjectFromXMLForWechat(String xml, Class tClass) {
        //将从API返回的XML数据映射到Java对象
        //XStream xStreamForResponseData = new XStream();
    	/**
    	 * 发现Xstream默认是使用XppDriver的   把Xstream的Driver改为DomDriver 
    	 */
        XStream xStreamForResponseData = new XStream(new DomDriver()); 
        xStreamForResponseData.alias("xml", tClass);
        xStreamForResponseData.ignoreUnknownElements();//暂时忽略掉一些新增的字段
        return xStreamForResponseData.fromXML(xml);
    }
}
