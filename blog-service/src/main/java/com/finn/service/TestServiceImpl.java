package com.finn.service;

import com.finn.api.TestService;
import com.finn.entity.Student;
import com.finn.entity.User;
import com.finn.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/*
 * @description: implement com.finn.api.TestService
 * @author: Finn
 * @create: 2022-01-09-19-26
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public String test() {
        return "hello world!";
    }

    @Override
    public User getUserById(Integer id) {
        return testMapper.getUserById(id);
//        return null;
    }


}
