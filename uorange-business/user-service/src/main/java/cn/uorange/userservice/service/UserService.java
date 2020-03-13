package cn.uorange.userservice.service;

import cn.uorange.common.utils.Result;
import cn.uorange.userservice.command.CreateUniUserCommand;
import cn.uorange.userservice.repository.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserService extends IService<User>{


    Result createUniUser(CreateUniUserCommand command);

    Result getOauthUserByUsername(String username);

    Result getOauthUserByPhone(String phone);
}
