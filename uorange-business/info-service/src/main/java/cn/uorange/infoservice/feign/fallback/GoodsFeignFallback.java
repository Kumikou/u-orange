package cn.uorange.infoservice.feign.fallback;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.feign.GoodsFeign;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 调用商品服务熔断类
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/27
 */
@Component
public class GoodsFeignFallback implements GoodsFeign {
    @Override
    public Result<JSONObject> queryGoodsById(Long goodsId) {
        return Result.errorMsg("系统繁忙,请稍候重试!");
    }
}
