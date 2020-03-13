package cn.uorange.orderservice.command;

import cn.hutool.core.bean.BeanUtil;
import cn.uorange.orderservice.repository.entity.OrderDelivery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

/**
 * <p>
 * 提交订单收货地址信息命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/29
 */
@Value
@ApiModel
public class SubmitOrderAddCommand {

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

    public OrderDelivery toObj() {
        return BeanUtil.toBean(this, OrderDelivery.class);
    }

}
