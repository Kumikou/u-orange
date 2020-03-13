package cn.uorange.infoservice.feign;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.command.RegistCommand;
import cn.uorange.infoservice.feign.fallback.UserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 调用用户服务Feign
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/25
 */
@FeignClient(name = "user-service", fallback = UserFeignFallback.class)
public interface UserFeign {

    @PostMapping("/users/createUniuser")
    Result<Long> createUniUser(@RequestBody RegistCommand command);
}
