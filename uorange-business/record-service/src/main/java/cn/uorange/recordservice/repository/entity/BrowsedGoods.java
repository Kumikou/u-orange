package cn.uorange.recordservice.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value="商品浏览次数记录表")
@Data
@Accessors(chain = true)
@TableName(value = "browsed_goods_record")
public class BrowsedGoods implements Serializable {
    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="商品id")
    private Long id;

    /**
     * 商品被浏览次数
     */
    @TableField(value = "browsed_time")
    @ApiModelProperty(value="商品被浏览次数")
    private Integer browsedTime;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String BROWSED_TIME = "browsed_time";
}