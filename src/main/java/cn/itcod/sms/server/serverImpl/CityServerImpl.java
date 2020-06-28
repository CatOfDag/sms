package cn.itcod.sms.server.serverImpl;

import cn.itcod.sms.mapper.CityMapper;
import cn.itcod.sms.pojo.City;
import cn.itcod.sms.server.CityServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ITCod
 */
@Service
public class CityServerImpl implements CityServer {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean insert(String name) {
        String createtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return cityMapper.insert(name, createtime) == 1;
    }

    @Override
    public int insertSelective(City record) {
        return 0;
    }

    @Override
    public City selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(City record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(City record) {
        return 0;
    }

    @Override
    public List<City> findByAll() {
        return cityMapper.findByAll();
    }
}
