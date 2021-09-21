/**
 * @author: zty
 * @program: SpringMVC
 * @ClassName TestController
 * @description:
 * @create: 2021-08-10 16:07
 * @Version 1.0
 **/
package com.zty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/t1")
    public String test(){
        System.out.println("TestController.test");
        return "ok";
    }
}
