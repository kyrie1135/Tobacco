package com.Lph.project.samplebright.bright.dao;

import com.Lph.project.samplebright.bright.model.TCCSampleBright;
import com.Lph.project.samplebright.bright.model.TCCSampleBrightExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TCCSampleBrightDAO {
    long countByExample(TCCSampleBrightExample example);

    int deleteByExample(TCCSampleBrightExample example);

    int deleteByPrimaryKey(String bickid);

    int insert(TCCSampleBright record);

    int insertSelective(TCCSampleBright record);

    List<TCCSampleBright> selectByExample(TCCSampleBrightExample example);

    TCCSampleBright selectByPrimaryKey(String bickid);

    int updateByExampleSelective(@Param("record") TCCSampleBright record, @Param("example") TCCSampleBrightExample example);

    int updateByExample(@Param("record") TCCSampleBright record, @Param("example") TCCSampleBrightExample example);

    int updateByPrimaryKeySelective(TCCSampleBright record);

    int updateByPrimaryKey(TCCSampleBright record);
}