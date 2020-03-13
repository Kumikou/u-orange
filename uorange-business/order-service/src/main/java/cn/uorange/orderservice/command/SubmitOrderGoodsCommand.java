package cn.uorange.orderservice.command;

import cn.hutool.core.bean.BeanUtil;
import cn.uorange.orderservice.repository.entity.Order;
import cn.uorange.orderservice.repository.entity.OrderDetail;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import java.math.BigDecimal;

/**
 * <p>
 * 提交订单商品信息命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/29
 */
@Value
@ApiModel
public class SubmitOrderGoodsCommand {

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "价格")
    private BigDecimal money;

    @ApiModelProperty(value = "卖家id/用户id")
    private Long sellerId;

    public Order toOrder() {
        return BeanUtil.toBean(this, Order.class);
    }

    public OrderDetail toOrderDetail() {
        return BeanUtil.toBean(this, OrderDetail.class);
    }
}
