package com.coder520.common.interceptor;

import com.coder520.user.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author: fanbopeng
 * @Date: 2018/9/5 15:21
 * @Description:
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (uri.indexOf("login")>=0||uri.indexOf("sign")>=0){
            return  true;
        }else {

            User userinfo = (User)request.getSession().getAttribute("userInfo");
            if(userinfo!=null){

                return  true;
            }

                request.getRequestDispatcher("/login").forward(request, response);
                return false;


        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
