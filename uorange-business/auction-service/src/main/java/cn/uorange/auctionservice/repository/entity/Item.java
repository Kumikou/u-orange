package cn.uorange.auctionservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "拍卖品表")
@Data
@Accessors(chain = true)
@TableName(value = "auction_items")
public class Item implements Serializable {
    /**
     * 拍卖品自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "拍卖品自增id")
    private Long id;

    /**
     * 拍卖发起人id
     */
    @TableField(value = "item_owner_id")
    @ApiModelProperty(value = "拍卖发起人id")
    private Long itemOwnerId;

    /**
     * 拍卖标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "拍卖标题")
    private String title;

    /**
     * 拍卖品描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "拍卖品描述")
    private String description;

    /**
     * 拍卖品图片 最多五张
     */
    @TableField(value = "pic")
    @ApiModelProperty(value = "拍卖品图片 最多五张")
    private String pic;

    /**
     * 开始时间
     */
    @TableField(value = "start_time")
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endTime;

    /**
     * 起始价格
     */
    @TableField(value = "origin_price")
    @ApiModelProperty(value = "起始价格")
    private BigDecimal originPrice;

    /**
     * 当前价格
     */
    @TableField(value = "current_price")
    @ApiModelProperty(value = "当前价格")
    private BigDecimal currentPrice;

    /**
     * 当前价格拍卖人
     */
    @TableField(value = "current_owner_id")
    @ApiModelProperty(value = "当前价格拍卖人")
    private Long currentOwnerId;

    /**
     * 拍卖品类别id
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value = "拍卖品类别id")
    private Integer categoryId;

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

    public static final String ITEM_OWNER_ID = "item_owner_id";

    public static final String TITLE = "title";

    public static final String DESCRIPTION = "description";

    public static final String PIC = "pic";

    public static final String START_TIME = "start_time";

    public static final String END_TIME = "end_time";

    public static final String ORIGIN_PRICE = "origin_price";

    public static final String CURRENT_PRICE = "current_price";

    public static final String COL_CURRENT_OWNER_ID = "current_owner_id";

    public static final String CATEGORY_ID = "category_id";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}