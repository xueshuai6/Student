package com.stu.Test;

import com.stu.util.RedisUtil;

import redis.clients.jedis.Jedis;

public class RedisTest {
	private Jedis jedis=RedisUtil.getJedis();
	/*redis存储字符串*/
	
	public void tetString(){
		
		jedis.set("name", "zhangsan");
		
		System.out.println(jedis.get("name"));
		
		jedis.append("name", "is a boy");//拼接
		
		System.out.println(jedis.get("name"));
		
		jedis.del("name");//删除某个键
		
		System.out.println(jedis.get("name"));
		//设置多个键值对
		
		jedis.mset("name","lisi","age","23","qq","2341312");
		jedis.incr("age");//进行加1操作
		
		System.out.println(jedis.get("name")+"-"+jedis.get("age")+"-"+jedis.get("qq"));
		
	}
	 private void testHash() {
	        System.out.println("=============hash==========================");
	        // 清空数据
	        System.out.println(jedis.flushDB());
	        // 添加数据
	        jedis.hset("hashs", "entryKey", "entryValue");
	        jedis.hset("hashs", "entryKey1", "entryValue1");
	        jedis.hset("hashs", "entryKey2", "entryValue2");
	        // 判断某个值是否存在
	        System.out.println(jedis.hexists("hashs", "entryKey"));
	        // 获取指定的值
	        System.out.println(jedis.hget("hashs", "entryKey"));        
	        // 批量获取指定的值
	        System.out.println(jedis.hmget("hashs", "entryKey", "entryKey1"));
	        // 删除指定的值
	        System.out.println(jedis.hdel("hashs", "entryKey"));
	        // 为key中的域 field 的值加上增量 increment
	        System.out.println(jedis.hincrBy("hashs", "entryKey", 123l));
	        // 获取所有的keys
	        System.out.println(jedis.hkeys("hashs"));
	        // 获取所有的values
	        System.out.println(jedis.hvals("hashs"));
	    }
	public void testRedisPool(){
		RedisUtil.getJedis().set("newname", "中文测试");
		System.out.println(RedisUtil.getJedis().get("newname"));
	}
	public static void main(String[] args){
		RedisTest  s=new RedisTest();
		s.tetString();
		s.testRedisPool();
		s.testHash();
	}
}
