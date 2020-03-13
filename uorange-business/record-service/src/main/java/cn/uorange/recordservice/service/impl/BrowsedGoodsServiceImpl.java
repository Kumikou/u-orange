package cn.uorange.recordservice.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.recordservice.repository.mapper.BrowsedGoodsMapper;
import cn.uorange.recordservice.repository.entity.BrowsedGoods;
import cn.uorange.recordservice.service.IBrowsedGoodsService;

@Service
public class BrowsedGoodsServiceImpl extends ServiceImpl<BrowsedGoodsMapper, BrowsedGoods> implements IBrowsedGoodsService {

}
