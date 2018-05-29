package com.yxcoach.common.base.pay.alipay;

public class AlipayConfig {
	
    //失败返回
    public static final String FAIL_CODE = "fail";

	//支付宝网关 
//	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";// 
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";//dev
	//字符编码格式
	public static String charset = "UTF-8";
	
   // 超时时间
	public static String overTime = "30m";
	
    // 加密方式
    public static String encryptionMethod = "RSA2";
    
   //支付宝消息验证地址
    public static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
	
    /*
	 * partner是申请支付宝商户时支付宝生成的一个商户号登陆支付宝商户账号密码访问：
	 * https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	 */
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
    public static String partner = "2088031647598089";//腾晟云 
	//public static String partner = "2088102175156536";//dev

	/*
	 *私钥：private_key这个在支付宝的文档里有生成的方式，基于java后台使用，需要将这个密钥转成PKCS8,
	    在蚂蚁金服的开放平台设置和上传公钥，私钥转成pkcs8格式放到代码中
	 */
	// 商户的私钥,使用支付宝自带的openssl工具生成。
//	public static String private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC994zTQAyKrllprQREksJsRvfyC9gQcjW8JF0ti9oj42SkEfPIhnHKs27AbdwpkNxr3z5Kk0cxBRdsH1Z8nrxUCUAlmCBZQOCtYAeDmucW4i8sNGlHYReR/JqvDUR2aygZmjpAcx5SvKp0uIOLQUlmoBLmoIJYaoJbvtJUpfi/KtCfeWqFOUueDd3x1Y34WOQfmbi749ifsB1GjjeW7M1lk7KYT93vUTD5bo+Mtn1Z2Mcxf35/a5AZRMjQjPYzYFz5+GM4+7nXlXmOhz2d6hMyttuoQ/bQ1AnyuYZULAB+Uam81OB8394yQ3AuoZW2zRJWOyZci8Z/0aGHKVe03luTAgMBAAECggEAGXYkmevrwmq78T4PZGGHTZv1f6u2uf2U1jLJimFES6sewh7l3eqnNdP29DPFXozb/lldsAEteZSFHyjUHr/n3hufTWqma1AWzSYh27HXZ2nJiNM9iSOqVRbWZMASfQy/wy64wAqt9cjzz9ErUG7ft7Gc1uyMi+06q7FX36CfRn/rdQA8uvIzHHueMlXhl1obTbtM6fi0J0o6dVJmPV6XKET6dPdhTKO3ZYZQv0w2v62P9U5krBIzX7p1CeRz3xRyNl3zJnjCZ5USzVtwDpIfP0JZ4AcXoszieOe49Y4KgJ6MXWJnBEkFv5/IsMig2rWE1U0QF/MlUHWt6MbzdzSDAQKBgQDhlA4W9grB/DG8W3yEojI+yqHq8deL1wvFaDcGJgqzTKBD5A1tYjcDFyEPoPyKizl6Tw2oxGWSwxE3dXDBohDet7FaV5dibH4b3ef/ionu0m819Ce04Sn5BIkTqYmT2R8IDO3ndLLCgp6K1ecXt541vpXc2dIzRzABrZZ87DfV2QKBgQDXlglaOliPu4smT1nayXP5gRMBZSm7TC+3eT6bw76H8eTlyafpNNMvA3oU+VZzKPWTrczweJuwVzJ/CxiKQ6lzr2MzpsHPP4HYuREYetTIAgpLo0uY2K8KsyNWTSuD/9zrez75xQcLlG/2He+aWA+h/T6LHPoBKdsG8pzBqD49SwKBgDZLSnDgW4qBRv9NDdVmrK1MXFiOSRERe3XSNZw3P9AUG2b71veC8ja+NGjsmJxIEleL+3+pdcEzTkuI6tDQTzsr/3X9KyS3dEsEyDhLghOHdtkHoR76Kv4Sx2OCJOj/E2b+paxV/Eiw47QK9ApTWbMZ4jw7+Un6UmW1AEmlGXNRAoGAVoLrz9xYC52r0jzHhweOVZJZSRcKbxG8mDi8Sg971tvYCeopSmkbUeNoSyBfc6j9Gz0EX39WoqXrKpYOS/Wo+zZnbaO+ZGdMuOZTGOq5lmVTMlUeEgDqBTYruQcQrlCvm4OCmwJYuGnhn/cVXm92HoAcaADBxlPAhAI5q3DTQQ8CgYAa0zzo9LP/i9JKGLC24YiITYSWHWWGBsgoYbZHGFsLGeZ/RoudbJrA/utzDdwrjE9Ps5iKzk37NNysiv1nTF8HKAMKGdYlNgNl31+yCKfKlmLukigyXBv5RcQ0fCE5DTyP4U3pqcExvhg2F1+BWw3Ocq0oWtHfsRasaqaz4i9/5A==";
	//dev
	public static String private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC994zTQAyKrllprQREksJsRvfyC9gQcjW8JF0ti9oj42SkEfPIhnHKs27AbdwpkNxr3z5Kk0cxBRdsH1Z8nrxUCUAlmCBZQOCtYAeDmucW4i8sNGlHYReR/JqvDUR2aygZmjpAcx5SvKp0uIOLQUlmoBLmoIJYaoJbvtJUpfi/KtCfeWqFOUueDd3x1Y34WOQfmbi749ifsB1GjjeW7M1lk7KYT93vUTD5bo+Mtn1Z2Mcxf35/a5AZRMjQjPYzYFz5+GM4+7nXlXmOhz2d6hMyttuoQ/bQ1AnyuYZULAB+Uam81OB8394yQ3AuoZW2zRJWOyZci8Z/0aGHKVe03luTAgMBAAECggEAGXYkmevrwmq78T4PZGGHTZv1f6u2uf2U1jLJimFES6sewh7l3eqnNdP29DPFXozb/lldsAEteZSFHyjUHr/n3hufTWqma1AWzSYh27HXZ2nJiNM9iSOqVRbWZMASfQy/wy64wAqt9cjzz9ErUG7ft7Gc1uyMi+06q7FX36CfRn/rdQA8uvIzHHueMlXhl1obTbtM6fi0J0o6dVJmPV6XKET6dPdhTKO3ZYZQv0w2v62P9U5krBIzX7p1CeRz3xRyNl3zJnjCZ5USzVtwDpIfP0JZ4AcXoszieOe49Y4KgJ6MXWJnBEkFv5/IsMig2rWE1U0QF/MlUHWt6MbzdzSDAQKBgQDhlA4W9grB/DG8W3yEojI+yqHq8deL1wvFaDcGJgqzTKBD5A1tYjcDFyEPoPyKizl6Tw2oxGWSwxE3dXDBohDet7FaV5dibH4b3ef/ionu0m819Ce04Sn5BIkTqYmT2R8IDO3ndLLCgp6K1ecXt541vpXc2dIzRzABrZZ87DfV2QKBgQDXlglaOliPu4smT1nayXP5gRMBZSm7TC+3eT6bw76H8eTlyafpNNMvA3oU+VZzKPWTrczweJuwVzJ/CxiKQ6lzr2MzpsHPP4HYuREYetTIAgpLo0uY2K8KsyNWTSuD/9zrez75xQcLlG/2He+aWA+h/T6LHPoBKdsG8pzBqD49SwKBgDZLSnDgW4qBRv9NDdVmrK1MXFiOSRERe3XSNZw3P9AUG2b71veC8ja+NGjsmJxIEleL+3+pdcEzTkuI6tDQTzsr/3X9KyS3dEsEyDhLghOHdtkHoR76Kv4Sx2OCJOj/E2b+paxV/Eiw47QK9ApTWbMZ4jw7+Un6UmW1AEmlGXNRAoGAVoLrz9xYC52r0jzHhweOVZJZSRcKbxG8mDi8Sg971tvYCeopSmkbUeNoSyBfc6j9Gz0EX39WoqXrKpYOS/Wo+zZnbaO+ZGdMuOZTGOq5lmVTMlUeEgDqBTYruQcQrlCvm4OCmwJYuGnhn/cVXm92HoAcaADBxlPAhAI5q3DTQQ8CgYAa0zzo9LP/i9JKGLC24YiITYSWHWWGBsgoYbZHGFsLGeZ/RoudbJrA/utzDdwrjE9Ps5iKzk37NNysiv1nTF8HKAMKGdYlNgNl31+yCKfKlmLukigyXBv5RcQ0fCE5DTyP4U3pqcExvhg2F1+BWw3Ocq0oWtHfsRasaqaz4i9/5A==";



