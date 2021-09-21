package com.zty.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zty.pojo.User;
import com.zty.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController //:相当于@controller+@ResponseBody
public class UserController {
    //produces:指定响应体返回类型和编码
    //@RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")
    @RequestMapping("/j1")
    //@ResponseBody//他就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        //jackson中的对象：ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User(1, "张天泳!!!", 12);
        return JsonUtils.getJson(user);
    }
    @RequestMapping("/j2")
    //@ResponseBody//他就不会走视图解析器，会直接返回一个字符串
    public String json2() throws JsonProcessingException {

        //创建一个对象
        User user1 = new User(1, "张天泳1", 12);
        User user2 = new User(2, "张天泳2", 12);
        User user3 = new User(3, "张天泳3", 12);
        User user4 = new User(4, "张天泳4", 12);
        User user5 = new User(5, "张天泳5", 12);
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        //将我们的对象解析成为json格式
        return JsonUtils.getJson(list);
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        //创建时间一个对象，java.util.Date
        Date date = new Date();
        //将我们的对象解析成为json格式
        //Jackson 默认是会把时间转成timestamps形式
        return JsonUtils.getJson(date);
    }

    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);//使用ObjectMapper解决
        String str1 = mapper.writeValueAsString(sdf.format(date));//传统JAVA方式解决

        return str+str1;
    }
    @RequestMapping("/j5")
    public String json5() throws JsonProcessingException {

        Date date = new Date();
        return JsonUtils.getJson(date);
    }

    @RequestMapping("/j6")
    public String json6(){

        User user1 = new User(1, "张天泳1", 12);
        User user2 = new User(2, "张天泳2", 12);
        User user3 = new User(3, "张天泳3", 12);
        User user4 = new User(4, "张天泳4", 12);
        User user5 = new User(5, "张天泳5", 12);

        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return JSON.toJSONString(list);
    }




}
