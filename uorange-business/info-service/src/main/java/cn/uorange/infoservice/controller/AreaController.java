package cn.uorange.infoservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.repository.entity.Area;
import cn.uorange.infoservice.repository.entity.City;
import cn.uorange.infoservice.repository.entity.Street;
import cn.uorange.infoservice.service.IAreaService;
import cn.uorange.infoservice.service.ICityService;
import cn.uorange.infoservice.service.IProvinceService;
import cn.uorange.infoservice.service.IStreetService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/19
 */
@RestController
@RequestMapping("/area")
@Api(tags = "地区获取控制器")
public class AreaController {

    @Resource
    IProvinceService provinceService;
    @Resource
    ICityService cityService;
    @Resource
    IAreaService areaService;
    @Resource
    IStreetService streetService;

    @ApiOperation("获取全部省市")
    @GetMapping("province")
    public Result getPrivince() {
        return Result.success(provinceService.list());
    }

    @ApiOperation("获取某省下全部市")
    @GetMapping("city/{provinceCode}")
    public Result getCity(@PathVariable Integer provinceCode) {
        return Result.success(cityService.list(new QueryWrapper<City>().eq(City.PROVINCE_CODE, provinceCode)));
    }

    @ApiOperation("获取某市下的所有区")
    @GetMapping("area/{cityCode}")
    public Result getArea(@PathVariable Integer cityCode) {
        return Result.success(areaService.list(new QueryWrapper<Area>().eq(Area.CITY_CODE, cityCode)));
    }

    @ApiOperation("获取某区下的街道")
    @GetMapping("street/{areaCode}")
    public Result getStreet(@PathVariable Integer areaCode) {
        return Result.success(streetService.list(new QueryWrapper<Street>().eq(Street.AREA_CODE, areaCode)));
    }

}
