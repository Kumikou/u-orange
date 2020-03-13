package cn.uorange.infoservice.service.impl;

import cn.uorange.infoservice.sender.VisitRecordEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/19
 */
@Service
@EnableBinding(VisitRecordEvent.class)
@Slf4j
public class VisitRecordServiceImpl {

    @Resource
    MessageChannel visitOutput;

    public void addVisitedTime(Long userId) {
        visitOutput.send(MessageBuilder.withPayload(userId).build());
        log.info("发送记录用户被访消息,用户id:{}", userId);
    }

}
