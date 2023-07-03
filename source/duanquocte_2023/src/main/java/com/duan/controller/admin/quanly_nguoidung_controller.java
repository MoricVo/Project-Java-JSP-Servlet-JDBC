package com.duan.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.constant.System_Constant;
import com.duan.database.duanDAO;
import com.duan.database.nguoidungDAO;
import com.duan.interface_of_service.bang_nguoidung_interface_service;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;
import com.duan.utils.session_utils;

@WebServlet(urlPatterns= {"/admin_quanly_nguoidung","/admin_quanly_nguoidung_khoa","/admin_timkiem_nguoidung_post","/admin_capnhat_trangthai_nguoidung_them0","/admin_danhsach_nguoidung_dangbikhoa"})
public class quanly_nguoidung_controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    @Inject
    bang_nguoidung_interface_service i_nguoidung_sv;
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String action = request.getParameter("action");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (action != null && action.equals("danhsach_nguoidung"))
		{
			
		bang_nguoidung_model nguoidung =form_utils.toModel(bang_nguoidung_model.class, request);
		pageble pageble1=new page_request (nguoidung.getPage(),nguoidung.getMaxPageItem(),
			new sorter(nguoidung.getSapxeptheothuoctinh(),nguoidung.getSapxeptheochieu()));
		nguoidung.setDanhsach(i_nguoidung_sv.laytoanbodanhsach_service(pageble1));
		nguoidung.setTotalItem(i_nguoidung_sv.getTotalItem());
		nguoidung.setTotalPage((int)Math.ceil((double) nguoidung.getTotalItem()/nguoidung.getMaxPageItem()+20));
		request.setAttribute(System_Constant.NGUOIDUNG,nguoidung);
		RequestDispatcher rd=request.getRequestDispatcher("/views/admin/nguoidung/danhsach_nguoidung.jsp");
		rd.forward(request, response);
		}
		else if (action != null && action.equals("danhsach_nguoidung_khoa"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int madonvitructhuoc = nguoiDung.getMaDonViTrucThuoc();
		bang_nguoidung_model nguoidung =form_utils.toModel(bang_nguoidung_model.class, request);
		pageble pageble1=new page_request (nguoidung.getPage(),nguoidung.getMaxPageItem(),
			new sorter(nguoidung.getSapxeptheothuoctinh(),nguoidung.getSapxeptheochieu()));
		nguoidung.setDanhsach(i_nguoidung_sv.laytoanbodanhsach_theokhoa_service(pageble1,madonvitructhuoc));
		nguoidung.setTotalItem(i_nguoidung_sv.getTotalItem());
		nguoidung.setTotalPage((int)Math.ceil((double) nguoidung.getTotalItem()/nguoidung.getMaxPageItem()+20));
		request.setAttribute(System_Constant.NGUOIDUNG,nguoidung);
		RequestDispatcher rd=request.getRequestDispatcher("/views/admin/nguoidung/danhsach_nguoidung_khoa.jsp");
		rd.forward(request, response);
		}
		else if (action != null && action.equals("danhsach_nguoidung_dangbikhoa"))
		{
			
		bang_nguoidung_model nguoidung =form_utils.toModel(bang_nguoidung_model.class, request);
		nguoidung.setDanhsach(i_nguoidung_sv.laytoanbodanhsach_dangbikhoa_sv());
		
		request.setAttribute(System_Constant.NGUOIDUNG,nguoidung);
		RequestDispatcher rd=request.getRequestDispatcher("/views/admin/nguoidung/danhsach_nguoidung_dangbikhoa.jsp");
		rd.forward(request, response);
		}
		else if (action != null && action.equals("capnhat_trangthai_nguoidung_them0"))
		{
			nguoidungDAO nguoidung1=new nguoidungDAO();
			  String maNguoiDung = request.getParameter("maNguoiDung");
			   request.setAttribute("maNguoiDung",maNguoiDung);
			 
			   if (!maNguoiDung.isEmpty())
			   {
				   
			      int idMaNguoiDung=Integer.parseInt(maNguoiDung);
			      bang_nguoidung_model dm = new bang_nguoidung_model(idMaNguoiDung);
			        nguoidung1.update_trangthai_nguoidung_0(dm);
			        response.sendRedirect(request.getContextPath()
							+ "/admin_quanly_nguoidung?action=danhsach_nguoidung&page=1&maxPageItem=20&sapxeptheothuoctinh=quyenhan&sapxeptheochieu=asc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
			   }
			  
		}
		else if (action != null && action.equals("capnhat_trangthai_nguoidung_them1"))
		{
			nguoidungDAO nguoidung1=new nguoidungDAO();
			  String maNguoiDung = request.getParameter("maNguoiDung");
			   request.setAttribute("maNguoiDung",maNguoiDung);
			 
			   if (!maNguoiDung.isEmpty())
			   {
				   
			      int idMaNguoiDung=Integer.parseInt(maNguoiDung);
			      bang_nguoidung_model dm = new bang_nguoidung_model(idMaNguoiDung);
			        nguoidung1.update_trangthai_nguoidung_1(dm);
			        response.sendRedirect(request.getContextPath()
							+ "/admin_quanly_nguoidung?action=danhsach_nguoidung&page=1&maxPageItem=20&sapxeptheothuoctinh=quyenhan&sapxeptheochieu=asc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
			   }
			  
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		 if (action != null && action.equals("timkiem_nguoidung_post")) {
			String key=request.getParameter("key");
			request.setAttribute("key",key);
			bang_nguoidung_model nguoidung =form_utils.toModel(bang_nguoidung_model.class, request);
			nguoidung.setDanhsach(i_nguoidung_sv.timkiemnguoidung_sv(key, key,key));
			request.setAttribute(System_Constant.NGUOIDUNG,nguoidung);
			RequestDispatcher rd=request.getRequestDispatcher("/views/admin/nguoidung/danhsach_nguoidung.jsp");
			rd.forward(request, response);
		}
		
	}

}

