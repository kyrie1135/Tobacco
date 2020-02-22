package com.Lph.admin.subscript.dao;

import com.Lph.admin.subscript.model.SubscriptModel;
import com.Lph.admin.subscript.model.SubscriptModelExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SubscriptDao {
    long countByExample(SubscriptModelExample example);

    int deleteByExample(SubscriptModelExample example);

    int deleteByPrimaryKey(String bickid);

    int insert(SubscriptModel record);

    int insertSelective(SubscriptModel record);

    List<SubscriptModel> selectByExample(SubscriptModelExample example);

    SubscriptModel selectByPrimaryKey(String bickid);

    int updateByExampleSelective(@Param("record") SubscriptModel record, @Param("example") SubscriptModelExample example);

    int updateByExample(@Param("record") SubscriptModel record, @Param("example") SubscriptModelExample example);

    int updateByPrimaryKeySelective(SubscriptModel record);

    int updateByPrimaryKey(SubscriptModel record);
}