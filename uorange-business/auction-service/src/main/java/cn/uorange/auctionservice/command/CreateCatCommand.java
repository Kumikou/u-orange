package cn.uorange.auctionservice.command;

import cn.hutool.core.bean.BeanUtil;
import cn.uorange.auctionservice.repository.entity.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 创建分类命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/16
 */
@Value
public class CreateCatCommand {
    @ApiModelProperty("分类父ID")
    @NotNull(message = "分类父ID不能为空")
    private Integer parentId;

    @ApiModelProperty("分类名称")
    @NotBlank(message = "分类名称不能为空")
    private String catName;

    public Category toObj() {
        return BeanUtil.toBean(this, Category.class);
    }
}
