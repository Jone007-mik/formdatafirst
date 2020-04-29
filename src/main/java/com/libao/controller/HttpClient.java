package com.libao.controller;

import com.libao.domain.model.User;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClient{
    public static void main(String[] args) {
        String s = new HttpClient().doPost();
        System.out.println(s);
    }
    public static String doPost(){
        String result = null;
        String url = "http://localhost:8080/json_formdata/user/login";
        //Map<String ,String>param=new HashMap<>();
//        param.put("username","123");
//        param.put("pwd","123");
        List param=new ArrayList();
        User user=new User("123","1234");
        param.add(new BasicNameValuePair("username","123"));
        param.add(new BasicNameValuePair("pwd","123"));
        // 获取httpclient
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(2000).setConnectTimeout(2000).build();
            httpPost.setConfig(requestConfig);


            // 提交参数发送请求
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(param);
            httpPost.setEntity(urlEncodedFormEntity);
            response = httpclient.execute(httpPost);
            // 得到响应信息
            int statusCode = response.getStatusLine().getStatusCode();
            // 判断响应信息是否正确
            if (statusCode != HttpStatus.SC_OK) {
                // 终止并抛出异常
                httpPost.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //result = EntityUtils.toString(entity);//不进行编码设置
                result = EntityUtils.toString(entity, "UTF-8");
            }
            EntityUtils.consume(entity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭所有资源连接
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
