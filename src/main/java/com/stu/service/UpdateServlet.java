package com.stu.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.dao.StudentDao;
import com.stu.model.Student;

public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String birthday=req.getParameter("birthday");
		String description=req.getParameter("description");
		String avgscore=req.getParameter("avgscore");
		Student stu=new Student();
		stu.setAvgscore(Integer.parseInt(avgscore));
		stu.setBirthday(birthday);
		stu.setDescription(description);
		stu.setName(name);
		stu.setId(id);
		StudentDao s=new StudentDao();
		s.addStudent(stu);
		resp.sendRedirect(req.getContextPath()+"/QueryServlet");
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
