package cn.uorange.goodservice.aspect;

import cn.uorange.goodservice.service.impl.RecordSenderImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 记录请求次数 切面
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/26
 */
@Aspect
@Component
@Slf4j
public class GoodsControllerAspect {

    @Resource
    RecordSenderImpl recordSender;

    @Pointcut("execution (public * cn.uorange.goodservice.controller.CommonController.getGoodsById(..))")
    public void recordRequestTime() {
    }

    @After("recordRequestTime()")
    public void doAfter(JoinPoint jp) {
        Object[] jpArgs = jp.getArgs();
//        log.info("记录请求参数:{}", jpArgs);
        recordSender.savaBrowsedGoods((Long) jpArgs[0]);
    }


}
