package com.Lph.admin.login.dao;

import com.Lph.admin.login.model.UserRight;
import com.Lph.admin.login.model.UserRightExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserRightDAO {
    long countByExample(UserRightExample example);

    int deleteByExample(UserRightExample example);

    int insert(UserRight record);

    int insertSelective(UserRight record);

    List<UserRight> selectByExample(UserRightExample example);

    int updateByExampleSelective(@Param("record") UserRight record, @Param("example") UserRightExample example);

    int updateByExample(@Param("record") UserRight record, @Param("example") UserRightExample example);
}