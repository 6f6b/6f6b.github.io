package com.feng.redpack.exception;

/**
 * @author liufeng
 * @date 2021/11/20 1:02 下午
 */
public class NegativeAmountException extends Exception{
    public NegativeAmountException(String message) {
        super(message);
    }
}
