package cn.uorange.assessservice.command;

import cn.hutool.core.bean.BeanUtil;
import cn.uorange.assessservice.repository.entity.Assess;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 修改评估申请命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/16
 */
@Value
@ApiModel
public class ChangeAssessCommand {

    @ApiModelProperty(value = "物品描述")
    @NotBlank(message = "描述不能为空")
    private String description;

    @ApiModelProperty(value = "图片 最多五张")
    @NotBlank(message = "图片不能为空")
    private String pic;

    @ApiModelProperty(value = "物品购买时间")
    private LocalDateTime buyTime;

    @ApiModelProperty(value = "物品新旧程度")
    private BigDecimal degree;

    @ApiModelProperty(value = "包装状态")
    private String packStatus;

    public Assess toObj() {
        return BeanUtil.toBean(this, Assess.class);
    }

}
