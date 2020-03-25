package cn.uorange.orderservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.orderservice.repository.mapper.OrderDetailMapper;
import cn.uorange.orderservice.repository.entity.OrderDetail;
import cn.uorange.orderservice.service.IOrderDetailService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@Slf4j
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {
    @Override
    public void updateOrderDetatil(Long orderId, Map<String, String> params) {
        OrderDetail orderDetail = this.getOne(new QueryWrapper<OrderDetail>().eq(OrderDetail.ORDER_ID,orderId));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("1");
        orderDetail.setPayType(0).setPayTime(LocalDateTime.parse(params.get("timestamp"), dtf));
        System.out.println("2");
        this.updateById(orderDetail);
        log.info("订单详细信息更新成功,订单详细信息:{}", orderDetail);
    }
}

