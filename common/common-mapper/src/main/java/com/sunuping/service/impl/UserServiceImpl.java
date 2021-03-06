package com.sunuping.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunuping.mapper.UserMapper;
import com.sunuping.model.User;
import com.sunuping.service.i.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author lime
 * @since 2020-09-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public User getByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.select(User::getId, User::getIsEnabled, User::getPassword, User::getUsername, User::getHeadImage)
                .eq(User::getUsername, username);
        return getOne(wrapper);
    }
}
