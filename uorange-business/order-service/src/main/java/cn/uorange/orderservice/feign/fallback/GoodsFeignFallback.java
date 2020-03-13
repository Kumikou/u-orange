package cn.uorange.orderservice.feign.fallback;

import cn.uorange.common.utils.Result;
import cn.uorange.orderservice.feign.GoodsFeign;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 商品服务调用熔断类
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/29
 */
@Component
public class GoodsFeignFallback implements GoodsFeign {

    @Override
    public Result<JSONObject> queryGoodsById(Long goodsId) {
        return Result.errorMsg("系统繁忙,请稍后重试！");
    }
}
