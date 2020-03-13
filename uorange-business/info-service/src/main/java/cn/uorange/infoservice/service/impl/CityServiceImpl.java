package cn.uorange.infoservice.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.infoservice.repository.entity.City;
import cn.uorange.infoservice.repository.mapper.CityMapper;
import cn.uorange.infoservice.service.ICityService;
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService{

}
