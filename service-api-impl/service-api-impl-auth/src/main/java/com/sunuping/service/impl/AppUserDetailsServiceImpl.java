package com.sunuping.service.impl;

import com.sunuping.config.UserInfo;
import com.sunuping.exception.ErrorException;
import com.sunuping.model.User;
import com.sunuping.service.i.AppUserDetailsService;
import com.sunuping.service.i.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author lime
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AppUserDetailsServiceImpl implements AppUserDetailsService {
    final UserService userService;

    @Autowired
    public AppUserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = new UserInfo();
        User user = Optional.ofNullable(userService.getByUsername(username)).orElseThrow(() -> new ErrorException("账号不存在"));
        BeanUtils.copyProperties(user, userInfo);
        return userInfo;
    }
}
