package cn.itcod.sms.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ITCod
 */
@Getter
@Setter
public class City {
    private Integer id;

    private String name;

    private Date createtime;

    private Integer numbers;
}