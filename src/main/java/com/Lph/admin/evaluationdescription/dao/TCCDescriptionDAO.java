package com.Lph.admin.evaluationdescription.dao;

import com.Lph.admin.evaluationdescription.model.TCCDescription;
import com.Lph.admin.evaluationdescription.model.TCCDescriptionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TCCDescriptionDAO {
    long countByExample(TCCDescriptionExample example);

    int deleteByExample(TCCDescriptionExample example);

    int deleteByPrimaryKey(String bickid);

    int insert(TCCDescription record);

    int insertSelective(TCCDescription record);

    List<TCCDescription> selectByExample(TCCDescriptionExample example);

    TCCDescription selectByPrimaryKey(String bickid);

    int updateByExampleSelective(@Param("record") TCCDescription record, @Param("example") TCCDescriptionExample example);

    int updateByExample(@Param("record") TCCDescription record, @Param("example") TCCDescriptionExample example);

    int updateByPrimaryKeySelective(TCCDescription record);

    int updateByPrimaryKey(TCCDescription record);
}