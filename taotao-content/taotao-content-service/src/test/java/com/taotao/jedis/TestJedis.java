package com.taotao.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.jedis.service.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJedis {
	 
    public void testJedis(){  
        //创建jedis对象，需要指定Redis服务的IP和端口号  
        Jedis jedis = new Jedis("192.168.221.99", 6379);  
        //直接操作数据库  
        jedis.set("jedis-name", "hello jedis!");  
        //获取数据  
        String result = jedis.get("jedis-name");  
        System.out.println(result);  
        //关闭jedis  
        jedis.close();  
    }  
	
	 
    public void testJedisPool(){  
        //创建一个数据库连接池对象（单例，即一个系统共用一个连接池），需要指定服务的IP和端口号  
        JedisPool jedisPool = new JedisPool("192.168.221.99", 6379);  
        //从连接池中获得连接  
        Jedis jedis = jedisPool.getResource();  
        //使用jedis操作数据库（方法级别，就是说只是在该方法中使用，用完就关闭）  
        String result = jedis.get("jedis-key");  
        System.out.println(result);  
        //用完之后关闭jedis连接  
        jedis.close();  
        //系统关闭前先关闭数据库连接池  
        jedisPool.close();  
    }  
	
	@Test  
	public void testJedisClientPool(){  
	    //初始化Spring容器  
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");  
	    //从容器中获取JedisClient对象  
	    JedisClient jedisClient = ctx.getBean(JedisClient.class);  
	    //使用JedisClient操作Redis  
	    jedisClient.set("jedisClient", "mytest");  
	    String result = jedisClient.get("jedisClient");
	    System.out.println(result);  
	}  
}
