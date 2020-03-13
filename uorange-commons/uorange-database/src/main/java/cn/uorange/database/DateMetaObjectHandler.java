package cn.uorange.database;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * <p>
 * 自动填充字段
 * </p>
 *
 * @Author Kumikou
 * @Date 2019/12/4
 */
public class DateMetaObjectHandler implements MetaObjectHandler {

    private final static String CREATE_TIME = "createTime";
    private final static String UPDATE_TIME = "modifyTime";
    private final static String DELETED = "deleted";

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName(CREATE_TIME, metaObject);
        Object updateTime = getFieldValByName(UPDATE_TIME, metaObject);
        Object deleted = getFieldValByName(DELETED, metaObject);
        if (createTime == null || updateTime == null) {
            LocalDateTime date = LocalDateTime.now();
            if (createTime == null)
                setFieldValByName(CREATE_TIME, date, metaObject);
            if (updateTime == null)
                setFieldValByName(UPDATE_TIME, date, metaObject);
            if (deleted == null)
                setFieldValByName(DELETED, false, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
    }
}
