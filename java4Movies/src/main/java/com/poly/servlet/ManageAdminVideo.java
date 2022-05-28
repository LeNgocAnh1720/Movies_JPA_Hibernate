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
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import com.poly.dao.UserDao;
import com.poly.dao.VideoDao;
import com.poly.entity.users;
import com.poly.entity.video;

/**
 * Servlet implementation class ManageAdminVideo
 */
@WebServlet({"/ManageAdminVideo","/ManageAdminVideo/findAllUser","/ManageAdminVideo/insertVideo","/ManageAdminVideo/updateVideo","/ManageAdminVideo/deleteVideo","/ManageAdminVideo/editVideo"})
public class ManageAdminVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if(uri.contains("insertVideo")) {
			this.insertVideo(request, response);
		}else if(uri.contains("updateVideo")) {
			this.updateVideo(request, response);
		}else if(uri.contains("deleteVideo")) {
			this.deleteVideo(request, response);
		}else if(uri.contains("editVideo")) {
			this.editVideo(request, response);
		}else if(uri.contains("findAllUser")) {
			this.findAllUser(request, response);
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/manageVideo.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideoDao dao = new VideoDao();
			List<video> vid = dao.findAll();
			request.setAttribute("videos", vid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void findAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.getRequestDispatcher("/ManageAdminUser").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void insertVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("dd/MM/yyyy");
			ConvertUtils.register(dtc, Date.class);
			try {
				video video = new video();
				BeanUtils.populate(video, request.getParameterMap());
	
				VideoDao dao = new VideoDao();
				dao.insert(video);
				request.setAttribute("message", "Thêm mới thành công");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Thêm mới thất bại");
			}
			
	}
	
	protected void updateVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			video vid = new video();
			BeanUtils.populate(vid, request.getParameterMap());
			
			VideoDao dao = new VideoDao();
			dao.update(vid);
			request.setAttribute("message", "Update Video thành công");
		} catch (Exception e) {
			request.setAttribute("error", "Update Video thất bại");
		}
	}
	
	protected void deleteVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String videoId = request.getParameter("videoId");
			VideoDao dao = new VideoDao();
			dao.delete(videoId);

			request.setAttribute("message", "Xoá Video thành công");
		} catch (Exception e) {
			request.setAttribute("error", "Xoá Video thất bại");
			e.printStackTrace();
		}
	}
	
	protected void editVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeConverter dtc = new DateConverter(new Date());
		dtc.setPattern("dd/MM/yyyy");
		ConvertUtils.register(dtc, Date.class);
		try {
			String videoId = request.getQueryString();
			System.out.print(videoId);
			VideoDao dao = new VideoDao();
			video vid = dao.findId(videoId);

			request.setAttribute("form", vid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
