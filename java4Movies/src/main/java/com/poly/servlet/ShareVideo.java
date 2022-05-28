package com.poly.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.ShareDao;
import com.poly.dao.VideoDao;
import com.poly.entity.share;
import com.poly.entity.users;
import com.poly.entity.video;

/**
 * Servlet implementation class ShareVideo
 */
@WebServlet({"/ShareVideo/LoadData","/ShareVideo/Share"})
public class ShareVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.LoadData(request, response);
		request.getRequestDispatcher("/views/user/shareVideo.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 
		 String username = "lengocanh2572@gmail.com";
		 String password = "0346064484aa";
		//Thông số kết nối smtp server
		try {
			Properties pros = new Properties();
			pros.put("mail.smtp.host", "smtp.gmail.com");
			pros.put("mail.smtp.port", "465");
			pros.put("mail.smtp.starttls.enable", "true");
			pros.put("mail.smtp.auth", "true");
			pros.put("mail.smtp.socketFactory.port", "465");
			pros.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			pros.put("mail.smtp.socketFactory.fallback", "false");
			pros.put("mail.smtp.ssl.protocols", "TLSv1.2");

			
			Session session = Session.getInstance(pros, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			
			});
			String fromEmail = request.getParameter("fromEmail");
			String subject = request.getParameter("toSubject");
			String emailLink = request.getParameter("videoTrailler");
			
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, fromEmail);
			message.setSubject(subject,"utf-8");
			message.setText(emailLink,"utf-8");
			
			
			Transport.send(message);
			this.insertShare(request, response);
			request.setAttribute("message", "Send mail succefully!");
			request.getRequestDispatcher("/java/index1").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void LoadData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			users user = (users) request.getSession().getAttribute("user");
			String videoId = request.getParameter("videoId");
			VideoDao dao = new VideoDao();
			video v = dao.findId(videoId);
			request.setAttribute("video", v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void insertShare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			users user = (users) request.getSession().getAttribute("user");
			String videoId = request.getParameter("videoId");
			VideoDao dao = new VideoDao();
			video video = dao.findId(videoId);
			String emails = request.getParameter("fromEmail");
	
			share sh = new share(user,video, emails);
			ShareDao daoShare = new ShareDao();
			share s = daoShare.insert(sh);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
