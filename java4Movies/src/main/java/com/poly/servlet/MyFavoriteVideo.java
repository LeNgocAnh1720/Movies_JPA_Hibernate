package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.VideoDao;
import com.poly.entity.favorite;
import com.poly.entity.users;
import com.poly.entity.video;
import com.poly.util.JpaUtils;


/**
 * Servlet implementation class MyFavoriteVideo
 */
@WebServlet({"/MyFavoriteVideo"})
public class MyFavoriteVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.DanhSachYeuThich(request, response);
		request.getRequestDispatcher("/views/user/VideoFavorite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void DanhSachYeuThich(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			users user = (users) request.getSession().getAttribute("user");
			System.out.println(user.getUserId());
			VideoDao dao = new VideoDao();
			List<video> videos = dao.DanhSachYeuThich(user);
			request.setAttribute("videoFavorite", videos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
