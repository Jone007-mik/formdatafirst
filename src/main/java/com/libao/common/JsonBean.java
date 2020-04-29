package com.libao.common;

public class JsonBean{
    /**
     * code 指代状态 0-->ok  -1-->error
     */
    private int code;
    /**
     * msg 指代当前是否执行成功 ok  error
     */
    private String msg;
    /**
     * data 指代传输的数据
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonBean(int code, String msg, Object data) {

        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
