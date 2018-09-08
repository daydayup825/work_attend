package com.coder520.user.controller;

import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author: fanbopeng
 * @Date: 2018/9/5 11:26
 * @Description: 用户controller
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/home")
    public String home(){
  /**
   *
   * 功能描述:
   * 跳转到home界面
   * @param: []
   * @return: java.lang.String
   * @auther: fanbopeng
   * @date: 2018/9/6 12:10
   */
        System.out.println("userController");

        return "home";
    }


    @RequestMapping("/userinfo")
    @ResponseBody
    public User getUser(HttpSession session){
        /**
         *
         * 功能描述:
         * 获取用户信息
         * @param: [session]
         * @return: com.coder520.user.entity.User
         * @auther: fanbopeng
         * @date: 2018/9/6 12:13
         */
        User userInfo = (User) session.getAttribute("userInfo");
         return userInfo;
    }

    @RequestMapping("/logout")
    public  String logout(HttpSession session){
        /**
         *
         * 功能描述:  销毁session 用户退出
         *
         * @param: [session]
         * @return: java.lang.String
         * @auther: fanbopeng
         * @date: 2018/9/6 13:32
         */

        session.invalidate();

        return "login";

    }






}
