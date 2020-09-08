package com.sunuping.controller;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.sunuping.bean.CommonResult;
import com.sunuping.dto.PayloadDTO;
import com.sunuping.service.i.JwtTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

/**
 * JWT令牌管理Controller
 *
 * @author lime
 */
@Api(tags = "JwtTokenController", description = "JWT令牌管理")
@Controller
@RequestMapping("/token")
public class JwtTokenController {

    final JwtTokenService jwtTokenService;

    @Autowired
    public JwtTokenController(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @ApiOperation("使用对称加密（HMAC）算法生成token")
    @RequestMapping(value = "/hmac/generate", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<?> generateTokenByHmac() {
        try {
            PayloadDTO payloadDto = jwtTokenService.getDefaultPayloadDTO();
            String token = jwtTokenService.generateTokenByHmac(JSON.toJSONString(payloadDto), SecureUtil.md5("test"));
            return CommonResult.ok(token);
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return CommonResult.fail();
    }

    @ApiOperation("使用对称加密（HMAC）算法验证token")
    @RequestMapping(value = "/hmac/verify", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<?> verifyTokenByHmac(String token) {
        try {
            PayloadDTO payloadDto = jwtTokenService.verifyTokenByHmac(token, SecureUtil.md5("test"));
            return CommonResult.ok(payloadDto);
        } catch (JOSEException | ParseException e) {
            e.printStackTrace();
        }
        return CommonResult.fail();

    }

    @ApiOperation("获取非对称加密（RSA）算法公钥")
    @RequestMapping(value = "/rsa/publicKey", method = RequestMethod.GET)
    @ResponseBody
    public Object getRsaPublicKey() {
        RSAKey key = jwtTokenService.getDefaultRsaKey();
        return new JWKSet(key).toJSONObject();
    }

    @ApiOperation("使用非对称加密（RSA）算法生成token")
    @RequestMapping(value = "/rsa/generate", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<?> generateTokenByRsa() {
        try {
            PayloadDTO payloadDto = jwtTokenService.getDefaultPayloadDTO();
            String token = jwtTokenService.generateTokenByRsa(JSON.toJSONString(payloadDto),jwtTokenService.getDefaultRsaKey());
            return CommonResult.ok(token);
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return CommonResult.fail();
    }

    @ApiOperation("使用非对称加密（RSA）算法验证token")
    @RequestMapping(value = "/rsa/verify", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<?> verifyTokenByRsa(String token) {
        try {
            PayloadDTO payloadDto  = jwtTokenService.verifyTokenByRsa(token, jwtTokenService.getDefaultRsaKey());
            return CommonResult.ok(payloadDto);
        } catch (ParseException | JOSEException e) {
            e.printStackTrace();
        }
        return CommonResult.fail();
    }
}