package cn.uorange.goodservice.service.impl;

import cn.hutool.core.lang.Assert;
import cn.uorange.common.utils.Result;
import cn.uorange.goodservice.command.ChangeGoodsCommand;
import cn.uorange.goodservice.command.ChangeStatusCommand;
import cn.uorange.goodservice.command.PublishGoodsCommand;
import cn.uorange.goodservice.vo.GoodsForOwnerVO;
import cn.uorange.goodservice.vo.GoodsVO;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.goodservice.repository.mapper.GoodsMapper;
import cn.uorange.goodservice.repository.entity.Goods;
import cn.uorange.goodservice.service.IGoodsService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Override
    public Result createGoods(Long userId, PublishGoodsCommand command) {
        Goods goods = command.toObj();
        goods.setUserId(userId);
        this.save(goods);
        log.info("商品数据创建成功,数据内容:{}", goods);
        return Result.success();
    }

    @Override
    public Result changeStatus(ChangeStatusCommand command) {
        existedGoods(command.getId());
        Goods goods = command.toObj();
        this.updateById(goods);
        log.info("商品状态修改成功,数据内容:{}", command);
        return Result.success();
    }

    @Override
    public Result changeGoods(ChangeGoodsCommand command) {
        existedGoods(command.getId());
        Goods goods = command.toObj();
        this.updateById(goods);
        log.info("商品描述修改成功,数据内容:{}", goods);
        return Result.success();
    }

    @Override
    public Result getGoodById(Long id) {
        Goods goods = this.getById(id);
        if (Objects.isNull(goods)) {
            log.debug("goodsId:{} 商品不存在", id);
            return Result.errorMsg("该商品不存在");
        }
        log.info("getGoods:{}", goods);
        if (goods.getStatus() != 0) {
            // status:0 已发布
            log.debug("goodsId:{} 商品已下架", id);
            return Result.errorMsg("该商品已下架！");
        }
        GoodsVO goodsVO = new GoodsVO(goods);
        return Result.success(goodsVO);
    }

    @Override
    public Result getGoodsForOwner(Long userId, Long id) {
        Goods goods = this.getOne(new QueryWrapper<Goods>().eq(Goods.ID, id).eq(Goods.USER_ID, userId));
        Objects.requireNonNull(goods, "该商品不存在");
        GoodsForOwnerVO goodsForOwnerVO = new GoodsForOwnerVO(goods);
        return Result.success(goodsForOwnerVO);
    }

    @Override
    public Result getGoodsByStatus(Long userId, Integer status, Integer page, Integer size) {
        IPage<Goods> goodsIPage = this.page(new Page<>(page, size), new QueryWrapper<Goods>().eq(Goods.USER_ID, userId).eq(Goods.STATUS, status));
        log.info("getGoodsByStatus: userId:{} status:{} currentPage:{} pageSize:{}", userId, status, page, size);
        return Result.success(goodsIPage);
    }

    @Override
    public Result countGoods(Long userId) {
        int inSaleCount = this.count(new QueryWrapper<Goods>().eq(Goods.USER_ID, userId).eq(Goods.STATUS, 0));
        int soldCount = this.count(new QueryWrapper<Goods>().eq(Goods.USER_ID, userId).eq(Goods.STATUS, 2));
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("inSaleCount", inSaleCount);
        countMap.put("soldCount", soldCount);
        return Result.success(countMap);
    }

    @Override
    public Result queryGoodsById(Long goodsId) {
        Goods goods = this.getOne(new QueryWrapper<Goods>()
                .select(Goods.ID, Goods.TITLE, Goods.PIC, Goods.PRICE, Goods.STATUS, Goods.USER_ID)
                .eq(Goods.ID, goodsId));
        if (Objects.isNull(goods))
            return Result.error();
        return Result.success(goods);
    }

    @Override
    public Result listGoods(Integer categoryId, Integer page, Integer size) {
        IPage goods = this.page(new Page<>(page, size), new QueryWrapper<Goods>().eq(Goods.CATEGORY_ID, categoryId).orderByDesc(Goods.CREATE_TIME));
        return Result.success(goods);
    }

    private void existedGoods(Long id) {
        int count = this.count(new QueryWrapper<Goods>().eq(Goods.ID, id));
        Assert.isTrue(retBool(count), String.format("goodsId:%d 数据不存在", id));
        log.debug("goodId:{} 数据存在", id);
    }
}
