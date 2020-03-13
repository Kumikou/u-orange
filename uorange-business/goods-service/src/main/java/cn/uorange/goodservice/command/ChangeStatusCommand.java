package cn.uorange.goodservice.command;

import cn.hutool.core.bean.BeanUtil;
import cn.uorange.goodservice.repository.entity.Goods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 修改商品状态命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/25
 */
@Value
@ApiModel
public class ChangeStatusCommand {

    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id不能为空")
    private Long id;

    @ApiModelProperty(value = "商品状态 0:已发布 1:已下架 2:已卖出")
    @NotNull(message = "商品状态不能为空")
    private Byte status;

    public Goods toObj() {
        return BeanUtil.toBean(this, Goods.class);
    }

}
