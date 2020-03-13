package cn.uorange.orderservice.service.impl;

import org.springframework.stereotype.Service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.orderservice.repository.mapper.OrderDetailMapper;
import cn.uorange.orderservice.repository.entity.OrderDetail;
import cn.uorange.orderservice.service.IOrderDetailService;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

}

