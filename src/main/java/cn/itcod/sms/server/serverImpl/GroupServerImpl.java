package cn.itcod.sms.server.serverImpl;

import cn.itcod.sms.mapper.GroupMapper;
import cn.itcod.sms.pojo.Group;
import cn.itcod.sms.pojo.GroupTag;
import cn.itcod.sms.server.GroupServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ITCod
 */
@Service
public class GroupServerImpl implements GroupServer {

    @Autowired
    private GroupMapper groupMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return groupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Group record) {
        return groupMapper.insert(record);
    }

    @Override
    public int insertSelective(Group record) {
        return 0;
    }

    @Override
    public Group selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Group record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Group record) {
        return 0;
    }

    @Override
    public List<Group> findByAll() {
        List<Group> groups = groupMapper.findByAll();
        List<GroupTag> groupTags = groupMapper.selectByGroupTag();
        for (Group group : groups){
            for (GroupTag groupTag : groupTags){
                if (group.getId().equals(groupTag.getId())){
                    group.getTags().add(groupTag.getName());
                }
            }
        }
        System.out.println(groups.toString());
        return groups;
    }

    @Override
    public List<Group> selectByClassId(int id) {

        return groupMapper.selectByClassId(id);
    }
}
