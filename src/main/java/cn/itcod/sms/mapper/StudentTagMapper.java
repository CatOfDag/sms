package cn.itcod.sms.mapper;

import cn.itcod.sms.pojo.StudentTag;
import cn.itcod.sms.pojo.Tag;

public interface StudentTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Integer studentid , Integer tagid);

    int insertSelective(StudentTag record);

    StudentTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentTag record);

    int updateByPrimaryKey(StudentTag record);
}