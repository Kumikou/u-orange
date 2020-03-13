package cn.uorange.userservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.common.webmvc.LoginUser;
import cn.uorange.common.webmvc.SysUser;
import cn.uorange.userservice.command.CreateUniUserCommand;
import cn.uorange.userservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/24
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户控制器")
public class UserController {

    @Resource
    UserService userService;

    @ApiOperation("创建唯一用户")
    @PostMapping("createUniuser")
    @ResponseStatus(HttpStatus.CREATED)
    public Result createUniUser(@RequestBody @Validated CreateUniUserCommand command) {
        return userService.createUniUser(command);
    }

    @ApiOperation("通过用户名获取认证用户")
    @GetMapping("authByUsername")
    public Result getOauthUserByUsername(@ApiParam("用户名") @RequestParam("username") String username) {
        return userService.getOauthUserByUsername(username);
    }

    @ApiOperation("通过手机号获取认证用户")
    @GetMapping("authByPhone")
    public Result getOauthUserByPhone(@ApiParam("手机号") @RequestParam String phone) {
        return userService.getOauthUserByPhone(phone);
    }

}
