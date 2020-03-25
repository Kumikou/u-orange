package cn.uorange.infoservice.service;

import cn.uorange.common.utils.Result;
import cn.uorange.infoservice.command.CreateAddressCommand;
import cn.uorange.infoservice.repository.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;
public interface IAddressService extends IService<Address>{


    Result createAddress(Long userId, CreateAddressCommand command);

    Result getAddress(Long id);

    Result changeAddress(Long id, CreateAddressCommand command);

    Result listAddressCh(Long id);
}
