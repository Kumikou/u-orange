package cn.uorange.auctionservice.service;

import cn.uorange.auctionservice.command.CreateItemCommand;
import cn.uorange.auctionservice.repository.entity.Item;
import cn.uorange.common.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

public interface ItemService extends IService<Item> {


    Result addItem(CreateItemCommand command);

    Result changeItem(Long id, CreateItemCommand command);

    Result getItem(Long id);

    Result updateNowPrice(Long id, Long currentOwnerId, BigDecimal currentPrice);
}
