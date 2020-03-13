package cn.uorange.userservice.service;

import cn.uorange.userservice.repository.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserRoleService extends IService<UserRole>{


    void createForUser(Long userId);
}
