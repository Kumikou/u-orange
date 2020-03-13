package cn.uorange.orderservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "订单表")
@Data
@Accessors(chain = true)
@TableName(value = "order")
public class Order implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    @ApiModelProperty(value = "自增id")
    private Long orderId;

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
     * 金额
     */
    @TableField(value = "money")
    @ApiModelProperty(value = "金额")
    private BigDecimal money;

    /**
     * 用户/买家id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户/买家id")
    private Long userId;

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
     * 订单号
     */
    @TableField(value = "order_no")
    @ApiModelProperty(value = "订单号")
    private String orderNo;

    /**
     * 支付宝交易号
     */
    @TableField(value = "alipay_no")
    @ApiModelProperty(value = "支付宝交易号")
    private String alipayNo;

    /**
     * 订单状态 -2:已关闭 -1:已取消 0:已提交 1:已付款 2:已发货 3:交易成功 4:待评价
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "订单状态 -2:已关闭 -1:已取消 0:已提交 1:已付款 2:已发货 3:交易成功 4:待评价")
    private Integer status;

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

    public static final String ORDER_ID = "order_id";

    public static final String TITLE = "title";

    public static final String PIC = "pic";

    public static final String MONEY = "money";

    public static final String USER_ID = "user_id";

    public static final String SELLER_ID = "seller_id";

    public static final String SELLER_NAME = "seller_name";

    public static final String ORDER_NO = "order_no";

    public static final String ALIPAY_NO = "alipay_no";

    public static final String STATUS = "status";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}