package cn.uorange.infoservice.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * <p>
 * 访问次数记录 消息发送源
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/19
 */
public interface VisitRecordEvent {
    String VISIT_OUTPUT = "visitOutput";

    @Output(VISIT_OUTPUT)
    MessageChannel visitOutput();
}
