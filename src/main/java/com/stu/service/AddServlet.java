package com.stu.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.dao.StudentDao;
import com.stu.model.Student;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {	

	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String birthday=req.getParameter("birthday");
		String description=req.getParameter("description");
		String avgscore=req.getParameter("avgscore");
		Student stu=new Student();
		stu.setId(id);
		stu.setAvgscore(Integer.parseInt(avgscore));
		stu.setBirthday(birthday);
		stu.setDescription(description);
		stu.setName(name);
		StudentDao s=new StudentDao();
		s.addStudent(stu);
		resp.sendRedirect(req.getContextPath()+"/QueryServlet");

	}
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req, resp);
		
	}

}
