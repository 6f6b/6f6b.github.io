import com.alibaba.cloudapi.sdk.constant.SdkConstant;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;

import java.io.IOException;

/**
 * @author LiuFeng
 * @date 2021/9/4 上午8:50
 */
public class DemoRWatcherOpenAPI {


    static {
        //HTTP Client init
        HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
        httpParam.setAppKey("203962099");
        httpParam.setAppSecret("Me1KNUc8r43aWsZ25B9Uu3Q6lEf9TgbB");


        HttpApiClientRplusOpenAPI.getInstance().init(httpParam);

        //HTTPS Client init
        HttpClientBuilderParams httpsParam = new HttpClientBuilderParams();
        httpsParam.setAppKey("203962099");
        httpsParam.setAppSecret("Me1KNUc8r43aWsZ25B9Uu3Q6lEf9TgbB");

        /**
         * HTTPS request use DO_NOT_VERIFY mode only for demo
         * Suggest verify for security
         */
        //httpsParam.setRegistry(getNoVerifyRegistry());
        RWatcherOpenAPI.getInstance().init(httpsParam);


    }

    public static void main(String[] args) {
        报告列表查询();
    }



    public static void 报告列表查询() {
        RWatcherOpenAPI.getInstance().报告列表查询(new ApiCallback() {
            public void onFailure(ApiRequest request, Exception e) {
                System.out.println(request);
            }

            public void onResponse(ApiRequest request, ApiResponse response) {
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
}
