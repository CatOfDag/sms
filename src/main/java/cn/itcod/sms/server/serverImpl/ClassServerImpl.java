package cn.itcod.sms.server.serverImpl;

import cn.itcod.sms.mapper.ClassMapper;
import cn.itcod.sms.pojo.Class;
import cn.itcod.sms.server.ClassServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author ITCod
 */
@Service
public class ClassServerImpl implements ClassServer {

    @Autowired
    ClassMapper classMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Class record) {
        return 0;
    }

    @Override
    public int insertSelective(Class record) {
        return 0;
    }

    @Override
    public Class selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Class record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Class record) {
        return 0;
    }

    @Override
    public List<Class> findByAll() {
        return classMapper.findByAll();
    }
}
