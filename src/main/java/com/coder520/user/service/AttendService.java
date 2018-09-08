package com.coder520.user.service;

import com.coder520.attend.entity.Attend;
import com.coder520.attend.vo.QueryCondition;
import com.coder520.common.utils.PageQueryBean;

import java.util.Date;

/**
 * @author: fanbopeng
 * @Date: 2018/9/6 14:48
 * @Description: 签到业务层
 */
public interface AttendService {

      void signAttend(Attend  attend) throws Exception;

    PageQueryBean signList(QueryCondition queryCondition);

    void checkAttend();
}
