package com.Lph.admin.evaluationitem.dao;

import com.Lph.admin.evaluationitem.model.TCCEvaluationitem;
import com.Lph.admin.evaluationitem.model.TCCEvaluationitemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TCCEvaluationitemDAO {
    long countByExample(TCCEvaluationitemExample example);

    int deleteByExample(TCCEvaluationitemExample example);

    int deleteByPrimaryKey(String bickid);

    int insert(TCCEvaluationitem record);

    int insertSelective(TCCEvaluationitem record);

    List<TCCEvaluationitem> selectByExample(TCCEvaluationitemExample example);

    TCCEvaluationitem selectByPrimaryKey(String bickid);

    int updateByExampleSelective(@Param("record") TCCEvaluationitem record, @Param("example") TCCEvaluationitemExample example);

    int updateByExample(@Param("record") TCCEvaluationitem record, @Param("example") TCCEvaluationitemExample example);

    int updateByPrimaryKeySelective(TCCEvaluationitem record);

    int updateByPrimaryKey(TCCEvaluationitem record);
}