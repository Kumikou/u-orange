package cn.uorange.orderservice.enums;

/**
 * <p>
 * 订单状态枚举
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/29
 */
public enum OrderStatus {

    CLOSED(-2, "已关闭"),
    CANCELED(1, "已取消"),
    COMMITTED(0, "已提交"),
    PAYED(1, "已付款"),
    DONE(2, "交易成功"),
    NOT_EVALUATED(3, "待评价");

    private int code;

    private String description;

    OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
