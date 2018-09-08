package com.coder520.attend.controller;

import com.coder520.attend.entity.Attend;
import com.coder520.attend.vo.QueryCondition;
import com.coder520.common.utils.PageQueryBean;
import com.coder520.user.entity.User;
import com.coder520.user.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * @author: fanbopeng
 * @Date: 2018/9/6 13:36
 * @Description: 打卡controller
 */
@Controller
@RequestMapping("attend")
public class AttendController {

    @Autowired
    private AttendService attendService;

    @RequestMapping()
    public String attend(){
        /**
         *
         * 功能描述:
         *      打卡页面
         * @param: []
         * @return: java.lang.String
         * @auther: fanbopeng
         * @date: 2018/9/6 13:39
         */
        System.out.println("进入");

        return "attend";
    }

    @RequestMapping("/sign")
    @ResponseBody
    public  String signAttend(@RequestBody Attend attend) throws Exception {
        /**
         *
         * 功能描述:
         *      打卡控制层*
         * @param: [attend]
         * @return: java.lang.String
         * @auther: fanbopeng
         * @date: 2018/9/6 20:21
         */
           attendService.signAttend(attend);
            return  "succ";
    }

    @RequestMapping("/attendList")
    @ResponseBody
    public PageQueryBean signList(QueryCondition queryCondition, HttpSession session){


        User user = (User) session.getAttribute("userInfo");
        String[] rangeDate = queryCondition.getRangeDate().split("/");
        queryCondition.setStartDate(rangeDate[0]);
        queryCondition.setEndDate(rangeDate[1]);
        queryCondition.setUserId((user.getId()));
        PageQueryBean  result=   attendService.signList(queryCondition);
        return  result;
    }




}
