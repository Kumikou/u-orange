package cn.uorange.recordservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "拍卖品价格记录表")
@Data
@Accessors(chain = true)
@TableName(value = "au_item_price_record")
public class ItemPrice implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "自增id")
    private Long id;

    /**
     * 拍卖品id
     */
    @TableId(value = "item_id", type = IdType.INPUT)
    @ApiModelProperty(value = "拍卖品id")
    private Long itemId;

    /**
     * 拍卖人/出价人
     */
    @TableField(value = "current_owner_id")
    @ApiModelProperty(value = "拍卖人/出价人")
    private Long currentOwnerId;

    /**
     * 价格
     */
    @TableField(value = "current_price")
    @ApiModelProperty(value = "价格")
    private BigDecimal currentPrice;

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

    public static final String ITEM_ID = "item_id";

    public static final String CURRENT_OWNER_ID = "current_owner_id";

    public static final String CURRENT_PRICE = "current_price";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}