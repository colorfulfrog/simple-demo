package com.yxcoach.common.base.pay.sign;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSA{
	
	public static final String  SIGN_ALGORITHMS = "SHA1WithRSA";
	
	/**
	* RSA签名
	* @param content 待签名数据
	* @param privateKey 商户私钥
	* @param input_charset 编码格式
	* @return 签名值
	*/
	public static String sign(String content, String privateKey, String input_charset)
	{
        try 
        {
        	PKCS8EncodedKeySpec priPKCS8 	= new PKCS8EncodedKeySpec( Base64.decode(privateKey) ); 
        	KeyFactory keyf 				= KeyFactory.getInstance("RSA");
        	PrivateKey priKey 				= keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature
                .getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update( content.getBytes(input_charset) );

            byte[] signed = signature.sign();
            
            return Base64.encode(signed);
        }
        catch (Exception e) 
        {
        	e.printStackTrace();
        }
        
        return null;
    }
	
	/**
	* RSA验签名检查
	* @param content 待签名数据
	* @param sign 签名值
	* @param ali_public_key 支付宝公钥
	* @param input_charset 编码格式
	* @return 布尔值
	*/
	public static boolean verify(String content, String sign, String ali_public_key, String input_charset)
	{
		try 
		{
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        byte[] encodedKey = Base64.decode(ali_public_key);
	        PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

		
			java.security.Signature signature = java.security.Signature
			.getInstance(SIGN_ALGORITHMS);
		
			signature.initVerify(pubKey);
			signature.update( content.getBytes(input_charset) );
		
			boolean bverify = signature.verify( Base64.decode(sign) );
			return bverify;
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	* 解密
	* @param content 密文
	* @param private_key 商户私钥
	* @param input_charset 编码格式
	* @return 解密后的字符串
	*/
	public static String decrypt(String content, String private_key, String input_charset) throws Exception {
        PrivateKey prikey = getPrivateKey(private_key);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, prikey);

        InputStream ins = new ByteArrayInputStream(Base64.decode(content));
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        //rsa解密的字节大小最多是128，将需要解密的内容，按128位拆开解密
        byte[] buf = new byte[128];
        int bufl;

        while ((bufl = ins.read(buf)) != -1) {
            byte[] block = null;

            if (buf.length == bufl) {
                block = buf;
            } else {
                block = new byte[bufl];
                for (int i = 0; i < bufl; i++) {
                    block[i] = buf[i];
                }
            }

            writer.write(cipher.doFinal(block));
        }

        return new String(writer.toByteArray(), input_charset);
    }

	
	/**
	* 得到私钥
	* @param key 密钥字符串（经过base64编码）
	* @throws Exception
	*/
	public static PrivateKey getPrivateKey(String key) throws Exception {

		byte[] keyBytes;
		
		keyBytes = Base64.decode(key);
		
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		
		return privateKey;
	}
	
	

    public static void main(String[] args) {
//        String enStr = "";


//        String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOSUhCPmkYMQNAP9\n" +
//                "Zv5qedjm/ayMsbAoQrdousUwZE/l/QzzL6tkLNOwvgbesJUdx9vQkKVAkj2Bw/J6\n" +
//                "frd9reCwGYhYQmMHTH7eYiUzbB67M05GR2j5N7x/8M5oPVe4lG+5CdnjS5I/vDSw\n" +
//                "fa0UyEBUY8XYviss6InUXrOjgaqtAgMBAAECgYEAw6fAh/5XNYmMDJI+M62uSJRI\n" +
//                "NQdlHTUJDnctz5YBd0aU2R3cAufHWxghQD4jhjAsn6Ih/eGMi+tkb0yc5LFGP7wy\n" +
//                "7m//7kSCyrUDzHCeF+j3aIHY6DCEYKg4pgKgcWdCXX13amRfYWCNXa/vVuXiGAyJ\n" +
//                "N9zK6M8S9om2nVcWi70CQQD1VDS+dfBgtpWPBTWC99mM33IJqoXXqCOOcFjMjqFY\n" +
//                "ZgAmKZBwtCBytjY+b7cDfNsBE6Pm7gUjwjmn+L739Zo3AkEA7oXO/C6UpZ9Wr1O6\n" +
//                "xfgAyYNo+YSdGhVSUx06pWoWA8xobZMFxFf1Ow0X+0w+tEM2tfKjSwWaWwCHapba\n" +
//                "iUHgOwJAFPC9F8zFWdv75BtTt/wj66xe9YhCqGfHsS7RxZQfHYaHWLqPg688Xc5D\n" +
//                "zwyGGJwdrXfZs6p5cdXwSfAnjM6//QJBALv1fdKD8mdBVNH8rSXr9NLXVxWpRxOS\n" +
//                "0bjlQ52uJ4L+xRvzy4uZtInAG7HPt2ndvXNLrRolZClqFUwNbFDVNJkCQAYshOVB\n" +
//                "8hCKBB/AU9HUZIsp31uxeb7VhyBYmIo1kKra6d02va29RUWt2vS+C0vG9+Qc+pHh\n" +
//                "V2NulQRuObIfGLg=";
//        String public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDklIQj5pGDEDQD/Wb+annY5v2sjLGwKEK3aLrFMGRP5f0M8y+rZCzTsL4G3rCVHcfb0JClQJI9gcPyen63fa3gsBmIWEJjB0x+3mIlM2weuzNORkdo+Te8f/DOaD1XuJRvuQnZ40uSP7w0sH2tFMhAVGPF2L4rLOiJ1F6zo4GqrQIDAQAB";
//        String ali_public_key = "";


//        String public_key=
//                "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDUH9ZG3cm6c8zPf7S6IPJsMn94TkaFbFPuGbac6FSNYCws1Af+wtfJR5Eu75dB+zLUzplJl3i0BjhQ8GPl/j+WTLHI7pot7oDRe9CC8mGRNIi7oHRDubm04W5H/HKl+9JuILdrki9In/SE2FjVu1UOQ9nd8kaYrtDxTSbkN1IdqQIDAQAB";
//        String private_key=
//                "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANQf1kbdybpzzM9/tLog8mwyf3hORoVsU+4ZtpzoVI1gLCzUB/7C18lHkS7vl0H7MtTOmUmXeLQGOFDwY+X+P5ZMscjumi3ugNF70ILyYZE0iLugdEO5ubThbkf8cqX70m4gt2uSL0if9ITYWNW7VQ5D2d3yRpiu0PFNJuQ3Uh2pAgMBAAECgYEA09VDYBvGg4t3AdSPf7y9Oy2mvFa2+DD5E/LbuZAON+zN0KqhnVmospnks5GSZNLdrUTwMVyxrl3zyWh26sxfY/8Uu8JZs8fIZPqv0aTRESLFCTBsOpstyKDoaDFA7cCsvcXWaZ+EDZfKth9xroDtZ42vpep4ptIpEJUY7Dkvvd0CQQD8xa1loTc/q/FCNuv0IH0nw0j3RpdBYBtLXM6+qUSgUP3+DIu+ZcEBV3NSyrJRwX5Lz4YcE+1ZZBgfmExmkG9zAkEA1tVHwkNrb+/V1egh9+8rnyEolfeTok7MBelSLov1/5P8IsK4qD225zUAbXT0tbshPnSfLuHu+SDgBcZB2MJ/cwJAb5u04T/azjFUWGE5s9Q4jrsKV6yCkqolwxPacZL5qzO3wlm1xj7Vhosfb3nyXGjsI/sggvtFfIfWovSzH0I9AwJBAKVZ3zNsROMRC9rqIkr8cOy3zs8ukRkZ4PqjzLc6zop6UlRG323OolpudvfITxkZAMtbY7Hn/9EMNqD7KW82tHUCQQDGXI/Ib0ll0F8KwqKI1VNcYUjdLF0IIYf8753Wq2OXfQcS42+2qfo8gQH1QYopELM/T0jy/n3E39rVzW7YalCE";

        //old
//        String public_key="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDT01XBeuUL1A818IZ5yKaFyZmH/1+hKjJOrQpEyUod+sl2juYo3cVgudPoT+SwUmFQGMvOLBcQSw+jtaQYLAAimQ9OHepunHT8fnXDNyQEZc7eJJuaV955qRmBm3tSU3yZ7WyNgCXmwZVh0PdvRcALoQGUl3xtGCOLJzd1OCjh5QIDAQAB";
//        String private_key="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANPTVcF65QvUDzXwhnnIpoXJmYf/X6EqMk6tCkTJSh36yXaO5ijdxWC50+hP5LBSYVAYy84sFxBLD6O1pBgsACKZD04d6m6cdPx+dcM3JARlzt4km5pX3nmpGYGbe1JTfJntbI2AJebBlWHQ929FwAuhAZSXfG0YI4snN3U4KOHlAgMBAAECgYADRwPOqI4errtFhGEwRTB+ZW4gsozSO4rnuLmt8sdYy2aOlQtumm/RXU6wC3xoVf33dUrB9+Cred3WFJtjXFrsJuinwgzLS2XE8TLa8FFabvBb3Qi0zqhCo0xYrmj5gDFZn31vdRpMm3vzYWXhIaVJANhVse5JS9H+WWrcZTkTyQJBAO9kxpNaXhij+YmvqUx+C035aw/TkXfIJohE3R//t9mc+CUFVjRmRN2sOznkYv21TAIw8SesZk82VO6WNPp6YJcCQQDihP8IJrMN5iIEelOwAKvD0LPdmZ8AIh23jnZXuDe4RStquUfSoGZc9Ap6eu4a/3noMnVrxyIGM9v8vhRKcCTjAkBkl0HhlO1JCU3HjypiW+xAHXfhNJNBc7bNN7J6yablJ9IVLELmzbpOMxrH3rHBzbZcjVgnxYdP7ZKOlks4nMeNAkEAnj77S959SEB1k1tCC7rsRCgQ/8bKZXVv/UPxOObhRkJMSoqVuneEC3wRte8bWJERwT0++sRq6JpiHPdNhZNCsQJAA1yZgKWMDfvGBmGjh/btRHTvJwdQEg7Y+UJoswisqElxtC4+jo5UhTTILRmJWl5kLNSWlwEOQyk2E8UGDuUSEQ==";

      /*  String public_key="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDT01XBeuUL1A818IZ5yKaFyZmH/1+hKjJOrQpEyUod+sl2juYo3cVgudPoT+SwUmFQGMvOLBcQSw+jtaQYLAAimQ9OHepunHT8fnXDNyQEZc7eJJuaV955qRmBm3tSU3yZ7WyNgCXmwZVh0PdvRcALoQGUl3xtGCOLJzd1OCjh5QIDAQAB";
        String private_key="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANPTVcF65QvUDzXwhnnIpoXJmYf/X6EqMk6tCkTJSh36yXaO5ijdxWC50+hP5LBSYVAYy84sFxBLD6O1pBgsACKZD04d6m6cdPx+dcM3JARlzt4km5pX3nmpGYGbe1JTfJntbI2AJebBlWHQ929FwAuhAZSXfG0YI4snN3U4KOHlAgMBAAECgYADRwPOqI4errtFhGEwRTB+ZW4gsozSO4rnuLmt8sdYy2aOlQtumm/RXU6wC3xoVf33dUrB9+Cred3WFJtjXFrsJuinwgzLS2XE8TLa8FFabvBb3Qi0zqhCo0xYrmj5gDFZn31vdRpMm3vzYWXhIaVJANhVse5JS9H+WWrcZTkTyQJBAO9kxpNaXhij+YmvqUx+C035aw/TkXfIJohE3R//t9mc+CUFVjRmRN2sOznkYv21TAIw8SesZk82VO6WNPp6YJcCQQDihP8IJrMN5iIEelOwAKvD0LPdmZ8AIh23jnZXuDe4RStquUfSoGZc9Ap6eu4a/3noMnVrxyIGM9v8vhRKcCTjAkBkl0HhlO1JCU3HjypiW+xAHXfhNJNBc7bNN7J6yablJ9IVLELmzbpOMxrH3rHBzbZcjVgnxYdP7ZKOlks4nMeNAkEAnj77S959SEB1k1tCC7rsRCgQ/8bKZXVv/UPxOObhRkJMSoqVuneEC3wRte8bWJERwT0++sRq6JpiHPdNhZNCsQJAA1yZgKWMDfvGBmGjh/btRHTvJwdQEg7Y+UJoswisqElxtC4+jo5UhTTILRmJWl5kLNSWlwEOQyk2E8UGDuUSEQ==";*/
        
        
        String public_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvfeM00AMiq5Zaa0ERJLCbEb38gvYEHI1vCRdLYvaI+NkpBHzyIZxyrNuwG3cKZDca98+SpNHMQUXbB9WfJ68VAlAJZggWUDgrWAHg5rnFuIvLDRpR2EXkfyarw1EdmsoGZo6QHMeUryqdLiDi0FJZqAS5qCCWGqCW77SVKX4vyrQn3lqhTlLng3d8dWN+FjkH5m4u+PYn7AdRo43luzNZZOymE/d71Ew+W6PjLZ9WdjHMX9+f2uQGUTI0Iz2M2Bc+fhjOPu515V5joc9neoTMrbbqEP20NQJ8rmGVCwAflGpvNTgfN/eMkNwLqGVts0SVjsmXIvGf9GhhylXtN5bkwIDAQAB";
        String private_key="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC994zTQAyKrllprQREksJsRvfyC9gQcjW8JF0ti9oj42SkEfPIhnHKs27AbdwpkNxr3z5Kk0cxBRdsH1Z8nrxUCUAlmCBZQOCtYAeDmucW4i8sNGlHYReR/JqvDUR2aygZmjpAcx5SvKp0uIOLQUlmoBLmoIJYaoJbvtJUpfi/KtCfeWqFOUueDd3x1Y34WOQfmbi749ifsB1GjjeW7M1lk7KYT93vUTD5bo+Mtn1Z2Mcxf35/a5AZRMjQjPYzYFz5+GM4+7nXlXmOhz2d6hMyttuoQ/bQ1AnyuYZULAB+Uam81OB8394yQ3AuoZW2zRJWOyZci8Z/0aGHKVe03luTAgMBAAECggEAGXYkmevrwmq78T4PZGGHTZv1f6u2uf2U1jLJimFES6sewh7l3eqnNdP29DPFXozb/lldsAEteZSFHyjUHr/n3hufTWqma1AWzSYh27HXZ2nJiNM9iSOqVRbWZMASfQy/wy64wAqt9cjzz9ErUG7ft7Gc1uyMi+06q7FX36CfRn/rdQA8uvIzHHueMlXhl1obTbtM6fi0J0o6dVJmPV6XKET6dPdhTKO3ZYZQv0w2v62P9U5krBIzX7p1CeRz3xRyNl3zJnjCZ5USzVtwDpIfP0JZ4AcXoszieOe49Y4KgJ6MXWJnBEkFv5/IsMig2rWE1U0QF/MlUHWt6MbzdzSDAQKBgQDhlA4W9grB/DG8W3yEojI+yqHq8deL1wvFaDcGJgqzTKBD5A1tYjcDFyEPoPyKizl6Tw2oxGWSwxE3dXDBohDet7FaV5dibH4b3ef/ionu0m819Ce04Sn5BIkTqYmT2R8IDO3ndLLCgp6K1ecXt541vpXc2dIzRzABrZZ87DfV2QKBgQDXlglaOliPu4smT1nayXP5gRMBZSm7TC+3eT6bw76H8eTlyafpNNMvA3oU+VZzKPWTrczweJuwVzJ/CxiKQ6lzr2MzpsHPP4HYuREYetTIAgpLo0uY2K8KsyNWTSuD/9zrez75xQcLlG/2He+aWA+h/T6LHPoBKdsG8pzBqD49SwKBgDZLSnDgW4qBRv9NDdVmrK1MXFiOSRERe3XSNZw3P9AUG2b71veC8ja+NGjsmJxIEleL+3+pdcEzTkuI6tDQTzsr/3X9KyS3dEsEyDhLghOHdtkHoR76Kv4Sx2OCJOj/E2b+paxV/Eiw47QK9ApTWbMZ4jw7+Un6UmW1AEmlGXNRAoGAVoLrz9xYC52r0jzHhweOVZJZSRcKbxG8mDi8Sg971tvYCeopSmkbUeNoSyBfc6j9Gz0EX39WoqXrKpYOS/Wo+zZnbaO+ZGdMuOZTGOq5lmVTMlUeEgDqBTYruQcQrlCvm4OCmwJYuGnhn/cVXm92HoAcaADBxlPAhAI5q3DTQQ8CgYAa0zzo9LP/i9JKGLC24YiITYSWHWWGBsgoYbZHGFsLGeZ/RoudbJrA/utzDdwrjE9Ps5iKzk37NNysiv1nTF8HKAMKGdYlNgNl31+yCKfKlmLukigyXBv5RcQ0fCE5DTyP4U3pqcExvhg2F1+BWw3Ocq0oWtHfsRasaqaz4i9/5A==";

      //  String sss="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC994zTQAyKrllprQREksJsRvfyC9gQcjW8JF0ti9oj42SkEfPIhnHKs27AbdwpkNxr3z5Kk0cxBRdsH1Z8nrxUCUAlmCBZQOCtYAeDmucW4i8sNGlHYReR/JqvDUR2aygZmjpAcx5SvKp0uIOLQUlmoBLmoIJYaoJbvtJUpfi/KtCfeWqFOUueDd3x1Y34WOQfmbi749ifsB1GjjeW7M1lk7KYT93vUTD5bo+Mtn1Z2Mcxf35/a5AZRMjQjPYzYFz5+GM4+7nXlXmOhz2d6hMyttuoQ/bQ1AnyuYZULAB+Uam81OB8394yQ3AuoZW2zRJWOyZci8Z/0aGHKVe03luTAgMBAAECggEAGXYkmevrwmq78T4PZGGHTZv1f6u2uf2U1jLJimFES6sewh7l3eqnNdP29DPFXozb/lldsAEteZSFHyjUHr/n3hufTWqma1AWzSYh27HXZ2nJiNM9iSOqVRbWZMASfQy/wy64wAqt9cjzz9ErUG7ft7Gc1uyMi+06q7FX36CfRn/rdQA8uvIzHHueMlXhl1obTbtM6fi0J0o6dVJmPV6XKET6dPdhTKO3ZYZQv0w2v62P9U5krBIzX7p1CeRz3xRyNl3zJnjCZ5USzVtwDpIfP0JZ4AcXoszieOe49Y4KgJ6MXWJnBEkFv5/IsMig2rWE1U0QF/MlUHWt6MbzdzSDAQKBgQDhlA4W9grB/DG8W3yEojI+yqHq8deL1wvFaDcGJgqzTKBD5A1tYjcDFyEPoPyKizl6Tw2oxGWSwxE3dXDBohDet7FaV5dibH4b3ef/ionu0m819Ce04Sn5BIkTqYmT2R8IDO3ndLLCgp6K1ecXt541vpXc2dIzRzABrZZ87DfV2QKBgQDXlglaOliPu4smT1nayXP5gRMBZSm7TC+3eT6bw76H8eTlyafpNNMvA3oU+VZzKPWTrczweJuwVzJ/CxiKQ6lzr2MzpsHPP4HYuREYetTIAgpLo0uY2K8KsyNWTSuD/9zrez75xQcLlG/2He+aWA+h/T6LHPoBKdsG8pzBqD49SwKBgDZLSnDgW4qBRv9NDdVmrK1MXFiOSRERe3XSNZw3P9AUG2b71veC8ja+NGjsmJxIEleL+3+pdcEzTkuI6tDQTzsr/3X9KyS3dEsEyDhLghOHdtkHoR76Kv4Sx2OCJOj/E2b+paxV/Eiw47QK9ApTWbMZ4jw7+Un6UmW1AEmlGXNRAoGAVoLrz9xYC52r0jzHhweOVZJZSRcKbxG8mDi8Sg971tvYCeopSmkbUeNoSyBfc6j9Gz0EX39WoqXrKpYOS/Wo+zZnbaO+ZGdMuOZTGOq5lmVTMlUeEgDqBTYruQcQrlCvm4OCmwJYuGnhn/cVXm92HoAcaADBxlPAhAI5q3DTQQ8CgYAa0zzo9LP/i9JKGLC24YiITYSWHWWGBsgoYbZHGFsLGeZ/RoudbJrA/utzDdwrjE9Ps5iKzk37NNysiv1nTF8HKAMKGdYlNgNl31+yCKfKlmLukigyXBv5RcQ0fCE5DTyP4U3pqcExvhg2F1+BWw3Ocq0oWtHfsRasaqaz4i9/5A==";
        try {
//            System.out.print(RSA.decrypt(enStr, ConstantsKey.ZMPAY.PRIVATE_KEY, "utf-8"));
           // String sign = RSA.sign("", private_key, "UTF-8");
            String sign = RSA.sign("a", private_key, "UTF-8");
            System.out.println(sign);
            System.out.println(RSA.verify("a", sign, public_key, "UTF-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

