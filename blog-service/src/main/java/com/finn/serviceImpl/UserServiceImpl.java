package com.finn.serviceImpl;

import com.finn.entity.User;
import com.finn.mapper.UserMapper;
import com.finn.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author finn
 * @since 2022-01-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
