package com.hyun.board_back.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JwtProvider
 */
@Component
public class JwtProvider {
    
    @Value("${secret-key}")//application.properties에 토큰 키 저장
    private String secretKey;

    public String create(String email){// 토큰 생성
        //토큰 발급 시간
        Date expiredDate = Date.from(Instant.now().plus(1,ChronoUnit.HOURS));

        @SuppressWarnings("deprecation")
        String jwt = Jwts.builder() // JWT 생성
            .signWith(SignatureAlgorithm.ES256, secretKey) //알고리즘 사용
            // 주체:email, 생성일(현재시간) , 만료시간
            .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredDate) 
            .compact();

        return jwt;
    }

    //검증
    public String validate(String jwt) {

        Claims claims=null;

        try {
            claims = Jwts.parser().setSigningKey(secretKey) // 토큰 key가 맞지 않을 경우
                .parseClaimsJws(jwt).getBody();// 토크 기간 만료
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return claims.getSubject();
    }
    
}