package cn.uorange.userservice.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value="权限表")
@Data
@Accessors(chain = true)
@TableName(value = "permission")
public class Permission implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="null")
    private Long id;

    /**
     * 父权限
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value="父权限")
    private Long parentId;

    /**
     * 权限名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value="权限名称")
    private String name;

    /**
     * 权限英文名称
     */
    @TableField(value = "enname")
    @ApiModelProperty(value="权限英文名称")
    private String enname;

    /**
     * 授权路径
     */
    @TableField(value = "url")
    @ApiModelProperty(value="授权路径")
    private String url;

    /**
     * 备注
     */
    @TableField(value = "description")
    @ApiModelProperty(value="备注")
    private String description;

    @TableField(value = "created")
    @ApiModelProperty(value="null")
    private Date created;

    @TableField(value = "updated")
    @ApiModelProperty(value="null")
    private Date updated;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String PARENT_ID = "parent_id";

    public static final String NAME = "name";

    public static final String ENNAME = "enname";

    public static final String URL = "url";

    public static final String DESCRIPTION = "description";

    public static final String CREATED = "created";

    public static final String UPDATED = "updated";
}