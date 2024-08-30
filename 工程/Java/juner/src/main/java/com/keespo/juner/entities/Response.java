package com.keespo.juner.entities;

import javax.persistence.Entity;
import java.io.Serializable;

public class Response <T> {
    /**
     * 当前API接口状态码(默认为0)
     */
    Integer status = 200;
    /**
     * 当前响应的时间戳
     */
    Long timestamp = System.currentTimeMillis();
    /**
     * 提示消息
     */
    String message = "success";
    /**
     * 返回的数据
     */
    T data;

    public Response(T data){
        this.data = data;
    }

    public Response(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public Response(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
