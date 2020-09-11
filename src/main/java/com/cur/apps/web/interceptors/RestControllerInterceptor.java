package com.cur.apps.web.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;

@Component
public class RestControllerInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(RestControllerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws UnknownHostException {
        System.out.println("Entered preHandle interceptor.");
        String s1 = request.getMethod();
        String s2 = request.getContextPath();
        String s12 = request.getQueryString();
        String s121 = request.getPathInfo();
        String s3 = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        Enumeration<String> s4 = request.getParameterNames();



        return true;
    }
}
