package com.sunuping.service.i;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import com.sunuping.dto.PayloadDTO;

import java.text.ParseException;

public interface JwtTokenService {

    String generateTokenByHmac(String payloadStr, String secret) throws JOSEException;

    PayloadDTO verifyTokenByHmac(String token, String secret) throws ParseException, JOSEException;

    PayloadDTO getDefaultPayloadDTO();

    RSAKey getDefaultRsaKey();

    PayloadDTO verifyTokenByRsa(String token, RSAKey rsaKey) throws ParseException, JOSEException;

    String generateTokenByRsa(String payloadStr, RSAKey rsaKey) throws JOSEException;

}
