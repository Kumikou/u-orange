package cn.uorange.userservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "用户表")
@Data
@Accessors(chain = true)
@TableName(value = "user")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "null")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码，加密存储
     */
    @TableField(value = "password")
    @ApiModelProperty(value = "密码，加密存储")
    private String password;

    /**
     * 注册手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "注册手机号")
    private String phone;

    /**
     * 注册邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "注册邮箱")
    private String email;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String PHONE = "phone";

    public static final String EMAIL = "email";

    public static final String CREATED = "created";

    public static final String UPDATED = "updated";
}