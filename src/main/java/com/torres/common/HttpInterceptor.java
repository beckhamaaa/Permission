package com.torres.common;

import com.torres.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Torres
 * 2018-05-27 18:47
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME="requestStartTime";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      String url=request.getRequestURI().toString();
      Map parameterMap=request.getParameterMap();
      log.info("request start. url:{},params:{}",url, JsonMapper.obj2String(parameterMap));
      long start= System.currentTimeMillis();
      request.setAttribute(START_TIME,start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        正常才进入此方法
//        String url=request.getRequestURI().toString();
//        Map parameterMap=request.getParameterMap();
//        long start= (long) request.getAttribute(START_TIME);
//        long end=System.currentTimeMillis();
//        log.info("request finished. url:{},costs:{}",url, end-start);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url=request.getRequestURI().toString();
        Map parameterMap=request.getParameterMap();
        long start= (long) request.getAttribute(START_TIME);
        long end=System.currentTimeMillis();
        log.info("request completed. url:{},costs:{}",url, end-start);
    }
}
