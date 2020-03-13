package cn.uorange.recordservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.recordservice.repository.entity.ItemPrice;
import cn.uorange.recordservice.service.IBrowsedGoodsService;
import cn.uorange.recordservice.service.IVisitRecordService;
import cn.uorange.recordservice.service.ItemPriceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/18
 */
@RestController
@RequestMapping
@Api(tags = "信息记录控制器")
public class CommonController {

    @Resource
    ItemPriceService priceService;

    @Resource
    IVisitRecordService visitRecordService;

    @Resource
    IBrowsedGoodsService browsedGoodsService;

    @ApiOperation("获取拍卖品价格记录")
    @GetMapping("price/{itemId}")
    public Result getPriceRecord(@ApiParam("拍卖品id") @PathVariable Long itemId) {
        return Result.success(priceService.list(new QueryWrapper<ItemPrice>().eq(ItemPrice.ITEM_ID, itemId)));
    }

    @ApiOperation("获取用户访客数量")
    @GetMapping("visit/{userId}")
    public Result getVisitedTimes(@ApiParam("用户id") @PathVariable Long userId) {
        int times = visitRecordService.getById(userId).getVisitedTime();
        return Result.success(times);
    }

    @ApiOperation("获取商品被浏览次数")
    @GetMapping("browse/{goodsId}")
    public Result getBrowsedTimes(@ApiParam("商品id") @PathVariable Long goodsId) {
        int times = browsedGoodsService.getById(goodsId).getBrowsedTime();
        return Result.success(times);
    }
}
