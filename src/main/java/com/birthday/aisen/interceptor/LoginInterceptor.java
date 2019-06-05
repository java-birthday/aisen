package com.birthday.aisen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.stereotype.Service;

import java.util.HashMap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;

@Service("loginInterceptor")
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        //获取session
        HttpSession session = request.getSession(true);
        if(session.getAttribute("userId") == null) {

            HashMap<String,String> result = new HashMap<>();
            result.put("error", "请先登录");

            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(result.toString());
            return false;
        }

        logger.info(session.getAttribute("userId").toString());
        return true;

    }

}
