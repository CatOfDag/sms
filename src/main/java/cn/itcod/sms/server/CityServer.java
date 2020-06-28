package cn.itcod.sms.server;

import cn.itcod.sms.pojo.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ITCod
 */
public interface CityServer {

    int deleteByPrimaryKey(Integer id);

    boolean insert(String name);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    List<City> findByAll();
}
