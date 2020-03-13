package cn.uorange.userservice.controller;

import cn.uorange.common.utils.Result;
import cn.uorange.userservice.command.CreateTestCommand;
import cn.uorange.userservice.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Kumikou
 * @Date 2019/12/6
 */
@RestController
@RequestMapping("/test")
@Api(tags = "test控制器")
public class TestController {

    @Resource
    private ITestService testService;

    @ApiOperation("创建Test数据")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result createTest(@Validated @RequestBody CreateTestCommand command) {
        return testService.addTest(command);
    }

    @ApiOperation("删除Test数据")
    @DeleteMapping("{id}")
    @CacheEvict(value = "getTest",key = "#id")
    public Result delTest(@ApiParam("id") @PathVariable("id") Long id) {
        return Result.success(testService.removeById(id));
    }

    @ApiOperation("修改Test")
    @PutMapping("{id}")
    @CacheEvict(value = "getTest",key = "#id")
    public Result changeTest(@ApiParam("id") @PathVariable("id") Long id, @RequestBody @Validated CreateTestCommand command) {
        return testService.changeTest(id, command);
    }

    @ApiOperation("获取Test数据")
    @GetMapping("{id}")
    @Cacheable(value = "getTest", key = "#id")
    public Result getTest(@ApiParam("id") @PathVariable("id") Long id) {
        return testService.getTest(id);
    }

    @ApiOperation("分页获取Test数据")
    @GetMapping("all/{page}/{size}")
    public Result getAllTest(@ApiParam("当前页") @PathVariable("current") Integer page,
                             @ApiParam("分页大小") @PathVariable("size") Integer size) {
        return testService.getAllTest(page, size);
    }

    @ApiOperation("feign demo")
    @GetMapping("feign")
    public Result getByFeign() {
        return testService.feignTest();
    }
}
