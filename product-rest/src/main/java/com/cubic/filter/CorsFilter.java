package com.cubic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		if (servletResponse instanceof HttpServletResponse) {
			HttpServletResponse alteredResponse = ((HttpServletResponse) servletResponse);
			/*
			 * String acAllowHeaderValue =
			 * request.getHeader("Access-Control-Allow-Origin"); if
			 * (StringUtils.isEmpty(acAllowHeaderValue)) { acAllowHeaderValue =
			 * request.getHeader("access-control-allow-origin"); }
			 */
			// HttpServletResponse alteredResponse = ((HttpServletResponse)
			// servletResponse);
			addHeadersFor200Response(alteredResponse);
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	private void addHeadersFor200Response(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, PUT, OPTIONS, DELETE, OPTIONS");
		// if (StringUtils.isEmpty(acAllowHeaderValue)) {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		/*
		 * } else { response.addHeader("Access-Control-Allow-Headers",
		 * acAllowHeaderValue); }
		 */
	}

}
