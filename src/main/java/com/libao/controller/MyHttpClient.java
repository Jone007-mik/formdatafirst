package com.libao.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyHttpClient{
    public static void main(String[] args) {
        // new MyHttpClient().formdata_doPost();
        new MyHttpClient().formdataFileDoPost();
    }
    public static void formdataFileDoPost(){
        File file=new File("D:\\imgs\\11.jpg");
        String result="";
        String url="http://localhost:8080/json_formdata/formdataFile";
        CloseableHttpClient client=HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);
        List list=new ArrayList();
        list.add(file);
        try {
            RequestConfig requestConfig=RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
            httpPost.setConfig(requestConfig);
            //向httpPost放入参数
            UrlEncodedFormEntity urlEncodedFormEntity=new UrlEncodedFormEntity(list);
            httpPost.setEntity(urlEncodedFormEntity);
            CloseableHttpResponse response = client.execute(httpPost);

            //取出response中的对象  EntityUtils取出json
            HttpEntity httpEntity=response.getEntity();
            result=EntityUtils.toString(httpEntity);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String  formdata_doPost(){
        String result="";
        String url="http://localhost:8080/json_formdata/user/login";
        CloseableHttpClient httpClient= HttpClients.createDefault();
        CloseableHttpResponse response=null;
        HttpPost httpPost=new HttpPost(url);
        //放入参数
        List param=new ArrayList();
        param.add(new BasicNameValuePair("username","123"));
        param.add(new BasicNameValuePair("pwd","123"));
        try {
            RequestConfig requestConfig=RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
            httpPost.setConfig(requestConfig);
            //向httpPost放入参数
            UrlEncodedFormEntity urlEncodedFormEntity=new UrlEncodedFormEntity(param);
            httpPost.setEntity(urlEncodedFormEntity);
            response  = httpClient.execute(httpPost);

            //取出response中的对象  EntityUtils取出json
            HttpEntity httpEntity=response.getEntity();
            result=EntityUtils.toString(httpEntity);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
