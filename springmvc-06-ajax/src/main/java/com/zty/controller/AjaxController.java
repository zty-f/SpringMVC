/**
 * @author: zty
 * @program: SpringMVC
 * @ClassName AjaxController
 * @description:
 * @create: 2021-08-09 16:32
 * @Version 1.0
 **/
package com.zty.controller;

import com.zty.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/a1")
    public void ajax1(String name , HttpServletResponse response) throws IOException {
        if ("zty".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
            }
        }
    @RequestMapping("/a2")
    public List<User> ajax2(){
        List<User> list = new ArrayList<User>();
        list.add(new User("张天泳1",3,"男"));
        list.add(new User("张天泳2",3,"男"));
        list.add(new User("张天泳3",3,"男"));
        return list; //由于@RestController注解，将list转成json格式返回
    }
    @RequestMapping("/a3")
    public String ajax3(String name,String pwd){
        String msg = "";
        //模拟数据库中存在数据
        if (name!=null){
            if ("zty".equals(name)){
                msg = "OK";
            }else {
                msg = "用户名输入错误";
            }
        }
        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg = "OK";
            }else {
                msg = "密码输入有误";
            }
        }
        return msg; //由于@RestController注解，将msg转成json格式返回
    }



}