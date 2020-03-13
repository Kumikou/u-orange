package cn.uorange.userservice.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value="用户角色表")
@Data
@Accessors(chain = true)
@TableName(value = "user_role")
public class UserRole implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="null")
    private Long id;

    /**
     * 用户 ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="用户 ID")
    private Long userId;

    /**
     * 角色 ID
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value="角色 ID")
    private Long roleId;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String ROLE_ID = "role_id";
}