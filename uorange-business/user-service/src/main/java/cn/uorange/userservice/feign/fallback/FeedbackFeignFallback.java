package cn.uorange.userservice.feign.fallback;

import cn.uorange.common.utils.Result;
import cn.uorange.userservice.feign.FeedbackFeign;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     服务熔断
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/8
 */
@Component
public class FeedbackFeignFallback implements FeedbackFeign {
    @Override
    public Result get() {
        return Result.errorMsg("访问出错");
    }
}
