package cn.uorange.orderservice.service;

import cn.uorange.orderservice.repository.entity.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface IOrderDetailService extends IService<OrderDetail> {


    void updateOrderDetatil(Long orderId, Map<String, String> params);
}
