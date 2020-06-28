package cn.itcod.sms.server;

import cn.itcod.sms.pojo.City;
import cn.itcod.sms.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ITCod
 */
public interface UserServer {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByName(String name);

    boolean checkReportUser(String name);

    int selectByNamePassword(String name, String password);

}
