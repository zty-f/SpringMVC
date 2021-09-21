/**
 * @author: zty
 * @program: SpringMVC
 * @ClassName User
 * @description:
 * @create: 2021-08-09 15:03
 * @Version 1.0
 **/
package com.zty.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private String sex;
}

