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
import com.duan.database.coquanpheduyetDAO;
import com.duan.database.danhmuc_DAO;
import com.duan.database.duanDAO;
import com.duan.database.nguoidungDAO;
import com.duan.interface_of_service.bang_coquanpheduyet_interface_service;
import com.duan.interface_of_service.bang_duan_interface_service;
import com.duan.model.bang_coquanpheduyet_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;
@WebServlet(urlPatterns= {"/admin_quanly_coquanpheduyet","/admin_them_coquanpheduyet","/admin_xoa_coquanpheduyet"})
public class quanly_coquanpheduyet_controller extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	@Inject
	  bang_coquanpheduyet_interface_service i_coquan_sv;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
	if(action !=null && action.equals("danhsach_coquanpheduyet"))
	{
	bang_coquanpheduyet_model coquanpheduyet = form_utils.toModel(bang_coquanpheduyet_model.class, request);
	pageble pageble1=new page_request (coquanpheduyet.getPage(),coquanpheduyet.getMaxPageItem(),
			new sorter(coquanpheduyet.getSapxeptheothuoctinh(),coquanpheduyet.getSapxeptheochieu()));
	coquanpheduyet.setDanhsach(i_coquan_sv.laytoanbodanhsach_sv(pageble1));
	coquanpheduyet.setTotalItem(i_coquan_sv.getTotalItem());
	coquanpheduyet.setTotalPage((int)Math.ceil((double) coquanpheduyet.getTotalItem()/coquanpheduyet.getMaxPageItem()+10));
	request.setAttribute(System_Constant.COQUANPHEDUYET,coquanpheduyet);
	RequestDispatcher rd=request.getRequestDispatcher("/views/admin/coquanpheduyet/danhsach_coquanpheduyet.jsp");
	rd.forward(request, response);
	}
	/*else if(action !=null && action.equals("them_coquanpheduyet"))
	{
		RequestDispatcher rd=request.getRequestDispatcher("/views/admin/coquanpheduyet/add.jsp");
		rd.forward(request, response);
	}*/
	else if (action != null && action.equals("xoa_coquanpheduyet"))
	{
		coquanpheduyetDAO coquanpheduyet=new coquanpheduyetDAO();
		duanDAO duan=new duanDAO();
		  String maCoQuanPheDuyet = request.getParameter("maCoQuanPheDuyet");
		   request.setAttribute("maCoQuanPheDuyet",maCoQuanPheDuyet);
		   if (!maCoQuanPheDuyet.isEmpty())
		   {
			   
		      int idMaCoQuan=Integer.parseInt(maCoQuanPheDuyet);
		        duan.update_coquanpheduyet_null(idMaCoQuan);
		        coquanpheduyet.delete1(idMaCoQuan);
		        String message1="Xóa thành công!";
				 request.setAttribute("successMessage_xoathanhcong", message1);
				 RequestDispatcher rd=request.getRequestDispatcher("/admin_quanly_coquanpheduyet?action=danhsach_coquanpheduyet&page=1&maxPageItem=20&sapxeptheothuoctinh=macoquanpheduyet&sapxeptheochieu=asc");
					rd.forward(request, response);
		   }
		  
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		if(action !=null && action.equals("them_coquanpheduyet"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
			
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
		String tenCoQuanPheDuyet=request.getParameter("tenCoQuanPheDuyet");
		request.setAttribute("tenCoQuanPheDuyet",tenCoQuanPheDuyet);
		 coquanpheduyetDAO coquanpheduyet = new coquanpheduyetDAO();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			Random r=new Random();
			int maCoQuanPheDuyet=r.nextInt(10000);
			
			bang_coquanpheduyet_model cq = new bang_coquanpheduyet_model(maCoQuanPheDuyet,tenCoQuanPheDuyet,ngayTao,manguoidung);
			coquanpheduyet.insert(cq);
			response.sendRedirect(request.getContextPath()+"/admin_them_duan?action=them_duan");
	}
		else if(action !=null && action.equals("them_coquanpheduyet_suaduan"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
		
			
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
		String tenCoQuanPheDuyet=request.getParameter("tenCoQuanPheDuyet");
		request.setAttribute("tenCoQuanPheDuyet",tenCoQuanPheDuyet);
		 coquanpheduyetDAO coquanpheduyet = new coquanpheduyetDAO();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			Random r=new Random();
			int maCoQuanPheDuyet=r.nextInt(10000);
			
			bang_coquanpheduyet_model cq = new bang_coquanpheduyet_model(maCoQuanPheDuyet,tenCoQuanPheDuyet,ngayTao,manguoidung);
			coquanpheduyet.insert(cq);
			response.sendRedirect(request.getContextPath()+"/admin_sua_duan?action=sua_duan");
	}
		
	}
	
}
