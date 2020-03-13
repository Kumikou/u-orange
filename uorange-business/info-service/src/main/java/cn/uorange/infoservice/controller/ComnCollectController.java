package cn.uorange.infoservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.common.webmvc.LoginUser;
import cn.uorange.common.webmvc.SysUser;
import cn.uorange.infoservice.service.ICollectGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/27
 */
@RestController
@RequestMapping("/collect")
@Api(tags = "收藏服务控制器")
public class ComnCollectController {

    @Resource
    ICollectGoodsService collectGoodsService;

    @ApiOperation("收藏商品")
    @PostMapping("goods/{goodsId}")
    public Result doCollectGoods(@LoginUser SysUser user, @ApiParam("商品id") @PathVariable Long goodsId) {
        return collectGoodsService.doCollect(user.getId(), goodsId);
    }

    @ApiOperation("取消收藏")
    @DeleteMapping("goods/{goodsId}")
    public Result cancelCollectGoods(@LoginUser SysUser user, @ApiParam("商品id") @PathVariable Long goodsId) {
        return collectGoodsService.cancelCollect(user.getId(), goodsId);
    }

    @ApiOperation("获取收藏商品列表")
    @GetMapping("goods/{page}/{size}")
    public Result listCollectGoods(@LoginUser SysUser user,
                                   @ApiParam("当前页") @PathVariable Integer page,
                                   @ApiParam("分页数量") @PathVariable Integer size) {
        return collectGoodsService.listAll(user.getId(), page, size);
    }

}
