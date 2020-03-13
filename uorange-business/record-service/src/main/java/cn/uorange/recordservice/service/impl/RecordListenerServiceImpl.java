package cn.uorange.recordservice.service.impl;

import cn.uorange.recordservice.listener.RecordListener;
import cn.uorange.recordservice.repository.entity.BrowsedGoods;
import cn.uorange.recordservice.repository.entity.ItemPrice;
import cn.uorange.recordservice.repository.entity.VisitRecord;
import cn.uorange.recordservice.service.IBrowsedGoodsService;
import cn.uorange.recordservice.service.IVisitRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * <p>
 * 记录监听实现类
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/19
 */
@Service
@Slf4j
@EnableBinding(RecordListener.class)
public class RecordListenerServiceImpl {

    @Resource
    ItemPriceServiceImpl priceService;

    @Resource
    IVisitRecordService visitRecordService;

    @Resource
    IBrowsedGoodsService browsedGoodsService;

    /**
     * 记录拍卖价格历史
     *
     * @param itemPrice 价格
     */
    @StreamListener(RecordListener.PRICE_INPUT)
    public void recordPrice(ItemPrice itemPrice) {
        log.info("消费拍卖价格记录消息:{}", itemPrice);
        priceService.save(itemPrice);
        log.info("itemPrice数据创建成功,数据内容:{}", itemPrice);
    }

    /**
     * 记录用户被访问次数
     *
     * @param userId 用户id
     */
    @StreamListener(RecordListener.VISIT_INPUT)
    public void recordVisited(Long userId) {
        log.info("消费用户被访问消息:{}", userId);
        VisitRecord record = visitRecordService.getById(userId);
        if (Objects.isNull(record)) {
            record = new VisitRecord().setUserId(userId).setVisitedTime(1);
            visitRecordService.save(record);
        } else {
            int newTimes = record.getVisitedTime() + 1;
            record.setVisitedTime(newTimes);
            visitRecordService.updateById(record);
        }
        log.info("访问次数记录成功,数据内容:{}", record);
    }

    /**
     * 记录商品浏览次数
     *
     * @param goodsId 商品id
     */
    @StreamListener(RecordListener.BROWSED_GOODS_INPUT)
    public void recordBrowsedGoods(Long goodsId) {
        log.info("消费商品被浏览消息:{}", goodsId);
        BrowsedGoods browsedGoods = browsedGoodsService.getById(goodsId);
        if (Objects.isNull(browsedGoods)) {
            browsedGoods = new BrowsedGoods().setId(goodsId).setBrowsedTime(1);
            browsedGoodsService.save(browsedGoods);
        } else {
            browsedGoods.setBrowsedTime(browsedGoods.getBrowsedTime() + 1);
            browsedGoodsService.updateById(browsedGoods);
        }
        log.info("浏览商品次数记录成功,数据内容:{}", browsedGoods);
    }

}
