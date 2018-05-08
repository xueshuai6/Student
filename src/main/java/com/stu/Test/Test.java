package com.stu.Test;

import com.stu.model.Student;
import com.stu.util.RedisUtil;
import com.stu.util.SerializeUtil;

import redis.clients.jedis.Jedis;

public class Test {
	@org.junit.Test
	public void gettest() throws Exception{
		Jedis jedis=RedisUtil.getJedis();
		byte[] bs = jedis.get("student".getBytes());
		Student st = (Student) SerializeUtil.unserialize(bs);
		System.out.println(st.getName());
		System.out.println(st.getAvgscore());
		jedis.close();
	}

}
