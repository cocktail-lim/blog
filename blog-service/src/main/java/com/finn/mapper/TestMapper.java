package com.finn.mapper;


import com.finn.entity.Student;
import com.finn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface TestMapper {

    /* @Param("id") 可以把 id 参数和 xml 文件中的 #{id} 进行绑定 */
    User getUserById(@Param("id") Integer id);

}
