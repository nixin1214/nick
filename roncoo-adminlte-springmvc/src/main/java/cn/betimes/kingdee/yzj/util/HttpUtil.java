package cn.betimes.kingdee.yzj.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class HttpUtil {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    /**
     * 判断是否是multipart/form-data 请求
     * 
     * @param request
     * @return
     */
    public static boolean isMultiPart(HttpServletRequest request) {
        String contentType = request.getContentType();
        return contentType != null && contentType.startsWith("multipart/form-data");
    }

    /**
     * 判断是否是server请求
     * 
     * @param request
     * @return
     */
    public static boolean isServerRequest(HttpServletRequest request) {
        String url = request.getRequestURI();
        if (StringUtils.defaultString(url).toLowerCase().contains("controller")
                || StringUtils.defaultString(url).toLowerCase().contains(".ajax")) {
            return true;
        }
        return false;
    }

    /**
     * 判断浏览器是否接受json内容类型的数据
     * 
     * @return 登录用户名
     */
    public static boolean isJsonContextType(HttpServletRequest request) {
        String contentType = request.getContentType();
        if ((contentType != null) && contentType.startsWith("multipart/form-data")) {
            // 解决当通过multipart/form-data上载文件时，当鉴权失败时，返回的json数据浏览器弹出下载框的问题
            // 如果鉴权失败，contextType=text/html时，前台可以弹出错误提示框
            return false;
        }
        // 如果前台传了这个属性，按这个属性返回contextType
        String acceptContentType = request.getParameter("acceptContentType");
        return StringUtils.isEmpty(acceptContentType);
    }

    /**
     * 得到Cookie
     * 
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie cookies[] = request.getCookies();
        if (cookies == null || name == null || name.length() == 0) {
            return null;
        }
        for (int i = 0; i < cookies.length; i++) {
            if (name.equals(cookies[i].getName()) && request.getServerName().equals(cookies[i].getDomain())) {
                return cookies[i];
            }
        }
        return null;
    }

    /**
     * 设置Cookie
     * 
     * @param response
     * @param name
     * @param value
     * @param path
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, String path) {
        Cookie cookie = getCookie(request, name);
        if (cookie == null) {
            cookie = new Cookie(name, value == null ? "" : value);
        }
        cookie.setPath(path);
        response.addCookie(cookie);
    }
    
    public static JSONObject httpPost(String requestUrl, Map<String, String> params) {
        JSONObject jsonObject = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(requestUrl);
            
            List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
            for (Entry<String, String> param : params.entrySet()) {
                BasicNameValuePair bnvp = new BasicNameValuePair(param.getKey(), param.getValue());
                formParams.add(bnvp);
            }
            
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
            httppost.setEntity(uefEntity);
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            
            jsonObject = JSONObject.fromObject(EntityUtils.toString(entity, "UTF-8"));
            System.out.println(jsonObject.toString());
            logger.debug("HTTP POST: 访问接口>> {}， 参数>> {}， 响应数据>> {}", new Object[]{requestUrl, formParams, jsonObject});
            
        } catch (Exception e) {
            logger.error("https request error:{}" + e.getMessage(), e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
    
    public static JSONObject httpGet(String requestUrl) {
        JSONObject jsonObject = null;
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            jsonObject = JSONObject.fromObject(EntityUtils.toString(entity, "UTF-8"));
            
            logger.debug("HTTP GET: 访问接口>> {}， 响应数据>> {}", new Object[]{requestUrl, jsonObject});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return jsonObject;
    }

    /**
     * 发起https请求并获取结果
     * 
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 设置
            System.setProperty("jsse.enableSNIExtension", "false");
            
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);
            
            httpUrlConn.connect();
            if ("GET".equalsIgnoreCase(requestMethod)){
                
            }
            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            logger.error("Weixin server connection timed out,error:" + ce.getMessage(), ce);
        } catch (Exception e) {
            logger.error("https request error:{}" + e.getMessage(), e);
        }
        return jsonObject;
    }
    
    /**
     * 发起https请求并获取结果
     * 
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 设置
            System.setProperty("jsse.enableSNIExtension", "false");
            
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);
            
            if ("GET".equalsIgnoreCase(requestMethod)){
                httpUrlConn.connect();
            }
            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            logger.error("Weixin server connection timed out,error:" + ce.getMessage(), ce);
        } catch (Exception e) {
            logger.error("https request error:{}" + e.getMessage(), e);
        }
        return jsonObject;
    }
    
    public static String URLEncode(String str, String enc) {
        String encodeStr = "";
        try {
            enc = enc == null ? "UTF-8" : enc;
            encodeStr = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            encodeStr = str;
        }
        return encodeStr;
    }
    
    public static String urlDecode(String str, String enc) {
        String encodeStr = "";
        try {
            enc = enc == null ? "UTF-8" : enc;
            encodeStr = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            encodeStr = str;
        }
        return encodeStr;
    }
}
