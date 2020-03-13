package cn.uorange.infoservice.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="街道表")
@Data
@TableName(value = "street")
public class Street implements Serializable {
    /**
     * 街道id
     */
    @TableId(value = "street_id", type = IdType.AUTO)
    @ApiModelProperty(value="街道id")
    private Integer streetId;

    /**
     * 街道名称
     */
    @TableField(value = "street_name")
    @ApiModelProperty(value="街道名称")
    private String streetName;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 父区级id
     */
    @TableField(value = "area_code")
    @ApiModelProperty(value="父区级代码")
    private Integer areaCode;

    private static final long serialVersionUID = 1L;

    public static final String STREET_ID = "street_id";

    public static final String STREET_NAME = "street_name";

    public static final String SORT = "sort";

    public static final String AREA_CODE = "area_code";
}