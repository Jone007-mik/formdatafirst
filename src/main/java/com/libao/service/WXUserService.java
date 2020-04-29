package com.libao.service;

import com.libao.common.JsonBean;
import com.libao.domain.model.WXUser;

public interface WXUserService{
    JsonBean insertUser(WXUser user);

    JsonBean deleteByUserId(Integer id);

    JsonBean updateUser(WXUser user);

    JsonBean selectByUserId(Integer id);

    JsonBean selectUserListByUser(WXUser user);
}
