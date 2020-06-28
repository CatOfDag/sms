package cn.itcod.sms.server.serverImpl;

import cn.itcod.sms.mapper.CityMapper;
import cn.itcod.sms.mapper.StudentMapper;
import cn.itcod.sms.mapper.StudentTagMapper;
import cn.itcod.sms.mapper.TagMapper;
import cn.itcod.sms.pojo.Student;
import cn.itcod.sms.pojo.StudentTag;
import cn.itcod.sms.pojo.Tag;
import cn.itcod.sms.server.StudentServer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ITCod
 */
@Service
public class StudentServerImpl implements StudentServer {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentTagMapper studentTagMapper;
    @Autowired
    private CityMapper cityMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        cityMapper.updateNumberByPrimaryKey(student.getCityid(), "less");
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record, String[] tags) {
        studentMapper.insert(record);
        int sid = studentMapper.selectByPhone(record.getPhone());
        cityMapper.updateNumberByPrimaryKey(record.getCityid(), "add");
        for (String tag : tags) {
            studentTagMapper.insert(sid, Integer.parseInt(tag));
        }
        return 0;
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return 0;
    }

    @Override
    public boolean selectByName(String name) {
        return studentMapper.selectByName(name) == 0;
    }

    @Override
    public List<Student> findByAll() {
        List<Student> students = studentMapper.findByAll();
        for (Student student : students){
            student.setTags(studentMapper.selectStudentTagById(student.getId()));
        }
        return students;
    }
    @Override
    public List<Student> selectSelective(@Param(value = "c") String c, @Param(value = "v") String v) {
        return studentMapper.selectSelective(c, v);
    }
}
