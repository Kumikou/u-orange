package cn.uorange.goodservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "商品表")
@Data
@Accessors(chain = true)
@TableName(value = "goods")
public class Goods implements Serializable {
    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "商品id")
    private Long id;

    /**
     * 标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 图片
     */
    @TableField(value = "pic")
    @ApiModelProperty(value = "图片")
    private String pic;

    /**
     * 价格
     */
    @TableField(value = "price")
    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    /**
     * 商品状态 0:已发布 1:已下架 2:已卖出
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "商品状态 0:已发布 1:已下架 2:已卖出")
    private Byte status;

    /**
     * 卖家id/用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "卖家id/用户id")
    private Long userId;

    /**
     * 所属类别id
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value = "所属类别id")
    private Integer categoryId;

    /**
     * 是否全新 0:否 1:是
     */
    @TableField(value = "is_new")
    @ApiModelProperty(value = "是否全新 0:否 1:是")
    private Boolean isNew;

    /**
     * 是否包邮 0:否 1:是
     */
    @TableField(value = "is_free_fare")
    @ApiModelProperty(value = "是否包邮 0:否 1:是")
    private Boolean isFreeFare;

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

    public static final String TITLE = "title";

    public static final String DESCRIPTION = "description";

    public static final String PIC = "pic";

    public static final String PRICE = "price";

    public static final String STATUS = "status";

    public static final String USER_ID = "user_id";

    public static final String CATEGORY_ID = "category_id";

    public static final String IS_NEW = "is_new";

    public static final String IS_FREE_FARE = "is_free_fare";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}