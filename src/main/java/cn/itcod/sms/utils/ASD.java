package cn.itcod.sms.utils;

import cn.itcod.sms.pojo.User;
import com.google.gson.Gson;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ASD {

    public void asd(HttpSession session, String role,StringRedisTemplate redisTemplate){
        Map<String,Object> map = new HashMap<>(3);
        map.put("token",session.getId());
        map.put("role",role);
        session.setAttribute("status", map);
        redisTemplate.boundValueOps("status").set(new Gson().toJson(map));
    }
}
