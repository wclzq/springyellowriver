package com.dongying.dao;

import com.dongying.entity.RecordEntity;

import java.util.List;

public interface RecordEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecordEntity record);

    int insertSelective(RecordEntity record);

    RecordEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecordEntity record);

    int updateByPrimaryKey(RecordEntity record);

    List<RecordEntity> getAllRecord();
}