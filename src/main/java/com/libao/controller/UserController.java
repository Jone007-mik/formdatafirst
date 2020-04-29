package com.libao.controller;

import com.libao.common.CipherUtil;
import com.libao.common.JsonBean;
import com.libao.domain.model.WXUser;
import com.libao.service.WXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "user")
public class UserController{
    @Autowired
    private WXUserService wxUserService;

    @RequestMapping(value = "insert")
    @ResponseBody
    public JsonBean insertUser(WXUser user){
        JsonBean jsonBean=new JsonBean(-1,"error",null);
        return wxUserService.insertUser(user);
    }
    @RequestMapping(value = "delete")
    @ResponseBody
    public JsonBean deleteUser(Integer id){
        JsonBean jsonBean=new JsonBean(-1,"error",null);
        return wxUserService.deleteByUserId(id);
    }
    @RequestMapping(value = "update")
    @ResponseBody
    public JsonBean updateUser(WXUser user){
        JsonBean jsonBean=new JsonBean(-1,"error",null);
        return wxUserService.updateUser(user);
    }
    @ResponseBody
    @RequestMapping(value = "selectById" ,method = RequestMethod.GET)
    public JsonBean selectById(String id){
        System.out.println("id==="+id);
        JsonBean jsonBean=new JsonBean(-1,"error",null);
        return wxUserService.selectByUserId(Integer.parseInt(id));
    }
    @RequestMapping(value = "selectUserList")
    @ResponseBody
    public JsonBean selectUserById(WXUser wxUser){
        JsonBean jsonBean=new JsonBean(-1,"error",null);
        return wxUserService.selectUserListByUser(wxUser);
    }
    @ResponseBody
    @RequestMapping(value = "login" )
    public JsonBean login(String username,String pwd){
        JsonBean jsonBean=new JsonBean(-1,"no",null);
        String result=null;
        if(username!=null&&pwd!=null){
            System.out.println("username="+username);
            System.out.println("pwdbefore="+pwd);
            pwd=CipherUtil.createPwdEncrypt(username,pwd,null);
            System.out.println("pwdafter="+pwd);
            result=username+pwd;
            jsonBean=new JsonBean(0,"yes",result);
        }
        return jsonBean;
    }
}
