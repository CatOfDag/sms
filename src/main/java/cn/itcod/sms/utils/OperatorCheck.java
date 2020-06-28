package cn.itcod.sms.utils;

import java.lang.annotation.*;

/**
 * @author ITCod
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperatorCheck {
    String identity();
}
