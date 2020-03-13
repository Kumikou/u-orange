package cn.uorange.common.oauth;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Kumikou
 * @Date 2019/12/24
 */
@Data
@AllArgsConstructor
public class OauthUser {
    private String username;
    private String password;
    private String phone;
    private String auths;

    public OauthUser() {

    }
}
