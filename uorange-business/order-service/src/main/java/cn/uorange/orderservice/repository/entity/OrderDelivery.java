package cn.uorange.orderservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "订单配送表")
@Data
@Accessors(chain = true)
@TableName(value = "order_delivery")
public class OrderDelivery implements Serializable {
    /**
     * 订单配送id
     */
    @TableId(value = "delivery_id", type = IdType.AUTO)
    @ApiModelProperty(value = "订单配送id")
    private Long deliveryId;

    /**
     * 收货人名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "收货人名称")
    private String name;

    /**
     * 收货人手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "收货人手机号")
    private String phone;

    /**
     * 地址详情
     */
    @TableField(value = "address_detail")
    @ApiModelProperty(value = "地址详情")
    private String addressDetail;

    /**
     * 街道名称
     */
    @TableField(value = "street")
    @ApiModelProperty(value = "街道名称")
    private String street;

    /**
     * 区域名称
     */
    @TableField(value = "area")
    @ApiModelProperty(value = "区域名称")
    private String area;

    /**
     * 市名称
     */
    @TableField(value = "city")
    @ApiModelProperty(value = "市名称")
    private String city;

    /**
     * 省名称
     */
    @TableField(value = "province")
    @ApiModelProperty(value = "省名称")
    private String province;

    /**
     * 订单表id 外键
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value = "订单表id 外键")
    private Long orderId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT_UPDATE)
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

    public static final String DELIVERY_ID = "delivery_id";

    public static final String NAME = "name";

    public static final String PHONE = "phone";

    public static final String ADDRESS_DETAIL = "address_detail";

    public static final String STREET = "street";

    public static final String AREA = "area";

    public static final String CITY = "city";

    public static final String PROVINCE = "province";

    public static final String ORDER_ID = "order_id";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}