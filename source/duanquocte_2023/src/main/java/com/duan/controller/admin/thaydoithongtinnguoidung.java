package com.duan.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.duan.database.chucvuDAO;
import com.duan.database.nguoidungDAO;
import com.duan.model.bang_nguoidung_model;
import com.duan.utils.password_encryption;

@WebServlet(urlPatterns = { "/admin_thaydoithongtin","/admin_capnhat_matkhau" })
public class thaydoithongtinnguoidung extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public thaydoithongtinnguoidung() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nguoidung/thaydoi_thongtin_canhan.jsp");
		rd.forward(request, response);
	}

	/*
	 * protected void thayDoiAnh(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { try { String
	 * folder=getServletContext().getInitParameter("avatar_user"); File file; int
	 * maxFileSize=5000*1024; int maxMemSize=5000*1024;
	 * 
	 * String contentType=request.getContentType();
	 * if(contentType.indexOf(contentType)>=0) { DiskFileItemFactory factory =new
	 * DiskFileItemFactory();
	 * 
	 * //quy định dung lượng tối đa của file factory.setSizeThreshold(maxMemSize);
	 * 
	 * 
	 * //tạo file ServletFileUpload upload =new ServletFileUpload(factory);
	 * upload.setSizeMax(maxFileSize); List<FileItem> files
	 * =upload.parseRequest(request);
	 * 
	 * } } catch(Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		if(action !=null && action.equals("capnhat_thongtin")) {
			chucvuDAO chucvus = new chucvuDAO();
			request.setAttribute("chucvus", chucvus.selectAll());
			String maChucVu = request.getParameter("maChucVu");
			/* int a = Integer.parseInt(maChucVu); */
			String hoNguoiDung = request.getParameter("hoNguoiDung");
			String tenNguoiDung = request.getParameter("tenNguoiDung");
			String sdt = request.getParameter("sdt");
			String diaChi = request.getParameter("diaChi");
			String gmail = request.getParameter("gmail");
			/* request.setAttribute("maChucVu", a); */
			request.setAttribute("hoNguoiDung", hoNguoiDung);
			request.setAttribute("teNguoiDung", tenNguoiDung);
			request.setAttribute("sdt", sdt);
			request.setAttribute("diaChi", diaChi);
			request.setAttribute("gmail", gmail);

			String baoLoi = "";
			nguoidungDAO nguoidung = new nguoidungDAO();

			request.setAttribute("baoLoi", baoLoi);

			if (baoLoi.length() > 0) {

			} else {
				Object obj = request.getSession().getAttribute("nguoiDung");
				bang_nguoidung_model nguoiDung = null;
				if (obj != null)
					nguoiDung = (bang_nguoidung_model) obj;
				if (nguoiDung != null) {
					int maNguoiDung = nguoiDung.getMaNguoiDung();
					bang_nguoidung_model kh = new bang_nguoidung_model(maNguoiDung, 5, hoNguoiDung, tenNguoiDung, sdt,
							diaChi, gmail, "", "", 1, "");
					nguoidung.updateInfo(kh);
					bang_nguoidung_model kh2 = nguoidung.selectById(kh);
					request.getSession().setAttribute("nguoiDung", kh2);
					response.sendRedirect(request.getContextPath() + "/admin");
				}

			}
		} else if(action !=null && action.equals("capnhat_anh")) {
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			try {

				nguoidungDAO nguoidung = new nguoidungDAO();

				if (obj != null)
					nguoiDung = (bang_nguoidung_model) obj;
				if (nguoiDung != null) {
					String folder = getServletContext().getRealPath("avatar_user");
					System.out.print(folder);
					File file;
					int maxFileSize = 5000 * 1024;
					int maxMemSize = 5000 * 1024;

					String contentType = request.getContentType();
					if (contentType.indexOf(contentType) >= 0) {
						DiskFileItemFactory factory = new DiskFileItemFactory();

						// quy định dung lượng tối đa của file
						factory.setSizeThreshold(maxMemSize);

						// tạo file
						ServletFileUpload upload = new ServletFileUpload(factory);
						upload.setSizeMax(maxFileSize);
						List<FileItem> files = upload.parseRequest(request);

						for (FileItem fileItem : files) {
							if (!fileItem.isFormField()) {
								
								String fileName = System.currentTimeMillis() + fileItem.getName();
								String path = folder + "\\" + fileName;
								file = new File(path);
								fileItem.write(file);
								nguoiDung.setAnhDaiDien(fileName);
								nguoidung.updateImage(nguoiDung);
								nguoiDung = nguoidung.selectById(nguoiDung);
								response.sendRedirect(request.getContextPath() + "/admin");
							} else {
								String name = fileItem.getFieldName();
								String value = fileItem.getString();
								System.out.print(name + ": " + value);
							}

						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		else if(action !=null && action.equals("capnhat_matkhau")) {
			
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			
			
			String matKhauHienTai=request.getParameter("matKhauHienTai");
			String matKhauMoi=request.getParameter("matKhauMoi");
			String matKhauNhapLai=request.getParameter("matKhauNhapLai");
			
			String matKhauHienTaiSha1= password_encryption.toSHA1(matKhauHienTai);
			  if(!matKhauHienTaiSha1.equals(nguoiDung.getMatKhau()))
			  {
				  String message1 = "Mật khẩu hiện tại bạn nhập không chính xác!Vui lòng kiểm tra lại.";
				  request.setAttribute("dangerMessage_doimatkhau_mkkhongchinhxac", message1);
				  RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nguoidung/thaydoi_thongtin_canhan.jsp");
					rd.forward(request, response);
			  }
			  else 
			  {
				  if(!matKhauMoi.equals(matKhauNhapLai))
				  {
					  String message = "Mật khẩu mới không khớp!vui lòng kiểm tra lại.";
					  request.setAttribute("dangerMessage_doimatkhau_mkkhongkhop", message);
					  RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nguoidung/thaydoi_thongtin_canhan.jsp");
						rd.forward(request, response);
					
				  }
				  else
				  {
					  String matKhauMoi_Sha1=password_encryption.toSHA1(matKhauMoi);
					  nguoiDung.setMatKhau(matKhauMoi_Sha1);
					  nguoidungDAO ngd=new nguoidungDAO();
					  if(ngd.changePassword(nguoiDung))
					  {
						  String message1 = "Thay đổi mật khẩu thành công!.";
						  request.setAttribute("successMessage_doimkthanhcong", message1);
						  RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nguoidung/thaydoi_thongtin_canhan.jsp");
							rd.forward(request, response);
						 
					  }
					  else
					  {
						  String message = "Quá trình thay đổi mật khẩu không thành công!.";
						  request.setAttribute("dangerMessage_quatrinh_doimatkhau_khongthanhcong", message);
						  RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nguoidung/thaydoi_thongtin_canhan.jsp");
							rd.forward(request, response);
					  }
				  }
			  }
			  
		}

	}

}
