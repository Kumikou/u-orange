package cn.uorange.assessservice.controller;

import cn.uorange.assessservice.command.DoAssessCommand;
import cn.uorange.assessservice.service.IAssessService;
import cn.uorange.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/16
 */
@RequestMapping("/sys")
@RestController
@Api(tags = "评估控制器")
public class SysController {

    @Resource
    IAssessService assessService;

    @ApiOperation("添加评估价格")
    @PutMapping("{id}")
    public Result doAssess(@ApiParam("评估ID") @PathVariable("id") Long id,
                           @RequestBody @Validated DoAssessCommand command) {
        return assessService.doAssess(id, command);
    }

    @ApiOperation("查看用户所有的评估申请")
    @GetMapping("{userId}/{page}/{size}")
    public Result listAssessByUserID(@ApiParam("用户ID") @PathVariable("userId") Long userId,
                                     @ApiParam("当前页") @PathVariable("page") Integer page,
                                     @ApiParam("分页大小") @PathVariable("size") Integer size) {
        return assessService.listByUserId(userId, page, size);
    }

    @ApiOperation("根据评估状态获取用户所有评估申请 0:未评估 1:已评估 2:无法评估")
    @GetMapping("{userId}/{status}/{page}/{size}")
    public Result listAssessByUserIdStatus(@ApiParam("用户ID") @PathVariable("userId") Long userId,
                                           @ApiParam("评估状态") @PathVariable("status") Long status,
                                           @ApiParam("当前页") @PathVariable("page") Integer page,
                                           @ApiParam("分页大小") @PathVariable("size") Integer size) {
        return assessService.listByUserIdStatus(userId, status, page, size);
    }

}
