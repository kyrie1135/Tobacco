package com.Lph.project.resultinput.input.dao;

import com.Lph.project.resultinput.input.model.TCCClientsatisfysurvey;
import com.Lph.project.resultinput.input.model.TCCClientsatisfysurveyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TCCClientsatisfysurveyDAO {
    long countByExample(TCCClientsatisfysurveyExample example);

    int deleteByExample(TCCClientsatisfysurveyExample example);

    int deleteByPrimaryKey(String bickid);

    int insert(TCCClientsatisfysurvey record);

    int insertSelective(TCCClientsatisfysurvey record);

    List<TCCClientsatisfysurvey> selectByExample(TCCClientsatisfysurveyExample example);

    TCCClientsatisfysurvey selectByPrimaryKey(String bickid);

    int updateByExampleSelective(@Param("record") TCCClientsatisfysurvey record, @Param("example") TCCClientsatisfysurveyExample example);

    int updateByExample(@Param("record") TCCClientsatisfysurvey record, @Param("example") TCCClientsatisfysurveyExample example);

    int updateByPrimaryKeySelective(TCCClientsatisfysurvey record);

    int updateByPrimaryKey(TCCClientsatisfysurvey record);
}