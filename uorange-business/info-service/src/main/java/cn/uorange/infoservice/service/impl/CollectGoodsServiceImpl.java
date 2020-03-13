package cn.uorange.infoservice.service.impl;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.feign.GoodsFeign;
import cn.uorange.infoservice.repository.entity.Goods;
import cn.uorange.infoservice.service.IGoodsService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.infoservice.repository.entity.CollectGoods;
import cn.uorange.infoservice.repository.mapper.CollectGoodsMapper;
import cn.uorange.infoservice.service.ICollectGoodsService;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CollectGoodsServiceImpl extends ServiceImpl<CollectGoodsMapper, CollectGoods> implements ICollectGoodsService {

    @Resource
    GoodsFeign goodsFeign;

    @Resource
    IGoodsService goodsService;

    @Override
    public Result doCollect(long userId, Long goodsId) {
        if (!isExistedGoods(goodsId)) {
            // 调用服务获取商品数据
            Result<JSONObject> res = goodsFeign.queryGoodsById(goodsId);
            JSONObject json = res.getData();
            Objects.requireNonNull(json, "该商品不存在或已删除");
            Goods goods = new Goods().setId(json.getLong("id"))
                    .setTitle(json.getString("title"))
                    .setPic(json.getString("pic"))
                    .setPrice(json.getBigDecimal("price"))
                    .setStatus(json.getByte("status"))
                    .setUserId(json.getLong("userId"));
            goodsService.save(goods);
            log.info("商品数据创建成功,数据内容:{}", goods);
        }
        if (!isExistedCollectGoods(userId,goodsId)) {
            CollectGoods collectGoods = new CollectGoods().setGoodsId(goodsId).setUserId(userId);
            this.save(collectGoods);
            log.info("商品收藏数据创建成功,数据内容:{}", collectGoods);
            return Result.success();
        } else {
            return Result.errorMsg("该商品已收藏");
        }
    }

    private boolean isExistedCollectGoods(long userId, Long goodsId) {
        CollectGoods collectGoods = this.getOne(new QueryWrapper<CollectGoods>().eq(CollectGoods.USER_ID,userId).eq(CollectGoods.GOODS_ID,goodsId));
        return !Objects.isNull(collectGoods);
    }

    private boolean isExistedGoods(Long goodsId) {
        int count = goodsService.count(new QueryWrapper<Goods>().eq(Goods.ID, goodsId));
        return retBool(count);
    }

    @Override
    public Result cancelCollect(long userId, Long goodsId) {
        boolean result = this.remove(new QueryWrapper<CollectGoods>()
                .eq(CollectGoods.USER_ID, userId)
                .eq(CollectGoods.GOODS_ID, goodsId));
        return Result.error(result);
    }

    @Override
    public Result listAll(long userId, Integer page, Integer size) {
        List<CollectGoods> collectGoodsList = this.list(new QueryWrapper<CollectGoods>().eq(CollectGoods.USER_ID, userId));
        Collection<Long> GoodsIds = collectGoodsList.stream().map(CollectGoods::getGoodsId).collect(Collectors.toSet());
        IPage goodsList = goodsService.page(new Page<>(page, size), new QueryWrapper<Goods>().in(Goods.ID, GoodsIds));
        log.info("获取收藏的商品列表成功, userId:{},currentPage:{},pageSize:{}", userId, page, size);
        return Result.success(goodsList);
    }
}
