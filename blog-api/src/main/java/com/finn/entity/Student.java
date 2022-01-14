package com.finn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @description: test
 * @author: Finn
 * @create: 2022-01-11-15-49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String name;
    private String email;
    private Integer age;

}
