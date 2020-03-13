package cn.uorange.goodservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "类目表")
@Data
@Accessors(chain = true)
@TableName(value = "category")
public class Category implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "自增id")
    private Integer id;

    /**
     * 分类名称
     */
    @TableField(value = "cat_name")
    @ApiModelProperty(value = "分类名称")
    private String catName;

    /**
     * 父id
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value = "父id")
    private Integer parentId;

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

    public static final String ID = "id";

    public static final String CAT_NAME = "cat_name";

    public static final String PARENT_ID = "parent_id";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}