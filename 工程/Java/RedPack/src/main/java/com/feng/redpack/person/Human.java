package com.feng.redpack.person;

import com.feng.redpack.exception.BalanceNotEnoughException;
import com.feng.redpack.exception.NegativeAmountException;

import java.math.BigDecimal;

/**
 * @author liufeng
 * @date 2021/11/20 12:24 下午
 */
public class Human {
    public String name;

    /**
     * 初始余额
     */
    private BigDecimal initialBalance;

    /**
     * 账户余额
     */
    private BigDecimal balance;

    private BigDecimal maxSurplus = new BigDecimal("0");
    private BigDecimal maxLoss = new BigDecimal("0");

    public Human(BigDecimal initialBalance) throws Exception{
        if (initialBalance.compareTo(new BigDecimal("0")) <= 0){
            throw new NegativeAmountException(String.format("初始金额不能为负数：%.2f",initialBalance).toString());
        }
        this.initialBalance = initialBalance;
        this.balance = initialBalance;
    }

    /**
     * Deduction amount
     */
    public void deduct(BigDecimal amount) throws Exception{
        if (amount.compareTo(new BigDecimal("0")) < 0){
            throw new NegativeAmountException(String.format("扣减金额不能为负数：%.2f",amount));
        }
        if (amount.compareTo(balance) > 0){
            throw new BalanceNotEnoughException(String.format("余额不足，当前余额：%.2f；欲扣减金额：%.2f",balance,amount));
        }
        balance = balance.subtract(amount);
        refreshAccountBook();
    }

    public void increase(BigDecimal amount) throws Exception{
        if (amount.compareTo(new BigDecimal("0")) < 0){
            throw new NegativeAmountException(String.format("存入金额不能为负数：%s",amount.toString()));
        }
        balance = balance.add(amount);
        refreshAccountBook();
    }

    /**
     * 自然人的盈亏情况
     * @return
     */
    public BigDecimal profitLoss(){
        return balance.subtract(initialBalance);
    }

    public BigDecimal getMaxSurplus(){
        return maxSurplus;
    }

    public BigDecimal getMaxLoss(){
        return maxLoss;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    private void refreshAccountBook(){
        BigDecimal p = profitLoss();
        if (p.compareTo(new BigDecimal("0")) > 0){
            if (p.compareTo(maxSurplus) > 0){
                maxSurplus = p;
            }
        }else {
            if (p.compareTo(maxLoss) < 0){
                maxLoss = p;
            }
        }
    }
}
