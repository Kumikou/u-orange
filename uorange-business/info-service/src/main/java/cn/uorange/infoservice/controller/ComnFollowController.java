package cn.uorange.infoservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.common.webmvc.LoginUser;
import cn.uorange.common.webmvc.SysUser;
import cn.uorange.infoservice.service.IFollowService;
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
@RequestMapping("/follow")
@Api(tags = "关注服务控制器")
public class ComnFollowController {

    @Resource
    IFollowService followService;

    @ApiOperation("添加关注")
    @PostMapping("{targetId}")
    public Result addFollow(@LoginUser SysUser user, @ApiParam("关注对象") @PathVariable Long targetId) {
        return followService.addFollow(user.getId(), targetId);
    }

    @ApiOperation("取消关注")
    @DeleteMapping("{targetId}")
    public Result delFollow(@LoginUser SysUser user, @ApiParam("关注对象") @PathVariable Long targetId) {
        return followService.delFollow(user.getId(), targetId);
    }

    @ApiOperation("获取粉丝列表")
    @GetMapping("follower/{page}/{size}")
    public Result listFollower(@LoginUser SysUser user, @ApiParam("当前页") @PathVariable Integer page, @ApiParam("分页大小") @PathVariable Integer size) {
        return followService.listFollower(user.getId(), page, size);
    }

    @ApiOperation("获取已关注列表")
    @GetMapping("followed/{page}/{size}")
    public Result listFollowed(@LoginUser SysUser user, @ApiParam("当前页") @PathVariable Integer page, @ApiParam("分页大小") @PathVariable Integer size) {
        return followService.listFollowed(user.getId(), page, size);
    }

}
