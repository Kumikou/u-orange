package cn.uorange.userservice.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.userservice.repository.entity.UserRole;
import cn.uorange.userservice.repository.mapper.UserRoleMapper;
import cn.uorange.userservice.service.UserRoleService;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public void createForUser(Long userId) {
        UserRole userRole = new UserRole().setRoleId((long) 38).setUserId(userId);
        this.save(userRole);
    }
}
