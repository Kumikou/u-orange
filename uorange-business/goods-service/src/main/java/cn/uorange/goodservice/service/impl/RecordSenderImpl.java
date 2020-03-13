package cn.uorange.goodservice.service.impl;

import cn.uorange.goodservice.command.RecordBrowsedGoods;
import cn.uorange.goodservice.sender.RecordSender;
import lombok.extern.slf4j.Slf4j;
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
 * @Date 2019/12/26
 */
@Service
@EnableBinding(RecordSender.class)
@Slf4j
public class RecordSenderImpl {

    @Resource
    MessageChannel browsedGoodsOutput;

    // 记录商品被浏览
    public void savaBrowsedGoods(Long id) {
        browsedGoodsOutput.send(MessageBuilder.withPayload(id).build());
        log.info("发送记录商品被浏览信息：商品id:{}", id);
    }
}
