package cn.uorange.infoservice.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.infoservice.repository.mapper.ProvinceMapper;
import cn.uorange.infoservice.repository.entity.Province;
import cn.uorange.infoservice.service.IProvinceService;
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements IProvinceService{

}
