package cn.uorange.infoservice.service.impl;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.repository.entity.UserInfo;
import cn.uorange.infoservice.service.IUserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.infoservice.repository.entity.Follow;
import cn.uorange.infoservice.repository.mapper.FollowMapper;
import cn.uorange.infoservice.service.IFollowService;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {

    @Resource
    IUserInfoService userInfoService;

    @Override
    public Result addFollow(Long userId, Long targetId) {
        Follow follow = new Follow().setFollowerId(userId).setFollowedUserId(targetId);
        this.save(follow);
        log.info("关注数据创建成功,数据内容:{}", follow);
        return Result.success();
    }

    @Override
    public Result delFollow(Long userId, Long targetId) {
        boolean result = this.remove(new QueryWrapper<Follow>().eq(Follow.FOLLOWER_ID, userId).eq(Follow.FOLLOWED_USER_ID, targetId));
        return Result.success(result);
    }

    @Override
    public Result listFollower(Long userId, Integer page, Integer size) {
        List<Follow> followList = this.list(new QueryWrapper<Follow>().eq(Follow.FOLLOWED_USER_ID, userId));
        if (followList.isEmpty())
            return Result.success();
        Collection<Long> followerIds = followList.stream().map(Follow::getFollowerId).collect(Collectors.toSet());
        IPage<UserInfo> userPage = userInfoService.page(new Page<>(page, size), new QueryWrapper<UserInfo>().in(UserInfo.USER_ID, followerIds));
        log.info("获取粉丝列表成功,用户id:{}", userId);
        return Result.success(userPage);
    }

    @Override
    public Result listFollowed(Long userId, Integer page, Integer size) {
        List<Follow> followList = this.list(new QueryWrapper<Follow>().eq(Follow.FOLLOWER_ID, userId));
        if (followList.isEmpty())
            return Result.success();
        Collection<Long> userIds = followList.stream().map(Follow::getFollowedUserId).collect(Collectors.toSet());
        IPage<UserInfo> userPage = userInfoService.page(new Page<>(page, size), new QueryWrapper<UserInfo>().in(UserInfo.USER_ID, userIds));
        log.info("获取关注列表成功,用户id:{}", userId);
        return Result.success(userPage);
    }
}
