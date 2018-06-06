package com.example.dell.yikezhong3.bean;

import java.util.List;

public class FllowBean {

    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : []
     */

    private String msg;
    private String code;
    private List<?> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
