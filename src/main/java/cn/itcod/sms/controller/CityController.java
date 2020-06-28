package cn.itcod.sms.controller;

import cn.itcod.sms.pojo.City;
import cn.itcod.sms.server.CityServer;
import cn.itcod.sms.utils.AspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ITCod
 */
@Controller
@RequestMapping("city")
public class CityController {

    @Autowired
    CityServer cityServer;
    @Autowired
    AspectService aspectService;

    @RequestMapping("getAll")
    public String getAll(HttpServletRequest request, HttpServletResponse response, Model model){
        // 不用注解注释，切点不执行返回，用aop服务代理
        aspectService.service(request, response);
        List<City> cities = cityServer.findByAll();
        model.addAttribute("cities", cities);
        return "back/city/index";
    }

    @RequestMapping("insertCity")
    public String insertCity(HttpServletRequest request, HttpServletResponse response, Model model){
        aspectService.adminService(request, response);
        String cityName = request.getParameter("name");
        boolean b = cityServer.insert(cityName);
        if (b){
            model.addAttribute("status", "添加成功");
        } else {
            model.addAttribute("status", "添加失败");
        }
        return "redirect:/city/getAll";
    }

    @RequestMapping("findAllCity")
    @ResponseBody
    public List<City> findByClass(HttpServletRequest request, HttpServletResponse response){
        aspectService.service(request, response);
        return cityServer.findByAll();
    }

    @RequestMapping("delete")
    public String deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response, int id){
        aspectService.adminService(request, response);
        cityServer.deleteByPrimaryKey(id);
        return "redirect:/city/getAll";
    }
}
