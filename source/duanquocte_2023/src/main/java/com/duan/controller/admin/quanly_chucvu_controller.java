package com.duan.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.constant.System_Constant;
import com.duan.database.chucvuDAO;
import com.duan.database.nguoidungDAO;
import com.duan.interface_of_service.bang_chucvu_interface_service;
import com.duan.model.bang_chucvu_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

@WebServlet(urlPatterns= {"/admin_quanly_chucvu","/admin_them_chucvu","/admin_xoa_chucvu"})
public class quanly_chucvu_controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	 @Inject
	  bang_chucvu_interface_service i_chucvu_sv;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action=request.getParameter("action");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (action != null && action.equals("danhsach_chucvu"))
		{
	bang_chucvu_model chucvu = form_utils.toModel(bang_chucvu_model.class, request);
	pageble pageble1=new page_request (chucvu.getPage(),chucvu.getMaxPageItem(),
			new sorter(chucvu.getSapxeptheothuoctinh(),chucvu.getSapxeptheochieu()));
	chucvu.setDanhsach(i_chucvu_sv.laytoanbodanhsach_sv(pageble1));
	chucvu.setTotalItem(i_chucvu_sv.getTotalItem());
	chucvu.setTotalPage((int)Math.ceil((double) chucvu.getTotalItem()/chucvu.getMaxPageItem()+20));
	request.setAttribute(System_Constant.CHUCVU,chucvu);
	RequestDispatcher rd=request.getRequestDispatcher("/views/admin/chucvu/danhsach_chucvu.jsp");
	rd.forward(request, response);
		}
		else if (action != null && action.equals("xoa_chucvu"))
	{
		chucvuDAO chucvu1=new chucvuDAO();
		nguoidungDAO nguoidung=new nguoidungDAO();
		  String machucvu = request.getParameter("machucvu");
		  
		   if (!machucvu.isEmpty())
		   {
			   
		      int idMaChucVu=Integer.parseInt(machucvu);
		        nguoidung.update_chucvu_null(idMaChucVu);
		        chucvu1.delete1(idMaChucVu);
				

				   String message1="Xóa thành công!";
					 request.setAttribute("successMessage_xoathanhcong", message1);
					 RequestDispatcher rd=request.getRequestDispatcher("/admin_quanly_chucvu?action=danhsach_chucvu&page=1&maxPageItem=20&sapxeptheothuoctinh=tenchucvu&sapxeptheochieu=desc");
						rd.forward(request, response);
		   }
		  
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		if(action !=null && action.equals("them_chucvu"))
		{
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			String tenChucVu=request.getParameter("tenChucVu");
		
			 chucvuDAO coquanpheduyet = new chucvuDAO();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			Random r=new Random();
			int maChucVu=r.nextInt(10000);
			bang_chucvu_model cq = new bang_chucvu_model(maChucVu,tenChucVu,ngayTao);
			coquanpheduyet.insert(cq);
			response.sendRedirect(request.getContextPath()+"/admin_quanly_chucvu?action=danhsach_chucvu&page=1&maxPageItem=20&sapxeptheothuoctinh=tenchucvu&sapxeptheochieu=desc");
			
	}
		
		
	}
}









