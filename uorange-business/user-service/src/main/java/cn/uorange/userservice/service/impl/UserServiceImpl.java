package cn.uorange.userservice.service.impl;

import cn.uorange.common.oauth.OauthUser;
import cn.uorange.common.utils.Result;
import cn.uorange.userservice.command.CreateUniUserCommand;
import cn.uorange.userservice.repository.entity.*;
import cn.uorange.userservice.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.userservice.repository.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    PasswordEncoder passwordEncoder;

    @Resource
    UserRoleService userRoleService;

    @Resource
    RoleService roleService;

    @Resource
    RolePermissionService rolePermissionService;

    @Resource
    PermissionService permissionService;

    @Override
    public Result createUniUser(CreateUniUserCommand command) {
        User userByName = queryByUsername(command.getUsername());
        User userByPhone = queryByPhone(command.getPhone());

        if (!Objects.isNull(userByName)) {
            log.info("该用户名已存在：{}", command.getUsername());
            return Result.errorMsg("该用户名已存在");
        }
        if (!Objects.isNull(userByPhone)) {
            log.info("该手机号已注册:{}", command.getPhone());
            return Result.errorMsg("该手机号已注册");
        }

        User user = command.toObj();
        encodePassword(user);
        boolean result = this.save(user);
        // add role for user
        userRoleService.createForUser(user.getId());
        if (result) {
            log.info("用户:{} 注册成功", user.getUsername());
            return Result.success(user.getId());
        } else {
            log.info("注册失败,请稍后重试");
            return Result.errorMsg("注册失败,请稍后重试");
        }

    }

    /**
     * 加密密码
     * @param user object
     */
    private void encodePassword(User user) {
        String password = user.getPassword();
        String cryptPassword = passwordEncoder.encode(password);
        user.setPassword(cryptPassword);
    }


    @Override
    public Result<OauthUser> getOauthUserByUsername(String username) {
        User user = queryByUsername(username);
        return toOauthUser(user);
    }

    @Override
    public Result<OauthUser> getOauthUserByPhone(String phone) {
        User user = queryByPhone(phone);
        return toOauthUser(user);
    }

    private Result<OauthUser> toOauthUser(User user) {
        if (Objects.isNull(user))
            return Result.errorMsg("该用户不存在");

        String username = user.getId() + "-" + user.getUsername();

        // 获取用户对应角色
        List<UserRole> userRoleList = userRoleService.list(new QueryWrapper<UserRole>().eq(UserRole.USER_ID, user.getId()));
        if (userRoleList.isEmpty()) {
            return Result.success(new OauthUser(username, user.getPassword(), null, ""));
        }
        Collection<Long> roleIds = userRoleList.stream().map(UserRole::getRoleId).collect(Collectors.toSet());
        List<Role> roleList = roleService.list(new QueryWrapper<Role>().in(Role.ID, roleIds));

        // 获取角色对应权限
        List<RolePermission> rolePermissionList = rolePermissionService.list(new QueryWrapper<RolePermission>().in(RolePermission.ROLE_ID, roleIds));
        String roleAuths = roleList.stream().map(Role::getEnname).map(roleEnname -> roleEnname.toUpperCase()).collect(Collectors.joining(","));
        if (rolePermissionList.isEmpty()) {
            return Result.success(new OauthUser(username, user.getPassword(), null, roleAuths));
        }
        Collection<Long> permissionIds = rolePermissionList.stream().map(RolePermission::getPermissionId).collect(Collectors.toSet());
        List<Permission> permissionList = permissionService.list(new QueryWrapper<Permission>().in(Permission.ID, permissionIds));
        String permissionAuths = permissionList.stream().map(Permission::getEnname).collect(Collectors.joining(","));
        permissionAuths = permissionAuths + "," + roleAuths;
        return Result.success(new OauthUser(username, user.getPassword(), null, permissionAuths));
    }

    private User queryByUsername(String username) {
        return this.getOne(new QueryWrapper<User>().eq(User.USERNAME, username));
    }

    private User queryByPhone(String phone) {
        return this.getOne(new QueryWrapper<User>().eq(User.PHONE, phone));
    }
}
