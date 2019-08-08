package com.example.other.core;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wxq
 * @date 2018-11-22
 */
public class RequestParameterFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Map<String, Object> parameter = new HashMap<>();
        /*1.获取加密串,进行解密*/

        /*2.解密出加密串，我和前台约定的是JSON,获取到JSON我将其转换为map，这里我直接用手动封装map代替*/

        parameter.put("action", "123");
        ParameterRequestWrapper wrapper = new ParameterRequestWrapper(request, parameter);
        filterChain.doFilter(wrapper, response);
    }
}
