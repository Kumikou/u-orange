package cn.uorange.infoservice.feign;

import cn.uorange.common.utils.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * 调用商品服务Feign
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/27
 */
@FeignClient(name = "goods-service")
public interface GoodsFeign {

    @GetMapping("/feign/queryGoodsById/{goodsId}")
    Result<JSONObject> queryGoodsById(@PathVariable("goodsId") Long goodsId);

}
