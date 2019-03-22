package com.wechat.dao;

import com.wechat.bean.Greens;
import com.wechat.bean.GreensExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GreensMapper {
    long countByExample(GreensExample example);

    int deleteByExample(GreensExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(Greens record);

    int insertSelective(Greens record);

    List<Greens> selectByExample(GreensExample example);

    Greens selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") Greens record, @Param("example") GreensExample example);

    int updateByExample(@Param("record") Greens record, @Param("example") GreensExample example);

    int updateByPrimaryKeySelective(Greens record);

    int updateByPrimaryKey(Greens record);
}