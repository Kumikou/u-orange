package cn.uorange.userservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.userservice.repository.mapper.RolePermissionMapper;
import cn.uorange.userservice.repository.entity.RolePermission;
import cn.uorange.userservice.service.RolePermissionService;
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService{

}
