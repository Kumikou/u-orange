package cn.uorange.orderservice.service;

import cn.uorange.common.utils.Result;
import cn.uorange.orderservice.command.SubmitOrderCommand;
import cn.uorange.orderservice.repository.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface IOrderService extends IService<Order> {


//    Result submit(Long userId, SubmitOrderGoodsCommand goodsCommand, SubmitOrderAddCommand addCommand);

    Result submit(Long userId, SubmitOrderCommand command);

    Result cancel(Long userId, Long orderNo);

    Result listAll(Long userId, Integer page, Integer size);

    Result listSellerAll(Long userId, Integer page, Integer size);

    String updataOrder(Map<String, String> params);

    Result getDetail(long id, Long orderNo);
}
