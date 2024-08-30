package com.feng.redpack.playground;

import com.feng.redpack.exception.BalanceNotEnoughException;
import com.feng.redpack.exception.ErrorInputException;
import com.feng.redpack.exception.NegativeAmountException;
import com.feng.redpack.person.Dealer;
import com.feng.redpack.person.Player;
import com.feng.redpack.redpack.RedPack;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author liufeng
 * @date 2021/11/20 12:29 下午
 */
public class Playground {
    /**
     * 庄家
     */
    public Dealer dealer;

    /**
     * 玩家列表
     */
    public List<Player> players;

    private List<RedPack> redPacks;

    private PrintStream logger = System.out;

    public Playground(Integer playerNumber, Integer activeNumber, BigDecimal playerAmount, Integer packNumber) throws Exception{
        if (playerNumber <= 0){
            throw new ErrorInputException("玩家个数必须大于0");
        }
        if (activeNumber <= 0){
            throw new ErrorInputException("活跃玩家个数必须大于0");
        }
        if (packNumber <= 0){
            throw new ErrorInputException("红包个数必须大于0");
        }
        if (activeNumber > playerNumber){
            throw new ErrorInputException(String.format("活跃玩家个数：%d不能大于总玩家个数：%d",playerNumber,activeNumber));
        }
        //dealer = new Dealer(new BigDecimal(0));
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < playerNumber; i++) {
            Player p = new Player(playerAmount);
            p.name = String.format("player-%s",i+1);
            players.add(p);
        }
        this.players = players;
    }

    public void start() throws Exception{
        Integer times = 1;
        Player sender = players.get(new Random().nextInt(players.size()));
        BigDecimal amount = new BigDecimal("200");
        BigDecimal threshold = new BigDecimal("10.0");
        while (true){
            try {
                if (amount.compareTo(threshold) < 0){
                    throw new ErrorInputException(String.format("运气王发红包金额：%s 小于阈值，游戏结束",amount.toString()));
                }
                if (times > 2000){
                    throw new ErrorInputException(String.format("2000轮结束游戏"));
                }
                logger.println(String.format("开始第：%d 轮，红包发送者：%s，红包金额：%s",times,sender.name,amount.toString()));

                redPacks = sender.sendRedPack(amount,10);
                Collections.shuffle(players);
                for (int i = 0; i < redPacks.size(); i++) {
                    redPacks.get(i).open(players.get(i));
                }
                sender = players.get(0);
                amount = new BigDecimal("200.0");
                times += 1;
                logger.println(String.format("---本轮运气王金额：%s",redPacks.get(0).getBalance().toString()));
            }catch (Exception e){
                e.printStackTrace();
                logger.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                Player maxProgressLoss = players.get(0);
                Player maxProgressWin = players.get(0);
                Player maxFinalLoss = players.get(0);
                Player maxFinalWin = players.get(0);
                BigDecimal ac = new BigDecimal("0");
                for (int i = 0; i < players.size(); i++) {
                    Player p = players.get(i);
                    ac = ac.add(p.profitLoss());
                    //过程中最大亏损者
                    if (p.getMaxLoss().compareTo(maxProgressLoss.getMaxLoss()) < 0){
                        maxProgressLoss = p;
                    }
                    //过程中最大盈利者
                    if (p.getMaxSurplus().compareTo(maxProgressWin.getMaxSurplus()) > 0){
                        maxProgressWin = p;
                    }
                    //结局中最大亏损者
                    //结局中最大盈利者
                    if (p.profitLoss().compareTo(new BigDecimal(0)) > 0){
                        if (p.profitLoss().compareTo(maxFinalWin.profitLoss()) > 0){
                            maxFinalWin = p;
                        }
                    }else {
                        if (p.profitLoss().compareTo(maxFinalLoss.profitLoss()) < 0){
                            maxFinalLoss = p;
                        }
                    }
                    {
                        logger.println(String.format("玩家(%s) 最终余额：%s，最大盈利：%s，最大亏损：%s，最终盈亏：%s",p.name,p.getBalance().toString(),p.getMaxSurplus().toString(),p.getMaxLoss().toString(),p.profitLoss().toString()));
                    }
                }
                logger.println("*************************************************************************************************");
                logger.println(String.format("最终总盈亏：%s",ac.toString()));
                {
                    Player p = maxProgressWin;
                    logger.println(String.format("过程中最大盈利 玩家(%s) 最终余额：%s，最大盈利：%s，最大亏损：%s，最终盈亏：%s",p.name,p.getBalance().toString(),p.getMaxSurplus().toString(),p.getMaxLoss().toString(),p.profitLoss().toString()));
                }
                {
                    Player p = maxProgressLoss;
                    logger.println(String.format("过程中最大亏损 玩家(%s) 最终余额：%s，最大盈利：%s，最大亏损：%s，最终盈亏：%s",p.name,p.getBalance().toString(),p.getMaxSurplus().toString(),p.getMaxLoss().toString(),p.profitLoss().toString()));
                }
                {
                    Player p = maxFinalWin;
                    logger.println(String.format("最终最大盈利 玩家(%s) 最终余额：%s，最大盈利：%s，最大亏损：%s，最终盈亏：%s",p.name,p.getBalance().toString(),p.getMaxSurplus().toString(),p.getMaxLoss().toString(),p.profitLoss().toString()));
                }
                {
                    Player p = maxFinalLoss;
                    logger.println(String.format("最终最大亏损 玩家(%s) 最终余额：%s，最大盈利：%s，最大亏损：%s，最终盈亏：%s",p.name,p.getBalance().toString(),p.getMaxSurplus().toString(),p.getMaxLoss().toString(),p.profitLoss().toString()));
                }
                break;
            }
        }
    }
}
