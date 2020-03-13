package cn.uorange.orderservice.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 支付接口
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/29
 */
@RestController
@RequestMapping("/alipay")
public class AlipayController {

    //发起请求的应用ID
    public static String APP_ID = "2016102100730964";
    //支付宝私匙
    public static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCsBUyydn/YS2Q77JQUPaSoHv6f4Fu3q852OPmyHTtKhAqq+HZNQnr6VKY0baDaypY6Eq1b5tYhZgd82L4Bwe8vFitCqzjI4SafJ1vZIHzWkcxkRq5jRyLdZAly/4V9OVZx0kVeXv70KMdQUCQ9t3ZIsgAMcljq2mPMEZUmVfM3G9dbNQzb5FKS9EwnqFszRE0klP+42NptxYEC+xZUmBI30gu4Xm4+PtI1MKYYz25spPlpLDQclGt5cZrBNpEwCY5EerSpHr7R0aQWNkWIh7wKA2Yb31bWe+kW2FUp0y/Jp2uNThQ/gUVujYeipnErhOOP5Q7fZR45hudqa/Ey8rnlAgMBAAECggEAMDj8Gztk83mPC81yZYoyUn792kvG6mJbaoDmXqwbJvSFGRC1+Uqdtvdr8F6bLTqFipoZxx2bAZncl38bJNr89jI8xl/Bd27GqO8brG6TEIOmzKWT1XjnqTCWBYrkHQqp1RahI6d1yXR1C2qr/jEkE5TytoqHqq62M0rqiOinWdcaep5EaCBMZvhmsVwauIpYRa8oFGQdJ5MlIAXLPiu6NjwnUOu0mMq8jtbvIIFSaaYoG5DFWRWJcgq3TB9XP9z7FS5G8I8mCzwHTTk5byG4fcfDGs5OsqA/OHgOq8ktDmcdRgLcHLpfkQdvm5STm9vBrdEvFZ6ZaGM8X2LIkgwKMQKBgQDZFzyFw8pehLf01YOtONE4jJ+hQXU1Gx9h6/Zq8y93DeQSL7J1FspPrMjrXi8E1BwHldZJzIsgPwv/O6NKYQ2RrPOZeu92vvcGonLI7jMnRJOyOlCcKrhGMp51U6LKyBluzQ3r0qVxYYsQAcQpjcYOP8ea7oVuLDyO1Su3cK/9uwKBgQDK2h2pgZoHkuDoxRb3mQ/puz95gU7HU6XjhMeJRRvLkmdK5Rjq/XBPkTf9u5Fg6ksNVepGQLljM21yoIPm5XFwcGGmNGXsWmQxwDo5qGNNC3A/aSVdhXzTGBJQJh42anMD3qAbf/9iaVLxUOYUxyq3+S5iZoLX6wDRful/3Ujc3wKBgB29Uys4ATclk1XVEi7ew7qteQjMQNQ/nPL7MkzAd9YlbwMWyanEr35uuy+TPXm53QUk/7Aodz65pFkYwGvmE8fLG6wA7WElFA4ynurrxtIwUNNvra9XIttq/84u4PRKqUFGkgumVcfMhxJwS4EtzN4S2rNczaakJL+kcFK2+0UVAoGBAINP3pOzybnNYrpLmyp8csii5dwJ0K1HgMNfWKuLiQqmoybgVtkHZoSbRNuDaACMqjjfvN/tVhTZXaguMDRvopdeqFem47O0b9ek0Awy7NUa6nah4gZAOyWLF4+6nSQslHeUzZ//o5pZA9Aixk38/7JII7afFWQgRE9ZEF4tKNWRAoGBAKn0OKCw3PnBMTsOBt07g0wjNmxfUmg/psJpsVPLAxDg83oQlivifaYnzinSGTaOJCe7RS0IlhCU1KBMINl5j/fM5NVzriM9ogITJySF1Iyn55ihfjDE/8HjRYsAFB6EHBn2InnK0FG3ogOiTKW/qwjUEEMgNJSOiZd2sDqvhb6W";
    //支付宝公匙
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiPf270WilIKOTY1Shnr9J4+VRSuRW8JnWdW1Bk5j1hytqq5c/J9TsNdOOsfh5wsm/dcE5QIacpn9fOdt4O+YzXF6T0NrtnxiOuO8NHsubHLSZAQ4Gg3ZjxeGOoE5JvdkBjBW15+3le05rXkXY7jwY5j0Y1mbaZwQTTIFCm1fXoWmasTMIOUjgiI46vkXWJXM6FaenheWhhfGFPCN74SK5vu16QIMPBvkyr2Rh9R7CmebAU1YjHl44V1qLhL19fvkvHwRgv0oOLhd5bBHdKnLTTuUYMKp4Or5NPtTJSqsj/3yDhIFmbIhL/MnbsYQAdzjl77TkEFArMEXOXeeZ+k5iQIDAQAB";
    //服务器异步通知路径
    public static String NOTIFY_URL = "http://127.0.01/alipay/alipayNotifyNotice.action";
    //服务器同步通知路径
    public static String RETURN_URL = "http://127.0.0.1/alipay/alipayReturnNotice.action";
    //公匙类型/签名类型
    public static String SIGN_TYPE = "RSA2";
    //编码格式
    public static String CHARSET = "utf-8";
    //向支付宝发起请求的网关。沙箱:https://openapi.alipaydev.com/gateway.do 上线https://openapi.alipay.com/gateway.do
    public static String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";

    public static String FORMAT = "JSON";


    @ApiOperation("支付宝测试")
    @GetMapping("test")
    public void doPost(HttpServletRequest httpRequest,
                       HttpServletResponse httpResponse) throws ServletException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(RETURN_URL);
        alipayRequest.setNotifyUrl(NOTIFY_URL);//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101001\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":88.88," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"body\":\"Iphone6 16G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


    @GetMapping("alipayReturnNotice.action")
    public void doPost() {
    }

}