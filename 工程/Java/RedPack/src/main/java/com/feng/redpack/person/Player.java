package com.feng.redpack.person;

import com.feng.redpack.common.Constants;
import com.feng.redpack.exception.ErrorInputException;
import com.feng.redpack.exception.GeneralException;
import com.feng.redpack.redpack.RedPack;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author liufeng
 * @date 2021/11/20 12:25 下午
 */
public class Player extends Human{
    public Player(BigDecimal initialBalance) throws Exception {
        super(initialBalance);
    }

    /**
     *
     * @param amount 发的金额
     * @param number 发的红包个数
     */
    public List<RedPack> sendRedPack(BigDecimal amount, Integer number) throws Exception{
        //创建空红包
        ArrayList<RedPack> redPacks = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            RedPack r = new RedPack(this,new BigDecimal("0"));
            redPacks.add(r);
        }
        //红包金额填充
        fillRedPacks(redPacks,amount);
        //扣减账户金额
        deduct(amount);
        return redPacks;
    }

    private static void fillRedPacks(List<RedPack> redPacks,BigDecimal totalAmount) throws Exception{
        Integer packNumber = redPacks.size();
        if (packNumber <= 0){
            throw new ErrorInputException("红包个数必须大于0");
        }
        BigDecimal av = totalAmount.divide(new BigDecimal(packNumber),2,RoundingMode.FLOOR);
        if (av.compareTo(Constants.RED_PACK_AMOUNT_LOW_LIMIT) < 0){
            throw new ErrorInputException(String.format("每个红包金必须大于0.01，红包金额：%.2f,红包个数：%.2f",totalAmount,packNumber));
        }
        if (packNumber.equals(1)){
            redPacks.get(0).increase(totalAmount);
        }else {
            //获取红包平均金额
            BigDecimal amount = new BigDecimal(totalAmount.toString());
            //除去运气王后剩下的人的平均金额
            for (int i = 0; i < packNumber; i++) {
                RedPack pack = redPacks.get(i);
                //operate value
                BigDecimal opv = new BigDecimal(0);
                int left = packNumber-i;
                if (left == 1){
                    opv = amount;
                }
                else {
                    av = amount.divide(new BigDecimal(left),2,RoundingMode.FLOOR);
                    boolean isFirst = (i == 0);
                    boolean go = true;
                    Double fluctuationPercent = isFirst ? 0.1 : 0.5;
                    while (go){
                        opv = randomValue(av.doubleValue()*2,fluctuationPercent);
                        //reduce av
                        BigDecimal rav = amount.subtract(opv).divide(new BigDecimal(left-1),2,RoundingMode.FLOOR);
                        if (isFirst){
                            go = (opv.compareTo(totalAmount) >= 0) || (rav.compareTo(Constants.RED_PACK_AMOUNT_LOW_LIMIT) < 0);
                        }else {
                            BigDecimal luckiesAmount = redPacks.get(0).getBalance();
                            boolean lastBiggerThanLuckies = false;
                            if (left == 2){
                                lastBiggerThanLuckies = (amount.subtract(opv)).compareTo(luckiesAmount) > 0;
                            }
                            go = (opv.compareTo(luckiesAmount) > 0) || (opv.compareTo(luckiesAmount) == 0 && opv.compareTo(Constants.RED_PACK_AMOUNT_LOW_LIMIT) != 0) || (rav.compareTo(Constants.RED_PACK_AMOUNT_LOW_LIMIT) < 0) || lastBiggerThanLuckies;
                        }
                    }
                }
                pack.increase(opv);
                amount = amount.subtract(opv);
            }

        }
        checkSum(redPacks,totalAmount);
    }

    /**
     * 根据基线及波动范围返回一个随机值
     * @param base 基线
     * @param fluctuationPercent 波动范围
     * @return
     * @throws Exception
     */
    private static BigDecimal randomValue(Double base,Double fluctuationPercent) throws Exception{
        BigDecimal v = new BigDecimal(0);
        while (v.doubleValue() < Constants.RED_PACK_AMOUNT_LOW_LIMIT.doubleValue()){
            v = random(base,fluctuationPercent);
        }
        return v;
    }

    private static BigDecimal random(Double base,Double fluctuationPercent) throws Exception{
        if (fluctuationPercent < 0 || fluctuationPercent > 1){
            throw new ErrorInputException(String.format("波动范围错误，不能小于0或大于1，传入数据为：%.2f",fluctuationPercent));
        }
        if (base < Constants.RED_PACK_AMOUNT_LOW_LIMIT.doubleValue()){
            throw new ErrorInputException(String.format("基线错误，不能小于%.2f，传入数据为：%.2f",Constants.RED_PACK_AMOUNT_LOW_LIMIT.doubleValue(),base));
        }
        Random random = new Random();
        int operate = random.nextInt(2);
        Double fluctuationValue = random.nextDouble()*base*fluctuationPercent;
        Double r = operate == 0 ? (base - fluctuationValue) : (base + fluctuationValue);
        String s = r.toString();
        String[] ss = s.split("\\.");
        if (Arrays.stream(ss).count() > 1 && ss[1].length() > 2){
            s = ss[0] + "." + ss[1].substring(0,2);
        }
        return new BigDecimal(s);
    }

    /**
     * 红包及金额对账
     * @param redPacks
     * @param targetAmout
     * @throws Exception
     */
    private static void checkSum(List<RedPack> redPacks,BigDecimal targetAmout) throws Exception{
        BigDecimal m = new BigDecimal(0);
        for (RedPack redPack : redPacks) {
            m = m.add(redPack.getBalance());
        }
        if (m.compareTo(targetAmout) != 0){
            redPacks.forEach(redPack -> System.out.println(redPack.toString()));
            throw new GeneralException("红包对账错误，生成失败！");
        }
    }

    public static void main(String[] args) throws Exception{
        //测试波动
//        for (int i = 0; i < 20; i++) {
//            System.out.println(randomValue(1.0,0.9));
//        }
        //测试红包分配
        ArrayList<RedPack> redPacks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            redPacks.add(new RedPack(null,new BigDecimal("0")));
        }
        BigDecimal amount = new BigDecimal("10");
        fillRedPacks(redPacks,amount);
        checkSum(redPacks,amount);
        for (RedPack redPack : redPacks) {
            System.out.println(redPack.toString());
        }
    }
}
