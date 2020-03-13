package cn.uorange.orderservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.common.webmvc.LoginUser;
import cn.uorange.common.webmvc.SysUser;
import cn.uorange.orderservice.command.SubmitOrderAddCommand;
import cn.uorange.orderservice.command.SubmitOrderGoodsCommand;
import cn.uorange.orderservice.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/29
 */
@RestController
@RequestMapping
@Api(tags = "订单服务控制器")
public class OrderController {

    @Resource
    IOrderService orderService;

    @ApiOperation("提交订单")
    @PostMapping("commit")
    public Result commitOrder(@LoginUser SysUser user,
                              @RequestBody @Validated SubmitOrderGoodsCommand goodsCommand,
                              @RequestBody @Validated SubmitOrderAddCommand addCommand) {
        return orderService.submit(user.getId(), goodsCommand, addCommand);
    }

    @ApiOperation("取消订单")
    @PutMapping("cancel/{orderNo}")
    public Result cancelOrder(@LoginUser SysUser user,
                              @ApiParam("订单号") @PathVariable Long orderNo) {
        return orderService.cancel(user.getId(), orderNo);
    }

    @ApiOperation("删除订单")
    @DeleteMapping("{orderId}")
    public Result delOrder(@ApiParam("订单id") @PathVariable Long orderId) {
        return Result.success(orderService.removeById(orderId));
    }

    @ApiOperation("买家方 获取订单列表")
    @GetMapping("list/{page}/{size}")
    public Result listOrder(@LoginUser SysUser user,
                            @ApiParam("当前页") @PathVariable Integer page,
                            @ApiParam("分页大小") @PathVariable Integer size) {
        return orderService.listAll(user.getId(), page, size);
    }

    @ApiOperation("卖家方 获取订单列表")
    @GetMapping("seller/list/{page}/{size}")
    public Result listSellerOrder(@LoginUser SysUser user,
                                  @ApiParam("当前页") @PathVariable Integer page,
                                  @ApiParam("分页大小") @PathVariable Integer size) {
        return orderService.listSellerAll(user.getId(), page, size);
    }

}
