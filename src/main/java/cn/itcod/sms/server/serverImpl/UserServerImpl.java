package cn.itcod.sms.server.serverImpl;

import cn.itcod.sms.mapper.UserMapper;
import cn.itcod.sms.pojo.User;
import cn.itcod.sms.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ITCod
 */
@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public boolean checkReportUser(String name) {
        return userMapper.findByName(name) != null;
    }

    @Override
    public int selectByNamePassword(String name, String password) {
        return userMapper.selectByNamePassword(name, password);
    }
}
