package cn.itcod.sms.mapper;

import cn.itcod.sms.pojo.Tag;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(String tname, String type, String createtime);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> findByAll();

    List<Tag> selectByType(String type);
}