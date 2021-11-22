package com.feng.redpack;

import com.feng.redpack.playground.Playground;

import java.math.BigDecimal;

/**
 * @author liufeng
 * @date 2021/11/20 12:24 下午
 */
public class RunApplication {
    public static void main(String[] args) throws Exception{
        //游戏场
        //游戏场玩家个数
        //活跃玩家个数
        //玩家
        Playground pg = new Playground(20,20,new BigDecimal("20000"),10);
        pg.start();
    }
}
