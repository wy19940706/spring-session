package com.wenyao.springsession.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@javax.servlet.annotation.WebFilter(filterName = "userFilter", urlPatterns = "/*")
public class WebFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(WebFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("---------过滤器正在启动-------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        logger.info("---------过滤器正在处理----------");
        logger.info("-----处理的uri：{}-------------", uri);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("-----------过滤器已被销毁------------");
    }
}
