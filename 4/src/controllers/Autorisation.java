package controllers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Autorisation implements Filter {
	private ServletContext context;
    public Autorisation() {
        // TODO Auto-generated constrctor stub
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
	     HttpServletResponse res = (HttpServletResponse) response;
	     HttpSession session = req.getSession();
	     
	     if (session == null) {   //checking whether the session exists
	            this.context.log("Unauthorized access request");
	            res.sendRedirect(req.getContextPath() + "/login");
	        } else {
	            // pass the request along the filter chain
	            chain.doFilter(request, response);
	        }
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		 this.context = fConfig.getServletContext();
	        this.context.log("AuthenticationFilter initialized");
	}

}
