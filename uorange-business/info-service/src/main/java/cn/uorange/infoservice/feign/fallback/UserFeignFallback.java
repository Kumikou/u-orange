package cn.uorange.infoservice.feign.fallback;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.command.RegistCommand;
import cn.uorange.infoservice.feign.UserFeign;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 调用用户服务熔断类
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/25
 */
@Component
public class UserFeignFallback implements UserFeign {
    @Override
    public Result<Long> createUniUser(RegistCommand command) {
        return Result.errorMsg("用户服务访问出错,请稍后重试");
    }
}
