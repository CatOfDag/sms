package cn.itcod.sms.pojo;

import lombok.Data;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@ToString
public class User {
    private Integer id;

    private String name;

    private String password;

    private boolean status;

    private String regtime;

    private String role;

    public User(){}

    public User(String name, String password, String role){
        this.name = name;
        this.password = password;
        this. role = role;
        this.regtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.status = false;
    }
}