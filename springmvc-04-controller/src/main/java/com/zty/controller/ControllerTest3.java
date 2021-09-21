/**
 * @author: zty
 * @program: SpringMVC
 * @ClassName ControllerTest3
 * @description:
 * @create: 2021-08-08 16:10
 * @Version 1.0
 **/
package com.zty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c3")
public class ControllerTest3 {

    @RequestMapping("/t2")
    public String test1(Model model){
        model.addAttribute("msg","ControllerTest3");
        return "test";
    }
}
