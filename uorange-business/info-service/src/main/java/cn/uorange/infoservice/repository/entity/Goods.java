package cn.uorange.infoservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "被收藏的商品表")
@Data
@Accessors(chain = true)
@TableName(value = "goods")
public class Goods implements Serializable {
    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "商品id")
    private Long id;

    /**
     * 标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "标题")
    private String title;

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
     * 商品状态 0:已发布 1:未发布/已下架 2:已卖出
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "商品状态 0:已发布 1:未发布/已下架 2:已卖出")
    private Byte status;

    /**
     * 用户/卖家id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户/卖家id")
    private Long userId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

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

    public static final String PIC = "pic";

    public static final String PRICE = "price";

    public static final String STATUS = "status";

    public static final String USER_ID = "user_id";

    public static final String CREATE_TIME = "create_time";

    public static final String DELETED = "deleted";
}