package cn.itcod.sms.controller;

import cn.itcod.sms.pojo.User;
import cn.itcod.sms.server.UserServer;
import cn.itcod.sms.utils.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ITCod
 */
@Controller
@RequestMapping("user")
public class UserController{

    @Autowired
    UserServer userServer;
    @Autowired
    AjaxResult ajaxResult;
    @Autowired
    AspectService aspectService;
    @Autowired
    StringRedisTemplate redisTemplate ;

    /**生成验证码*/
    @GetMapping("getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 获取验证码图片
        BufferedImage captchaImage = ImageCaptcha.getCaptchaImage();
        // 获取验证码
        String captcha = ImageCaptcha.getCaptcha();
        // 添加到session
        request.getSession().setAttribute("captcha", captcha);
        request.getSession().setAttribute("error", "");
        ImageIO.write(captchaImage, "jpg", response.getOutputStream());
    }

    @RequestMapping("registerCheck")
    @ResponseBody
    public AjaxResult registerCheck(User user, String code, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        if (!session.getAttribute("captcha").equals(code)) {
            ajaxResult.setInfo("验证码错误");
            return ajaxResult;
        }
        else {
            if (!userServer.checkReportUser(user.getName())){
                if(userServer.insert(user) > 0) {
                    ajaxResult.setRes(true);
                    return ajaxResult;
                } else {
                    ajaxResult.setInfo("系统忙");
                    return ajaxResult;
                }
            } else {
                ajaxResult.setInfo("用户已创建");
                return ajaxResult;
            }
        }
    }


    @RequestMapping("login")
    @ResponseBody
    public AjaxResult login(HttpServletRequest request, HttpServletResponse response, User user, String code) throws IOException {
        HttpSession session = request.getSession(true);
        try {
            if (!session.getAttribute("captcha").equals(code)) {
                ajaxResult.setInfo("验证码错误");
            } else {
                if (userServer.checkReportUser(user.getName())) {
                    if (userServer.selectByNamePassword(user.getName(), user.getPassword()) == 1) {
                        User enterUser = userServer.findByName(user.getName());
                        //简单的session-redis权限验证
                        new ASD().asd(session, enterUser.getRole(), redisTemplate);
                        session.setAttribute("user", enterUser);
                        ajaxResult.setRes(true);
                        return ajaxResult;
                    } else {
                        ajaxResult.setInfo("密码错误");
                    }
                } else {
                    ajaxResult.setInfo("用户名错误");
                }
            }
        } catch (NullPointerException e){
            ajaxResult.setInfo("请重新刷新");
        }
        return ajaxResult;
    }

    @RequestMapping("middleJump")
    public void middleJump(HttpServletRequest request, HttpServletResponse response ) throws IOException {
        aspectService.service(request, response);
        response.sendRedirect(request.getContextPath()+"/back/index.jsp");
    }

    @RequestMapping("logout")
    public void loginOut(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/back/login.jsp");
    }
}
