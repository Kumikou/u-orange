package cn.uorange.feedbackservice.controller;

import cn.uorange.common.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Kumikou
 * @Date 2019/12/8
 */
@RestController
@RequestMapping("/user")
@Api("feign test")
public class TestController {

    @GetMapping("test")
    public Result get() {
        return Result.success("feign test success");
    }

}
