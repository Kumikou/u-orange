package cn.uorange.infoservice;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.feign.GoodsFeign;
import cn.uorange.infoservice.repository.entity.Goods;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class InfoServiceApplication {
//
//    @Resource
//    GoodsFeign goodsFeign;

    @Test
    public void contextLoad() {

    }

//    @Test
//    public void goodsFeignTest() {
//        Goods goods = new Goods();
//        Long goodsId = 1L;
//        Result<JSONObject> res = goodsFeign.queryGoodsById(goodsId);
//        JSONObject object = res.getData();
//        log.info("feign请求结果:{}",object.getString("title"));
//    }

}
