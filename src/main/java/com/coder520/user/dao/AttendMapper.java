package com.coder520.user.dao;

import com.coder520.attend.entity.Attend;
import com.coder520.attend.entity.AttendExample;
import java.util.Date;
import java.util.List;

import com.coder520.attend.vo.QueryCondition;
import org.apache.ibatis.annotations.Param;

public interface AttendMapper {
    int countByExample(AttendExample example);

    int deleteByExample(AttendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Attend record);

    int insertSelective(Attend record);

    List<Attend> selectByExample(AttendExample example);

    Attend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Attend record, @Param("example") AttendExample example);

    int updateByExample(@Param("record") Attend record, @Param("example") AttendExample example);

    int updateByPrimaryKeySelective(Attend record);

    int updateByPrimaryKey(Attend record);

    Attend selectTodaySignRecord(Long userId);

    int selectTotal(QueryCondition queryCondition);

    List<Attend> selectAttendPage(QueryCondition queryCondition);

    List<Long> selectTodayAbsence();

    void batchInsert(List<Attend> attendList);

    List<Attend> selectTodayEveryingAttend();
}