package com.liu.springtest.start.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.print("MyFilter..执行了..");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
