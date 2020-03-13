package cn.uorange.goodservice.service;

import cn.uorange.common.utils.Result;
import cn.uorange.goodservice.command.ChangeCatCommand;
import cn.uorange.goodservice.command.CreateCatCommand;
import cn.uorange.goodservice.repository.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ICategoryService extends IService<Category> {


    Result addCat(CreateCatCommand command);

    Result changeCat(Integer id, ChangeCatCommand command);
}
