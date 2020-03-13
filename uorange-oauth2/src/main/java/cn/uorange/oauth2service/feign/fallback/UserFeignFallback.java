package cn.uorange.oauth2service.feign.fallback;

import cn.uorange.common.oauth.OauthUser;
import cn.uorange.common.utils.Result;
import cn.uorange.oauth2service.feign.UserFeign;
import org.springframework.stereotype.Component;

/**
 *
 * @Author Kumikou
 * @Date 2019/12/23
 */
@Component
public class UserFeignFallback implements UserFeign {
    @Override
    public Result<OauthUser> getOauthUserByUsername(String username) {
        return Result.errorMsg("系统繁忙,请稍后重试");
    }
}
