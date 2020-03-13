package cn.uorange.recordservice.service.impl;

import cn.uorange.recordservice.listener.RecordListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.recordservice.repository.entity.ItemPrice;
import cn.uorange.recordservice.repository.mapper.ItemPriceMapper;
import cn.uorange.recordservice.service.ItemPriceService;


@Service
@Slf4j
@EnableBinding(RecordListener.class)
public class ItemPriceServiceImpl extends ServiceImpl<ItemPriceMapper, ItemPrice> implements ItemPriceService {

}
