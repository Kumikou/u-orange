package cn.uorange.goodservice.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * <p>
 * 记录消息发送源
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/26
 */
public interface RecordSender {

    String BROWSED_GOODS_OUTPUT = "browsedGoodsOutput";

    @Output(BROWSED_GOODS_OUTPUT)
    MessageChannel browsedGoodsOutput();
}
