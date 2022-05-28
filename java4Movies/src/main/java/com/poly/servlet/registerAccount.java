package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.UserDao;
import com.poly.entity.users;

/**
 * Servlet implementation class registerAccount
 */
@WebServlet({"/registerAccount/register","/registerAccount/update","/registerAccount/upload"})
public class registerAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("register")) {
			this.register(request, response);
		}else if(uri.contains("update")) {
			this.LoadFile(request, response);
		}
		else if(uri.contains("upload")) {
			this.updatefile(request, response);
		}
		request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			String userId = request.getParameter("userId");
			String passwords = request.getParameter("passwords");
			String fullName = request.getParameter("fullName");
			String email = request.getParameter("email");
			
			users user = new users(userId, passwords, email, fullName, false);
			UserDao dao = new UserDao();
			users us = dao.insert(user);
			request.setAttribute("message", "Ðãng kí thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void LoadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			String userId = request.getParameter("userId");
			UserDao dao = new UserDao();
			users user = dao.findId(userId);
			request.setAttribute("user", user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void updatefile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			String userId = request.getParameter("userId");
			String passwords = request.getParameter("passwords");
			String fullName = request.getParameter("fullName");
			String email = request.getParameter("email");
			
			users user = new users(userId, passwords, email, fullName, false);
			UserDao dao1 = new UserDao();
			users us = dao1.Update(user);
			request.setAttribute("message", "Update thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
