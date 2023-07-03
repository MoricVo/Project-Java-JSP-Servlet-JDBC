package com.duan.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.database.duanDAO;
import com.duan.interface_of_service.bang_nguoidung_interface_service;
import com.duan.model.bang_nguoidung_model;
@WebServlet(urlPatterns= {"/admin"})
public class home extends HttpServlet
{
@Inject bang_nguoidung_interface_service i_nguoidung_sv;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
	
		Object obj = request.getSession().getAttribute("nguoiDung");
		bang_nguoidung_model nguoiDung = null;
		if (obj != null)
			nguoiDung = (bang_nguoidung_model) obj;
		int manguoidung = nguoiDung.getMaNguoiDung();
		duanDAO donvi=new duanDAO();
		request.setAttribute("duan",donvi.count_thongke_duan());
		request.setAttribute("duan2",donvi.selectVonLon(manguoidung));
		request.setAttribute("duan3",donvi.selectVonLonAll());
		RequestDispatcher rd=request.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(request, response);
	
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
