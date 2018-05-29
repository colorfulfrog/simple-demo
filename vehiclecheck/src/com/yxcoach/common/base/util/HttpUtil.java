package com.yxcoach.common.base.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;

/**
 * Created by alan on 15/10/14.
 */
public class HttpUtil {

    public static final String GET = "GET";
    public static final String POST = "POST";
    /**
     * 最大连接数
     */
    public final static int MAX_TOTAL_CONNECTIONS = 256;
    /**
     * 获取连接的最大等待时间
     */
    public final static int WAIT_TIMEOUT = 5000;
    /**
     * 每个路由最大连接数
     */
    public final static int MAX_ROUTE_CONNECTIONS = 40;
    /**
     * 连接超时时间
     */
    public final static int CONNECT_TIMEOUT = 10000;
    /**
     * 读取超时时间
     */
    public final static int READ_TIMEOUT = 10000;
    private final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static CloseableHttpClient init() {

        //需要通过以下代码声明对https连接支持
        try {
            SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null,
                    new TrustSelfSignedStrategy())
                    .build();

            HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslcontext, hostnameVerifier);

            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslsf)
                    .build();

            //初始化连接管理器
            PoolingHttpClientConnectionManager poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

            // Increase max total connection to 200
            poolConnManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
            // Increase default max connection per route to 20
            poolConnManager.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);

            CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(poolConnManager).build();

            return httpClient;
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            e.printStackTrace();
        }

        return HttpClients.createDefault();
    }

    /**
     * 发送Http请求,返回 string 结果
     *
     * @param serviceURL
     * @param params
     * @return
     */
    public static String doRequest(String serviceURL,
                                   Map<String, String> params, String httpType) throws IOException {

        String response = null;

        if (StringUtils.equalsIgnoreCase(httpType, GET)) {
            response = doGet(serviceURL);
        } else if (StringUtils.equalsIgnoreCase(httpType, POST)) {
            response = doPost(serviceURL, params);
        }

        return response;
    }

    //xiongzhe,add,2016-09-29
    public static String doRequestJson(String serviceURL, String jsonStr) throws Exception {
        Map headers = Maps.newHashMap();
        headers.put("Content-Type", "application/json");
        return HttpUtil.doRequestJson(serviceURL, jsonStr, headers);
    }
    //xiongzhe,add,2016-09-29
    public static String doRequestJson(String serviceURL,
                                   String jsonStr, Map<String, String> headers) throws Exception {
        CloseableHttpClient httpclient = init();
        HttpPost httppost = new HttpPost(serviceURL);
        //配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(WAIT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(READ_TIMEOUT).build();
        httppost.setConfig(requestConfig);
        //header
        Set<String> keys = headers.keySet();
        for (Iterator<String> i = keys.iterator(); i.hasNext();) {
            String key = (String) i.next();
            httppost.addHeader(key, headers.get(key));
        }
        StringEntity sEntry = new StringEntity(jsonStr, "utf-8");
        sEntry.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httppost.setEntity(sEntry);
        CloseableHttpResponse response = httpclient.execute(httppost);
        httppost.releaseConnection();
        return getResponseStr(response);
    }

    /**
     * 发送Http请求,返回 string 结果
     *
     * @param serviceURL
     * @param params
     * @return
     */
    public static String doRequest(String serviceURL,
                                   String httpType, List<BasicNameValuePair> params) throws IOException {

        String response = null;

        if (StringUtils.equalsIgnoreCase(httpType, GET)) {
            response = doGet(serviceURL);
        } else if (StringUtils.equalsIgnoreCase(httpType, POST)) {
            response = doPost(serviceURL, params);
        }

        return response;
    }

    /**
     * 走 POST
     * 参数为 NameValuePair, 省掉了转换过程
     *
     * @param serviceURL
     * @param params
     * @return
     */
    private static String doPost(String serviceURL, List<BasicNameValuePair> params) throws IOException {
        CloseableHttpClient httpclient = init();

        HttpPost httppost = new HttpPost(serviceURL);

        //配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(WAIT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(READ_TIMEOUT).build();
        httppost.setConfig(requestConfig);

        httppost.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = httpclient.execute(httppost);
        httppost.releaseConnection();

        return getResponseStr(response);
    }

    /**
     * 走 POST
     *
     * @param serviceURL
     * @param params
     * @return
     */
    private static String doPost(String serviceURL, final Map<String, String> params) throws IOException {
        CloseableHttpClient httpclient = init();

        HttpPost httppost = new HttpPost(serviceURL);

        //配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(WAIT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(READ_TIMEOUT).build();
        httppost.setConfig(requestConfig);

        //将 map数据转换为 listName
        Collection<NameValuePair> pairs = Collections2.transform(params.keySet(), new Function<String, NameValuePair>() {
            @Override
            public NameValuePair apply(String input) {
                return new BasicNameValuePair(input, params.get(input));
            }
        });

        httppost.setEntity(new UrlEncodedFormEntity(pairs));
        CloseableHttpResponse response = httpclient.execute(httppost);
        httppost.releaseConnection();

        return getResponseStr(response);
    }

    /**
     * 走 Get
     *
     * @param serviceURL
     * @return
     */
    private static String doGet(String serviceURL) throws IOException {
        CloseableHttpClient httpclient = init();

        HttpGet httpget = new HttpGet(serviceURL);
        //配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(WAIT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(READ_TIMEOUT).build();
        httpget.setConfig(requestConfig);


        CloseableHttpResponse response = httpclient.execute(httpget);

        httpget.releaseConnection();
        return getResponseStr(response);
    }

    /**
     * 把 respone 转换为对应的 string 信息
     *
     * @param response
     * @return
     * @throws IOException
     */
    private static String getResponseStr(CloseableHttpResponse response) throws IOException {
        String responseStr = null;
        int status = response.getStatusLine().getStatusCode();

        if (status >= 200 && status < 300) {
            responseStr = response.getEntity() != null ? EntityUtils.toString(response.getEntity(), "utf-8") : null;
        } else {
            throw new ClientProtocolException("Unexpected response status: " + status);
        }

        return responseStr;
    }

   
}
