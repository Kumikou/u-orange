package cn.uorange.assessservice.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>
 * 添加评估价格命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/16
 */
@Value
@ApiModel
public class DoAssessCommand {

    @ApiModelProperty("评估人ID")
    @NotNull(message = "评估人ID不能为空")
    private Long userId;

    @ApiModelProperty("估价")
    @NotNull(message = "估价不能为空")
    private BigDecimal assessPrice;
}
