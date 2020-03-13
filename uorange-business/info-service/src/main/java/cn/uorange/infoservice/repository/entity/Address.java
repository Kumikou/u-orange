package cn.uorange.infoservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value="街道表")
@Data
@Accessors(chain = true)
@TableName(value = "address")
public class Address implements Serializable {
    /**
     * 地址id
     */
    @TableId(value = "add_id", type = IdType.AUTO)
    @ApiModelProperty(value="地址id")
    private Long addId;

    /**
     * 地址详情
     */
    @TableField(value = "add_detail")
    @ApiModelProperty(value="地址详情")
    private String addDetail;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
     * 街道id
     */
    @TableField(value = "street_id")
    @ApiModelProperty(value="区名称")
    private Integer streetId;

    /**
     * 区id
     */
    @TableField(value = "area_id")
    @ApiModelProperty(value="区名称")
    private Integer areaId;

    /**
     * 市id
     */
    @TableField(value = "city_id")
    @ApiModelProperty(value="市名称")
    private Integer cityId;

    /**
     * 省id
     */
    @TableField(value = "province_id")
    @ApiModelProperty(value="省名称")
    private Integer provinceId;

    /**
     * 收货人姓名
     */
    @TableField(value = "name")
    @ApiModelProperty(value="收货人姓名")
    private String name;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value="手机号")
    private Integer phone;

    /**
     * 标签 1:家 2:公司 3:学校
     */
    @TableField(value = "tag")
    @ApiModelProperty(value="标签 1:家 2:公司 3:学校")
    private Byte tag;

    /**
     * 是否默认 0:否 1:是
     */
    @TableField(value = "is_default")
    @ApiModelProperty(value="是否默认 0:否 1:是")
    private Boolean isDefault;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value="修改时间")
    private LocalDateTime modifyTime;

    /**
     * 逻辑删除
     */
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    @ApiModelProperty(value="逻辑删除")
    @TableLogic
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public static final String ADD_ID = "add_id";

    public static final String ADD_DETAIL = "add_detail";

    public static final String USER_ID = "user_id";

    public static final String STREET_ID = "street_id";

    public static final String AREA_ID = "area_id";

    public static final String CITY_ID = "city_id";

    public static final String PROVINCE_ID = "province_id";

    public static final String NAME = "name";

    public static final String PHONE = "phone";

    public static final String TAG = "tag";

    public static final String IS_DEFAULT = "is_default";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String DELETED = "deleted";
}