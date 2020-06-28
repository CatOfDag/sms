package cn.itcod.sms.utils;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ITCod
 */
@Service
public class AspectService {

    /**
     *  默认普通权限
     */
    @OperatorCheck(identity = "student")
    public void service(HttpServletRequest request, HttpServletResponse response){
    }

    @OperatorCheck(identity = "admin")
    public void adminService(HttpServletRequest request, HttpServletResponse response){
    }
}
