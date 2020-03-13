package cn.uorange.infoservice.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="省表")
@Data
@TableName(value = "province")
public class Province implements Serializable {
    /**
     * 省id
     */
    @TableId(value = "province_id", type = IdType.AUTO)
    @ApiModelProperty(value="省id")
    private Integer provinceId;

    /**
     * 省名称
     */
    @TableField(value = "province_name")
    @ApiModelProperty(value="省名称")
    private String provinceName;

    /**
     * 省编号
     */
    @TableField(value = "privince_code")
    @ApiModelProperty(value="省编号")
    private Integer privinceCode;

    /**
     * 排序号
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序号")
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public static final String PROVINCE_ID = "province_id";

    public static final String PROVINCE_NAME = "province_name";

    public static final String PRIVINCE_CODE = "privince_code";

    public static final String SORT = "sort";
}