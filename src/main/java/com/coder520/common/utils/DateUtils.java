package com.coder520.common.utils;


import java.util.Calendar;
import java.util.Date;

/**
 * @author: fanbopeng
 * @Date: 2018/9/6 16:10
 * @Description: 时间工具类
 */
public class DateUtils {

   private  static Calendar calendar=Calendar.getInstance();

    public static int getTodayWeek(){
        /**
         *
         * 功能描述:
         *              获取今天是星期几
         * @param: []
         * @return: int
         * @auther: fanbopeng
         * @date: 2018/9/6 16:17
         */


        int week = calendar.get(Calendar.DAY_OF_WEEK - 1);
        if (week>=0){

            return week;
        }else {

            return 7;
        }
    }

    public static  int  getMunite(Date startDate,Date endDate){
        /**
         *
         * 功能描述:
         *              计算打卡时间差
         * @param: [startDate, endDate]
         * @return: int
         * @auther: fanbopeng
         * @date: 2018/9/6 16:22
         */

        long startDateTime = startDate.getTime();
        long endDateTime = endDate.getTime();
        int munite = (int) (endDateTime - startDateTime) / (1000 * 60);

        return  munite;

    }
    public static Date getDate(int hour, int munite){
        /**
         *
         * 功能描述: 获取当天的某个时间
         *
         * @param: [hour, munite]
         * @return: java.util.Date
         * @auther: fanbopeng
         * @date: 2018/9/6 16:31
         */

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, munite);

        return calendar.getTime();



    }

}
