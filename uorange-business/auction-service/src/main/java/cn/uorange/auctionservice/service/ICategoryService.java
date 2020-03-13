package cn.uorange.auctionservice.service;

import cn.uorange.auctionservice.command.ChangeCatCommand;
import cn.uorange.auctionservice.command.CreateCatCommand;
import cn.uorange.auctionservice.repository.entity.Category;
import cn.uorange.common.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ICategoryService extends IService<Category> {


    Result listSon(Integer id);

    Result addCat(CreateCatCommand command);

    Result changeCat(Integer id, ChangeCatCommand command);

}

