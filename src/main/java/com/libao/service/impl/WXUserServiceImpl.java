package com.libao.service.impl;

import com.libao.common.JsonBean;
import com.libao.domain.mapper.WXUserMapper;
import com.libao.domain.model.WXUser;
import com.libao.service.WXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class WXUserServiceImpl implements WXUserService{
    @Autowired
    private WXUserMapper wxUserMapper;
    public JsonBean insertUser(WXUser user) {
        JsonBean jsonBean=new JsonBean(-1,"error",null);
        int a=wxUserMapper.insert(user);
        if(a>0){
            jsonBean=new JsonBean(0,"ok",user);
        }
        return jsonBean;
    }

    public JsonBean deleteByUserId(Integer id) {
        JsonBean jsonBean=new JsonBean(-1,"error",null);
        int a=wxUserMapper.deleteByPrimaryKey(id);
        if(a>0){
            jsonBean=new JsonBean(0,"ok",id);
        }
        return jsonBean;
    }

    public JsonBean updateUser(WXUser user) {
        JsonBean jsonBean=new JsonBean(-1,"error",null);
        int a=wxUserMapper.updateByPrimaryKeySelective(user);
        if(a>0){
            jsonBean=new JsonBean(0,"ok",user);
        }
        return jsonBean;
    }

    public JsonBean selectByUserId(Integer id) {
        JsonBean jsonBean=new JsonBean(-1,"error",null);
        WXUser user=wxUserMapper.selectByPrimaryKey(id);
        if(user!=null){
            jsonBean=new JsonBean(0,"ok",user);
        }
        return jsonBean;
    }

    public JsonBean selectUserListByUser(WXUser wxUser) {
        JsonBean jsonBean=new JsonBean(-1,"error",null);

        return jsonBean;
    }

}
