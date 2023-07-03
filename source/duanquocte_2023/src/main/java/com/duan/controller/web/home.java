package com.duan.controller.web;

import java.io.IOException;
import java.util.Random;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duan.database.nguoidungDAO;
import com.duan.interface_of_service.bang_nguoidung_interface_service;
import com.duan.model.bang_nguoidung_model;
import com.duan.utils.form_utils;
import com.duan.utils.password_encryption;
import com.duan.utils.session_utils;
@WebServlet(urlPatterns= {"/trang-chu","/dang-nhap","/thoat"})

public class home extends HttpServlet
{
@Inject bang_nguoidung_interface_service i_nguoidung_sv;
	
	private static final long serialVersionUID = 1L;
	ResourceBundle mybundle = ResourceBundle.getBundle("message");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
		
			String action=request.getParameter("action");
			if(action !=null && action.equals("login"))
			{
				String message=request.getParameter("message");
				String alert=request.getParameter("alert");
				if(message!=null&&alert!=null)
				{
					request.setAttribute("message",mybundle.getString(message));
					request.setAttribute("alert",alert);
				}
				RequestDispatcher rd=request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);
			}
			else if(action !=null && action.equals("logout"))
		    {
				session_utils.getInstance().removeValue(request,"USERMODEL");
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
		    }
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("/views/intro.jsp");
				rd.forward(request, response);
			}
	
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String gmail=request.getParameter("gmail");
		String matKhau=request.getParameter("matKhau");
		 matKhau=password_encryption.toSHA1(matKhau);
		bang_nguoidung_model nguoidunga=new bang_nguoidung_model();
		nguoidunga.setGmail(gmail);
		nguoidunga.setMatKhau(matKhau);
		nguoidungDAO ngd=new nguoidungDAO();
		bang_nguoidung_model nguoidungne=ngd.selectByGmailAndPassWord(nguoidunga);
		if(action !=null && action.equals("login"))
		{
			bang_nguoidung_model nguoidung =form_utils.toModel(bang_nguoidung_model.class, request);
			nguoidung=i_nguoidung_sv.laytoanbodanhsachtheo_gmail_tennguoidung_matkhau_trangthai(nguoidung.getGmail(),matKhau,1);
			if(nguoidung!=null &&nguoidungne!=null)
			{
				HttpSession session =request.getSession();
				session.setAttribute("nguoiDung",nguoidungne);
				session_utils.getInstance().putValue(request,"USERMODEL",nguoidung);
				if(nguoidung.getQuyenHan().equals("user")&&nguoidung.getTrangThaiXacThuc().equals(true)||nguoidung.getQuyenHan().equals("manager")&&nguoidung.getTrangThaiXacThuc().equals(true))
				{
					response.sendRedirect(request.getContextPath()+"/admin");
				}
				else if(nguoidung.getQuyenHan().equals("admin")&&nguoidung.getTrangThaiXacThuc().equals(true) )
				{
					response.sendRedirect(request.getContextPath()+"/admin");
				}
				else if(nguoidung.getTrangThaiXacThuc().equals(false))
				{
					 String message_xacthuc = "Bạn cần xác thực tài khoản trước khi đăng nhập!";
		 			  request.setAttribute("danger_Message_xacthuc", message_xacthuc);
					
		 			 RequestDispatcher rd=request.getRequestDispatcher("views/login.jsp");
		 			rd.forward(request, response);
				}
				
			}
			else
			{
				 String message_khongkhop = "Tài khoản và mật khẩu của bạn không khớp hoặc đã bị khóa!";
	 			  request.setAttribute("danger_Message_khongkhop", message_khongkhop);
				
	 			 RequestDispatcher rd=request.getRequestDispatcher("views/login.jsp");
	 			rd.forward(request, response);
			}
		}
		
			
		
	}
}
