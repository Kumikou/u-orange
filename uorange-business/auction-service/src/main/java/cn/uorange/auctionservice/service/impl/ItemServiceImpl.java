package cn.uorange.auctionservice.service.impl;

import cn.hutool.core.lang.Assert;
import cn.uorange.auctionservice.command.CreateItemCommand;
import cn.uorange.auctionservice.command.PriceRecordCommand;
import cn.uorange.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.auctionservice.repository.entity.Item;
import cn.uorange.auctionservice.repository.mapper.ItemMapper;
import cn.uorange.auctionservice.service.ItemService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
@Slf4j
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

    @Resource
    PriceRecordService recordService;

    @Override
    public Result addItem(CreateItemCommand command) {
        Item item = command.toObj();
        item.setCurrentPrice(command.getOriginPrice());
        this.save(item);
        log.info("item数据创建成功,数据内容:{}", item);
        return Result.success();
    }

    @Override
    public Result changeItem(Long id, CreateItemCommand command) {
        Item item = this.getById(id);
        Objects.requireNonNull(item, String.format("itemID:%d数据不存在", id));
        if (LocalDateTime.now().isAfter(item.getStartTime()))
            return Result.errorMsg("拍卖品已开始拍卖，无法修改拍卖品信息");

        Item itemFromCom = command.toObj();
        itemFromCom.setId(id);
        this.updateById(itemFromCom);
        log.info("item数据修改成功,数据内容:{}", itemFromCom);
        return Result.success();
    }

    @Override
    public Result getItem(Long id) {
        Item item = this.getById(id);
        Objects.requireNonNull(item, String.format("itemID:%d数据不存在", id));
        log.debug("getItem:{}", item);
        return Result.success(item);
    }

    @Override
    @Transactional
    public Result updateNowPrice(Long id, Long currentOwnerId, BigDecimal currentPrice) {
        Item item = this.getById(id);
        Objects.requireNonNull(item, String.format("itemID:%d数据不存在", id));
        log.debug("getItem:{}", item);

        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(item.getStartTime()))
            return Result.errorMsg("该物品还未开始拍卖，请稍后再来");
        if (now.isAfter(item.getEndTime()))
            return Result.errorMsg("该物品已结束拍卖，无法修改信息");

        int result = currentPrice.compareTo(item.getCurrentPrice());
        Assert.isTrue(retBool(result), "当前出价低于或等于当前价格");

        item.setCurrentOwnerId(currentOwnerId).setCurrentPrice(currentPrice);
        this.updateById(item);
        log.info("拍卖品当前价格更新成功,出价人:{},更新价格:{}", currentOwnerId, currentPrice);

        // 发送保存价格消息
        PriceRecordCommand data = new PriceRecordCommand().setItemId(item.getId()).setCurrentOwnerId(currentOwnerId).setCurrentPrice(currentPrice);
        recordService.savePrice(data);
        return Result.success();
    }
}
