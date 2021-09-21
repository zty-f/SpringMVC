/**
 * @author: zty
 * @program: SpringMVC
 * @ClassName HelloController
 * @description:
 * @create: 2021-08-08 15:28
 * @Version 1.0
 **/
package com.zty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zty")
public class HelloController {
    //真实访问地址 : 项目名/HelloController/hello
    @RequestMapping("/hello")
    public String sayHello(Model model){
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVC Annotation!!!!");
        //web-inf/jsp/hello.jsp
        return "hello";
    }
}