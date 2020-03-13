package cn.uorange.assessservice.service;

import cn.uorange.assessservice.command.ChangeAssessCommand;
import cn.uorange.assessservice.command.CreateAssessCommand;
import cn.uorange.assessservice.command.DoAssessCommand;
import cn.uorange.assessservice.repository.entity.Assess;
import cn.uorange.common.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IAssessService extends IService<Assess> {


    Result createAssess(Long userid, CreateAssessCommand command);

    Result changeAssess(Long id, ChangeAssessCommand command);

    Result getByVo(Long id);

    Result listByStatus(Long userId, Integer status, Integer page, Integer size);

    Result doAssess(Long id, DoAssessCommand command);

    Result listByUserId(Long userId, Integer page, Integer size);

    Result listByUserIdStatus(Long userId, Long status, Integer page, Integer size);
}

