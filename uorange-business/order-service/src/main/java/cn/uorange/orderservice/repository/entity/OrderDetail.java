package cn.uorange.orderservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "订单详情表")
@Data
@Accessors(chain = true)
@TableName(value = "order_detail")
public class OrderDetail implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "自增id")
    private Long id;

    /**
     * 商品id
     */
    @TableField(value = "goods_id")
    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    /**
     * 商品标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "商品标题")
    private String title;

    /**
     * 商品图片
     */
    @TableField(value = "pic")
    @ApiModelProperty(value = "商品图片")
    private String pic;

    /**
     * 卖家id
     */
    @TableField(value = "seller_id")
    @ApiModelProperty(value = "卖家id")
    private Long sellerId;

    /**
     * 卖家昵称
     */
    @TableField(value = "seller_name")
    @ApiModelProperty(value = "卖家昵称")
    private String sellerName;

    /**
     * 金额
     */
    @TableField(value = "money")
    @ApiModelProperty(value = "金额")
    private BigDecimal money;

    /**
     * 交易类型 0:在线支付 1:货到付款
     */
    @TableField(value = "pay_type")
    @ApiModelProperty(value = "交易类型 0:在线支付 1:货到付款")
    private Integer payType;

    /**
     * 付款时间
     */
    @TableField(value = "pay_time")
    @ApiModelProperty(value = "付款时间")
    private LocalDateTime payTime;

    /**
     * 发货时间
     */
    @TableField(value = "deliver_time")
    @ApiModelProperty(value = "发货时间")
    private LocalDateTime deliverTime;

    /**
     * 成交时间
     */
    @TableField(value = "deal_time")
    @ApiModelProperty(value = "成交时间")
    private LocalDateTime dealTime;

    /**
     * 用户/买家id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户/买家id")
    private Long userId;

    /**
     * 订单id 外键
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value = "订单id 外键")
    private Long orderId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

    /**
     * 逻辑删除
     */
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String TITLE = "title";

    public static final String PIC = "pic";

    public static final String SELLER_ID = "seller_id";

    public static final String SELLER_NAME = "seller_name";

    public static final String MONEY = "money";

    public static final String PAY_TYPE = "pay_type";

    public static final String PAY_TIME = "pay_time";

    public static final String DELIVER_TIME = "deliver_time";

    public static final String DEAL_TIME = "deal_time";

    public static final String USER_ID = "user_id";

    public static final String ORDER_ID = "order_id";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}