package cn.uorange.userservice.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.userservice.repository.entity.Role;
import cn.uorange.userservice.repository.mapper.RoleMapper;
import cn.uorange.userservice.service.RoleService;
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{

}
