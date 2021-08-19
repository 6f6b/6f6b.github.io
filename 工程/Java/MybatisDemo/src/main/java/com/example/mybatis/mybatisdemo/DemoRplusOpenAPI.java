package com.example.mybatis.mybatisdemo;//
//  Created by  fred on 2016/10/26.
//  Copyright © 2016年 Alibaba. All rights reserved.
//


import com.alibaba.cloudapi.sdk.constant.SdkConstant;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import java.io.IOException;


import com.example.mybatis.mybatisdemo.HttpApiClientRplusOpenAPI;
import com.example.mybatis.mybatisdemo.HttpsApiClientRplusOpenAPI;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import javax.net.ssl.*;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class DemoRplusOpenAPI {


    static{
        //HTTP Client init
        HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
        httpParam.setAppKey("203961652");
        httpParam.setAppSecret("ae2N6SHWnUaoQcj4VqF4gbEaQfNCSQwA");


        HttpApiClientRplusOpenAPI.getInstance().init(httpParam);

        //HTTPS Client init
        HttpClientBuilderParams httpsParam = new HttpClientBuilderParams();
        httpsParam.setAppKey("203961652");
        httpsParam.setAppSecret("ae2N6SHWnUaoQcj4VqF4gbEaQfNCSQwA");

        /**
        * HTTPS request use DO_NOT_VERIFY mode only for demo
        * Suggest verify for security
        */
        //httpsParam.setRegistry(getNoVerifyRegistry());

        HttpsApiClientRplusOpenAPI.getInstance().init(httpsParam);


    }



    public static void main(String[] args) {
        //获取手机验证码HttpsSyncTest();
        //获取随访配置HttpsASyncTest();
        HttpsApiClientRplusOpenAPI.getInstance().获取随访详情("","",new ApiCallback() {
            @Override
            public void onFailure(ApiRequest apiRequest, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest apiRequest, ApiResponse apiResponse) {
                try {
                    System.out.println(getResultString(apiResponse));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public static void 手机号登录HttpsTest(){
        HttpsApiClientRplusOpenAPI.getInstance().手机号登录("default" , "default" , "default" , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 手机号登录HttpsSyncTest(){
        ApiResponse response = HttpsApiClientRplusOpenAPI.getInstance().手机号登录SyncMode("default" , "default" , "default");
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



    public static void 获取用户测评数据HttpsTest(){
        HttpsApiClientRplusOpenAPI.getInstance().获取用户测评数据("default" , "default" , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 获取用户测评数据HttpsSyncTest(){
        ApiResponse response = HttpsApiClientRplusOpenAPI.getInstance().获取用户测评数据SyncMode("default" , "default");
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



    public static void 按自然月统计运动情况HttpsTest(){
        HttpsApiClientRplusOpenAPI.getInstance().按自然月统计运动情况("default" , 1L , 1L , "default" , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 按自然月统计运动情况HttpsSyncTest(){
        ApiResponse response = HttpsApiClientRplusOpenAPI.getInstance().按自然月统计运动情况SyncMode("default" , 1L , 1L , "default");
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



    public static void 按日统计运动情况HttpsTest(){
        HttpsApiClientRplusOpenAPI.getInstance().按日统计运动情况("default" , 1L , 1L , "default" , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 按日统计运动情况HttpsSyncTest(){
        ApiResponse response = HttpsApiClientRplusOpenAPI.getInstance().按日统计运动情况SyncMode("default" , 1L , 1L , "default");
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



    public static void 获取单次运动详情HttpsTest(){
        HttpsApiClientRplusOpenAPI.getInstance().获取单次运动详情("default" , 1L , "default" , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 获取单次运动详情HttpsSyncTest(){
        ApiResponse response = HttpsApiClientRplusOpenAPI.getInstance().获取单次运动详情SyncMode("default" , 1L , "default");
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



    public static void 刷新用户tokenHttpsTest(){
        HttpsApiClientRplusOpenAPI.getInstance().刷新用户token("default" , "default" , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 刷新用户tokenHttpsSyncTest(){
        ApiResponse response = HttpsApiClientRplusOpenAPI.getInstance().刷新用户tokenSyncMode("default" , "default");
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



    public static void 获取手机验证码HttpsTest(){
        HttpsApiClientRplusOpenAPI.getInstance().获取手机验证码("86" , "15708456403" , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void 获取手机验证码HttpsSyncTest(){
        ApiResponse response = HttpsApiClientRplusOpenAPI.getInstance().获取手机验证码SyncMode("86" , "15708456403");
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void 获取随访配置HttpsSyncTest(){
        ApiResponse response = HttpsApiClientRplusOpenAPI.getInstance().获取随访配置("86" , "15708456403");
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void 获取随访配置HttpsASyncTest(){
        HttpsApiClientRplusOpenAPI.getInstance().获取随访配置Async("86" , "15708456403" , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                System.out.println("发生错误");
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                System.out.println("回调");
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    private static String getResultString(ApiResponse response) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append("Response from backend server").append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        result.append("ResultCode:").append(SdkConstant.CLOUDAPI_LF).append(response.getCode()).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        if(response.getCode() != 200){
            result.append("Error description:").append(response.getHeaders().get("X-Ca-Error-Message")).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        }

        result.append("ResultBody:").append(SdkConstant.CLOUDAPI_LF).append(new String(response.getBody() , SdkConstant.CLOUDAPI_ENCODING));

        return result.toString();
    }

    private static Registry<ConnectionSocketFactory> getNoVerifyRegistry() {
            RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.create();
            try {
                registryBuilder.register("http", PlainConnectionSocketFactory.INSTANCE).build();
                registryBuilder.register(
                        "https",
                        new SSLConnectionSocketFactory(new SSLContextBuilder().loadTrustMaterial(
                                KeyStore.getInstance(KeyStore.getDefaultType()), new TrustStrategy() {
                                    @Override
                                    public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                                        return true;
                                    }
                                }).build(),
                                new HostnameVerifier() {
                                    @Override
                                    public boolean verify(String paramString, SSLSession paramSSLSession) {
                                        return true;
                                    }
                                }));

            } catch (Exception e) {
                throw new RuntimeException("HttpClientUtil init failure !", e);
            }
            return registryBuilder.build();
        }


        private static void trustAllHttpsCertificates() throws Exception {
            javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
            javax.net.ssl.TrustManager tm = new miTM();
            trustAllCerts[0] = tm;
            javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
                    .getInstance("SSL");
            sc.init(null, trustAllCerts, null);
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
                    .getSocketFactory());
        }

        static class miTM implements javax.net.ssl.TrustManager,
                javax.net.ssl.X509TrustManager {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public boolean isServerTrusted(
                    java.security.cert.X509Certificate[] certs) {
                return true;
            }

            public boolean isClientTrusted(
                    java.security.cert.X509Certificate[] certs) {
                return true;
            }

            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] certs, String authType)
                    throws java.security.cert.CertificateException {
                return;
            }

            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] certs, String authType)
                    throws java.security.cert.CertificateException {
                return;
            }
        }
}
