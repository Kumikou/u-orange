package cn.uorange.infoservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.command.RegistCommand;
import cn.uorange.infoservice.feign.UserFeign;
import cn.uorange.infoservice.repository.entity.UserInfo;
import cn.uorange.infoservice.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @Author Kumikou
 * @Date 2019/12/25
 */
@RestController
@RequestMapping("/regist")
@Api(tags = "注册 控制器")
@Slf4j
public class RegistController {

    @Resource
    UserFeign userFeign;

    @Resource
    IUserInfoService userInfoService;

    @ApiOperation("用户注册")
    @PostMapping
    public Result regist(@RequestBody @Validated RegistCommand command) {
        Result<Long> res = userFeign.createUniUser(command);
        if (res.isNotSuccess())
            return res;
        UserInfo userInfo = new UserInfo()
                .setUserId(res.getData())
                .setUsername(command.username)
                .setPhone(command.phone);
        userInfoService.save(userInfo);
        log.info("用户数据创建成功,数据内容:{}", userInfo);
        return Result.success("注册成功");
    }

}
