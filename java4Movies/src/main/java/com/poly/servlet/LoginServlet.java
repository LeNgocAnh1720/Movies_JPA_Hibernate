package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.UserDao;
import com.poly.entity.users;
import com.poly.util.Cookies;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns ="/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		try {
			UserDao dao = new UserDao();
			users user = dao.findId(userid);
			
			if (!user.getPassword().equals(password)) {
				request.setAttribute("message", "Sai mật khẩu!!!");
				request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Đăng nhập thành công");
				int hours = (remember == null) ? 0 : 30 * 24; // 0 = xóa
				Cookies.add("userid", userid, hours, response);
				Cookies.add("password", password, hours, response);
				request.getSession().setAttribute("user", user);
				request.setAttribute("role", user.isAdmin());
				request.setAttribute("userid", userid);
				request.setAttribute("password", password);
				request.getRequestDispatcher("/java/index1").forward(request, response);
				
			}
		} catch (Exception e) {
			request.setAttribute("error", "Sai tên đăng nhập");
			e.printStackTrace();
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		}
		
	}
}
