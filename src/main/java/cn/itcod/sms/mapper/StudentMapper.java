package cn.itcod.sms.mapper;

import cn.itcod.sms.pojo.Student;
import cn.itcod.sms.pojo.StudentTag;
import cn.itcod.sms.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int selectByName(String name);

    int selectByPhone(String phone);

    List<Student> findByAll();

    List<String> selectStudentTagById(Integer id);

    List<Student> selectSelective(@Param(value = "c") String c, @Param(value = "v") String v);
}