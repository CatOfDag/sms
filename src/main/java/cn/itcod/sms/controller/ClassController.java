package cn.itcod.sms.controller;

import cn.itcod.sms.mapper.ClassMapper;
import cn.itcod.sms.mapper.TagMapper;
import cn.itcod.sms.pojo.Class;
import cn.itcod.sms.pojo.Tag;
import cn.itcod.sms.server.ClassServer;
import cn.itcod.sms.server.TagServer;
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
@RequestMapping("class")
public class ClassController {

    @Autowired
    AspectService aspectService;
    @Autowired
    ClassServer classServer;

    @RequestMapping("getAll")
    public String getAll(HttpServletRequest request, HttpServletResponse response, Model model){
        aspectService.adminService(request, response);
        List<Class> classes = classServer.findByAll();
        model.addAttribute("classes", classes);
        return "back/class/index";
    }

    @RequestMapping("insertClass")
    public String insertClass(HttpServletRequest request, HttpServletResponse response){
        aspectService.adminService(request, response);
        Class c = new Class(request.getParameter("name"), Integer.valueOf(request.getParameter("tagid")));
        classServer.insert(c);
        return "redirect:/class/getAll";
    }

    @RequestMapping("findAllClass")
    @ResponseBody
    public List<Class> findAllClass(HttpServletRequest request, HttpServletResponse response){
        aspectService.adminService(request, response);
        return classServer.findByAll();
    }

    @RequestMapping("delete")
    public String deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response, int id){
        aspectService.adminService(request, response);
        classServer.deleteByPrimaryKey(id);
        return "redirect:/class/getAll";
    }
}
