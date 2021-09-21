/**
 * @author: zty
 * @program: SpringMVC
 * @ClassName ResultSpringMVC2
 * @description:
 * @create: 2021-08-08 17:33
 * @Version 1.0
 **/
package com.zty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultSpringMVC2 { //需要配置视图解析器
    @RequestMapping("/rng/t1")
    public String test1(){
        //转发
        return "test";
    }

    @RequestMapping("/rng/t2")
    public String test2(){
        //重定向
        return "redirect:/index.jsp";
        //return "redirect:hello.do"; //hello.do为另一个请求/
    }

}

