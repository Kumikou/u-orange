package cn.uorange.orderservice.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import java.math.BigDecimal;

/**
 * @Author Kumikou
 * @Date 2020/3/24
 */
@Value
@ApiModel
public class SubmitOrderCommand {
    @ApiModelProperty(value = "收货人名称")
    private String name;

    @ApiModelProperty(value = "收货人手机号")
    private String phone;

    @ApiModelProperty(value = "地址详情")
    private String addressDetail;

    @ApiModelProperty(value = "街道名称")
    private String street;

    @ApiModelProperty(value = "区域名称")
    private String area;

    @ApiModelProperty(value = "市名称")
    private String city;

    @ApiModelProperty(value = "省名称")
    private String province;

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
}
