package cn.uorange.infoservice.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.infoservice.repository.entity.Goods;
import cn.uorange.infoservice.repository.mapper.GoodsMapper;
import cn.uorange.infoservice.service.IGoodsService;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
