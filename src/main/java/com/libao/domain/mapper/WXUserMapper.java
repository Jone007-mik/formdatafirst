package com.libao.domain.mapper;

import com.libao.domain.model.WXUser;

public interface WXUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WXUser record);

    int insertSelective(WXUser record);

    WXUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WXUser record);

    int updateByPrimaryKey(WXUser record);
}