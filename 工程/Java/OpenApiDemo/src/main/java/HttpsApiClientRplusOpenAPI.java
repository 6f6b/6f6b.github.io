//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

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

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class HttpsApiClientRplusOpenAPI extends ApacheHttpClient{
    public final static String HOST = "doctor-openapi.rplushealth.cn";
    //public final static String HOST = "doctor.rplushealth.cn";

    static HttpsApiClientRplusOpenAPI instance = new HttpsApiClientRplusOpenAPI();
    public static HttpsApiClientRplusOpenAPI getInstance(){return instance;}

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
    public void 获取用户测评数据(String Authorization , String AcceptLanguage , ApiCallback callback) {
        String path = "/patient/assessment/data";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , true);
        request.addParam("Accept-Language" , AcceptLanguage , ParamPosition.HEAD , true);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 获取用户测评数据SyncMode(String Authorization , String AcceptLanguage) {
        String path = "/patient/assessment/data";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , true);
        request.addParam("Accept-Language" , AcceptLanguage , ParamPosition.HEAD , true);



        return sendSyncRequest(request);
    }
    public void 按自然月统计运动情况(String Authorization , Long date , Long timezoneOffset , String AcceptLanguage , ApiCallback callback) {
        String path = "/patient/month";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , true);
        request.addParam("date" , String.valueOf(date) , ParamPosition.QUERY , true);
        request.addParam("timezoneOffset" , String.valueOf(timezoneOffset) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , AcceptLanguage , ParamPosition.HEAD , false);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 按自然月统计运动情况SyncMode(String Authorization , Long date , Long timezoneOffset , String AcceptLanguage) {
        String path = "/patient/month";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , true);
        request.addParam("date" , String.valueOf(date) , ParamPosition.QUERY , true);
        request.addParam("timezoneOffset" , String.valueOf(timezoneOffset) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , AcceptLanguage , ParamPosition.HEAD , false);



        return sendSyncRequest(request);
    }
    public void 按日统计运动情况(String Authorization , Long date , Long timezoneOffset , String AcceptLanguage , ApiCallback callback) {
        String path = "/patient/day";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , false);
        request.addParam("date" , String.valueOf(date) , ParamPosition.QUERY , true);
        request.addParam("timezoneOffset" , String.valueOf(timezoneOffset) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , AcceptLanguage , ParamPosition.HEAD , false);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 按日统计运动情况SyncMode(String Authorization , Long date , Long timezoneOffset , String AcceptLanguage) {
        String path = "/patient/day";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , false);
        request.addParam("date" , String.valueOf(date) , ParamPosition.QUERY , true);
        request.addParam("timezoneOffset" , String.valueOf(timezoneOffset) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , AcceptLanguage , ParamPosition.HEAD , false);



        return sendSyncRequest(request);
    }
    public void 获取单次运动详情(String Authorization , Long id , String AcceptLanguage , ApiCallback callback) {
        String path = "/patient/detail";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , false);
        request.addParam("id" , String.valueOf(id) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , AcceptLanguage , ParamPosition.HEAD , false);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse 获取单次运动详情SyncMode(String Authorization , Long id , String AcceptLanguage) {
        String path = "/patient/detail";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("Authorization" , Authorization , ParamPosition.HEAD , false);
        request.addParam("id" , String.valueOf(id) , ParamPosition.QUERY , true);
        request.addParam("Accept-Language" , AcceptLanguage , ParamPosition.HEAD , false);



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
        request.addParam("pageNumber" , "3" , ParamPosition.QUERY , true);


        sendAsyncRequest(request , callback);
    }

    public ApiResponse 获取手机验证码SyncMode(String regionCode , String mobile) {
        String path = "/patient/verify/mobile";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("regionCode" , regionCode , ParamPosition.QUERY , true);
        request.addParam("mobile" , mobile , ParamPosition.QUERY , true);

        request.addParam("pageNumber" , "3" , ParamPosition.QUERY , true);

        return sendSyncRequest(request);
    }

    public ApiResponse 获取随访配置(String regionCode , String mobile) {
        String authorization = "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIyNDM4ODk1Njc1OTg1MTAwOCIsImlpcyI6Imh0dHA6Ly9vYXV0aC5ycGx1c2hlYWx0aC5jbi9pZGVudGl0eS9vYXV0aC90b2tlbiIsInNjb3BlIjpbInVzZXJuYW1lIl0sImV4cCI6MTYyODU3OTQ3NCwianRpIjoiMDhhMGE1NjUtODdiOS00ZWY4LTlmNDgtMjgzNGRlMTEwNDYxIiwiY2xpZW50X2lkIjoicnBsdXMtZG9jdG9yLWNsaWVudCIsInVzZXJuYW1lIjoiMTM4MDAwMDAwMDIifQ.hWOKpf4Z0LagpzNIoeh1txg6Km1eoxkwUK-aie9p9ukDnjz9DW_ST-LnQTVCsHyBU0jVaeT_OA-e-pZ984vvbhwvVyjShwQ7cFp1VlEX-IB16bAghtp-6oJd7HSpdCCWIhb7J8F5GPVSlmMAlMMcd3ymPovHjaFMq9nOtO4nCT4";
        ApiRequest request = new ApiRequest(HttpMethod.GET, "/followup/19021757320478720/configs");
        request.addParam("X-Ca-Stage", "RELEASE", ParamPosition.HEAD, false);
        request.addParam("pageNumber", "0", ParamPosition.QUERY, false);
        request.addParam("pageSize", "20", ParamPosition.QUERY, false);
        request.addParam("Authorization", authorization, ParamPosition.HEAD, true);
        return sendSyncRequest(request);
    }

    public void 获取随访配置Async(String regionCode , String mobile, ApiCallback callback) {
        //String authorization = "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIyNDM4ODk1Njc1OTg1MTAwOCIsImlpcyI6Imh0dHA6Ly9vYXV0aC5ycGx1c2hlYWx0aC5jbi9pZGVudGl0eS9vYXV0aC90b2tlbiIsInNjb3BlIjpbInVzZXJuYW1lIl0sImV4cCI6MTYyODU3OTQ3NCwianRpIjoiMDhhMGE1NjUtODdiOS00ZWY4LTlmNDgtMjgzNGRlMTEwNDYxIiwiY2xpZW50X2lkIjoicnBsdXMtZG9jdG9yLWNsaWVudCIsInVzZXJuYW1lIjoiMTM4MDAwMDAwMDIifQ.hWOKpf4Z0LagpzNIoeh1txg6Km1eoxkwUK-aie9p9ukDnjz9DW_ST-LnQTVCsHyBU0jVaeT_OA-e-pZ984vvbhwvVyjShwQ7cFp1VlEX-IB16bAghtp-6oJd7HSpdCCWIhb7J8F5GPVSlmMAlMMcd3ymPovHjaFMq9nOtO4nCT4";
        String authorization = "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjYzMDE2NDE3MjM0NjUzNTg1IiwiaWlzIjoiaHR0cDovL29hdXRoLnJwbHVzaGVhbHRoLmNuL2lkZW50aXR5L29hdXRoL3Rva2VuIiwic2NvcGUiOlsidXNlcm5hbWUiXSwiZXhwIjoxNjI5Njg4ODMwLCJqdGkiOiIxMDYwY2ZhNy1lMjcxLTQwOTItODgzOS04ZDMzNmEwODlmZjAiLCJjbGllbnRfaWQiOiJycGx1cy1kb2N0b3ItY2xpZW50IiwidXNlcm5hbWUiOiIxMzkwMDAwMDAwMSJ9.qZ1wPXw2oMwkbU9l9WufwVe4fbOMz50iCm5wd9RustAVeC1DnucSnQrkouROaRpuyarOSyMbMhDnjSQPzRUt0_26TmUyFC_xQw5N4bYK-IwsHHWqYTtyvChEUHEMH3rMvu3BlStln6MXjzF9iSS2LdWcvliXUTbM9wu9JYRCf98";
        ApiRequest request = new ApiRequest(HttpMethod.GET, "/task/questionnaire/answer/81905374232027139");
        request.addParam("X-Ca-Stage", "RELEASE", ParamPosition.HEAD, false);
        request.addParam("pageNumber", "0", ParamPosition.QUERY, false);
        request.addParam("pageSize", "20", ParamPosition.QUERY, false);
        request.addParam("Authorization", authorization, ParamPosition.HEAD, true);
        sendAsyncRequest(request,callback);
    }
}