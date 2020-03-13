package cn.uorange.assessservice.controller;

import cn.uorange.assessservice.command.ChangeAssessCommand;
import cn.uorange.assessservice.command.CreateAssessCommand;
import cn.uorange.assessservice.service.IAssessService;
import cn.uorange.common.utils.Result;
import cn.uorange.common.webmvc.LoginUser;
import cn.uorange.common.webmvc.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/16
 */
@RestController
@RequestMapping
@Api(tags = "评估物品控制器")
public class AssessController {
    @Resource
    IAssessService assessService;

    @ApiOperation("申请评估")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result apply(@LoginUser SysUser user, @RequestBody @Validated CreateAssessCommand command) {
        return assessService.createAssess(user.getId(), command);
    }

    @ApiOperation("删除评估")
    @DeleteMapping("{id}")
    public Result delAssess(@ApiParam("评估ID") @PathVariable("id") Long id) {
        return Result.success(assessService.removeById(id));
    }

    @ApiOperation("修改评估")
    @PutMapping("{id}")
    public Result changeAssess(@ApiParam("评估ID") @PathVariable("id") Long id,
                               @RequestBody @Validated ChangeAssessCommand command) {
        return assessService.changeAssess(id, command);
    }

    @ApiOperation("查看评估")
    @GetMapping("{id}")
    public Result getAssess(@ApiParam("评估ID") @PathVariable("id") Long id) {
        return assessService.getByVo(id);
    }

    @ApiOperation("根据评估状态获取评估列表 状态 0:未评估 1:已评估 2:无法评估")
    @GetMapping("{status}/{page}/{size}")
    public Result listByStatus(@LoginUser SysUser user,
                               @ApiParam("评估状态") @PathVariable("status") Integer status,
                               @ApiParam("当前页") @PathVariable("page") Integer page,
                               @ApiParam("分页大小") @PathVariable("size") Integer size) {
        return assessService.listByStatus(user.getId(), status, page, size);
    }
}
