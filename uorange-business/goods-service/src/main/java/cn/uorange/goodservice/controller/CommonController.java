package cn.uorange.goodservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.common.webmvc.LoginUser;
import cn.uorange.common.webmvc.SysUser;
import cn.uorange.goodservice.command.ChangeGoodsCommand;
import cn.uorange.goodservice.command.ChangeStatusCommand;
import cn.uorange.goodservice.command.PublishGoodsCommand;
import cn.uorange.goodservice.repository.entity.Category;
import cn.uorange.goodservice.service.ICategoryService;
import cn.uorange.goodservice.service.IGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/25
 */
@RestController
@RequestMapping
@Api(tags = "商品控制器")
public class CommonController {

    @Resource
    IGoodsService goodsService;

    @Resource
    ICategoryService categoryService;

    @ApiOperation("发布商品信息")
    @PostMapping
    public Result publishGoods(@LoginUser SysUser user, @RequestBody @Validated PublishGoodsCommand command) {
        return goodsService.createGoods(user.getId(), command);
    }

    @ApiOperation("删除商品")
    @DeleteMapping("{id}")
    public Result delGoods(@ApiParam("商品id") @PathVariable Long id) {
        return Result.success(goodsService.removeById(id));
    }

    @ApiOperation("修改商品描述")
    @PutMapping
    public Result changeGoods(@RequestBody @Validated ChangeGoodsCommand command) {
        return goodsService.changeGoods(command);
    }

    @ApiOperation("修改商品状态 0:已发布 1:未发布/已下架 2:已卖出")
    @PutMapping("status")
    public Result changeStatus(@RequestBody @Validated ChangeStatusCommand command) {
        return goodsService.changeStatus(command);
    }

    @ApiOperation("查看商品信息")
    @GetMapping("{id}")
    public Result getGoodsById(@ApiParam("商品id") @PathVariable Long id) {
        return goodsService.getGoodById(id);
    }

    @ApiOperation("卖家查看自己的商品信息")
    @GetMapping("owner/{id}")
    public Result getGoods(@LoginUser SysUser user, @ApiParam("商品id") @PathVariable Long id) {
        return goodsService.getGoodsForOwner(user.getId(), id);
    }

    @ApiOperation("根据商品状态获取商品列表 0:已发布 1:未发布/已下架 2:已卖出")
    @GetMapping("status/{status}/{page}/{size}")
    public Result getGoodsByStatus(@LoginUser SysUser user,
                                   @ApiParam("商品状态") @PathVariable Integer status,
                                   @ApiParam("当前页") @PathVariable Integer page,
                                   @ApiParam("分页大小") @PathVariable Integer size) {
        return goodsService.getGoodsByStatus(user.getId(), status, page, size);
    }

    @ApiOperation("获取已发布和已卖出的商品数量")
    @GetMapping("count")
    public Result countGoods(@LoginUser SysUser user) {
        return goodsService.countGoods(user.getId());
    }

    @ApiOperation("查看全部分类")
    @GetMapping("cat/{parentId}")
    public Result listCategory(@ApiParam("分类父id") @PathVariable Integer parentId) {
        return Result.success(categoryService.list(new QueryWrapper<Category>().eq(Category.PARENT_ID, parentId)));
    }

    @ApiOperation("获取指定分类下已发布状态的商品列表")
    @GetMapping("index/goods/list/{categoryId}/{page}/{size}")
    public Result listGoods(@ApiParam("分类id") @PathVariable Integer categoryId,
                            @ApiParam("当前页") @PathVariable Integer page,
                            @ApiParam("分页大小") @PathVariable Integer size) {
        return goodsService.listGoods(categoryId, page, size);
    }

    @ApiOperation("feign接口 获取商品详情")
    @GetMapping("/feign/queryGoodsById/{goodsId}")
    public Result queryGoodsById(@PathVariable Long goodsId) {
        return goodsService.queryGoodsById(goodsId);
    }
}
