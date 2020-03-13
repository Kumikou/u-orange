package cn.uorange.infoservice.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.infoservice.repository.entity.Area;
import cn.uorange.infoservice.repository.mapper.AreaMapper;
import cn.uorange.infoservice.service.IAreaService;
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements IAreaService{

}
