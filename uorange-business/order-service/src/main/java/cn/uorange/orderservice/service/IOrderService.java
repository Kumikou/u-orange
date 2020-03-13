package cn.uorange.orderservice.service;

import cn.uorange.common.utils.Result;
import cn.uorange.orderservice.command.SubmitOrderAddCommand;
import cn.uorange.orderservice.command.SubmitOrderGoodsCommand;
import cn.uorange.orderservice.repository.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IOrderService extends IService<Order> {


    Result submit(Long userId, SubmitOrderGoodsCommand goodsCommand, SubmitOrderAddCommand addCommand);

    Result cancel(Long userId, Long orderNo);

    Result listAll(Long userId, Integer page, Integer size);

    Result listSellerAll(Long userId, Integer page, Integer size);
}
