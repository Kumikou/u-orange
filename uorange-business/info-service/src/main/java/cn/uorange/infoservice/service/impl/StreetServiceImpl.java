package cn.uorange.infoservice.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.infoservice.repository.entity.Street;
import cn.uorange.infoservice.repository.mapper.StreetMapper;
import cn.uorange.infoservice.service.IStreetService;

@Service
public class StreetServiceImpl extends ServiceImpl<StreetMapper, Street> implements IStreetService {

}
