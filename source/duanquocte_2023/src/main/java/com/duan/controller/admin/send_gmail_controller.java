package com.duan.controller.admin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;
import javax.servlet.ServletInputStream;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.MimetypesFileTypeMap;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.duan.database.nguoidungDAO;
import com.duan.model.bang_nguoidung_model;


/**
 * Servlet implementation class send_gmail_controller
 */
@MultipartConfig()
@WebServlet(urlPatterns= {"/admin_send_gmail"})
public class send_gmail_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send_gmail_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("send_gmail"))
		{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Object obj = request.getSession().getAttribute("nguoiDung");
		bang_nguoidung_model nguoiDung = null;
		if (obj != null)
			nguoiDung = (bang_nguoidung_model) obj;
		int madonvitructhuoc = nguoiDung.getMaDonViTrucThuoc();
		nguoidungDAO nguoidung=new nguoidungDAO();
		request.setAttribute("nguoidungs", nguoidung.selectAll_ByManager());
		request.setAttribute("nguoidungs_2", nguoidung.selectAll_ByUser(madonvitructhuoc));
		RequestDispatcher rd=request.getRequestDispatcher("/views/send_gmail.jsp");
		rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
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
		  Timestamp ngayTao;
		   Date now = new Date(); // Lấy thời gian hiện tại
		   ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
		   String[] emailToList = request.getParameterValues("gmail");
			  String emailSubject=request.getParameter("subject");
			  String emailContent=request.getParameter("content");
			 
		// Lấy thông tin về file đính kèm
		  Part attachmentPart = request.getPart("attachment");
		  String fileName = attachmentPart.getSubmittedFileName();
		  InputStream inputStream = attachmentPart.getInputStream();
		
		  try
		  {
			  
			 

			  for (String emailTo : emailToList) {
				    Message message = new MimeMessage(session);
				    message.setFrom(new InternetAddress(userName,info));
				    message.setRecipients(
				            Message.RecipientType.TO,
				            InternetAddress.parse(emailTo)
				    );
				    message.setSubject(emailSubject);

				    MimeMultipart multipart = new MimeMultipart();

				    MimeBodyPart messageBodyPart = new MimeBodyPart();
				    messageBodyPart.setText(emailContent+"|| Email được gửi từ hệ thống quản lý dự án quốc tế(PQHDN)yêu cầu anh chị tiến hành báo cáo dự án!Vui lòng truy cập đường link:http://localhost:8080/duanquocte_2023/trang-chu\n");

				    multipart.addBodyPart(messageBodyPart);

				    if(inputStream != null) {
				        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
				        DataSource source = new ByteArrayDataSource(inputStream, attachmentPart.getContentType());
				        attachmentBodyPart.setDataHandler(new DataHandler(source));
				        attachmentBodyPart.setFileName(fileName);
				        multipart.addBodyPart(attachmentBodyPart);
				    }

				    message.setContent(multipart);

				    Transport.send(message);
				}

				System.out.print("Gửi thành công!");
				String message1 = "Đã gửi email thành công!";
				request.setAttribute("successMessage1", message1);
				RequestDispatcher rd=request.getRequestDispatcher("/views/send_gmail.jsp");
				rd.forward(request, response);
			
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	}

}
