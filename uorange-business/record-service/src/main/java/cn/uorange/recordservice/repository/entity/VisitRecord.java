package cn.uorange.recordservice.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value="用户被访问次数记录表")
@Data
@Accessors(chain = true)
@TableName(value = "visit_record")
public class VisitRecord implements Serializable {
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
     * 被访问次数
     */
    @TableField(value = "visited_time")
    @ApiModelProperty(value="被访问次数")
    private Integer visitedTime;

    private static final long serialVersionUID = 1L;

    public static final String USER_ID = "user_id";

    public static final String VISITED_TIME = "visited_time";
}