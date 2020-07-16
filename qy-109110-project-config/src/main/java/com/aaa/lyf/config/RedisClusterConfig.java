package com.aaa.lyf.config;

import com.aaa.lyf.properties.RedisClusterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/11 9:11
 * @version: 1.0
 * @Description:
 */
@Configuration
public class RedisClusterConfig {
    @Autowired
    private RedisClusterProperties redisClusterProperties;

    @Bean
    public JedisCluster getJedisCluster(){
        String nodes = redisClusterProperties.getNodes();
        String[] split = nodes.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        for (String hostPort : split){
            String[] split1 = hostPort.split(",");
            HostAndPort hostAndPort = new HostAndPort(split[0],Integer.parseInt(split1[1]));


        }
      return  new JedisCluster(hostAndPortSet,redisClusterProperties.getCommandTimeout(),redisClusterProperties.getMaxAttempts());
    }
}
