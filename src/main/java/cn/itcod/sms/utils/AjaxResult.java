package cn.itcod.sms.utils;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author ITCod
 */
@Data
@Service
public class AjaxResult {
    private boolean res;
    private String info;

    public AjaxResult(){
        this.res = false;
    }
}
