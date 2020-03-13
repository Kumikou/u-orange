package cn.uorange.goodservice.command;

import cn.hutool.core.bean.BeanUtil;
import cn.uorange.goodservice.repository.entity.Goods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>
 * 修改商品描述命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/26
 */
@Value
@ApiModel
public class ChangeGoodsCommand {

    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id不能为空")
    private Long id;

    @ApiModelProperty(value = "标题")
    @NotBlank(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value = "描述")
    @NotBlank(message = "描述不能为空")
    private String description;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "价格")
    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @ApiModelProperty(value = "所属类别id")
    @NotNull(message = "所属类别id不能为空")
    private Integer categoryId;

    @ApiModelProperty(value = "是否全新 0:否 1:是")
    private Boolean isNew;

    @ApiModelProperty(value = "是否包邮 0:否 1:是")
    private Boolean isFreeFare;

    public Goods toObj() {
        return BeanUtil.toBean(this, Goods.class);
    }

}
