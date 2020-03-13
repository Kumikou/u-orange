package cn.uorange.infoservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/19
 */
@RestController
@RequestMapping("/sys")
@Api(tags = "信息控制器 系统级")
public class SysController {

    @Resource
    IUserInfoService userInfoService;

    @ApiOperation("获取用户信息列表")
    @GetMapping("user/list/{page}/{size}")
    public Result listUsers(@ApiParam("当前页") @PathVariable Integer page, @PathVariable Integer size) {
        return userInfoService.listUserInfos(page, size);
    }

    @ApiOperation("查看用户信息")
    @GetMapping("user/{userId}")
    public Result queryUserInfo(@ApiParam("用户id") @PathVariable Long userId) {
        return userInfoService.getInfo(userId);
    }

    @ApiOperation("修改用户状态")
    @PutMapping("user/{userId}/{status}")
    public Result changeUserStatus(@ApiParam("用户id") @PathVariable Long userId, @ApiParam("状态码 0:正常 1:封禁") @PathVariable Integer status) {
        return userInfoService.changeUserStatus(userId, status);
    }


}
