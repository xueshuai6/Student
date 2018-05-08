package com.stu.model;


import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	String id;
	String name;
	String birthday;
	String description;
	Integer avgscore;
	public Student(){
		
	}
	public Student(String id, String name, String birthday, String description, Integer avgscore) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.description = description;
		this.avgscore = avgscore;
	}
	public Integer getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(Integer avgscore) {
		this.avgscore = avgscore;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
