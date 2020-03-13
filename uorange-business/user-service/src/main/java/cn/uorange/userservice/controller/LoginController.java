package cn.uorange.userservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.userservice.command.LoginCommand;
import cn.uorange.userservice.utils.OkHttpClientUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Kumikou
 * @Date 2019/12/24
 */
@Api(tags = "登录")
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Value("${security.oauth2.client.access-token-uri}")
    public String ACCESS_TOKEN_URI;

    @Value("${security.oauth2.client.client-id}")
    public String CLIENT_ID;

    @Value("${security.oauth2.client.client-secret}")
    public String CLIENT_SECRET;

    public String GRANT_TYPE = "password";

    @PostMapping
    public Result login(@RequestBody @Validated LoginCommand command) throws IOException {
        OkHttpClientUtil client = OkHttpClientUtil.getInstance();
        Map<String, String> params = new HashMap<>();
        params.put("username", command.username);
        params.put("password", command.password);
        params.put("grant_type", GRANT_TYPE);
        params.put("client_id", CLIENT_ID);
        params.put("client_secret", CLIENT_SECRET);

        Response response = client.postData(ACCESS_TOKEN_URI, params);
        ResponseBody body = response.body();
        String json = body.string();
        Map<String, Object> jsonMap = JSON.parseObject(json);
        Object accessToken = jsonMap.get("access_token");
        if (Objects.isNull(accessToken))
            return Result.errorMsg("登录失败");
        log.info("用户:{} 登录成功", command.username);
        return Result.success("登录成功", "bearer " + accessToken);
    }


}
