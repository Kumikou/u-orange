package cn.uorange.userservice.feign;

import cn.uorange.common.utils.Result;
import cn.uorange.userservice.feign.fallback.FeedbackFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * feedback服务调用
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/8
 */
@FeignClient(name = "feedback-service", fallback = FeedbackFeignFallback.class)
public interface FeedbackFeign {

    @GetMapping("/user/test")
    Result get();
}
