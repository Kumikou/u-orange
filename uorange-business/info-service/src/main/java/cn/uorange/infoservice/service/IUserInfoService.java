package cn.uorange.infoservice.service;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.command.ChangeInfoCommand;
import cn.uorange.infoservice.repository.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserInfoService extends IService<UserInfo> {


    Result getInfo(Long userId);

    Result changeInfo(Long userId, ChangeInfoCommand command);

    Result changImg(Long userId, String img);

    Result changePhone(Long userId, String phone);

    Result getInfoByUsername(String username);

    Result listUserInfos(Integer page, Integer size);

    Result changeUserStatus(Long userId, Integer status);
}
