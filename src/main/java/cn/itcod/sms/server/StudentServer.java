package cn.itcod.sms.server;

import cn.itcod.sms.pojo.Student;
import cn.itcod.sms.pojo.Tag;

import java.util.List;

/**
 * @author ITCod
 */
public interface StudentServer {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record, String[] tags);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    boolean selectByName(String name);

    List<Student> findByAll();

    List<Student> selectSelective(String c, String v);

}