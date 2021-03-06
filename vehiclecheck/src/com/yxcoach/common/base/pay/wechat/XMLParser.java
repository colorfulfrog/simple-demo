package com.yxcoach.common.base.pay.wechat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yxcoach.common.base.pay.wechat.refundquery.RefundOrderData;
import com.yxcoach.common.base.util.IntegerExtends;
import com.yxcoach.common.base.util.StringExtends;

/**
 * XML 解析相关
 */
public class XMLParser {
    private static final Logger logger = LoggerFactory.getLogger(XMLParser.class);

    /**
     * 从RefunQueryResponseString里面解析出退款订单数据
     *
     * @param refundQueryResponseString RefundQuery API返回的数据
     * @return 因为订单数据有可能是多个，所以返回一个列表
     */
    public static List<RefundOrderData> getRefundOrderList(String refundQueryResponseString) throws IOException, SAXException, ParserConfigurationException {
        List list = Lists.newArrayList();

        Map<String, String> map = XMLParser.getMapFromXML(refundQueryResponseString);

        int count = Integer.parseInt(map.get("refund_count"));
        logger.info("refund count:" + count);

        if (count < 1) {
            return list;
        }

        RefundOrderData refundOrderData;

        for (int i = 0; i < count; i++) {
            refundOrderData = new RefundOrderData();

            refundOrderData.setOutRefundNo(StringExtends.getStringFromMap(map, "out_refund_no_" + i, ""));
            refundOrderData.setRefundID(StringExtends.getStringFromMap(map, "refund_id_" + i, ""));
            refundOrderData.setRefundChannel(StringExtends.getStringFromMap(map, "refund_channel_" + i, ""));
            refundOrderData.setRefundFee(IntegerExtends.getIntFromMap(map, "refund_fee_" + i));
            refundOrderData.setCouponRefundFee(IntegerExtends.getIntFromMap(map, "coupon_refund_fee_" + i));
            refundOrderData.setRefundStatus(StringExtends.getStringFromMap(map, "refund_status_" + i, ""));
            list.add(refundOrderData);
        }

        return list;
    }

    /**
     * xml 转换为 map
     *
     * @param xmlString
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static Map<String, String> getMapFromXML(String xmlString) throws ParserConfigurationException, IOException, SAXException {

        //这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is = StringExtends.getStringStream(xmlString);
        Document document = builder.parse(is);

        //获取到document里面的全部结点
        NodeList allNodes = document.getFirstChild().getChildNodes();
        Node node;
        Map<String, String> map = Maps.newHashMap();
        int i = 0;
        while (i < allNodes.getLength()) {
            node = allNodes.item(i);
            if (node instanceof Element) {
            	//唐志伟修改
//            	 map.put(node.getNodeName(), node.getNodeValue());
                map.put(node.getNodeName(), node.getTextContent());
            }
            i++;
        }
        return map;

    }

}
