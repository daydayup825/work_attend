package com.coder520.user.service.impl;

import com.coder520.attend.vo.QueryCondition;
import com.coder520.common.utils.DateUtils;
import com.coder520.common.utils.PageQueryBean;
import com.coder520.user.dao.AttendMapper;
import com.coder520.attend.entity.Attend;
import com.coder520.user.service.AttendService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author: fanbopeng
 * @Date: 2018/9/6 14:49
 * @Description:打卡业务
 */
@Service
public class AttendServiceImpl implements AttendService {

    private static final int NOON_HOUR =12 ;
    private static final int NOON_MUNITE =00 ;
    private static final Integer ABSENCE_DAY =480 ;
    private static final Byte ATTEND_STATUS_ABNORMAL = 2;
    private static final Byte ATTEND_STATUS_NORMAL = 1;
    private SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yy-mm-dd HH:mm");

    @Autowired
    private AttendMapper attendMapper;
    @Override
    public void signAttend(Attend attend) throws Exception {
        /**
         *
         * 功能描述: 打开业务
         *
         * @param: [attend]
         * @return: void
         * @auther: fanbopeng
         * @date: 2018/9/6 16:04
         */

        try {
            Date today = new Date();
             attend.setAttendDate(today);
             attend.setAttendWeek((byte) DateUtils.getTodayWeek());
            Date date = DateUtils.getDate(NOON_HOUR, NOON_MUNITE);
        Attend todayRecord = attendMapper.selectTodaySignRecord(attend.getUserId());
        if (todayRecord==null){
            //打卡记录不存在  早上打卡
            if (today.compareTo(date)<=0){
                attend.setAttendMorning(today);
                //查询此人今天上午有没有打卡记录
            }else {
                attend.setAttendEvening(today);
            }
            attendMapper.insert(attend);
        }else {
            //晚上打卡
            if (today.compareTo(date)<=0){
                return;
                //查询此人今天上午有没有打卡记录
            }else {
                //晚上打卡
               todayRecord.setAttendEvening(today);
                attendMapper.updateByPrimaryKey(todayRecord);
            }
        }
            //中午十二点之前打卡 都算早晨，如果9.30以后直接异常，算迟到
            //十二点以后算下午打卡
            //下午打卡。 与上午打卡时间差  18点之前算异常
            // 不足八小时都算异常 并且 缺席多长时间 要存进去
        }catch (Exception e){

            throw e;
        }
    }

    @Override
    public PageQueryBean signList(QueryCondition queryCondition) {
        /**
         *
         * 功能描述:
         *  分页查询
         * @param: [queryCondition]
         * @return: com.coder520.common.utils.PageQueryBean
         * @auther: fanbopeng
         * @date: 2018/9/6 21:33
         */
        Integer total = attendMapper.selectTotal(queryCondition);
        PageQueryBean pageResult = new PageQueryBean();
        if (total!=null){
            pageResult.setTotalPage(total);
         pageResult.setCurrentPage(queryCondition.getCurrentPage());
         pageResult.setPageSize(queryCondition.getPageSize());
            List<Attend> attendList = attendMapper.selectAttendPage(queryCondition);
            pageResult.setItems(attendList);

        }


        return pageResult;
    }

    @Override
    public void checkAttend() {
        /**
         *
         * 功能描述:  检查打卡状态
         *
         * @param: []
         * @return: void
         * @auther: fanbopeng
         * @date: 2018/9/7 18:31
         */
        //查询缺勤用户id。插入打卡记录。并且设置打卡状态为异常 2 缺勤 480分钟
       List<Long> userIdList=   attendMapper.selectTodayAbsence();
       if(CollectionUtils.isNotEmpty(userIdList)){
           List<Attend> attendList= new ArrayList<Attend>();
           for (Long userId: userIdList){
               Attend attend= new Attend();
               attend.setUserId(userId);
               attend.setAttendDate(new Date());
               attend.setAttendWeek((byte)DateUtils.getTodayWeek());
               attend.setAbsence(ABSENCE_DAY);
               attend.setAttendStatus(ATTEND_STATUS_ABNORMAL);
               attendList.add(attend);
           }
           attendMapper.batchInsert(attendList);
       }
        //检查晚打卡，将下班未打卡的记录设置为空
        List<Attend> attendList =attendMapper.selectTodayEveryingAttend();
       if(CollectionUtils.isNotEmpty(attendList)){
           for (Attend attend :attendList){
                attend.setAbsence(ABSENCE_DAY);
                attend.setAttendStatus(ATTEND_STATUS_ABNORMAL);
                 attendMapper.updateByPrimaryKeySelective(attend);


           }

       }


    }
}
