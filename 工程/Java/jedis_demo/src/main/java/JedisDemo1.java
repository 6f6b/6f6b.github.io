import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author LiuFeng
 * @date 2021/8/18 上午11:30
 */
public class JedisDemo1 {
    static Jedis jedis = new Jedis(new HostAndPort("localhost",6379));

    public static void main(String[] args) {
        System.out.println(requestVerifyCode("15708456403"));
        //verifyCode("15708456403","787707");
    }

    public static void verifyCode(String phoneNumber,String code){
        String countKey = countKey(phoneNumber);
        String codeKey = codeKey(phoneNumber);
        String c = jedis.get(codeKey);
        if (c == null || !c.equals(code)){
            System.out.println("校验失败");
        }else{
            jedis.del(codeKey);
            System.out.println("校验成功");
        }
    }

    public static String requestVerifyCode(String phoneNumber){
        String countKey = countKey(phoneNumber);
        String codeKey = codeKey(phoneNumber);
        String countString = jedis.get(countKey);
        int count = 0;
        if (countString != null){
            count = Integer.parseInt(countString);
        }
        String code = jedis.get(codeKey);

        if (code == null){
            if (count < 3){
                code = generateVerifyCode();
                jedis.setex(codeKey,60*2,code);
                jedis.setex(countKey,24*60*60,jedis.incr(countKey).toString());
            }else{
                code = "今日已超过三次";
            }
        }
        return code;
    }

    public static String codeKey(String phoneNumber){
        return phoneNumber + ":code";
    }

    public static String countKey(String phoneNumber){
        DateFormat format = new SimpleDateFormat("MM-dd");
        return phoneNumber +":" + format.format(new Date()) + ":count";
    }

    //生成6位数验证码
    public static String generateVerifyCode(){
        Random random = new Random();
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }
}
