package cn.uorange.infoservice.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="市表")
@Data
@TableName(value = "city")
public class City implements Serializable {
    /**
     * 市id
     */
    @TableId(value = "city_id", type = IdType.AUTO)
    @ApiModelProperty(value="市id")
    private Integer cityId;

    /**
     * 市名称
     */
    @TableField(value = "city_name")
    @ApiModelProperty(value="市名称")
    private String cityName;

    /**
     * 市代码
     */
    @TableField(value = "city_code")
    @ApiModelProperty(value="市代码")
    private Integer cityCode;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 父级省代码
     */
    @TableField(value = "province_code")
    @ApiModelProperty(value="父级省代码")
    private Integer provinceCode;

    private static final long serialVersionUID = 1L;

    public static final String CITY_ID = "city_id";

    public static final String CITY_NAME = "city_name";

    public static final String CITY_CODE = "city_code";

    public static final String SORT = "sort";

    public static final String PROVINCE_CODE = "province_code";
}