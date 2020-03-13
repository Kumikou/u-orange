package cn.uorange.infoservice.command;

import cn.hutool.core.bean.BeanUtil;
import cn.uorange.infoservice.repository.entity.UserInfo;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 修改用户信息命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/19
 */
@Value
@ApiModel
public class ChangeInfoCommand {

    @ApiModelProperty(value = "用户昵称")
    @NotBlank(message = "用户昵称不能为空")
    private String username;

    @ApiModelProperty(value = "用户性别 0:保密 1:男 2:女")
    @NotNull(message = "性别不能为空")
    private Byte sex;

    public UserInfo toObj() {
        return BeanUtil.toBean(this, UserInfo.class);
    }

}
