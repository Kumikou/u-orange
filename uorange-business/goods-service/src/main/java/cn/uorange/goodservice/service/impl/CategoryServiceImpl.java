package cn.uorange.goodservice.service.impl;

import cn.hutool.core.lang.Assert;
import cn.uorange.common.utils.Result;
import cn.uorange.goodservice.command.ChangeCatCommand;
import cn.uorange.goodservice.command.CreateCatCommand;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.goodservice.repository.entity.Category;
import cn.uorange.goodservice.repository.mapper.CategoryMapper;
import cn.uorange.goodservice.service.ICategoryService;

@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Override
    public Result addCat(CreateCatCommand command) {
        Category cat = command.toObj();
        this.save(cat);
        log.info("category数据创建成功,数据内容:{}", cat);
        return Result.success();
    }

    @Override
    public Result changeCat(Integer id, ChangeCatCommand command) {
        isExisted(id);
        Category cat = command.toObj();
        cat.setId(id);
        this.updateById(cat);
        log.info("category数据修改成功,数据内容:{}", cat);
        return Result.success();
    }

    private void isExisted(Integer id) {
        Integer count = this.count(new QueryWrapper<Category>().eq(Category.ID, id));
        Assert.isTrue(retBool(count), String.format("categoryId:%d数据不存在", id));
        log.debug("categoryId:{}数据存在", id);
    }
}
