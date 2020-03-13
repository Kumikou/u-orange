package cn.uorange.infoservice.repository.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value="关注表")
@Data
@Accessors(chain = true)
@TableName(value = "follow")
public class Follow implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="自增id")
    private Long id;

    /**
     * 被关注用户id
     */
    @TableField(value = "followed_user_id")
    @ApiModelProperty(value="被关注用户id")
    private Long followedUserId;

    /**
     * 关注者/粉丝id
     */
    @TableField(value = "follower_id")
    @ApiModelProperty(value="关注者/粉丝id")
    private Long followerId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 逻辑删除
     */
    @TableField(value = "deleted",fill = FieldFill.INSERT)
    @ApiModelProperty(value="逻辑删除")
    @TableLogic
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String FOLLOWED_USER_ID = "followed_user_id";

    public static final String FOLLOWER_ID = "follower_id";

    public static final String CREATE_TIME = "create_time";

    public static final String DELETED = "deleted";
}