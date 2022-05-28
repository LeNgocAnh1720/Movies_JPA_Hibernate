package com.poly.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.UserDao;
import com.poly.entity.users;


/**
 * Servlet implementation class ManageAdminUser
 */
@WebServlet({"/ManageAdminUser","/ManageAdminUser/insertUser","/ManageAdminUser/updateUser","/ManageAdminUser/deleteUser","/ManageAdminUser/editUser"})
public class ManageAdminUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if(uri.contains("insertUser")) {
			this.insertUser(request, response);
		}else if(uri.contains("updateUser")) {
			this.updateUser(request, response);
		}else if(uri.contains("deleteUser")) {
			this.deleteUser(request, response);
		}else if(uri.contains("editUser")) {
			this.editUser(request, response);
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/manageUsers.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDao dao = new UserDao();
			List<users> vid = dao.findAll();
			request.setAttribute("listuser", vid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			users user = new users();
			BeanUtils.populate(user, request.getParameterMap());

			UserDao dao = new UserDao();
			dao.insert(user);
			request.setAttribute("message", "Thêm mới thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Thêm mới thất bại");
		}
		
}

protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		users user = new users();
		BeanUtils.populate(user, request.getParameterMap());
		UserDao dao = new UserDao();
		boolean admin = Boolean.valueOf(request.getParameter("isAdmin"));
		System.out.print(admin);
		user.setAdmin(admin);
		dao.Update(user);
		request.setAttribute("message", "Update User thành công");
	} catch (Exception e) {
		request.setAttribute("error", "Update User thất bại");
	}
}

protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		String userId = request.getParameter("userId");
		UserDao dao = new UserDao();
		dao.delete(userId);

		request.setAttribute("message", "Xoá User thành công");
	} catch (Exception e) {
		request.setAttribute("error", "Xoá User thất bại");
		e.printStackTrace();
	}
}

protected void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		String userId = request.getQueryString();
		System.out.print(userId);
		UserDao dao = new UserDao();
		users user = dao.findId(userId);
		
		request.setAttribute("admin", user.isAdmin());
		request.setAttribute("formUser", user);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
