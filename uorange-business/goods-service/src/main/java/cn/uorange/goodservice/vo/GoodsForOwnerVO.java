package cn.uorange.goodservice.vo;

import cn.uorange.goodservice.repository.entity.Goods;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 面向卖家的商品VO
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/26
 */
@Value
public class GoodsForOwnerVO {

    private Long id;

    private String title;

    private String description;

    private String pic;

    private BigDecimal price;

    private Integer categoryId;

    private Boolean isNew;

    private Boolean isFreeFare;

    public GoodsForOwnerVO(Goods goods) {
        this.id = goods.getId();
        this.title = goods.getTitle();
        this.description = goods.getDescription();
        this.pic = goods.getPic();
        this.price = goods.getPrice();
        this.categoryId = goods.getCategoryId();
        this.isNew = goods.getIsNew();
        this.isFreeFare = goods.getIsFreeFare();
    }
}
