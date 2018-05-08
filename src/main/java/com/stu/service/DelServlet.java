package com.stu.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.dao.StudentDao;
import com.stu.model.Student;

/**
 * Servlet implementation class DelServlet
 */
public class DelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Student student=new Student();
		String parameter = req.getParameter("id");
		StudentDao sd=new StudentDao();
		sd.delStudent(parameter);
		resp.sendRedirect(req.getContextPath()+"/QueryServlet");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
