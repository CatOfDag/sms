package cn.itcod.sms.mapper;

import cn.itcod.sms.pojo.Group;
import cn.itcod.sms.pojo.GroupTag;

import java.util.List;

public interface GroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

    List<Group> findByAll();

    List<Group> selectByClassId(int id);

    List<GroupTag> selectByGroupTag();
}