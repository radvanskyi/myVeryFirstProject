package controller.internationalization;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodFilter implements Filter {

    private String encoding;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String requestEncoding = httpRequest.getCharacterEncoding();
        if (requestEncoding == null) {
            request.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    public void destroy() { }
}
