package cn.uorange.infoservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "用户信息表")
@Data
@Accessors(chain = true)
@TableName(value = "user_info")
public class UserInfo implements Serializable {
    /**
     * 用户信息主键id
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    @ApiModelProperty(value = "用户信息主键id")
    private Long userId;

    /**
     * 用户昵称
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户昵称")
    private String username;

    /**
     * 用户性别 0:保密 1:男 2:女
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "用户性别 0:保密 1:男 2:女")
    private Byte sex;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 用户头像
     */
    @TableField(value = "img")
    @ApiModelProperty(value = "用户头像")
    private String img;

    /**
     * 用户状态 0:正常 1:封禁
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "用户状态 0:正常 1:封禁")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

    /**
     * 逻辑删除
     */
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public static final String USER_ID = "user_id";

    public static final String USERNAME = "username";

    public static final String SEX = "sex";

    public static final String PHONE = "phone";

    public static final String IMG = "img";

    public static final String STATUS = "status";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}