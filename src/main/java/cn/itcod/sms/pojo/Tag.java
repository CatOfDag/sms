package cn.itcod.sms.pojo;

import lombok.*;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    private Integer tid;

    private String tname;

    private String type;

    private Date createtime;
}