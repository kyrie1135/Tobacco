package com.Lph.project.resultinput.input.dao;

import com.Lph.project.resultinput.input.model.TCCSaitDescription;
import com.Lph.project.resultinput.input.model.TCCSaitDescriptionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TCCSaitDescriptionDAO {
    long countByExample(TCCSaitDescriptionExample example);

    int deleteByExample(TCCSaitDescriptionExample example);

    int deleteByPrimaryKey(String bickid);

    int insert(TCCSaitDescription record);

    int insertSelective(TCCSaitDescription record);

    List<TCCSaitDescription> selectByExample(TCCSaitDescriptionExample example);

    TCCSaitDescription selectByPrimaryKey(String bickid);

    int updateByExampleSelective(@Param("record") TCCSaitDescription record, @Param("example") TCCSaitDescriptionExample example);

    int updateByExample(@Param("record") TCCSaitDescription record, @Param("example") TCCSaitDescriptionExample example);

    int updateByPrimaryKeySelective(TCCSaitDescription record);

    int updateByPrimaryKey(TCCSaitDescription record);

    List<String> selectMonthDistinct();

    List<TCCSaitDescription> selectTargetMonthDistinct();
}