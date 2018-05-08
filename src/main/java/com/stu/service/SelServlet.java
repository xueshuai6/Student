package com.stu.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.dao.StudentDao;
import com.stu.model.Student;

/**
 * Servlet implementation class SelServlet
 */
public class SelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		StudentDao sd=new StudentDao();
		Student selStudent =sd.selStudent(id);
		req.setAttribute("sel", selStudent);
		req.getRequestDispatcher("UpdateStudent.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
