import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;

/**
 * @author LiuFeng
 * @date 2021/9/4 上午8:31
 */
public class RWatcherOpenAPI extends ApacheHttpClient {
    public final static String HOST = "rwatcher.open.shukangyun.com";

    static RWatcherOpenAPI instance = new RWatcherOpenAPI();
    public static RWatcherOpenAPI getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTPS);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }

    public void 报告列表查询(ApiCallback callback) {
//        String authorization = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6Ijk1MGNkZjVkNjc3YmY5ZThiNzJkOGY2ODQyZTJjMzIyIiwidHlwIjoiSldUIn0.eyJuYmYiOjE2MzEwMDg4ODEsImV4cCI6MTY2MjU0NDg4MSwiaXNzIjoiaHR0cDovL2FjY291bnQuZmF0LnNodWthbmd5dW4uY29tIiwiYXVkIjpbImh0dHA6Ly9hY2NvdW50LmZhdC5zaHVrYW5neXVuLmNvbS9yZXNvdXJjZXMiLCJJZGVudGl0eVNlcnZpY2UiLCJPcmdhbml6YXRpb25TZXJ2aWNlIiwiUldhdGNoZXJTZXJ2aWNlIl0sImNsaWVudF9pZCI6ImhhaS14aW4iLCJzdWIiOiIyNzZiYWQ4YS02NTRmLTRhZDAtYTI0Ni0xNmU0NjZiN2IyZTEiLCJhdXRoX3RpbWUiOjE2MzEwMDg4ODEsImlkcCI6ImxvY2FsIiwibmFtZSI6IjEwODU4Iiwic2NvcGUiOlsiYWRkcmVzcyIsImVtYWlsIiwib3BlbmlkIiwicGhvbmUiLCJwcm9maWxlIiwicm9sZSIsIklkZW50aXR5U2VydmljZSIsIk9yZ2FuaXphdGlvblNlcnZpY2UiLCJSV2F0Y2hlclNlcnZpY2UiLCJvZmZsaW5lX2FjY2VzcyJdLCJhbXIiOlsidGhyZWVwYXJ0eV9vcGVuaWQiXX0.AOKbHeeyTR3wuFk1KqiAbnLuGRrvmTtbsmNvOwsfNp9IHh2ViSnzE2kuQ83HvrNU9q9W3hQdoPuwLcottF3ny_xHLVwSU5aZs8mcjjoWprbsysdXnkAm4lRtGazr0HyuZZuKk_CxzauufadoBDhDhUj3gwSbpabGXOf8C9gDeK3XYzK2uhSZNra0S6LGUlUYPboqnPH-KYPE0tZ-O7-pOtrySw-mAkCQI9D8LmVMZcSwHFH4qglrebOo5b6V5YuILw4p8AJh1rW0-LcP8EV2zE_oOT3OndeFF27_oP28RyHIFGqJVQXRCt69wP2lHCJoZspffKnhzff7-oM4fi95pw";
        String authorization = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6Ijk1MGNkZjVkNjc3YmY5ZThiNzJkOGY2ODQyZTJjMzIyIiwidHlwIjoiSldUIn0.eyJuYmYiOjE2MzEwNzEzNzYsImV4cCI6MTY2MjYwNzM3NiwiaXNzIjoiaHR0cDovL2FjY291bnQuZmF0LnNodWthbmd5dW4uY29tIiwiYXVkIjpbImh0dHA6Ly9hY2NvdW50LmZhdC5zaHVrYW5neXVuLmNvbS9yZXNvdXJjZXMiLCJJZGVudGl0eVNlcnZpY2UiLCJPcmdhbml6YXRpb25TZXJ2aWNlIiwiUldhdGNoZXJTZXJ2aWNlIl0sImNsaWVudF9pZCI6InJ3YXRjaGVyLWFwcC1jbGllbnQiLCJzdWIiOiJjYzQ2NDQzZS04NmZjLTQ4MjctYjk0Ny04MzJlZGZkNWQ2M2EiLCJhdXRoX3RpbWUiOjE2MzEwNzEzNzYsImlkcCI6ImxvY2FsIiwibmFtZSI6IjEwODYxIiwic2NvcGUiOlsiYWRkcmVzcyIsImVtYWlsIiwib3BlbmlkIiwicGhvbmUiLCJwcm9maWxlIiwicm9sZSIsIklkZW50aXR5U2VydmljZSIsIk9yZ2FuaXphdGlvblNlcnZpY2UiLCJSV2F0Y2hlclNlcnZpY2UiLCJvZmZsaW5lX2FjY2VzcyJdLCJhbXIiOlsidGhyZWVwYXJ0eV9vcGVuaWQiXX0.wK9lPD4e6OwV3EmsbxSfxk02QVRcbGlqMm1_iUNrv1G_0tW08xVS1rOGeS51eVH_0u9j6tkaceKk7hftW1EBnyRXo-P0MNQKYgAU-WO9VxA2L0KRdn-HamWhyeocKaDBjWtSz3DI_Oo8GRusKSLbZmY1mlnh_mjkDSBLvcCHDbgtMXUcKY67bJ-paeMxOXaUsTqRuRmiK7xXBmHenSPvZHk5wmkw5hBC7UqTiOAqE-AhG4vDgACvuSE5-__LSeluWvUL1PGljzx7ygXYYt_b1RlFg9Kvu8fUNBydBmeMTDGuaHJqzWTZ9lwCpTUtwNnFx9bLbtPYZe-1Y76g9HWkeQ";
//        ApiRequest request = new ApiRequest(HttpMethod.GET, "/api/assessment/list");
        ApiRequest request = new ApiRequest(HttpMethod.GET, "/api/evaluation/home");
        request.addParam("X-Ca-Stage", "TEST", ParamPosition.HEAD, false);
        request.addParam("pageNumber", "0", ParamPosition.QUERY, false);
        request.addParam("pageSize", "500", ParamPosition.QUERY, false);
        request.addParam("Authorization", authorization, ParamPosition.HEAD, true);
        sendAsyncRequest(request,callback);
    }
}
