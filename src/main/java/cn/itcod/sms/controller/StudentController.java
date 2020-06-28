package cn.itcod.sms.controller;

import cn.itcod.sms.pojo.Student;
import cn.itcod.sms.pojo.StudentTag;
import cn.itcod.sms.pojo.Tag;
import cn.itcod.sms.server.StudentServer;
import cn.itcod.sms.utils.AspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author ITCod
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    AspectService aspectService;
    @Autowired
    StudentServer studentServer;

    @RequestMapping("getAll")
    public String getAll(HttpServletRequest request, HttpServletResponse response, Model model){
        aspectService.adminService(request, response);
        List<Student> students = studentServer.findByAll();
        model.addAttribute("students", students);
        return "back/student/index";
    }

    @RequestMapping("insertStudent")
    public String insertStudent(HttpServletRequest request, HttpServletResponse response, Student student){
        String[] tags = request.getParameterValues("tagIds");
        aspectService.adminService(request, response);
        studentServer.insertSelective(student, tags);
        return "redirect:/student/getAll";
    }

    @RequestMapping("selectByInput")
    public String selectByInput(HttpServletRequest request, HttpServletResponse response, Model model, String searchCol, String searchValue){
        aspectService.adminService(request, response);
        model.addAttribute("students", studentServer.selectSelective(searchCol, searchValue));
        model.addAttribute("searchCol",searchCol);
        model.addAttribute("searchValue",searchValue);
        return "back/student/index";
    }
    @RequestMapping("delete")
    public String deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response, int id){
        aspectService.adminService(request, response);
        studentServer.deleteByPrimaryKey(id);
        return "redirect:/student/getAll";
    }
}
