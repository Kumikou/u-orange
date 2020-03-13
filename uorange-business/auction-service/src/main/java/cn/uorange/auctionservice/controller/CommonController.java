package cn.uorange.auctionservice.controller;

import cn.uorange.auctionservice.command.CreateItemCommand;
import cn.uorange.auctionservice.service.ICategoryService;
import cn.uorange.auctionservice.service.ItemService;
import cn.uorange.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author Kumikou
 * @Date 2019/12/16
 */
@RestController
@RequestMapping
@Api(tags = "拍卖品分类控制器")
public class CommonController {

    @Resource
    ICategoryService categoryService;

    @Resource
    ItemService itemsService;

    @ApiOperation("创建拍卖品")
    @PostMapping
    public Result addItem(@RequestBody @Validated CreateItemCommand command) {
        return itemsService.addItem(command);
    }

    @ApiOperation("修改拍卖品")
    @PutMapping("{id}")
    @CacheEvict(value = "getAuItem", key = "#id")
    public Result changeItem(@ApiParam("拍卖品id") @PathVariable("id") Long id, @RequestBody @Validated CreateItemCommand command) {
        return itemsService.changeItem(id, command);
    }

    @ApiOperation("查看拍卖品")
    @GetMapping("{id}")
    @Cacheable(value = "getAuItem", key = "#id")
    public Result getItem(@ApiParam("拍卖品id") @PathVariable("id") Long id) {
        return itemsService.getItem(id);
    }

    @ApiOperation("删除拍卖品")
    @DeleteMapping("{id}")
    public Result delItem(@ApiParam("拍卖品id") @PathVariable("id") Long id) {
        return Result.success(itemsService.removeById(id));
    }

    @ApiOperation("修改拍卖品当前价格/出价")
    @PutMapping("price/{id}")
    public Result changeNowPrice(@ApiParam("拍卖品id") @PathVariable("id") Long id,
                                 @ApiParam("出价人id") @RequestParam("currentOwnerId") Long currentOwnerId,
                                 @ApiParam("当前出价") @RequestParam("currentPrica") BigDecimal currentPrice) {
        return itemsService.updateNowPrice(id, currentOwnerId, currentPrice);
    }

    @ApiOperation("获取全部分类")
    @GetMapping("cat/{parentId}")
    @Cacheable(value = "getCategories", key = "#parentId")
    public Result listSon(@ApiParam("父分类id") @PathVariable("parentId") Integer parentId) {
        return categoryService.listSon(parentId);
    }

}
