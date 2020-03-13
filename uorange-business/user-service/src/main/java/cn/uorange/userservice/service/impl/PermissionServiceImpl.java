package cn.uorange.userservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.userservice.repository.entity.Permission;
import cn.uorange.userservice.repository.mapper.PermissionMapper;
import cn.uorange.userservice.service.PermissionService;
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService{

}
