package cn.uorange.infoservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value="收藏表")
@Data
@Accessors(chain = true)
@TableName(value = "collect_goods")
public class CollectGoods implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="自增id")
    private Long id;

    /**
     * 商品id
     */
    @TableField(value = "goods_id")
    @ApiModelProperty(value="商品id")
    private Long goodsId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value="修改时间")
    private LocalDateTime modifyTime;

    /**
     * 逻辑删除
     */
    @TableField(value = "deleted",fill = FieldFill.INSERT)
    @ApiModelProperty(value="逻辑删除")
    @TableLogic
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String GOODS_ID = "goods_id";

    public static final String USER_ID = "user_id";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}