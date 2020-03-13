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

@ApiModel(value="角色权限表")
@Data
@Accessors(chain = true)
@TableName(value = "role_permission")
public class RolePermission implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="null")
    private Long id;

    /**
     * 角色 ID
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value="角色 ID")
    private Long roleId;

    /**
     * 权限 ID
     */
    @TableField(value = "permission_id")
    @ApiModelProperty(value="权限 ID")
    private Long permissionId;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String ROLE_ID = "role_id";

    public static final String PERMISSION_ID = "permission_id";
}