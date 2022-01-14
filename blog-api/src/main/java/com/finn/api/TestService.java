package com.finn.api;

import com.finn.entity.Student;
import com.finn.entity.User;
import org.apache.ibatis.annotations.Param;

/*
 * @description: Dao接口
 * @author: Finn
 * @create: 2022-01-09-19-25
 */
public interface TestService {

    String test();

    User getUserById(Integer id);

}
