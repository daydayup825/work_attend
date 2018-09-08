package com.coder520.attend.vo;

import com.coder520.common.utils.PageQueryBean;

import java.util.Date;

/**
 * @author: fanbopeng
 * @Date: 2018/9/6 20:19
 * @Description:
 */
public class QueryCondition extends PageQueryBean {

    private Integer userId;

    private String startDate ;

    private String endDate ;

    private String rangeDate;

    private Byte attendStatus;

    public Byte getAttendStatus() {
        return attendStatus;
    }

    public void setAttendStatus(Byte attendStatus) {
        this.attendStatus = attendStatus;
    }

    public String getRangeDate() {
        return rangeDate;
    }

    public void setRangeDate(String rangeDate) {
        this.rangeDate = rangeDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
