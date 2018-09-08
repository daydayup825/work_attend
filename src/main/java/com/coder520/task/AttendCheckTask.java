package com.coder520.task;

import com.coder520.user.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: fanbopeng
 * @Date: 2018/9/7 17:55
 * @Description:定时器类
 */

public class AttendCheckTask {
    @Autowired
    private AttendService attendService;



        public void checkAttend(){

            attendService.checkAttend();

          //首先获取今天没打卡的人  插入打卡记录 并且设置为缺席
            //如果有打卡记录 检查早晚打卡 晚上是不是9点半以前 晚上是不是6点半以后打卡
            //


        }

}
