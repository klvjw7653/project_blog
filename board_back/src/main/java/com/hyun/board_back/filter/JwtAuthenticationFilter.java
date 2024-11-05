package com.hyun.board_back.filter;

import java.io.IOException;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hyun.board_back.provider.JwtProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

/**
 * JwtAuthenticcationFilter
 */
@Component
@RequiredArgsConstructor //필수(final) 멤버 변수에 생성자를 만들어줄 수 있다.
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtprovider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try{

            String token = paresBearerToken(request);
    
            if(token == null) {
                filterChain.doFilter(request, response);
                return;
            }
    
            String email = jwtprovider.validate(token);
    
            if(email == null){
                filterChain.doFilter(request, response);
                return;
            }
            
            AbstractAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(email,null,AuthorityUtils.NO_AUTHORITIES);
            
                //인증 요청에 대한 세부 정보 설정할 수 있다
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            //내부 context에 이메일을 저장
            securityContext.setAuthentication(authenticationToken);
            //외부 context에서 사용가능하게 ContextHolder에 저장함
            SecurityContextHolder.setContext(securityContext);
        
        } catch(Exception exception) {
            exception.printStackTrace();

        }     

        filterChain.doFilter(request, response);// 다음 필터로 넘긴다.
        
        
    }

    private String paresBearerToken(HttpServletRequest request) {

        String authorization = request.getHeader("Authorization");

        boolean hasAuthorization = StringUtils.hasText(authorization);
        // hasText = 값이 null / 길이가 0/ 공백이면 False로 반환됨
        if(!hasAuthorization) return null;

        boolean isBearer = authorization.startsWith("Bearer ");
        if(!isBearer) return null;

        String token = authorization.substring(7);
        return token;
    }

    
}