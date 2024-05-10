package edu.njit.dbms.group11;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CSPFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter initialization code can be added here.
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            HttpServletResponse httpResp = (HttpServletResponse) response;
            // Set CSP policies
            httpResp.setHeader("Content-Security-Policy", "default-src 'self' ; script-src-elem 'self' ; style-src-elem 'self' ;img-src 'self' ;");
            httpResp.setHeader("Access-Control-Allow-Origin", "localhost:8080");
            httpResp.setHeader("X-Frame-Options", "SAMEORIGIN");
            //httpResp.setHeader("","");
        }
        chain.doFilter(request, response);

    }

    public void destroy() {
        // Filter destruction code can be added here.
    }
}

