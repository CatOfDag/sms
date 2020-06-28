package cn.itcod.sms.server;

import cn.itcod.sms.pojo.Class;

import java.util.List;

public interface ClassServer {
    int deleteByPrimaryKey(Integer id);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    List<Class> findByAll();
}
