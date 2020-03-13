package cn.uorange.orderservice.service.impl;

import org.springframework.stereotype.Service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.orderservice.repository.mapper.OrderDeliveryMapper;
import cn.uorange.orderservice.repository.entity.OrderDelivery;
import cn.uorange.orderservice.service.IOrderDeliveryService;

@Service
public class OrderDeliveryServiceImpl extends ServiceImpl<OrderDeliveryMapper, OrderDelivery> implements IOrderDeliveryService {

}
