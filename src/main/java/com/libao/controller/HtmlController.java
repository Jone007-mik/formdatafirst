package com.libao.controller;

import com.libao.common.JsonBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class HtmlController{

    @RequestMapping(value = "json_formdata",method = RequestMethod.GET)
    public String enterIndex(){
        return "index";
    }

    /**
     * 前端传输formdata 后端取值
     * @param username
     * @param pwd
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "formdata",method = RequestMethod.POST)
    public JsonBean dataform1(String username,String pwd){
        System.out.println("toString"+username+pwd);
        JsonBean jsonBean=new JsonBean(-1,"no",null);
        if(username!=null){
            System.out.println(username);
            jsonBean=new JsonBean(0,"yes",username);
        }
        return jsonBean;
    }

    /**
     * 前端传formdata  file文件 后端取文件
     * @param files
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "formdataFile",method = RequestMethod.POST)
    public JsonBean dataformFile(@RequestParam("file")MultipartFile []files){
        JsonBean jsonBean=new JsonBean(-1,"no",null);
        for (MultipartFile file : files) {
            //获取原始文件名
            String ware_name1 = file.getOriginalFilename();
            System.out.println("原始文件名：" + ware_name1);
            //新文件
            String ware_name = UUID.randomUUID() + ware_name1;
            //获取项目路径
                    //获取上传文件的保存目录，将上传的文件存放于WEB-INF目录下
                    // 不允许外界直接访问，保证上传文件的安全
            String address = "D:\\newnew\\";
            File filex = new File(address);
            if (!(filex.exists())) {//若上传目录不存在，则创建目录  (filex.exists() && filex.isDirectory())
                System.out.println("kaishi 创建文件");
                filex.mkdirs();
            }
            String message = "";
            InputStream is = null;
            FileOutputStream fos = null;
            byte[] buffer = new byte[100 * 1024];//根据上传文件大小设定
            try {
                is = file.getInputStream();// 获得上传文件流
                //创建文件输出流  使用FileOutputStream打开服务器端的上传文件
                fos = new FileOutputStream(address + ware_name);
                int len = 0;
                //开始读取上传文件的字节，并将其输出到服务端的上传文件输出流中
                //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                while ((len = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);//写入到指定的目录当中
                }
                fos.flush();
                is.close();
                fos.close();
                message = "上传成功！";
                message += "上传内容：" + ware_name;
                System.out.println( message);
                jsonBean=new JsonBean(0,"OK",ware_name);
            } catch (IOException e) {
                message = "文件上传失败！";
                e.printStackTrace();
            }

        }

        return jsonBean;
    }
//    public JsonBean dataformFile(HttpServletRequest request){
//        JsonBean jsonBean=new JsonBean(-1,"no",null);
//        MultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
//        MultipartHttpServletRequest multipartHttpServletRequest=multipartResolver.resolveMultipart(request);
//        MultipartFile file=multipartHttpServletRequest.getFile("image");
//        if(file!=null){
//            System.out.println(file);
//            jsonBean=new JsonBean(0,"yes",file);
//            MultipartHttpServletRequest servletRequest= (MultipartHttpServletRequest) request;
//            file=servletRequest.getFile("image");
//        }
//        return jsonBean;
//    }

}
