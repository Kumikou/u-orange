package cn.uorange.recordservice.config;

import cn.uorange.common.exception.DefaultExceptionHandle;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * <p>
 *     统一异常处理
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/6
 */
@ControllerAdvice
public class ExceptionAdvice extends DefaultExceptionHandle {
}
