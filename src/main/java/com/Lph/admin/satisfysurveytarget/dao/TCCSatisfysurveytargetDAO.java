package com.Lph.admin.satisfysurveytarget.dao;

import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytarget;
import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytargetExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TCCSatisfysurveytargetDAO {
    long countByExample(TCCSatisfysurveytargetExample example);

    int deleteByExample(TCCSatisfysurveytargetExample example);

    int deleteByPrimaryKey(String bickid);

    int insert(TCCSatisfysurveytarget record);

    int insertSelective(TCCSatisfysurveytarget record);

    List<TCCSatisfysurveytarget> selectByExample(TCCSatisfysurveytargetExample example);

    TCCSatisfysurveytarget selectByPrimaryKey(String bickid);

    int updateByExampleSelective(@Param("record") TCCSatisfysurveytarget record, @Param("example") TCCSatisfysurveytargetExample example);

    int updateByExample(@Param("record") TCCSatisfysurveytarget record, @Param("example") TCCSatisfysurveytargetExample example);

    int updateByPrimaryKeySelective(TCCSatisfysurveytarget record);

    int updateByPrimaryKey(TCCSatisfysurveytarget record);
}