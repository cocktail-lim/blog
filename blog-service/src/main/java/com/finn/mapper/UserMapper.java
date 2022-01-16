package com.finn.mapper;

import com.finn.api.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author finn
 * @since 2022-01-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
