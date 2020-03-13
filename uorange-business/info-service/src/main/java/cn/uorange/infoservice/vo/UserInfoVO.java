package cn.uorange.infoservice.vo;

import cn.uorange.infoservice.repository.entity.UserInfo;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

/**
 * <p>
 * 用户信息展示类
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/19
 */
@Value
public class UserInfoVO {

    private String username;

    private Byte sex;

    private String phone;

    private String img;

    public UserInfoVO(UserInfo userInfo) {
        this.username = userInfo.getUsername();
        this.sex = userInfo.getSex();
        this.phone = userInfo.getPhone();
        this.img = userInfo.getImg();
    }
}
