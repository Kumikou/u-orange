package cn.uorange.userservice.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *     登录命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2020/2/18
 */
@Value
@ApiModel
public class LoginCommand {

    @ApiModelProperty("用户名")
    @NotBlank
    public String username;

    @ApiModelProperty("密码")
    @NotBlank
    public String password;
}
