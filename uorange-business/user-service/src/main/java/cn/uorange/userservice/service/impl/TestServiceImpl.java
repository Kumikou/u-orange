package cn.uorange.userservice.service.impl;

import cn.hutool.core.lang.Assert;
import cn.uorange.common.utils.Result;
import cn.uorange.userservice.command.CreateTestCommand;
import cn.uorange.userservice.feign.FeedbackFeign;
import cn.uorange.userservice.repository.entity.Test;
import cn.uorange.userservice.repository.mapper.TestMapper;
import cn.uorange.userservice.service.ITestService;
import cn.uorange.userservice.vo.TestVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;


/**
 * 测试服务实现类
 *
 * @author Kumikou
 */
@Service
@Slf4j
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Resource
    FeedbackFeign feedbackFeign;

    /**
     * 增
     *
     * @param command 需创建的内容
     * @return 创建结果
     */
    @Override
    public Result addTest(CreateTestCommand command) {
        Test test = command.toObj();
        this.save(test);
        log.info("test数据创建成功,数据内容:{}", test);
        return Result.success();
    }

    /**
     * 改
     * @param id 测试ID
     * @param command 修改的内容
     * @return 修改结果
     */
    @Override
    public Result changeTest(Long id, CreateTestCommand command) {
        existedTest(id);
        Test test = command.toObj();
        test.setId(id);
        this.updateById(test);
        log.info("test数据修改成功,数据内容:{}", test);
        return Result.success();
    }

    private void existedTest(Long id) {
        int count = this.count(new QueryWrapper<Test>().eq(Test.ID, id));
        Assert.isTrue(retBool(count), String.format("testId:%d数据不存在", id));
        log.debug("testId:{}数据存在", id);
    }

    /**
     * 查
     *
     * @param id 测试ID
     * @return Test数据
     */
    @Override
    public Result getTest(Long id) {
        Test testById = this.getById(id);
        Objects.requireNonNull(testById, "Test数据不存在");
        log.debug("getTest:{}", testById);
        TestVO testVO = new TestVO(testById);
        return Result.success(testVO);
    }

    /**
     * 查/分页
     *
     * @param page 当前分页
     * @param size  分页页数
     * @return 测试列表
     */
    @Override
    public Result getAllTest(Integer page, Integer size) {
        IPage<Test> testIPage = this.page(new Page<>(page, size));
        log.info("getAllTest: currentPage {} , pageSize {}", page, size);
        return Result.success(testIPage);
    }

    @Override
    public Result feignTest() {
        return feedbackFeign.get();
    }
}


