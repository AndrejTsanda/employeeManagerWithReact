package com.tsanda.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebMvc
public class CorsFilter implements Filter {

  private static final Logger logger = LogManager.getLogger();

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Max-Age", "3600");

    logger.debug("CORSFilter HTTP Request Method: " + request.getMethod());
    logger.debug("CORSFilter HTTP Request URL: " + request.getRequestURI());

    filterChain.doFilter(request, res);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    logger.info("CORSFilter initialized.");
  }

  @Override
  public void destroy() {
    logger.info("CORSFilter destroyed.");
  }
}
