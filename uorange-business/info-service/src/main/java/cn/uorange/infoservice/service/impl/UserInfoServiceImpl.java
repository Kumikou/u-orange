package cn.uorange.infoservice.service.impl;

import cn.hutool.core.lang.Assert;
import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.command.ChangeInfoCommand;
import cn.uorange.infoservice.vo.UserInfoVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.infoservice.repository.entity.UserInfo;
import cn.uorange.infoservice.repository.mapper.UserInfoMapper;
import cn.uorange.infoservice.service.IUserInfoService;

import javax.annotation.Resource;
import java.util.Objects;

@Service
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Resource
    VisitRecordServiceImpl recordService;

    @Override
    public Result getInfo(Long userId) {
        UserInfo userInfo = this.getById(userId);
        log.info("getUserInfo:{}", userId);
        return Result.success(new UserInfoVO(userInfo));
    }

    @Override
    public Result getInfoByUsername(String username) {
        UserInfo userInfo = this.getOne(new QueryWrapper<UserInfo>().eq(UserInfo.USERNAME, username));
        Objects.requireNonNull(userInfo, String.format("username:%s用户不存在", username));
        UserInfoVO infoVO = new UserInfoVO(userInfo);
        log.info("getUserInfoByUsername:{}", username);

        // 记录被访次数增加
        recordService.addVisitedTime(userInfo.getUserId());
        return Result.success(infoVO);
    }

    @Override
    public Result changeInfo(Long userId, ChangeInfoCommand command) {
        isExisted(userId);
        UserInfo info = command.toObj();
        info.setUserId(userId);
        this.updateById(info);
        log.info("userInfo数据更新成功,数据内容:{}", info);
        return Result.success();
    }

    @Override
    public Result changImg(Long userId, String img) {
        UserInfo info = this.getById(userId);
        Objects.requireNonNull(info, String.format("userId:%d 用户不存在", userId));
        info.setImg(img);
        this.updateById(info);
        log.info("userInfo数据更新成功,数据内容:{}", info);
        return Result.success();
    }

    @Override
    public Result changePhone(Long userId, String phone) {
        UserInfo info = this.getById(userId);
        Objects.requireNonNull(info, String.format("userId:%d 用户不存在", userId));
        info.setPhone(phone);
        this.updateById(info);
        log.info("userInfo数据更新成功,数据内容:{}", info);
        return Result.success();
    }

    @Override
    public Result listUserInfos(Integer page, Integer size) {
        IPage<UserInfo> userInfoIPage = this.page(new Page<>(page, size));
        log.info("获取用户信息列表");
        return Result.success(userInfoIPage);
    }

    @Override
    public Result changeUserStatus(Long userId, Integer status) {
        UserInfo userInfo = this.getById(userId);
        if (Objects.isNull(userInfo))
            return Result.errorMsg("用户不存在");
        userInfo.setStatus(status);
        this.updateById(userInfo);
        log.info("用户状态修改成功,当前状态: 用户id:{} 状态:{}", userId, status);
        return Result.success();
    }

    private void isExisted(Long userId) {
        int count = this.count(new QueryWrapper<UserInfo>().eq(UserInfo.USER_ID, userId));
        Assert.isTrue(retBool(count), String.format("userId:%d用户信息不存在", userId));
        log.debug("userId:{}用户信息存在", userId);
    }
}
