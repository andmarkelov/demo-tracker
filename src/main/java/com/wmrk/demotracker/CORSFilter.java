//package com.wmrk.demotracker;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class CORSFilter implements Filter {
//
////    private static final Logger LOGGER = LogManager.getLogger(CORSFilter.class.getName());
////
////    @Override
////    public void init(FilterConfig filterConfig) throws ServletException {
////    }
////
////    @Override
////    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
////        final HttpServletRequest request = (HttpServletRequest) req;
////        final HttpServletResponse response = (HttpServletResponse) res;
////        final String origin = ((HttpServletRequest) req).getHeader("Origin");
////
////        if (true) {
////            LOGGER.info("CORSFilter run");
////            response.addHeader("Access-Control-Allow-Origin", "*");
////            //response.addHeader("Access-Control-Allow-Credentials", "true");
////
////            if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
////                response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
////                response.addHeader("Access-Control-Allow-Headers", "X-Requested-With,Origin,Content-Type,Accept,Authorization");
////                response.setStatus(200);
////            }
////        }
////        chain.doFilter(addNecessaryHeaders(request), response);
////    }
////
////
////    private MutableHttpServletRequest addNecessaryHeaders(final HttpServletRequest request) {
////        final MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(request);
////        mutableRequest.putHeader("Accept", "application/json");
////        mutableRequest.putHeader("Authorization", "Basic" + " bXVzaWNzY2hvb2w6");
////        return mutableRequest;
////    }
////
////    @Override
////    public void destroy() {
////    }
//}