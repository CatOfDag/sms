package cn.itcod.sms.config;

import cn.itcod.sms.pojo.User;
import cn.itcod.sms.utils.OperatorCheck;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.jasper.compiler.JspUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author ITCod
 */
@Component
@Aspect
public class OperatorCheckAopConfig {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Around(value = "@annotation(cn.itcod.sms.utils.OperatorCheck)&& @annotation(check)", argNames = "joinPoint,check")
    public Object around(ProceedingJoinPoint joinPoint, OperatorCheck check) throws Throwable {
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpServletResponse response = (HttpServletResponse) joinPoint.getArgs()[1];

        HttpSession session = request.getSession();

        // 获取redis中保存的token
        String status = stringRedisTemplate.opsForValue().get("status");
        Map<String, String> redisToken = new Gson().fromJson(status, new TypeToken<Map<String, String>>(){}.getType());

        if (session.getAttribute("status") == null || redisToken == null) {
            response.sendRedirect(request.getContextPath()+"/back/login.jsp");
            return null;
        }

        // 获取session中保存的token
        Map<String, String> sessionToken = (Map<String, String>) session.getAttribute("status");
        System.out.println(sessionToken.get("role"));
        if (sessionToken.get("token").equals(redisToken.get("token"))) {
            System.out.println("1、token正确>>> 开始验证role");

            // 如果用户role是 admin 则不做拦截
            if ("admin".equals(sessionToken.get("role"))) {
                System.out.println("admin 权限 不做拦截");
                return null;
            } else if ("student".equals((sessionToken.get("role")))) {
                /*如果用户是 student 的权限，调用的接口是 admin 的权限，则重定向的 error 页面
                * 如果调用的是 student 权限的接口，这通行 */
                if ("admin".equals(check.identity())) {
                    System.out.println("student 权限调用 admin 权限接口 错误");
                    response.sendRedirect(request.getContextPath()+"/back/error.jsp");
                    return null;
                }
            }else {
                response.sendRedirect(request.getContextPath() + "/back/login.jsp");
                return null;
            }
        }
        return null;
    }
}
