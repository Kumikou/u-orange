package cn.uorange.assessservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "评估表")
@Data
@Accessors(chain = true)
@TableName(value = "assess")
public class Assess implements Serializable {
    /**
     * 评估id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "评估id")
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 物品描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "物品描述")
    private String description;

    /**
     * 图片 最多五张
     */
    @TableField(value = "pic")
    @ApiModelProperty(value = "图片 最多五张")
    private String pic;

    /**
     * 物品购买时间
     */
    @TableField(value = "buy_time")
    @ApiModelProperty(value = "物品购买时间")
    private LocalDateTime buyTime;

    /**
     * 物品新旧程度
     */
    @TableField(value = "degree")
    @ApiModelProperty(value = "物品新旧程度")
    private BigDecimal degree;

    /**
     * 包装状态
     */
    @TableField(value = "pack_status")
    @ApiModelProperty(value = "包装状态")
    private String packStatus;

    /**
     * 物品状态 0:未评估 1:已评估 2:无法评估
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "物品状态 0:未评估 1:已评估 2:无法评估")
    private Byte status;

    /**
     * 评估价格
     */
    @TableField(value = "assess_price")
    @ApiModelProperty(value = "评估价格")
    private BigDecimal assessPrice;

    /**
     * 评估人
     */
    @TableField(value = "assess_by_id")
    @ApiModelProperty(value = "评估人")
    private Long assessById;

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

    public static final String USER_ID = "user_id";

    public static final String DESCRIPTION = "description";

    public static final String PIC = "pic";

    public static final String BUY_TIME = "buy_time";

    public static final String DEGREE = "degree";

    public static final String PACK_STATUS = "pack_status";

    public static final String STATUS = "status";

    public static final String ASSESS_PRICE = "assess_price";

    public static final String ASSESS_BY_ID = "assess_by_id";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}