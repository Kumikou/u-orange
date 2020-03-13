package cn.uorange.orderservice.service.impl;

import cn.uorange.common.utils.Result;
import cn.uorange.orderservice.command.SubmitOrderAddCommand;
import cn.uorange.orderservice.command.SubmitOrderGoodsCommand;
import cn.uorange.orderservice.enums.OrderStatus;
import cn.uorange.orderservice.feign.GoodsFeign;
import cn.uorange.orderservice.repository.entity.OrderDelivery;
import cn.uorange.orderservice.repository.entity.OrderDetail;
import cn.uorange.orderservice.service.IOrderDeliveryService;
import cn.uorange.orderservice.service.IOrderDetailService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.orderservice.repository.mapper.OrderMapper;
import cn.uorange.orderservice.repository.entity.Order;
import cn.uorange.orderservice.service.IOrderService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Resource
    GoodsFeign goodsFeign;

    @Resource
    IOrderDetailService detailService;

    @Resource
    IOrderDeliveryService deliveryService;

    /**
     * <p>
     * 1.获取商品信息
     * 2.判断商品是否上架，价格是否一致
     * 3.生成订单信息
     * 4.生成订单详情信息
     * 5.生成订单配送信息
     * </P>
     *
     * @param userId       用户id
     * @param goodsCommand 商品信息
     * @param addCommand   地址信息
     * @return 结果
     */
    @Override
    @Transactional
    public Result submit(Long userId, SubmitOrderGoodsCommand goodsCommand, SubmitOrderAddCommand addCommand) {
        // 获取商品信息
        Result<JSONObject> res = goodsFeign.queryGoodsById(goodsCommand.getGoodsId());
        JSONObject goodsJson = res.getData();
        if (Objects.isNull(goodsJson))
            return Result.errorMsg("服务繁忙,请稍后重试");

        // 检查商品状态
        if (goodsJson.getInteger("status") != 0)
            return Result.errorMsg("该商品已下架或删除");

        // 检查价格
        if (goodsCommand.getMoney().compareTo(goodsJson.getBigDecimal("price")) != 0)
            return Result.errorMsg("价格出错");

        // 生成订单信息
        Order order = goodsCommand.toOrder();
        order.setUserId(userId)
                .setSellerId(goodsCommand.getSellerId())
                .setMoney(goodsCommand.getMoney())
                .setOrderNo(generatNo());
        this.save(order);
        log.info("订单数据创建成功,数据内容:{}", order);

        // 获取订单数据主键
        Long orderId = order.getOrderId();

        // 生成订单详情信息
        OrderDetail detail = goodsCommand.toOrderDetail();
        detail.setUserId(userId).setOrderId(orderId);
        detailService.save(detail);
        log.info("订单详情数据创建成功,数据内容:{}", detail);

        // 生成订单配送信息
        OrderDelivery delivery = addCommand.toObj();
        delivery.setOrderId(orderId);
        deliveryService.save(delivery);
        log.info("订单配送数据创建成功,数据内容:{}", delivery);

        return Result.successMsg("订单提交成功!");
    }

    private String generatNo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String dateStr = formatter.format(LocalDateTime.now());
        return dateStr + new Random().nextInt(900000) + 100000;
    }

    @Override
    public Result cancel(Long userId, Long orderNo) {
        Order order = this.getOne(new QueryWrapper<Order>().eq(Order.USER_ID, userId).eq(Order.ORDER_NO, orderNo));
        if (Objects.isNull(order) || order.getStatus() != 0)
            return Result.success("当前订单不可取消");
        order.setStatus(OrderStatus.CANCELED.getCode());
        this.updateById(order);
        log.info("订单取消成功,数据内容:{}", order);
        return Result.success();
    }

    @Override
    public Result listAll(Long userId, Integer page, Integer size) {
        IPage orderPage = this.page(new Page<>(page, size), new QueryWrapper<Order>().eq(Order.USER_ID, userId));
        log.info("订单列表数据查询成功,买家方用户id:{}", userId);
        return Result.success(orderPage);
    }

    @Override
    public Result listSellerAll(Long userId, Integer page, Integer size) {
        IPage orderPage = this.page(new Page<>(page, size), new QueryWrapper<Order>().eq(Order.SELLER_ID, userId));
        log.info("订单列表数据查询成功,卖家方用户id:{}", userId);
        return Result.success(orderPage);
    }
}

