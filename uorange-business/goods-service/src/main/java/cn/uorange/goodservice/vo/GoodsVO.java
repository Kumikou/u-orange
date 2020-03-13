package cn.uorange.goodservice.vo;

import cn.uorange.goodservice.repository.entity.Goods;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 面向用户/买家的商品VO
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/26
 */
@Value
public class GoodsVO  {

    private Long id;

    private String title;

    private String description;

    private String pic;

    private BigDecimal price;

    private Long userId;

    private Integer categoryId;

    private Boolean isNew;

    private Boolean isFreeFare;

    private LocalDateTime createTime;

    public GoodsVO(Goods goods) {
        this.id = goods.getId();
        this.title = goods.getTitle();
        this.description = goods.getDescription();
        this.pic = goods.getPic();
        this.price = goods.getPrice();
        this.userId = goods.getUserId();
        this.categoryId = goods.getCategoryId();
        this.isNew = goods.getIsNew();
        this.isFreeFare = goods.getIsFreeFare();
        this.createTime = goods.getCreateTime();
    }
}
