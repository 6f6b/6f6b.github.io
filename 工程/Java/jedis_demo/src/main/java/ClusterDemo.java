import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiuFeng
 * @date 2021/8/24 上午11:38
 */
public class ClusterDemo {

    public static void main(String[] args) {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("localhost",6379));
        nodes.add(new HostAndPort("localhost",6380));
        nodes.add(new HostAndPort("localhost",6381));
        nodes.add(new HostAndPort("localhost",6382));
        nodes.add(new HostAndPort("localhost",6383));
        nodes.add(new HostAndPort("localhost",6384));

        JedisCluster cluster = new JedisCluster(nodes);
        System.out.println(cluster.get("name"));
    }
}
