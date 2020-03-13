package cn.uorange.assessservice.service.impl;

import cn.hutool.core.lang.Assert;
import cn.uorange.assessservice.command.ChangeAssessCommand;
import cn.uorange.assessservice.command.CreateAssessCommand;
import cn.uorange.assessservice.command.DoAssessCommand;
import cn.uorange.assessservice.service.IAssessService;
import cn.uorange.assessservice.vo.AssessVO;
import cn.uorange.common.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.assessservice.repository.mapper.AssessMapper;
import cn.uorange.assessservice.repository.entity.Assess;

import java.util.Objects;

@Service
@Slf4j
public class AssessServiceImpl extends ServiceImpl<AssessMapper, Assess> implements IAssessService {

    @Override
    public Result createAssess(Long userid, CreateAssessCommand command) {
        Assess assess = command.toObj();
        assess.setUserId(userid);
        this.save(assess);
        log.info("Assess数据创建成功,数据内容:{}", assess);
        return Result.success();
    }

    @Override
    public Result changeAssess(Long id, ChangeAssessCommand command) {
        isExisted(id);
        Assess assess = command.toObj();
        assess.setId(id);
        this.updateById(assess);
        log.info("Assess数据修改成功,数据内容:{}", assess);
        return Result.success();
    }

    private void isExisted(Long id) {
        int count = this.count(new QueryWrapper<Assess>().eq(Assess.ID, id));
        Assert.isTrue(retBool(count), String.format("assessId:%d数据不存在", id));
        log.debug("assessId:{}数据存在", id);
    }

    @Override
    public Result getByVo(Long id) {
        Assess assess = this.getById(id);
        Objects.requireNonNull(assess, "Assess数据不存在");
        log.info("getAssess:{}", assess);
        AssessVO assessVO = new AssessVO(assess);
        return Result.success(assessVO);
    }

    @Override
    public Result listByStatus(Long userId, Integer status, Integer page, Integer size) {
        IPage<Assess> assessIPage = this.page(new Page<>(page, size),
                new QueryWrapper<Assess>().eq(Assess.USER_ID, userId).eq(Assess.STATUS, status));
        log.info("getAssessList: currentPage {} ,pageSize {}", page, size);
        return Result.success(assessIPage);
    }

    @Override
    public Result doAssess(Long id, DoAssessCommand command) {
        isExisted(id);
        Assess assess = new Assess().setId(id).setAssessById(command.getUserId()).setAssessPrice(command.getAssessPrice()).setStatus(Byte.valueOf("1"));
        this.updateById(assess);
        log.info("assess数据更新成功,数据内容:{}", assess);
        return Result.success();
    }

    @Override
    public Result listByUserId(Long userId, Integer page, Integer size) {
        IPage<Assess> assessIPage = this.page(new Page<>(page, size), new QueryWrapper<Assess>().eq(Assess.USER_ID, userId));
        log.info("getAssessList: userId:{} currentPage {} ,pageSize {}", userId, page, size);
        return Result.success(assessIPage);
    }

    @Override
    public Result listByUserIdStatus(Long userId, Long status, Integer page, Integer size) {
        IPage<Assess> assessIPage = this.page(new Page<>(page, size),
                new QueryWrapper<Assess>().eq(Assess.USER_ID, userId).eq(Assess.STATUS, status));
        log.info("getAssessList: userId:{} status:{} currentPage {} ,pageSize {}", userId, status, page, size);
        return Result.success(assessIPage);
    }
}

