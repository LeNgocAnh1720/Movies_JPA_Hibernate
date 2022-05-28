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

import com.poly.dao.UserDao;
import com.poly.entity.users;

/**
 * Servlet implementation class forgotPassword
 */
@WebServlet("/forgotPassword")
public class forgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/forgotPassword.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		try {
			String userId = request.getParameter("userId");
			String emails = request.getParameter("emails");

			 String username = "lengocanh2572@gmail.com";
			 String password = "0346064484aa";
			UserDao dao = new UserDao();
			users user = dao.findId(userId);
			if(!user.getUserId().equals(userId)) {
				request.setAttribute("message", "UserId này không tồn tại");
				return;
			}else if(!user.getEmail().equals(emails)) {
				request.setAttribute("message", "Email này không thuộc quyền sở hửu của UserId này");
				return;
			}else {
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
				String fromEmail = request.getParameter("emails");
				String userName = request.getParameter("userId");
				
				
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO, fromEmail);
				message.setSubject("Reset Mật Khẩu?" ,"utf-8");
				message.setText(user.getUserId() +"\n"+ user.getFullName() +"\n"+user.getPassword(),"utf-8");
				
				Transport.send(message);
				
				request.setAttribute("message", "Send mail succefully!");
				request.getRequestDispatcher("/views/user/forgotPassword.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
