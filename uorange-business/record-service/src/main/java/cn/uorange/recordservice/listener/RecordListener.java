package cn.uorange.recordservice.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * <p>
 * 信息记录 监听器
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/17
 */
public interface RecordListener {

    String PRICE_INPUT = "priceInput";

    String VISIT_INPUT = "visitInput";

    String BROWSED_GOODS_INPUT = "browsedGoodsInput";

    @Input(PRICE_INPUT)
    SubscribableChannel priceInput();

    @Input(VISIT_INPUT)
    SubscribableChannel visitInput();

    @Input(BROWSED_GOODS_INPUT)
    SubscribableChannel browsedGoodsInput();

}