	// 支付宝的公钥，无需修改该值 dev
	//public static String ali_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsUNUtogEaUZDueZJZ51nNpCVwwhg7zD9HThn5iVsfbwm+HbTQ8El5ybW8LQIJYnyvfoqfcn3mj1gyFvCrUc6SJFUHehoxkWqow6N2P+t5WqABWf8vsdmKowtbakmhoJAf5PvrCApa6S9Fouax6R+YZBC/arL71DAsv3pm1nfF/zQlj7TvxkliwYgTWgZmt+dM5lwMCrpLI4mjKzYKjq2TJwAlFPXyBDd94RCqbh+6kB/jtW4DDA5dNj8eRK3GdhpsJwJbzNFuTrRsvVwyR6YKGDLyZ83R7hvMXKr9R2kECKyPpt/gy3Eq9Gmww2e30iebHyYjjVtO3qkzoYBCINFLwIDAQAB";
	
	public static String ali_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqYuYhbk/funRHAPM46rsJWP1HTHE67JVKhKGYd2TtUT+atwgLpZGA+JyV7NiTnSv6TPz0889PaLvvAvxrRRsvZ8rPCr25w0aW39YVOkRfk/FrFv28QvvjHV+xXZUBMC7ag3BUVzJPAtaNhwuuvUsP3vV+C6OT3jfXus9wbSeAoAl3EPv6NqHznHR4eKj4d0BuhXDHp0UaWbAvDwWIsGvKfzoRMKrcWQnr3QjCbl16LoYYk3pVylWbmpDUXwFejW5M2D9prVTO2/DeRf0AcnRPJr+t/RLNNI3zcKxKT+UmcePqO4n8rMm9bOiT6dNw2Aq4d2j89dv1sXZcd66LEO84wIDAQAB";
//	public static String ali_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqYuYhbk/funRHAPM46rsJWP1HTHE67JVKhKGYd2TtUT+atwgLpZGA+JyV7NiTnSv6TPz0889PaLvvAvxrRRsvZ8rPCr25w0aW39YVOkRfk/FrFv28QvvjHV+xXZUBMC7ag3BUVzJPAtaNhwuuvUsP3vV+C6OT3jfXus9wbSeAoAl3EPv6NqHznHR4eKj4d0BuhXDHp0UaWbAvDwWIsGvKfzoRMKrcWQnr3QjCbl16LoYYk3pVylWbmpDUXwFejW5M2D9prVTO2/DeRf0AcnRPJr+t/RLNNI3zcKxKT+UmcePqO4n8rMm9bOiT6dNw2Aq4d2j89dv1sXZcd66LEO84wIDAQAB";
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";// RSA  SHA256WithRSA

	public static String seller = "";

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "d:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "UTF-8";

	// 签名方式 不需修改
	public static String sign_type = "RSA";

	/*
	 * service这个需要注意一下，这个是处理最终订单完成时修改数据库标记所需要的一个链接，
	 * 这个链接需要外网可访问的地址，不能写一个127.0.0.1这样的本地地址
	 */
	
	// 接收通知的接口名(这里的域名或者ip需要填写外网可以访问的地址)
	public static String service = "http://127.0.0.1:8081/c/app/AppServer/notify-url";
	
	/*
	 *appid是在开放平台新建应用的appid
	 */
	// APPID
//	public static String app_id = "2018041102536751";
	public static String app_id = "2016091100486855";//dev 2018041102536751
}
