package com.sgcc.exam.common.utils;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.codehaus.jackson.map.ObjectMapper;

import com.sgcc.uap.rest.utils.JsonUtils;


/**
 * <b>概述</b>：调用URI工具<br>
 * @author Mr.Li
 * @date 2019-03-12
 * @since 1.0
 */
public class WXUtil {
	/**
	 * <b>功能</b>：post调用url<br>
	 * @date 2019-03-12
	 * @since 1.0
	 */
//	public static String sendPost(String url, Map<String, ?> paramMap) {
	public static String sendPost(String url) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        
//        String param = "";
//		Iterator<String> it = paramMap.keySet().iterator();
//		
//		while(it.hasNext()) {
//			String key = it.next();
//			param += key + "=" + paramMap.get(key) + "&";
//		}
		
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
//            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	System.out.println("sendPost()执行post请求异常！");
        	e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
	
	/**
	 * <b>功能</b>：传入code获取 openId<br>
	 * @return Map<String,String>
	 * @date 2019-03-12
	 * @since 1.0
	 */
	public static Map<String, String> getUserMap(String code) {
		/*
		 * 根据前端传来的code 调用code2Session接口  获取OpenId和session_key
		 */
		    ResourceBundle resource = ResourceBundle.getBundle("weixin");	//读取属性文件
	        String requestUrl = resource.getString("url");//请求地址
	      //  Map<String,String> requestUrlParam = new HashMap<String,String>();
	      //  requestUrlParam.put("appid", resource.getString("appid"));	//开发者设置中的appId
	     //   requestUrlParam.put("secret",resource.getString("secret"));	//开发者设置中的appSecret
	       // requestUrlParam.put("js_code", code);	//小程序调用wx.login返回的code
	      //  requestUrlParam.put("grant_type",resource.getString("grant_type"));	//默认参数
	        //发送post请求读取调用微信 https://api.weixin.qq.com/sns/code2session 接口获取openid用户唯一标识
	       // String str = WXUtil.sendPost(requestUrl,requestUrlParam);
	        String str = WXUtil.sendPost(String.format(requestUrl,  resource.getString("appid"),resource.getString("secret"),code));
	        ObjectMapper mapper = new ObjectMapper();  
	        Map<String, String> map = null; 
	        try {  
	        	map = mapper.readValue(str, Map.class);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		return map;
	}
	
	/**
	 * <b>功能</b>：用户加密信息解密<br>
	 * @return String
	 * @date 2019-03-12
	 * @since 1.0
	 */
	public static String solution(String encryptedData, String sessionKey, String iv) {
		 // 被加密的数据  
       byte[] dataByte = Base64.decodeBase64(encryptedData);  
       // 加密秘钥  
       byte[] keyByte = Base64.decodeBase64(sessionKey);  
       // 偏移量  
       byte[] ivByte = Base64.decodeBase64(iv);  
       try {  
              // 如果密钥不足16位，则补足
           int base = 16;  
           if (keyByte.length % base != 0) {  
               int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);  
               byte[] temp = new byte[groups * base];  
               Arrays.fill(temp, (byte) 0);  
               System.arraycopy(keyByte, 0, temp, 0, keyByte.length);  
               keyByte = temp;
           } 
           // 初始化   
           Security.addProvider(new BouncyCastleProvider());  
           Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");  
           SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");  
           AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");  
           parameters.init(new IvParameterSpec(ivByte));  
           cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化  
           byte[] resultByte = cipher.doFinal(dataByte);  
           if (null != resultByte && resultByte.length > 0) {  
               String result = new String(resultByte, "UTF-8"); 
               return result;  
           }  
       } catch (NoSuchAlgorithmException e) {  
    	   e.getMessage();  
       } catch (NoSuchPaddingException e) {  
    	   e.getMessage(); 
       } catch (InvalidParameterSpecException e) {  
    	   e.getMessage(); 
       } catch (IllegalBlockSizeException e) {  
    	   e.getMessage();  
       } catch (BadPaddingException e) {  
    	   e.getMessage(); 
       } catch (UnsupportedEncodingException e) {  
    	   e.getMessage(); 
       } catch (InvalidKeyException e) {  
    	   e.getMessage(); 
       } catch (InvalidAlgorithmParameterException e) {  
    	   e.getMessage();  
       } catch (NoSuchProviderException e) {  
    	   e.getMessage();  
       }  
		return null;
	}

}
