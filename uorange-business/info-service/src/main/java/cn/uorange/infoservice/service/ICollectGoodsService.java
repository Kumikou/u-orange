package cn.uorange.infoservice.service;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.repository.entity.CollectGoods;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ICollectGoodsService extends IService<CollectGoods> {


    Result doCollect(long userId, Long goodsId);

    Result cancelCollect(long userId, Long goodsId);

    Result listAll(long userId, Integer page, Integer size);
}
