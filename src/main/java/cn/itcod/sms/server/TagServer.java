package cn.itcod.sms.server;

import cn.itcod.sms.pojo.Tag;

import java.util.List;

/**
 * @author ITCod
 */
public interface TagServer {
    int deleteByPrimaryKey(Integer id);

    boolean insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> findByAll();

    List<Tag> selectByType(String type);
}