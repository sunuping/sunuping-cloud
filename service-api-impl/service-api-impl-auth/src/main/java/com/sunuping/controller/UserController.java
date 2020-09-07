package com.sunuping.controller;

import com.alibaba.fastjson.JSON;
import com.sunuping.annotation.ResponseResult;
import com.sunuping.exception.ErrorException;
import com.sunuping.model.UmsAdmin;
import com.sunuping.service.i.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author lime
 */
@RequestMapping("/oauth")
@RestController
@ResponseResult
@Slf4j
public class UserController {
    @Autowired
    private UmsAdminService umsAdminService;

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @ResponseResult
    @GetMapping("/ok")
    public UmsAdmin get() {
        return new UmsAdmin();
    }

    @ResponseResult
    @GetMapping("/err")
    public UmsAdmin err() {
        log.debug(JSON.toJSONString(umsAdminService.list()));
        throw new ErrorException("");
    }
}
