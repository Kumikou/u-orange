package cn.uorange.infoservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Kumikou
 * @Date 2020/3/23
 */
@Data
@AllArgsConstructor
public class AddressChVO {

    private Long addId;

    private String addDetail;

    private Long userId;

    private Integer streetId;

    private Integer areaId;

    private Integer cityId;

    private Integer provinceId;

    private String name;

    private Long phone;

    private Byte tag;

    private Boolean isDefault;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private Boolean deleted;

    private String provinceName;

    private String cityName;

    private String areaName;

    private String streetName;

}
