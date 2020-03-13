package cn.uorange.assessservice.vo;

import cn.uorange.assessservice.repository.entity.Assess;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *     Assess展示对象
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/16
 */
@Value
public class AssessVO {
    private Long id;
    private Long userId;
    private String description;
    private String pic;
    private LocalDateTime buyTime;
    private BigDecimal degree;
    private String packStatus;
    private Byte status;
    private BigDecimal assessPrice;
    private Long assessById;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;

    public AssessVO(Assess assess) {
        this.id = assess.getId();
        this.userId = assess.getUserId();
        this.description = assess.getDescription();
        this.pic = assess.getPic();
        this.buyTime = assess.getBuyTime();
        this.degree = assess.getDegree();
        this.packStatus = assess.getPackStatus();
        this.status = assess.getStatus();
        this.assessPrice = assess.getAssessPrice();
        this.assessById = assess.getAssessById();
        this.createTime = assess.getCreateTime();
        this.modifyTime = assess.getModifyTime();
    }
}
