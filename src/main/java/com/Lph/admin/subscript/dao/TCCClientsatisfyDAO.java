package com.Lph.admin.subscript.dao;

import com.Lph.admin.subscript.model.TCCClientsatisfy;
import com.Lph.admin.subscript.model.TCCClientsatisfyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TCCClientsatisfyDAO {
    long countByExample(TCCClientsatisfyExample example);

    int deleteByExample(TCCClientsatisfyExample example);

    int deleteByPrimaryKey(String bickid);

    int insert(TCCClientsatisfy record);

    int insertSelective(TCCClientsatisfy record);

    List<TCCClientsatisfy> selectByExample(TCCClientsatisfyExample example);

    TCCClientsatisfy selectByPrimaryKey(String bickid);

    int updateByExampleSelective(@Param("record") TCCClientsatisfy record, @Param("example") TCCClientsatisfyExample example);

    int updateByExample(@Param("record") TCCClientsatisfy record, @Param("example") TCCClientsatisfyExample example);

    int updateByPrimaryKeySelective(TCCClientsatisfy record);

    int updateByPrimaryKey(TCCClientsatisfy record);

    List<String> selectAllBigCorps();
}