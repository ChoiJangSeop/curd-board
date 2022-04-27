package util.filter;

import javax.servlet.*;
import java.io.IOException;

public class SessionCheckFilter implements Filter {
    FilterConfig config;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

    }
}
