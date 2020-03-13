package cn.uorange.userservice.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * OkHttpClient工具类
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/25
 */
public class OkHttpClientUtil {

    private static final int READ_TIMEOUT = 100;
    private static final int CONNECT_TIMEOUT = 60;
    private static final int WRITE_TIMEOUT = 60;
    private static final MediaType JSON = MediaType.parse("application/json; chareset=usf-8");
    private static final byte[] LOCKER = new byte[0];
    private static OkHttpClientUtil mInstance;
    private OkHttpClient okHttpClient;

    private OkHttpClientUtil() {
        okhttp3.OkHttpClient.Builder clientBuider = new okhttp3.OkHttpClient.Builder();
        clientBuider.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        okHttpClient = clientBuider.build();
    }

    /**
     * 单例模式获取OkHttpClientUtil
     *
     * @return OkHttpClientUtil instance
     */
    public static OkHttpClientUtil getInstance() {
        if (mInstance == null) {
            synchronized (LOCKER) {
                if (mInstance == null) {
                    mInstance = new OkHttpClientUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * get请求，同步方式，获取网络数据，是在主线程中执行的，需要新起线程，将其放到子线程中执行
     *
     * @param url request url
     * @return Response
     */
    public Response getData(String url) {
        //1 构造Request
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url(url).build();
        //2 将Request封装为Call
        Call call = okHttpClient.newCall(request);
        //3 执行Call，得到response
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * post请求，同步方式，提交数据，是在主线程中执行的，需要新起线程，将其放到子线程中执行
     *
     * @param url        request url
     * @param bodyParams RequestBody
     * @return Response
     */
    public Response postData(String url, Map<String, String> bodyParams) {
        //1构造RequestBody
        RequestBody body = setRequestBody(bodyParams);
        //2 构造Request
        Request.Builder requestBuilder = new Request.Builder();
        Request request = requestBuilder.post(body).url(url).build();
        //3 将Request封装为Call
        Call call = okHttpClient.newCall(request);
        //4 执行Call，得到response
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }



    /**
     * post的请求参数，构造RequestBody
     *
     * @param BodyParams params
     * @return RequestBody
     */
    private RequestBody setRequestBody(Map<String, String> BodyParams) {
        RequestBody body;
        okhttp3.FormBody.Builder formEncodingBuilder = new okhttp3.FormBody.Builder();
        if (BodyParams != null) {
            Iterator<String> iterator = BodyParams.keySet().iterator();
            String key;
            while (iterator.hasNext()) {
                key = iterator.next();
                formEncodingBuilder.add(key, BodyParams.get(key));
            }
        }
        body = formEncodingBuilder.build();
        return body;

    }

}
