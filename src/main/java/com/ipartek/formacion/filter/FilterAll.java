package com.ipartek.formacion.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.listener.InitListener;

/**
 * Servlet Filter implementation class FilterAll
 */
public class FilterAll implements Filter {


private final static Logger LOG = Logger.getLogger("FilterAll");

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.trace("filtro destruido");
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOG.trace("filtro ejecutandose");
		// place your code here

		LOG.debug("IP="+request.getRemoteAddr());
		LOG.debug("IP="+((HttpServletRequest)request).getHeader("User-Agent"));
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.trace("filtro inicializado");
	}

}
