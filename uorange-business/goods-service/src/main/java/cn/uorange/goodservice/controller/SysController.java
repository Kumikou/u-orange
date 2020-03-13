package cn.uorange.goodservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.goodservice.command.ChangeCatCommand;
import cn.uorange.goodservice.command.CreateCatCommand;
import cn.uorange.goodservice.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @Author Kumikou
 * @Date 2019/12/27
 */
@RestController
@RequestMapping("/sys")
@Api(tags = "商品控制器 系统级")
public class SysController {

    @Resource
    ICategoryService categoryService;

    @ApiOperation("增加分类")
    @PostMapping
    public Result addCategory(@RequestBody @Validated CreateCatCommand command) {
        return categoryService.addCat(command);
    }

    @ApiOperation("删除分类")
    @DeleteMapping("{id}")
    public Result delCategory(@ApiParam("分类id") @PathVariable("id") Integer id) {
        return Result.success(categoryService.removeById(id));
    }

    @ApiOperation("修改分类")
    @PutMapping("{id}")
    public Result changeCategory(@ApiParam("id") @PathVariable("id") Integer id,
                                 @RequestBody @Validated ChangeCatCommand command) {
        return categoryService.changeCat(id, command);
    }

}
