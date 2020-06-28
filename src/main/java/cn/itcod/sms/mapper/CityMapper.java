package cn.itcod.sms.mapper;

import cn.itcod.sms.pojo.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(String name, String createtime);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    int updateNumberByPrimaryKey(int id, @Param(value = "symbol") String symbol);

    List<City> findByAll();
}