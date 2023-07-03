package com.duan.controller.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.database.nguoidungDAO;
import com.duan.model.bang_nguoidung_model;
import com.duan.utils.number_random;
import com.duan.utils.password_encryption;

/**
 * Servlet implementation class quenmatkhau
 */
@WebServlet(urlPatterns = {"/dang-ky-khoiphuctaikhoan"})
public class quenmatkhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quenmatkhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
	    if (action != null && action.equals("dangky_khoiphuctaikhoan")) 
		{
		
		RequestDispatcher rd=request.getRequestDispatcher("/forgot_password.jsp");
		rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 static String matkhau;
	 static  String matkhau1;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		if (action != null && action.equals("dangky_khoiphuctaikhoan_post")) 
		{
		
		String gmail=request.getParameter("gmail");
		
		
	
		request.setAttribute("gmail",gmail);
		 nguoidungDAO nguoidung = new nguoidungDAO();
		if(nguoidung.kiemTraGmail(gmail)) {
			
			
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			Random n=new Random();
			matkhau1="User"+n.nextInt(10000);
		    matkhau=password_encryption.toSHA1(matkhau1);
			bang_nguoidung_model kh = new bang_nguoidung_model(gmail,matkhau);
			nguoidung.changePasswordIfForgotPass(kh);
		
				
					  final String userName="phong.qhdn.agu@gmail.com";
					  final String info="Phòng QHDN (AGU)";
					  final String password="uhlfaxdbzrrgjvak";
					  Properties prop=new Properties();
					  prop.put("mail.smtp.host", "smtp.gmail.com");
					  prop.put("mail.smtp.port", "465");
					  prop.put("mail.smtp.auth", "true");
					  prop.put("mail.smtp.starttls.enable", "true");
					  prop.put("mail.smtp.starttls.required", "true");
					  prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
					  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					  Session session=Session.getInstance(prop,new javax.mail.Authenticator() {
						  protected PasswordAuthentication getPasswordAuthentication ()
						  {
							  return new PasswordAuthentication(userName, password);
						  }
					  });
					  try
					  {
						  Message message= new MimeMessage(session);
						  message.setFrom(new InternetAddress(userName,info));
						  message.setRecipients(
								  Message.RecipientType.TO,
								  InternetAddress.parse(kh.getGmail())
								  );
						  message.setSubject("Quên mật khẩu.");
						  message.setContent(getNoiDung(kh), "text/HTML; charset=UTF-8");
				           if(message!=null)
				           {
				        	   Transport.send(message);
				 			  System.out.print("Gửi thành công!");
				 		
				           }
				         
						
					  }
					  catch(Exception e)
					  {
						  e.printStackTrace();
					  }
				
				
 			
			String message1="Vui lòng kiểm tra tài khoản email và làm theo hướng dẫn!";
			 request.setAttribute("successMessage_quenmatkhau", message1);
			 RequestDispatcher rd=request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);
			
		}	
		else {
			 String message = "Gmail không tồn tại trong hệ thống!";
			  request.setAttribute("dangerMessage_gmailkhongtontai", message);
			
			 RequestDispatcher rd=request.getRequestDispatcher("/forgot_password.jsp");
			rd.forward(request, response);
		
		}
		}
	}
	public static String getNoiDung(bang_nguoidung_model kh) {
	
		String noiDung = "<p>Xin ch&agrave;o bạn <strong>"+"</strong>.</p>\r\n" + 
				"<p>Đ&acirc;y l&agrave; mật khẩu hiện tại của bạn :<strong>"+matkhau1+"</strong> vui l&ograve;ng truy cập v&agrave;o hệ thống v&agrave; đổi lại mật khẩu.</p>\r\n" + 
				"<p>Đ&acirc;y l&agrave; tin nhắn trả lời tự động từ ph&ograve;ng Quan Hệ Đối Ngoại(trường Đại Học An Giang) vui l&ograve;ng kh&ocirc;ng trả lời lại!.</p>\r\n" + 
				"<p>Tr&acirc;n trọng.</p>";
		return noiDung;
	}

}
