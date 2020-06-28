package cn.itcod.sms.pojo;

import lombok.Data;

/**
 * @author ITCod
 */
@Data
public class Class {
    private Integer id;

    private String name;

    private Integer tagid;

    private Tag tag = new Tag();

    public Class(String name, Integer tagid) {
        this.name = name;
        this.tagid = tagid;
    }

    public Class(){}

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tagid=" + tagid +
                ", tag=" + tag.toString() +
                '}';
    }
}