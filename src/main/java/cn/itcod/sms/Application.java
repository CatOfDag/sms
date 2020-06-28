package cn.itcod.sms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ITCod
 */
@SpringBootApplication
@EnableCaching
@MapperScan("cn.itcod.sms.mapper")
@ComponentScan("cn.itcod.sms.*")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
