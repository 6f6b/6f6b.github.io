package com.feng.redpack.exception;

/**
 * @author liufeng
 * @date 2021/11/20 1:03 下午
 */
public class BalanceNotEnoughException extends Exception{
    public BalanceNotEnoughException(String message) {
        super(message);
    }
}
