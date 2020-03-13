package cn.uorange.infoservice.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="区表")
@Data
@TableName(value = "area")
public class Area implements Serializable {
    /**
     * 区域id
     */
    @TableId(value = "area_id", type = IdType.AUTO)
    @ApiModelProperty(value="区域id")
    private Integer areaId;

    /**
     * 区域名称
     */
    @TableField(value = "area_name")
    @ApiModelProperty(value="区域名称")
    private String areaName;

    /**
     * 区域编码
     */
    @TableField(value = "area_code")
    @ApiModelProperty(value="区域编码")
    private Integer areaCode;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 父级市代码
     */
    @TableField(value = "city_code")
    @ApiModelProperty(value="父级市代码")
    private Integer cityCode;

    private static final long serialVersionUID = 1L;

    public static final String AREA_ID = "area_id";

    public static final String AREA_NAME = "area_name";

    public static final String AREA_CODE = "area_code";

    public static final String SORT = "sort";

    public static final String CITY_CODE = "city_code";
}