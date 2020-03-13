package cn.uorange.userservice.command;

import cn.hutool.core.bean.BeanUtil;
import cn.uorange.userservice.repository.entity.Test;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *     创建或修改Test命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/6
 */
@Value
@ApiModel
public class CreateTestCommand {

    @ApiModelProperty("测试内容")
    @NotBlank(message = "测试内容不能为空")
    public String content;

    public Test toObj() {
        return BeanUtil.toBean(this, Test.class);
    }

}
