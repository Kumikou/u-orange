package cn.uorange.oauth2service.feign;

import cn.uorange.common.oauth.OauthUser;
import cn.uorange.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @Author Kumikou
 * @Date 2019/12/23
 */
@FeignClient(name = "user-service")
public interface UserFeign {
    @GetMapping("/users/authByUsername")
    Result<OauthUser> getOauthUserByUsername(@RequestParam("username") String username);
}
