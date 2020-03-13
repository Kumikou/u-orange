package cn.uorange.auctionservice.command;

import cn.hutool.core.bean.BeanUtil;
import cn.uorange.auctionservice.repository.entity.Item;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 创建拍卖品命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/16
 */
@Value
public class CreateItemCommand {

    @ApiModelProperty(value = "拍卖发起人id")
    @NotNull(message = "发起人ID不能为空")
    private Long itemOwnerId;

    @ApiModelProperty(value = "拍卖标题")
    @NotBlank(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value = "拍卖品描述")
    @NotBlank(message = "描述不能为空")
    private String description;

    @ApiModelProperty(value = "拍卖品图片 最多五张")
    private String pic;

    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "起始价格")
    @NotNull(message = "起始价格不能为空")
    private BigDecimal originPrice;

    @ApiModelProperty(value = "拍卖品类别id")
    @NotNull(message = "类别ID不能为空")
    private Integer categoryId;

    public Item toObj() {
        return BeanUtil.toBean(this, Item.class);
    }
}
