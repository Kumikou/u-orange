package cn.uorange.infoservice.vo;

import cn.uorange.infoservice.repository.entity.Address;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

/**
 * <p>
 *
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/19
 */
@Value
public class AddressVO {

    private String addDetail;

    private Integer streetId;

    private Integer areaId;

    private Integer cityId;

    private Integer provinceId;

    private String name;

    private Long phone;

    private Byte tag;

    private Boolean isDefault;

    public AddressVO(Address address) {
        this.addDetail = address.getAddDetail();
        this.streetId = address.getStreetId();
        this.areaId = address.getAreaId();
        this.cityId = address.getCityId();
        this.provinceId = address.getProvinceId();
        this.name = address.getName();
        this.phone = address.getPhone();
        this.tag = address.getTag();
        this.isDefault = address.getIsDefault();
    }
}
