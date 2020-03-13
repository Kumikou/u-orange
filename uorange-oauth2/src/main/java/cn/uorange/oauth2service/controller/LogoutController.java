package cn.uorange.oauth2service.controller;

import cn.uorange.common.utils.Result;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @Author Kumikou
 * @Date 2019/12/25
 */
@RestController
@RequestMapping("/user")
public class LogoutController {

    @Resource
    TokenStore tokenStore;

    @GetMapping("logout")
    public Result logout(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization");
        String[] token = authToken.split("\\s+");
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token[1]);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return Result.success("注销成功");
    }
}
