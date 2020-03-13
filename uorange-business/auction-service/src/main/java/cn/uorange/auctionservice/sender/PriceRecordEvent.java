package cn.uorange.auctionservice.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * <p>
 * 记录消息发送源
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/17
 */

public interface PriceRecordEvent {

    String PRICE_OUTPUT = "priceOutput";

    @Output(PRICE_OUTPUT)
    MessageChannel priceOutput();

}
