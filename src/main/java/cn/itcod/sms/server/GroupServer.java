package cn.itcod.sms.server;

import cn.itcod.sms.pojo.Group;

import java.util.List;

/**
 * @author ITCod
 */
public interface GroupServer {
    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

    List<Group> findByAll();

    List<Group> selectByClassId(int id);
}
