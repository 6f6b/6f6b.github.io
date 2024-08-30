package com.feng.redpack.redpack;

import com.feng.redpack.common.Constants;
import com.feng.redpack.exception.*;
import com.feng.redpack.person.Player;

import java.math.BigDecimal;

/**
 * @author liufeng
 * @date 2021/11/20 1:31 下午
 */
public class RedPack {

    /**
     * 红包金额
     */
    private BigDecimal balance = new BigDecimal(0);

    /**
     * 红包是否被领取
     */
    private boolean received;

    /**
     * 领取者
     */
    private Player receiver;

    /**
     * 红包发送者
     */
    private Player sender;

    /**
     * 红包创建时间
     */
    private Long createTime;

    /**
     * 红包封
     */
    private boolean closed;

    public RedPack(Player sender,BigDecimal amount) throws Exception{
        this.createTime = System.currentTimeMillis();
        this.sender = sender;
        this.increase(amount);
    }

    public void close() throws BalanceNotEnoughException{
        if (balance.compareTo(Constants.RED_PACK_AMOUNT_LOW_LIMIT) < 0){
            throw new BalanceNotEnoughException(String.format("红包金额不能小于:%.2f",Constants.RED_PACK_AMOUNT_LOW_LIMIT));
        }
        this.closed = true;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public synchronized void open(Player player) throws Exception{
        if (received){
            throw new RedPackReceivedException(String.format("红包已被：%s 领取",receiver.name));
        }
        if (isExpired()){
            throw new RedPackExpireException("红包已过期");
        }
        player.increase(balance);
        received = true;
        receiver = player;
    }

    /**
     * Deduction amount
     */
    public void deduct(BigDecimal amount) throws Exception{
        if (amount.compareTo(new BigDecimal(0)) < 0){
            throw new NegativeAmountException(String.format("扣减金额不能为负数：%.2f",amount));
        }
        if (amount.compareTo(balance) > 0){
            throw new BalanceNotEnoughException(String.format("余额不足，当前余额：%.2f；欲扣减金额：%.2f",balance,amount));
        }
        if (closed){
            throw new GeneralException("红包已经封存，不能再扣减金额");
        }
        balance = balance.subtract(amount);
    }

    public void increase(BigDecimal amount) throws Exception{
        if (amount.compareTo(new BigDecimal(0)) < 0){
            throw new NegativeAmountException(String.format("存入金额不能为负数：%.2f",amount));
        }
        if (closed){
            throw new GeneralException("红包已经封存，不能再增加金额");
        }
        balance = balance.add(amount);
    }

    /**
     * 红包是否过期
     * @return
     */
    public boolean isExpired(){
        return (System.currentTimeMillis() - createTime) > Constants.RED_PACK_EXPIRE_TIME*1000;
    }

    @Override
    public String toString() {
        return String.format("红包金额:%.2f",balance);
    }
}
