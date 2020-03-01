package com.Lph.project.samplebright.bright.dao;

import com.Lph.project.samplebright.bright.model.TBCClient;
import com.Lph.project.samplebright.bright.model.TBCClientExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TBCClientDAO {
    long countByExample(TBCClientExample example);

    int deleteByExample(TBCClientExample example);

    int deleteByPrimaryKey(String clientCode);

    int insert(TBCClient record);

    int insertSelective(TBCClient record);

    List<TBCClient> selectByExample(TBCClientExample example);

    TBCClient selectByPrimaryKey(String clientCode);

    int updateByExampleSelective(@Param("record") TBCClient record, @Param("example") TBCClientExample example);

    int updateByExample(@Param("record") TBCClient record, @Param("example") TBCClientExample example);

    int updateByPrimaryKeySelective(TBCClient record);

    int updateByPrimaryKey(TBCClient record);
}