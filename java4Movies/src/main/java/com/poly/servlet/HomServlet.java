package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.VideoDao;
import com.poly.entity.video;

/**
 * Servlet implementation class HomServlet
 */
@WebServlet(urlPatterns = { "/java/index1"})
public class HomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.Select10Video(request, response);
		request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	
	protected void Select10Video(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VideoDao dao = new VideoDao();
			List<video> vid = dao.SelectTop10();
			request.setAttribute("videos", vid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
