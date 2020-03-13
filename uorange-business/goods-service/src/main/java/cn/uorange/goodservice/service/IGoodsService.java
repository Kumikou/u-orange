package cn.uorange.goodservice.service;

import cn.uorange.common.utils.Result;
import cn.uorange.goodservice.command.ChangeGoodsCommand;
import cn.uorange.goodservice.command.ChangeStatusCommand;
import cn.uorange.goodservice.command.PublishGoodsCommand;
import cn.uorange.goodservice.repository.entity.Goods;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IGoodsService extends IService<Goods> {


    Result createGoods(Long userId, PublishGoodsCommand command);

    Result changeStatus(ChangeStatusCommand command);

    Result changeGoods(ChangeGoodsCommand command);

    Result getGoodsByStatus(Long userId, Integer status, Integer page, Integer size);

    Result countGoods(Long userId);

    Result getGoodById(Long id);

    Result getGoodsForOwner(Long userId, Long id1);

    Result queryGoodsById(Long goodsId);

    Result listGoods(Integer categoryId, Integer page, Integer size);
}
