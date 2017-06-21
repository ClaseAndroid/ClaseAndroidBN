package com.project.jebus.appsolar.model.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jebus on 23/10/15.
 */
public class BaseResponse implements Serializable {

    private static final int STATE_SUCCESS = 1;
    private int status;
    private String msg;
    private List<BaseError> data_error;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<BaseError> getData_error() {
        return data_error;
    }

    public void setData_error(List<BaseError> data_error) {
        this.data_error = data_error;
    }

    public boolean isSuccess()
    {
        return  (this.status==STATE_SUCCESS)?(true):(false);
    }
}
