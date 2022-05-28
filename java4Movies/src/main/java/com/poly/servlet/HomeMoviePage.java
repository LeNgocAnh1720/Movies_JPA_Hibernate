package com.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.FavoriteDao;
import com.poly.dao.VideoDao;
import com.poly.entity.favorite;
import com.poly.entity.users;
import com.poly.entity.video;

/**
 * Servlet implementation class HomeMoviePage
 */
@WebServlet({"/HomeMoviePage/SelectById","/HomeMoviePage/addVideoFavorite"})
public class HomeMoviePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if(uri.contains("addVideoFavorite")) {
			this.addVideoFavorite(request, response);
		}
		this.SelectById(request, response);
		request.getRequestDispatcher("/views/user/moviepage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void Select10Video(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideoDao dao = new VideoDao();
			List<video> vid = dao.SelectTop10();
			request.setAttribute("videos", vid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void SelectById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String videoid = request.getParameter("videoId");
			VideoDao dao = new VideoDao();
			VideoDao dao2 = new VideoDao();

			video vid = dao.findId(videoid);
			List<video> daovideo = dao.findAll();
			request.setAttribute("video", vid);
			request.setAttribute("videos", daovideo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	protected void addVideoFavorite(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String videoid =  request.getParameter("videoId");
			VideoDao dao = new VideoDao();
			video vid = dao.findId(videoid);
			users user = (users) request.getSession().getAttribute("user");
			if(user == null) {
				request.setAttribute("message", "Vui lòng đăng nhập!!");
				return;
			}else {
				System.out.println(user.getUserId());
				System.out.println(vid.getVideoId());
				favorite fav = new favorite(user, vid);
				FavoriteDao favdao = new FavoriteDao();
				favorite fa = favdao.insert(fav);
				request.setAttribute("message", "Video đã được thêm vào danh sách yêu thích!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
