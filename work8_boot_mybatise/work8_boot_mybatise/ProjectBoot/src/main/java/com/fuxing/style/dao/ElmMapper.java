package com.fuxing.style.dao;

import com.fuxing.style.model.Elm;

public interface ElmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Elm record);

    int insertSelective(Elm record);

    Elm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Elm record);

    int updateByPrimaryKey(Elm record);
}