package cn.uorange.common.exception;

import cn.uorange.common.utils.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * <p>
 * 统一异常处理中心
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/3
 */
@ResponseBody
@ResponseStatus(HttpStatus.OK)
@Slf4j
public class DefaultExceptionHandle {

    @Autowired
    private ObjectMapper objectMapper;

    @ExceptionHandler(Exception.class)
    public Result handle(Exception e) {
        return Result.errorMsg(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handle2(MethodArgumentNotValidException e) {
        String error = e.getBindingResult().getAllErrors().stream().map(item -> item.getDefaultMessage()).findFirst().get();
        return Result.errorMsg(error);
    }

    @ExceptionHandler(BindException.class)
    public Result handle3(BindException e) {
        String error = e.getBindingResult().getAllErrors().stream().map(item -> item.getDefaultMessage()).findFirst().get();
        return Result.errorMsg(error);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handle4(DuplicateKeyException e) {
        return Result.errorMsg("数据已存在" + e.getCause().getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result handle5(ConstraintViolationException e) throws JsonProcessingException {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        String result = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
        return Result.errorMsg(objectMapper.writeValueAsString(result));
    }

    @ExceptionHandler(AuthenticationException.class)
    public Result handle6(AuthenticationException e) {
        return Result.errorMsg(e.getMessage());

    }
}
