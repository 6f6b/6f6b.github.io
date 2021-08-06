//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.alibaba.cloudapi.client;

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.alibaba.cloudapi.sdk.enums.WebSocketApiType;
import com.alibaba.fastjson.JSONObject;

public class HttpsApiClient术康运动治疗OpenAPI extends ApacheHttpClient{
    public final static String HOST = "openapi.rplushealth.cn";
    static HttpsApiClient术康运动治疗OpenAPI instance = new HttpsApiClient术康运动治疗OpenAPI();
    public static HttpsApiClient术康运动治疗OpenAPI getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTPS);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }



    public void 手机号登录(String regionCode , String mobile , String verifyCode , ApiCallback callback) {
        String path = "/patient/mobile";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM , path);
        request.addParam("regionCode" , regionCode , ParamPosition.QUERY , true);
        request.addParam("mobile" , mobile , ParamPosition.QUERY , true);
        request.addParam("verifyCode" , verifyCode , ParamPosition.QUERY , true);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 手机号登录SyncMode(String regionCode , String mobile , String verifyCode) {
        String path = "/patient/mobile";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM , path);
        request.addParam("regionCode" , regionCode , ParamPosition.QUERY , true);
        request.addParam("mobile" , mobile , ParamPosition.QUERY , true);
        request.addParam("verifyCode" , verifyCode , ParamPosition.QUERY , true);



        return sendSyncRequest(request);
    }
    public void 获取用户测评数据(String Authorization , String Accept-Language , ApiCallback callback) {
        String path = "/patient/assessment/data";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , true);
        request.addParam("Accept-Language" , Accept-Language , ParamPosition.HEAD , true);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 获取用户测评数据SyncMode(String Authorization , String Accept-Language) {
        String path = "/patient/assessment/data";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , true);
        request.addParam("Accept-Language" , Accept-Language , ParamPosition.HEAD , true);



        return sendSyncRequest(request);
    }
    public void 按自然月统计运动情况(String Authorization , Long date , Long timezoneOffset , String Accept-Language , ApiCallback callback) {
        String path = "/patient/month";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , true);
        request.addParam("date" , String.valueOf(date) , ParamPosition.QUERY , true);
        request.addParam("timezoneOffset" , String.valueOf(timezoneOffset) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , Accept-Language , ParamPosition.HEAD , false);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 按自然月统计运动情况SyncMode(String Authorization , Long date , Long timezoneOffset , String Accept-Language) {
        String path = "/patient/month";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , true);
        request.addParam("date" , String.valueOf(date) , ParamPosition.QUERY , true);
        request.addParam("timezoneOffset" , String.valueOf(timezoneOffset) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , Accept-Language , ParamPosition.HEAD , false);



        return sendSyncRequest(request);
    }
    public void 按日统计运动情况(String Authorization , Long date , Long timezoneOffset , String Accept-Language , ApiCallback callback) {
        String path = "/patient/day";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , false);
        request.addParam("date" , String.valueOf(date) , ParamPosition.QUERY , true);
        request.addParam("timezoneOffset" , String.valueOf(timezoneOffset) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , Accept-Language , ParamPosition.HEAD , false);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 按日统计运动情况SyncMode(String Authorization , Long date , Long timezoneOffset , String Accept-Language) {
        String path = "/patient/day";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , false);
        request.addParam("date" , String.valueOf(date) , ParamPosition.QUERY , true);
        request.addParam("timezoneOffset" , String.valueOf(timezoneOffset) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , Accept-Language , ParamPosition.HEAD , false);



        return sendSyncRequest(request);
    }
    public void 获取单次运动详情(String Authorization , Long id , String Accept-Language , ApiCallback callback) {
        String path = "/patient/detail";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , false);
        request.addParam("id" , String.valueOf(id) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , Accept-Language , ParamPosition.HEAD , false);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 获取单次运动详情SyncMode(String Authorization , Long id , String Accept-Language) {
        String path = "/patient/detail";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , false);
        request.addParam("id" , String.valueOf(id) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , Accept-Language , ParamPosition.HEAD , false);



        return sendSyncRequest(request);
    }
    public void 刷新用户token(String refreshToken , String Authorization , ApiCallback callback) {
        String path = "/patient/token/refresh";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("refreshToken" , refreshToken , ParamPosition.QUERY , true);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , true);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 刷新用户tokenSyncMode(String refreshToken , String Authorization) {
        String path = "/patient/token/refresh";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("refreshToken" , refreshToken , ParamPosition.QUERY , true);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , true);



        return sendSyncRequest(request);
    }
    public void 获取手机验证码(String regionCode , String mobile , ApiCallback callback) {
        String path = "/patient/verify/mobile";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("regionCode" , regionCode , ParamPosition.QUERY , true);
        request.addParam("mobile" , mobile , ParamPosition.QUERY , true);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 获取手机验证码SyncMode(String regionCode , String mobile) {
        String path = "/patient/verify/mobile";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("regionCode" , regionCode , ParamPosition.QUERY , true);
        request.addParam("mobile" , mobile , ParamPosition.QUERY , true);



        return sendSyncRequest(request);
    }

}