package cn.itcod.sms.server.serverImpl;

import cn.itcod.sms.mapper.TagMapper;
import cn.itcod.sms.pojo.Tag;
import cn.itcod.sms.server.TagServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ITCod
 */
@Service
public class TagServerImpl implements TagServer {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean insert(Tag record) {
        String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return tagMapper.insert(record.getTname(), record.getType(), createTime) == 1;
    }

    @Override
    public int insertSelective(Tag record) {
        return 0;
    }

    @Override
    public Tag selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Tag record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Tag record) {
        return 0;
    }

    @Override
    public List<Tag> findByAll() {
        return tagMapper.findByAll();
    }

    @Override
    public List<Tag> selectByType(String type) {
        return tagMapper.selectByType(type);
    }
}
