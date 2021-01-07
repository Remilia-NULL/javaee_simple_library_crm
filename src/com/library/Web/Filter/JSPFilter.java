package com.library.Web.Filter;
/*
* 拦截所有对于jsp的访问，统一重定向于404。
* */
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JSPFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        httpServletRequest.getRequestDispatcher("/ERROR/404.html").forward(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
