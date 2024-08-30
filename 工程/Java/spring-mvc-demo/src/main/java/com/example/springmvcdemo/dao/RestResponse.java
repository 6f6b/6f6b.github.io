package com.example.springmvcdemo.dao;

public class RestResponse<T> {
    /**
     * 返回的数据
     */
    private T data;
    /**
     * 提示消息
     */
    private String message;
    /**
     * 业务状态码
     */
    private Integer status;
    /**
     * 标识请求是否成功
     */
    private boolean success = true;
    /**
     * 当前响应的时间戳
     */
    private Long timestamp = System.currentTimeMillis();
    /**
     * 当前请求在不分页情况下可查询的数据总量
     */
    private Long total;

    public RestResponse() {
    }

    public RestResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
