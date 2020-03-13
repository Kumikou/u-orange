package cn.uorange.infoservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.common.webmvc.LoginUser;
import cn.uorange.common.webmvc.SysUser;
import cn.uorange.infoservice.command.ChangeInfoCommand;
import cn.uorange.infoservice.command.CreateAddressCommand;
import cn.uorange.infoservice.repository.entity.Address;
import cn.uorange.infoservice.service.IAddressService;
import cn.uorange.infoservice.service.IUserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author Kumikou
 * @Date 2019/12/19
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户信息服务控制器")
public class ComnInfoController {

    @Resource
    IUserInfoService infoService;

    @Resource
    IAddressService addressService;

    @ApiOperation("获取用户信息")
    @GetMapping
    @Cacheable(value = "getUserInfo", key = "#user.id")
    public Result getInfo(@LoginUser SysUser user) {
        return infoService.getInfo(user.getId());
    }

    @ApiOperation("根据用户昵称获取用户信息")
    @GetMapping("name/{username}")
    public Result getInfoByUsername(@ApiParam @PathVariable String username) {
        return infoService.getInfoByUsername(username);
    }

    @ApiOperation("修改用户信息")
    @PutMapping
    @CacheEvict(value = "getUserInfo", key = "#user.id")
    public Result changeInfo(@LoginUser SysUser user, @RequestBody @Validated ChangeInfoCommand command) {
        return infoService.changeInfo(user.getId(), command);
    }

    @ApiOperation("修改用户头像")
    @PutMapping("img")
    @CacheEvict(value = "getUserInfo", key = "#user.id")
    public Result changeImg(@LoginUser SysUser user, @RequestParam("img") @NotBlank String img) {
        return infoService.changImg(user.getId(), img);
    }

    @ApiOperation("修改用户手机号")
    @PutMapping("phone")
    @CacheEvict(value = "getUserInfo", key = "#user.id")
    public Result changePhone(@LoginUser SysUser user,
                              @Pattern(regexp = "^1[0-9]{10}$") @RequestParam("phone") @NotBlank String phone) {
        return infoService.changePhone(user.getId(), phone);
    }

    @ApiOperation("新增地址")
    @PostMapping("address")
    public Result createAddress(@LoginUser SysUser user, @RequestBody @Validated CreateAddressCommand command) {
        return addressService.createAddress(user.getId(), command);
    }

    @ApiOperation("删除地址")
    @DeleteMapping("address/{id}")
    public Result delAddress(@LoginUser SysUser user, @ApiParam("地址id") @PathVariable Long id) {
        return Result.success(addressService.removeById(id));
    }

    @ApiOperation("查看地址")
    @GetMapping("address/{id}")
    public Result getAddress(@ApiParam("地址id") @PathVariable Long id) {
        return addressService.getAddress(id);
    }

    @ApiOperation("修改地址")
    @PutMapping("address/{id}")
    public Result changeAddress(@LoginUser SysUser user, @ApiParam("地址id") @PathVariable Long id, @RequestBody @Validated CreateAddressCommand command) {
        return addressService.changeAddress(id, command);
    }

    @ApiOperation("获取地址列表")
    @GetMapping("address/list")
    public Result listAddress(@LoginUser SysUser user) {
        return Result.success(addressService.list(new QueryWrapper<Address>().eq(Address.USER_ID, user.getId())));
    }


}
