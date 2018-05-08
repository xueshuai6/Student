package com.stu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.stu.model.Student;
import com.stu.util.RedisUtil;
import com.stu.util.SerializeUtil;

import redis.clients.jedis.Jedis;

public class StudentDao{
	Jedis jedis=RedisUtil.getJedis();
	//查看学生数据
	public List queryStudent(int page) {
		//Set<String> zrevrangeByScore = jedis.zrevrangeByScore("student_sort", 100, 0, i, 10);
		Set<String> zrange = jedis.zrevrange("student_sort",(page-1)*10,page*10-1);
		ArrayList<Student> arrayList = new ArrayList<Student>();
		for (String string : zrange) {
			byte[] hget = jedis.hget("student".getBytes(),string.getBytes() );
			Student unserialize = (Student) SerializeUtil.unserialize(hget);
			arrayList.add(unserialize);
		}
		jedis.close();
		return arrayList;
	}
	//添加学生数据
	public void addStudent(Student student) {	
		jedis.zadd("student_sort", student.getAvgscore(), student.getId());	
		jedis.hset("student".getBytes(),student.getId().getBytes() , SerializeUtil.serialize(student));		
		jedis.close();
	}
	//删除学生数据
	public void delStudent(String id) {
//		jedis.hdel("student",id);
//		jedis.zrem("student_sort",id);
		jedis.hdel("student".getBytes(), id.getBytes());
		jedis.zrem("student_sort".getBytes(), id.getBytes());
	
	}
	//查单条学生数据
		public Student selStudent(String id) {
			byte[] hget = jedis.hget("student".getBytes(), id.getBytes());
			Student student = (Student) SerializeUtil.unserialize(hget);
			return student;
		}
	//更新学生数据
	public void updateStudent(Student student) {

		System.out.println(student.getId());
		System.out.println(student.getAvgscore());
		jedis.zadd("student_sort", student.getAvgscore(), student.getId());	
		jedis.hset("student".getBytes(), student.getId().getBytes(), SerializeUtil.serialize(student));
		jedis.close();
	}
	
}
