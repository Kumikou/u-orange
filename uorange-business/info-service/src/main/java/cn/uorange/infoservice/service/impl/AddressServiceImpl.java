package cn.uorange.infoservice.service.impl;

import cn.hutool.core.lang.Assert;
import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.command.CreateAddressCommand;
import cn.uorange.infoservice.vo.AddressVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.infoservice.repository.mapper.AddressMapper;
import cn.uorange.infoservice.repository.entity.Address;
import cn.uorange.infoservice.service.IAddressService;

@Service
@Slf4j
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

    @Override
    public Result createAddress(Long userId, CreateAddressCommand command) {
        Address address = command.toObj();
        address.setUserId(userId);
        this.save(address);
        log.info("address数据创建成功,数据内容:{}", address);
        return Result.success();
    }

    @Override
    public Result getAddress(Long id) {
        Address address = this.getById(id);
        AddressVO addressVO = new AddressVO(address);
        log.info("getAddress:{}", id);
        return Result.success(addressVO);
    }

    @Override
    public Result changeAddress(Long id, CreateAddressCommand command) {
        isExisted(id);
        Address address = command.toObj();
        address.setAddId(id);
        this.updateById(address);
        log.info("address数据更新成功,数据内容:{}", address);
        return Result.success();
    }

    private void isExisted(Long id) {
        int count = this.count(new QueryWrapper<Address>().eq(Address.ADD_ID, id));
        Assert.isTrue(retBool(count), String.format("addressId:%d数据不存在", id));
        log.debug("addressId:{}数据存在", id);
    }
}
