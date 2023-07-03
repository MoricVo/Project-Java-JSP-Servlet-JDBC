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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.database.chucvuDAO;
import com.duan.database.donvitructhuocDAO;
import com.duan.database.nguoidungDAO;
import com.duan.interface_of_dao.implement_dao.bang_nguoidung_dao;
import com.duan.model.bang_nguoidung_model;
import com.duan.utils.number_random;
import com.duan.utils.password_encryption;

@WebServlet(urlPatterns = {"/dang-ky","/dang-ky-xac-thuc"})
public class dangky extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangky() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
	    if (action != null && action.equals("dangky_taikhoan")) 
		{
		
		
		donvitructhuocDAO donvitructhuoc = new donvitructhuocDAO();
		chucvuDAO chucvus = new chucvuDAO();
		request.setAttribute("donvitructhuocs", donvitructhuoc.selectAll());
		request.setAttribute("chucvus", chucvus.selectAll());
		RequestDispatcher rd=request.getRequestDispatcher("/register.jsp");
		rd.forward(request, response);
		}
	    else if (action != null && action.equals("xacthuc_taikhoan")) 
		{
			try {
				String maNguoiDung = request.getParameter("maNguoiDung");
				String maXacThuc = request.getParameter("maXacThuc");

				nguoidungDAO nguoidung = new nguoidungDAO();
				int ImaNguoiDung=Integer.parseInt(maNguoiDung);
				bang_nguoidung_model kh = new bang_nguoidung_model();
				kh.setMaNguoiDung(ImaNguoiDung);
				bang_nguoidung_model nguoiDung = nguoidung.selectById(kh);
				
				 String message1 = "";
				 String message = "";
				 
				if (nguoiDung != null) {
					// Kiem tra ma xac thuc co giong nhau hay khong? // Kiem tra xem ma xac thuc con hieu luc hay khong?
					if(nguoiDung.getMaXacThuc().equals(maXacThuc)) {
						// Thanh Cong
						nguoiDung.setTrangThaiXacThuc(true);
						nguoidung.updateVeryfyAndInformation(nguoiDung);
						message1 ="Xác thực thành công!";
					
					}else {
						// That Bai
						message ="Xác thực không thành công!";
					}
				}else {
					message ="Tài khoản không tồn tại!";
				}
				
				 request.setAttribute("dangerMessage_xacthuckhongthanhcong", message);
				 request.setAttribute("successMessage_xacthucthanhcong", message1);
				 RequestDispatcher rd=request.getRequestDispatcher("/views/login.jsp");
					rd.forward(request, response);
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action != null && action.equals("dang_ky_taikhoan")) 
		{
		String maDonViTrucThuoc=request.getParameter("maDonViTrucThuoc");
		String maChucVu=request.getParameter("maChucVu");
		String hoNguoiDung=request.getParameter("hoNguoiDung");
		String tenNguoiDung=request.getParameter("tenNguoiDung");
		String gmail=request.getParameter("gmail");
		String matKhau=request.getParameter("matKhau");
		
		String matKhauNhapLai=request.getParameter("matKhauNhapLai");
		int ImaDonViTrucThuoc = Integer.parseInt(maDonViTrucThuoc);
		int ImaChucVu = Integer.parseInt(maChucVu);
		request.setAttribute("maDonViTrucThuoc",ImaDonViTrucThuoc);
		request.setAttribute("maChucVu",ImaChucVu);
		request.setAttribute("hoNguoiDung",hoNguoiDung);
		request.setAttribute("tenNguoiDung",tenNguoiDung);
		request.setAttribute("gmail",gmail);
		request.setAttribute("matKhau",matKhau);
		request.setAttribute("matKhauNhapLai",matKhauNhapLai);
		String baoLoi="";
		 nguoidungDAO nguoidung = new nguoidungDAO();
		if(nguoidung.kiemTraGmail(gmail)) {
			 String message = "Gmail đã tồn tại trong hệ thống";
			  request.setAttribute("dangerMessage_trungtaikhoan", message);
			
			 RequestDispatcher rd=request.getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
		}	
		else {
			matKhau=password_encryption.toSHA1(matKhau);
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			Random r=new Random();
			int ma=r.nextInt(10000);
			bang_nguoidung_model kh = new bang_nguoidung_model(ma,ImaDonViTrucThuoc,ImaChucVu,hoNguoiDung,tenNguoiDung,gmail,matKhau);
			if(nguoidung.insert(kh)>0)
			{
				Date todaysDate = new Date(new java.util.Date().getTime());
				Calendar c = Calendar.getInstance();
				c.setTime(todaysDate);
				c.add(Calendar.DATE, 1);
				Timestamp thoGianHieuLuc = new Timestamp(c.getTimeInMillis());
				
				boolean trangThaiXacThuc = false;
				String songaunhien=number_random.getSoNgauNhien();
				kh.setMaXacThuc(songaunhien);
				kh.setThoiGianHieuLuc(thoGianHieuLuc);
				kh.setTrangThaiXacThuc(trangThaiXacThuc);
				if(nguoidung.updateVeryfyAndInformation(kh)>0) {
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
						  message.setSubject("Xác thực đăng ký tài khoản");
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
				}
				
 			}
			String message1="Đăng ký tài khoản thành công!vui lòng xác thực để tiếp tục truy cập";
			 request.setAttribute("successMessage_dangkythanhcong", message1);
			 RequestDispatcher rd=request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);
		
		}
		}
	
	}
	
	public static String getNoiDung(bang_nguoidung_model kh) {
		String link = "http://localhost:8080/duanquocte_2023/dang-ky?action=xacthuc_taikhoan&maNguoiDung="+kh.getMaNguoiDung()+"&maXacThuc="+kh.getMaXacThuc();
		String noiDung = "<p>Xin ch&agrave;o bạn <strong>"+kh.getHoNguoiDung()+" "+ kh.getTenNguoiDung()+"</strong>.</p>\r\n" + 
				"<p>Click trực tiếp v&agrave;o đường link sau đ&acirc;y để tiến hành xác thực tài khoản của bạn:</p>\r\n" + 
				"<p><a  style=\"padding: 15px; font-size: 15pt; font-weight: bold; color: white; background-color: green; text-decoration: none; border-radius: 50px\" href=\""+link+"\">"+"Xác nhận"+"</a></p>\r\n" + 
				"<p>Đ&acirc;y l&agrave; nội dung email được gửi tự động từ hệ thống website quản l&yacute; dự &aacute;n quốc tế(PQHDN) vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n" + 
				"<p>Tr&acirc;n trọng cảm ơn</p>";
		return noiDung;
	}


}
