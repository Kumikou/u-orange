package cn.uorange.infoservice.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.Pattern;

/**
 * <p>
 * 注册用户命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/25
 */
@Value
@ApiModel
public class RegistCommand {

    @ApiModelProperty("用户名")
    @Pattern(regexp = "^[A-Za-z_@.][A-Za-z0-9_@.]{6,9}$", message = "6-10位之间的字母、下划线、@、.,不能以数字开头")
    public String username;

    @ApiModelProperty("密码")
    @Pattern(regexp = "^[A-Za-z_@.][A-Za-z0-9_@.]{6,9}$", message = "6-10位之间的字母、下划线、@、.,不能以数字开头")
    public String password;

    @ApiModelProperty("手机号")
    @Pattern(regexp = "^1[1-9]{10}", message = "1开头,11位数字的手机号")
    public String phone;

}
