package org.java.mql.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private ObjectMapper mapper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Map<String, Object> errorDetails = new HashMap<>();
		
		try {
			 String accessToken = jwtUtil.resolveToken(request);
	            if (accessToken == null ) {
	                filterChain.doFilter(request, response);
	                return;
	            }
	            System.out.println("dazz");
	            Claims claims = jwtUtil.resolveClaims(request);
	            if(claims != null & jwtUtil.validateClaims(claims)){
	                String username = claims.getSubject();
	                System.out.println("user : "+username);
	                Authentication authentication =
	                        new UsernamePasswordAuthenticationToken(username,"",new Vector<>());
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	            }
			
		} catch (Exception e) {
			
			errorDetails.put("message", "Authentication Error");
            errorDetails.put("details",e.getMessage());
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            mapper.writeValue(response.getWriter(), errorDetails);
		}
        filterChain.doFilter(request, response);

	}
	
	

}
