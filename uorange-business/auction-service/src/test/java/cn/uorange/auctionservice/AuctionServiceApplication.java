package cn.uorange.auctionservice;

import cn.uorange.auctionservice.command.PriceRecordCommand;
import cn.uorange.auctionservice.service.impl.PriceRecordService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AuctionServiceApplication {

    @Resource
//    PriceRecordService priceRecordService;

    @Test
    public void contextLoad() {

    }

    @Test
    public void priceRecordTest() {
//        priceRecordService.savePrice(new PriceRecordCommand().setId((long) 1).setCurrentOwnerId((long) 1).setCurrentPrice(BigDecimal.valueOf(50.55)));
    }

}
