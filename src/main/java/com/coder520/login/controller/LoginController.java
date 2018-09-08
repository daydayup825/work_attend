package com.coder520.login.controller;

import com.coder520.common.utils.SecurityUtils;
import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;


/**
 * @author: fanbopeng
 * @Date: 2018/9/5 12:14
 * @Description: 登录controller
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping()
    public String login(){
        /**
         *
         * 功能描述: 登录界面
         *
         * @param: []
         * @return: java.lang.String
         * @auther: fanbopeng
         * @date: 2018/9/5 12:48
         */

        return "login";

    }

    @RequestMapping("/registerPage")
    public String register(){
        /**
         *
         * 功能描述: 登录界面
         *
         * @param: []
         * @return: java.lang.String
         * @auther: fanbopeng
         * @date: 2018/9/5 12:48
         */

        return "register";

    }


    @RequestMapping("/check")
    @ResponseBody
    public String checkLogin(HttpServletRequest request) throws NoSuchAlgorithmException {
        /**
         *
         * 功能描述:  账号密码校验 如果校验成功  用户信息存到session
         *
         * @param: [request]
         * @return: java.lang.String
         * @auther: fanbopeng
         * @date: 2018/9/5 12:51
         */
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user= userService.findUserByUsername(username);
        if(user!=null){
                     boolean b = SecurityUtils.checkPassword(password, user.getPassword());
                if (b){
                    //校验成功设置session
                    request.getSession().setAttribute("userInfo", user);
                    return "login_succ";
                 }else {
                //校验失败返回校验失败
                    return "login_fail";
            }
        }else {
            return "login_fail";
        }


    }

    @RequestMapping("/register")
    public String register(@RequestParam("username") String username,@RequestParam("password") String password)
            throws NoSuchAlgorithmException {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);


            userService.registerUser(user);


         return "login";


    }


}
