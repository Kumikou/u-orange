package cn.uorange.auctionservice.service.impl;

import cn.uorange.auctionservice.command.PriceRecordCommand;
import cn.uorange.auctionservice.sender.PriceRecordEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 * 记录消息发送 实现类
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/17
 */
@Service
@EnableBinding(PriceRecordEvent.class)
@Slf4j
public class PriceRecordService {

    @Resource
    MessageChannel priceOutput;

    public void savePrice(PriceRecordCommand data) {
        priceOutput.send(MessageBuilder.withPayload(data).build());
        log.info("发送记录拍卖价格消息:{}", data);
    }


}
