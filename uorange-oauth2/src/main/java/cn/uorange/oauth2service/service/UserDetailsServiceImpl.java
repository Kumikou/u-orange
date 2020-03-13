package cn.uorange.oauth2service.service;

import cn.uorange.common.oauth.OauthUser;
import cn.uorange.common.utils.Result;
import cn.uorange.oauth2service.feign.UserFeign;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    UserFeign userFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Result<OauthUser> oauthUserResult = userFeign.getOauthUserByUsername(username);
        if (oauthUserResult.isNotSuccess()) {
            throw new UsernameNotFoundException(oauthUserResult.getMessage());
        }

        OauthUser oauthUser = oauthUserResult.getData();
        return new User(oauthUser.getUsername(), oauthUser.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(oauthUser.getAuths()));
    }
}
