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


@WebServlet("/searchVideo")
public class searchVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		this.name(request, response);
		request.getRequestDispatcher("/java/index1").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void name(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException {
		try {
			String nameVideo = request.getParameter("searchVideo");
			System.out.println(nameVideo);
			VideoDao dao = new VideoDao();
			List<video> list = dao.SearchVideo(nameVideo);
			request.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
