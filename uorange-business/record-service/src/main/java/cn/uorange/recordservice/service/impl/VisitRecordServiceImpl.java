package cn.uorange.recordservice.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.uorange.recordservice.repository.entity.VisitRecord;
import cn.uorange.recordservice.repository.mapper.VisitRecordMapper;
import cn.uorange.recordservice.service.IVisitRecordService;
@Service
public class VisitRecordServiceImpl extends ServiceImpl<VisitRecordMapper, VisitRecord> implements IVisitRecordService{

}
