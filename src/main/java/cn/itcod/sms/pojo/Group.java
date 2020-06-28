package cn.itcod.sms.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ITCod
 */
@Data
public class Group {
    private Integer id;

    private String name;

    private String content;

    private Integer clazzid;

    private Class c;

    private List<String> tags = new ArrayList<>();

    public Group(String name, String content, Integer clazzid){
        this.name = name;
        this.content = content;
        this.clazzid = clazzid;
    }

    public Group(){}
}