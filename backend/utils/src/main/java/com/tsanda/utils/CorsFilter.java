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

    response.addHeader("Access-Control-Allow-Origin", "*");
    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
    response.setHeader(
        "Access-Control-Allow-Headers",
        "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, observe");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Expose-Headers", "Authorization");
    response.addHeader("Access-Control-Expose-Headers", "responseType");
    response.addHeader("Access-Control-Expose-Headers", "observe");

    logger.debug("CORSFilter HTTP Request Method: " + request.getMethod());
    logger.debug("CORSFilter HTTP Request URL: " + request.getRequestURI());

    if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
      try {
        filterChain.doFilter(req, res);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Pre-flight");
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader(
          "Access-Control-Allow-Headers",
          "Access-Control-Expose-Headers"
              + "Authorization, content-type,"
              + "access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with,responseType,observe");
      response.setStatus(HttpServletResponse.SC_OK);
    }
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
