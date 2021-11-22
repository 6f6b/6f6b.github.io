package com.feng.redpack.common;

import java.math.BigDecimal;

/**
 * @author liufeng
 * @date 2021/11/20 1:37 下午
 */
public class Constants {
    /**
     * 红包最低金额
     */
    public static final BigDecimal RED_PACK_AMOUNT_LOW_LIMIT = new BigDecimal("0.01");

    /**
     * 红包过期时间(单位秒)
     */
    public static final Integer RED_PACK_EXPIRE_TIME = 60*2;

    /**
     * 单次红包个数
     */
    public static final Integer RED_PACK_NUMBER = 10;
}
