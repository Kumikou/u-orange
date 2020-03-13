package cn.uorange.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Kumikou
 * @Date 2019/12/3
 */
@Data
public class Result<T> implements Serializable {

    private static final int STATUS_SUCCESS = 200;
    private static final int STATUS_ERROR = -1;

    private static final String SUCCESS_MSG = "操作成功";
    private static final String ERROR_MSG = "操作失败";

    private long code;

    private String message;

    private T data;

    Result() {
    }

    Result(int code) {
        this.code = code;
    }

    public Result(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(long code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<>(STATUS_SUCCESS, SUCCESS_MSG);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(STATUS_SUCCESS, data);
    }

    public static <T> Result<T> successMsg(String message) {
        return new Result<>(STATUS_SUCCESS, message);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(STATUS_SUCCESS, SUCCESS_MSG, data);
    }

    public static <T> Result<T> error() {
        return new Result<>(STATUS_ERROR, SUCCESS_MSG);
    }

    public static <T> Result<T> error(T data) {
        return new Result<>(STATUS_ERROR, data);
    }

    public static <T> Result<T> errorMsg(String message) {
        return new Result<>(STATUS_ERROR, message);
    }

    public static <T> Result<T> error(String message, T data) {
        return new Result<>(STATUS_ERROR, message, data);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == STATUS_SUCCESS;
    }

    @JsonIgnore
    public boolean isNotSuccess() {
        return !isSuccess();
    }

}
