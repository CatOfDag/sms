package cn.itcod.sms.pojo;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ITCod
 */
@Data
public class Student {
    private Integer id;

    private String name;

    private Integer age;

    private Date bir;

    private String phone;

    private String qq;

    private String attr;

    private String starts;

    private String mark;

    private Integer cityid;

    private Integer clazzid;

    private Integer groupid;

    private City city;

    private Class clazz;

    private Group group;

    private List<String> tags = new ArrayList<>();

    public void setBir(String bir) throws ParseException {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            this.bir = simpleDateFormat.parse(bir);
        } catch (Exception ignored){}
    }
}