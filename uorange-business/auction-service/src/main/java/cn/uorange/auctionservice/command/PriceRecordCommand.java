package cn.uorange.auctionservice.command;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 历史拍卖价格记录命令
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/17
 */
@Data
@Accessors(chain = true)
public class PriceRecordCommand {

    private Long itemId;

    private Long currentOwnerId;

    private BigDecimal currentPrice;

}
