package cn.itcod.sms.controller;

import cn.itcod.sms.pojo.Group;
import cn.itcod.sms.server.GroupServer;
import cn.itcod.sms.utils.AspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ITCod
 */
@Controller
@RequestMapping("group")
public class GroupController {

    @Autowired
    AspectService aspectService;
    @Autowired
    private GroupServer groupServer;

    @RequestMapping("getAll")
    public String getAll(HttpServletRequest request, HttpServletResponse response, Model model){
        aspectService.adminService(request, response);
        model.addAttribute("groups", groupServer.findByAll());
        return "back/group/index";
    }

    @RequestMapping("insertGroup")
    public String insertGroup(HttpServletRequest request, HttpServletResponse response){
        aspectService.adminService(request, response);
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        int clazz = Integer.parseInt(request.getParameter("clazzid"));
        Group group = new Group(name, content, clazz);
        groupServer.insert(group);
        return "redirect:/group/getAll";
    }

    @RequestMapping("findByClass")
    @ResponseBody
    public List<Group> findByClass(HttpServletRequest request, HttpServletResponse response, String clazzid){
        aspectService.adminService(request, response);
        return groupServer.selectByClassId(Integer.parseInt(clazzid));
    }
    @RequestMapping("delete")
    public String deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response, int id){
        aspectService.adminService(request, response);
        groupServer.deleteByPrimaryKey(id);
        return "redirect:/group/getAll";
    }
}
