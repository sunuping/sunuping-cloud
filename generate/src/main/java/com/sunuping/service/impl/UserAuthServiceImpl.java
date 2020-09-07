package com.sunuping.service.impl;

import com.sunuping.model.UserAuth;
import com.sunuping.mapper.UserAuthMapper;
import com.sunuping.service.i.UserAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 第三方应用用户关联 服务实现类
 * </p>
 *
 * @author lime
 * @since 2020-09-07
 */
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthMapper, UserAuth> implements UserAuthService {

}
