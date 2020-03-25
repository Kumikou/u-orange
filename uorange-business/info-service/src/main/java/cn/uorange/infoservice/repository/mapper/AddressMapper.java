package cn.uorange.infoservice.repository.mapper;

import cn.uorange.infoservice.repository.entity.Address;
import cn.uorange.infoservice.vo.AddressChVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface AddressMapper extends BaseMapper<Address> {
    List<AddressChVO> listAddressCh(Long userId);
}