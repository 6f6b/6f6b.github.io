import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

/**
 * @author LiuFeng
 * @date 2021/8/18 上午11:30
 */
public class JedisDemo1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis(new HostAndPort("192.168.3.199",6379));
//        String message = jedis.ping();
//        jedis.set("name","liufeng");
        jedis.zadd("age",12,"feng");
        jedis.zadd("age",13,"feng");

        System.out.println(jedis.zpopmax("age",10));
    }
}
