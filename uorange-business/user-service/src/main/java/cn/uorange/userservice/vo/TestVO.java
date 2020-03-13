package cn.uorange.userservice.vo;

import cn.uorange.userservice.repository.entity.Test;
import lombok.Value;

import java.io.Serializable;

/**
 * <p>
 *    TestVO类
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/6
 */
@Value
public class TestVO{
    private String content;

    public TestVO(Test test) {
        this.content = test.getContent();
    }
}
