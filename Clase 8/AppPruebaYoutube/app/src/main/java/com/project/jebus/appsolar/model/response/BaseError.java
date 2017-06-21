package com.project.jebus.appsolar.model.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by emedinaa on 26/10/15.
 */
public class BaseError implements Serializable {

    private String element;
    private List<String> msg;

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public List<String> getMsg() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }
}
