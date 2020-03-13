package cn.uorange.common.webmvc;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.security.auth.message.AuthException;
import java.util.Objects;

/**
 * <p>
 * 自定义参数解析器 @LoginUser
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/24
 */
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(SysUser.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication))
            throw new AuthException("请登录");

        Object principal = authentication.getPrincipal();
        String username;

        if (principal instanceof User)
            username = ((User) principal).getUsername();
        else if (principal instanceof String)
            username = (String) principal;
        else
            throw new AuthException("用户信息不正确");

        String[] split = username.split("-");
        SysUser oauthUser = new SysUser(Long.parseLong(split[0]), split[1]);

        return oauthUser;
    }
}
