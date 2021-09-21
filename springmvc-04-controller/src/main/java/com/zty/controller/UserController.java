/**
 * @author: zty
 * @program: SpringMVC
 * @ClassName UserController
 * @description:
 * @create: 2021-08-08 18:45
 * @Version 1.0
 **/
package com.zty.controller;

import com.zty.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    //@RequestParam("username") : username提交的域的名称 .
    @GetMapping("/name")
    public String test1(@RequestParam("username") String name, Model model){
        System.out.println("接收到前端的参数"+name);
        model.addAttribute("msg",name);
        return "test";
    }

    @GetMapping("/add")
    public String test2(User user,Model model){
        System.out.println(user);
        model.addAttribute("msg",user);
        return "test";
    }

    @RequestMapping("/tt")
    public String test3(@RequestParam("username") String name, ModelMap modelMap){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        modelMap.addAttribute("msg",name);
        System.out.println(name);
        return "test";
    }






}
