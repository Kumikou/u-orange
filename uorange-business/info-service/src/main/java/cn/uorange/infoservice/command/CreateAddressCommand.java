package cn.uorange.infoservice.command;

import cn.hutool.core.bean.BeanUtil;
import cn.uorange.infoservice.repository.entity.Address;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 创建或修改地址命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/19
 */
@Value
@ApiModel
public class CreateAddressCommand {

    @ApiModelProperty(value = "详细地址")
    @NotBlank(message = "详细地址不能为空")
    private String addDetail;

    @ApiModelProperty(value = "街道id")
    private Integer streetId;

    @ApiModelProperty(value = "区id")
    private Integer areaId;

    @ApiModelProperty(value = "市id")
    @NotNull(message = "市id不能为空")
    private Integer cityId;

    @ApiModelProperty(value = "省id")
    @NotNull(message = "省id不能为空")
    private Integer provinceId;

    @ApiModelProperty(value = "收货人姓名")
    @NotNull(message = "收货人不能为空")
    private String name;

    @ApiModelProperty(value = "手机号")
    @NotNull(message = "手机号不能为空")
    private Integer phone;

    @ApiModelProperty(value = "标签 1:家 2:公司 3:学校")
    private Byte tag;

    @ApiModelProperty(value = "是否默认 0:否 1:是")
    @NotNull(message = "是否默认不能为空")
    private Boolean isDefault;

    public Address toObj() {
        return BeanUtil.toBean(this, Address.class);
    }
}
