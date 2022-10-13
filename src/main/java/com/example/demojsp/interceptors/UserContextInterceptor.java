package com.example.demojsp.interceptors;

import com.example.demojsp.context.UserContext;
import com.example.demojsp.context.UserContextSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UserContextInterceptor implements Filter {
    private final UserContextSupport userContextSupport;

    @Autowired
    public UserContextInterceptor(UserContextSupport userContextSupport) {
        this.userContextSupport = userContextSupport;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        userContextSupport.processUserContext((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        userContextSupport.resetContext();
        Filter.super.destroy();
    }


//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        userContextSupport.processUserContext(request, response);
//        request.setAttribute("userContext", UserContext.getUserFromUserContext());
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        userContextSupport.resetContext();
//    }
}
