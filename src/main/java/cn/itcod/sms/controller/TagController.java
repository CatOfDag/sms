package cn.itcod.sms.controller;

import cn.itcod.sms.pojo.Tag;
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
@RequestMapping("tag")
public class TagController {

    @Autowired
    private AspectService aspectService;
    @Autowired
    private TagServer tagServer;

    @RequestMapping("getAll")
    public String getAll(HttpServletRequest request, HttpServletResponse response, Model model) {
        aspectService.adminService(request, response);
        List<Tag> tags = tagServer.findByAll();
        model.addAttribute("tags", tags);
        return "back/tag/index";
    }

    @RequestMapping("insertTag")
    public String insertTag(HttpServletRequest request, HttpServletResponse response, Tag tag) {
        aspectService.adminService(request, response);
        tagServer.insert(tag);
        return "redirect:/tag/getAll";
    }

    @RequestMapping("selectByType")
    @ResponseBody
    public List<Tag> selectByType(HttpServletRequest request, HttpServletResponse response, String type){
        aspectService.adminService(request, response);
        return tagServer.selectByType(type);
    }

    @RequestMapping("delete")
    public String deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response, int id){
        aspectService.adminService(request, response);
        tagServer.deleteByPrimaryKey(id);
        return "redirect:/tag/getAll";
    }
}
