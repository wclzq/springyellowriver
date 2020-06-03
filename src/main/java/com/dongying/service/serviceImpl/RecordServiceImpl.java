package com.dongying.service.serviceImpl;

import com.dongying.dao.RecordEntityMapper;
import com.dongying.entity.RecordEntity;
import com.dongying.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordEntityMapper recordEntityMapper;
    @Override
    public List<RecordEntity> getAllRecord() {
        return recordEntityMapper.getAllRecord();
    }
}
