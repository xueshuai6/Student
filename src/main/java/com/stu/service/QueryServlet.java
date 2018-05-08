package com.stu.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.dao.StudentDao;
import com.stu.model.Student;
import com.stu.util.RedisUtil;
import com.stu.util.SerializeUtil;

import redis.clients.jedis.Jedis;

public class QueryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");		
		String p = req.getParameter("page");
		//当前页数
		int page;
		try {			
			page=Integer.valueOf(p);
		} catch (NumberFormatException e) {
			page=1;
		}
		StudentDao s=new StudentDao();
		List queryStudent = s.queryStudent(page);
		req.setAttribute("list", queryStudent);
		int size = queryStudent.size();
		int i=10;
		//总页数
		int pages=(size%i == 0? size/i : size/i+1)+2;
		//本页起始序号
		int begin=(page-1)*i;
		//本页末页序号
		int end=begin+i;
		req.setAttribute("pages", pages);
		req.setAttribute("page", page);
		req.setAttribute("size", size);
		req.setAttribute("end", end);
		req.setAttribute("begin", begin);
		req.getRequestDispatcher("Student.jsp").forward(req, resp);
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {			
			doGet(req, resp);
		}
}
