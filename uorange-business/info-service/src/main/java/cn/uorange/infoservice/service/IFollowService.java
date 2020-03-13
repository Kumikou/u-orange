package cn.uorange.infoservice.service;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.repository.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IFollowService extends IService<Follow> {


    Result addFollow(Long userId, Long targetId);

    Result delFollow(Long userId, Long targetId);

    Result listFollower(Long userId, Integer page, Integer size);

    Result listFollowed(Long userId, Integer page, Integer size);
}
