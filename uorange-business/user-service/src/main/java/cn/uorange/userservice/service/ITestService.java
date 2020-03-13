package cn.uorange.userservice.service;


import cn.uorange.common.utils.Result;
import cn.uorange.userservice.command.CreateTestCommand;
import cn.uorange.userservice.repository.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 测试服务类
 */
public interface ITestService extends IService<Test> {


    Result getTest(Long id);

    Result addTest(CreateTestCommand command);

    Result changeTest(Long id, CreateTestCommand command);

    Result getAllTest(Integer page, Integer size);

    Result feignTest();

}


