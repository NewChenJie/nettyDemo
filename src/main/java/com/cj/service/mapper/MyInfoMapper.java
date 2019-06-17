package com.cj.service.mapper;

import com.cj.service.domain.entity.MyInfo;
import com.cj.service.domain.entity.MyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 */
@Repository
public interface MyInfoMapper {
    long countByExample(MyInfoExample example);

    int deleteByExample(MyInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MyInfo record);

    int insertSelective(MyInfo record);

    List<MyInfo> selectByExample(MyInfoExample example);

    MyInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MyInfo record, @Param("example") MyInfoExample example);

    int updateByExample(@Param("record") MyInfo record, @Param("example") MyInfoExample example);

    int updateByPrimaryKeySelective(MyInfo record);

    int updateByPrimaryKey(MyInfo record);
}