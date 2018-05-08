package com.stu.Test;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.stu.util.RedisUtil;

import redis.clients.jedis.Jedis;

public class RedisMapTest {
	private Jedis jedis=RedisUtil.getJedis();
	public void testMap(){
		//添加数据
		Map<String,String> map= new HashMap<String,String>();
		map.put("name", "zhangsan");
		map.put("age", "22");
		map.put("qq", "2134124");
		jedis.hmset("user", map);
		//去除user中的name，执行结果是一个泛型的list
		//第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变的参数
		List<String> rsmap=jedis.hmget("user", "name","age","qq");
		System.out.println(rsmap);
		
		//删除map中的某个键值
		
		jedis.hdel("user", "age");
		System.out.println(jedis.hmget("user", "name","age","qq"));//因为删除了，所以返回的是null
		System.out.println(jedis.hlen("user"));//返回key为user的键中存放的值的个数
		System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
		System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
		System.out.println(jedis.hvals("user"));//返回map对象中的所有value
		
		Iterator<String> iter=jedis.hkeys("user").iterator();
		while(iter.hasNext()){
			String key = iter.next();
			System.out.println(key+":"+jedis.hmget("user",key));
		}					
	}
	public static void main(String[] args){
		RedisMapTest rmt=new RedisMapTest();
		rmt.testMap();
	}
}
