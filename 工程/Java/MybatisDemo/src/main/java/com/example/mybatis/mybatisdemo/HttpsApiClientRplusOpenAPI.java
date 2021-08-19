package com.example.mybatis.mybatisdemo;//
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
        request.addParam("X-Ca-Stage", "PRE", ParamPosition.HEAD, false);
        request.addParam("pageNumber", "0", ParamPosition.QUERY, false);
        request.addParam("pageSize", "20", ParamPosition.QUERY, false);
        request.addParam("Authorization", authorization, ParamPosition.HEAD, true);
        return sendSyncRequest(request);
    }

    public void 获取随访配置Async(String regionCode , String mobile, ApiCallback callback) {
        String authorization = "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIyNDM4ODk1Njc1OTg1MTAwOCIsImlpcyI6Imh0dHA6Ly9vYXV0aC5ycGx1c2hlYWx0aC5jbi9pZGVudGl0eS9vYXV0aC90b2tlbiIsInNjb3BlIjpbInVzZXJuYW1lIl0sImV4cCI6MTYyODU3OTQ3NCwianRpIjoiMDhhMGE1NjUtODdiOS00ZWY4LTlmNDgtMjgzNGRlMTEwNDYxIiwiY2xpZW50X2lkIjoicnBsdXMtZG9jdG9yLWNsaWVudCIsInVzZXJuYW1lIjoiMTM4MDAwMDAwMDIifQ.hWOKpf4Z0LagpzNIoeh1txg6Km1eoxkwUK-aie9p9ukDnjz9DW_ST-LnQTVCsHyBU0jVaeT_OA-e-pZ984vvbhwvVyjShwQ7cFp1VlEX-IB16bAghtp-6oJd7HSpdCCWIhb7J8F5GPVSlmMAlMMcd3ymPovHjaFMq9nOtO4nCT4";
        ApiRequest request = new ApiRequest(HttpMethod.GET, "/followup/19021757320478720/configs");
        request.addParam("X-Ca-Stage", "PRE", ParamPosition.HEAD, false);
        request.addParam("pageNumber", "0", ParamPosition.QUERY, false);
        request.addParam("pageSize", "20", ParamPosition.QUERY, false);
        request.addParam("Authorization", authorization, ParamPosition.HEAD, true);
        sendAsyncRequest(request,callback);
    }

    public void 获取随访详情(String regionCode , String mobile, ApiCallback callback) {
        //String authorization = "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI3NzEyMDg3NzMwMDgzNDMwNCIsImlpcyI6Imh0dHA6Ly9vYXV0aC5ycGx1c2hlYWx0aC5jbi9pZGVudGl0eS9vYXV0aC90b2tlbiIsInNjb3BlIjpbInVzZXJuYW1lIl0sImV4cCI6MTYyOTUzNDg4MSwianRpIjoiNjM3MTNhNmYtZDdhMS00MTcyLWEwZTgtM2UwMjIxODBjZmUxIiwiY2xpZW50X2lkIjoicnBsdXMtZG9jdG9yLWNsaWVudCIsInVzZXJuYW1lIjoiMTUyNDM4MTYwMDMifQ.jF_T1xzkuiA8mEa2J5lcXuTMEdzCVA-REHRzwen2L5swPacs8bmW50mbzeT8vszFBQEvjzRp9--dAWoK6pj700Q2vqlH8jd81H-w7LZJvjfnDD5zmxr2SZoX0a-Nwoc4kTqXf4BkW1pw255SjxWOnYgmPh_eNvL8XvZDufY7QC4";
        String authorization = "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjYzMDE2NDE3MjM0NjUzNTg1IiwiaWlzIjoiaHR0cDovL29hdXRoLnJwbHVzaGVhbHRoLmNuL2lkZW50aXR5L29hdXRoL3Rva2VuIiwic2NvcGUiOlsidXNlcm5hbWUiXSwiZXhwIjoxNjI5NTQ5NTk0LCJqdGkiOiI5ODkxOGY3MC1iOGZjLTQxMTUtYjE2NC1jZTE0YTg4MTZiODMiLCJjbGllbnRfaWQiOiJycGx1cy1kb2N0b3ItY2xpZW50IiwidXNlcm5hbWUiOiIxMzkwMDAwMDAwMSJ9.ZPSfW44ROcqY-swe1VTKAhWOTDmrwU6N4E1Sddxs0uf6R6Zj78xz3AMBEEnx-8s8QTiKfRtSCRZBcQnUaxN-TxLmWdEN_AsqoC6XfwJ3qd62EuLCPp1651gSNN8J-A74VI-7nO7GpiMMpesB45RzvFcJd8umwVmJuK9lhIptPkU";
        //String authorization = "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjYzMDE2NDE3MjM0NjUzNTg1IiwiaWlzIjoiaHR0cDovL29hdXRoLnJwbHVzaGVhbHRoLmNuL2lkZW50aXR5L29hdXRoL3Rva2VuIiwic2NvcGUiOlsidXNlcm5hbWUiXSwiZXhwIjoxNjI5NTI4NjM1LCJqdGkiOiI3NmRiMGFiYi04ODNjLTQ1ZTEtOTA4Mi1kMTM5NmEzZTg1MTMiLCJjbGllbnRfaWQiOiJycGx1cy1kb2N0b3ItY2xpZW50IiwidXNlcm5hbWUiOiIxMzkwMDAwMDAwMSJ9.T5mjGlKdvC5EkAbkC0cpYGN1I5YIjB2pavL4qAGmcyNaxiYSXa917wZRPkez1ufNd6PmhG-i8uyfB8tLdFSjkmbkKGaIl-xosWEDquFlJAL7NsmxssihI4D9GM9LDythZHTJosK-4fXQxg0dOoMlI4cDiYgXL4yZQpnBdYIi3Aw";
//        String authorization = "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjYzMDE2NDE3MjM0NjUzNTg1IiwiaWlzIjoiaHR0cDovL29hdXRoLnJwbHVzaGVhbHRoLmNuL2lkZW50aXR5L29hdXRoL3Rva2VuIiwic2NvcGUiOlsidXNlcm5hbWUiXSwiZXhwIjoxNjI5NTMzNjk2LCJqdGkiOiIyNWNmZGM5Yi03NjVhLTQ4MTItYjMyMS1mMTY1ZGJjMTU2ZjciLCJjbGllbnRfaWQiOiJycGx1cy1kb2N0b3ItY2xpZW50IiwidXNlcm5hbWUiOiIxMzkwMDAwMDAwMSJ9.MJ1DoQqVo0QHvRhArLSvxO7V3HKq7GQrgyUUzdAFyJOVqrrguvRTkUXkKe6__Z2TPCIxXHyeQyDJgNHv786-1vkbnOHqJLLtbs423kSIrD0vlXHkxlz6rIVxQaHNMtDrrMr-INkduERau6zB6Lyh2zVQL9PReZykjj13zF0IyUA";
        //ApiRequest request = new ApiRequest(HttpMethod.GET, "/patient/list");
        //ApiRequest request = new ApiRequest(HttpMethod.GET, "/patient/exercise/detail");
//        ApiRequest request = new ApiRequest(HttpMethod.GET, "/followup/37272653910261760/list/81419334257999875");
        //https://doctor.rplushealth.cn/doctor-web/api/followup/37272653910261760/list/81418853221638151
        //ApiRequest request = new ApiRequest(HttpMethod.GET, "/followup/37272653910261760/configs");
        ApiRequest request = new ApiRequest(HttpMethod.GET, "/followup/37272653910261760/configs");
        //ApiRequest request = new ApiRequest(HttpMethod.GET, "/followup/37272653910261760/list");

        String configId = "81419334257999872";
//        request.addParam("X-Ca-Stage", "RELEASE", ParamPosition.HEAD, false);
        request.addParam("X-Ca-Stage", "PRE", ParamPosition.HEAD, false);
        request.addParam("pageNumber", "0", ParamPosition.QUERY, false);
        request.addParam("pageSize", "500", ParamPosition.QUERY, false);
        request.addParam("keyword", "", ParamPosition.QUERY, false);
        request.addParam("pageSize", "500", ParamPosition.QUERY, false);
//        request.addParam("patientId", "81562880654917632", ParamPosition.QUERY, false);
//        request.addParam("sportId", "81563381018624008", ParamPosition.QUERY, false);
        request.addParam("Authorization", authorization, ParamPosition.HEAD, true);
        request.addParam("configId", configId, ParamPosition.QUERY, true);

        sendAsyncRequest(request,callback);
    }
}