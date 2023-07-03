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
import com.duan.database.danhmuc_DAO;
import com.duan.database.duanDAO;
import com.duan.database.thamgiaduanDAO;
import com.duan.interface_of_service.bang_danhmuc_interface_service;
import com.duan.model.bang_danhmuc_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.model.bang_thamgiaduan_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class quanly_danhmuc_controller
 */
@WebServlet(urlPatterns= {"/admin_quanly_danhmuc","/admin_them_danhmuc","/admin_xoa_danhmuc"})
public class quanly_danhmuc_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	  bang_danhmuc_interface_service i_coquan_sv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanly_danhmuc_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
	if(action !=null && action.equals("danhsach_danhmuc"))
	{
	bang_danhmuc_model danhmuc = form_utils.toModel(bang_danhmuc_model.class, request);
	pageble pageble1=new page_request (danhmuc.getPage(),danhmuc.getMaxPageItem(),
			new sorter(danhmuc.getSapxeptheothuoctinh(),danhmuc.getSapxeptheochieu()));
	danhmuc.setDanhsach(i_coquan_sv.laytoanbodanhsach_sv(pageble1));
	danhmuc.setTotalItem(i_coquan_sv.getTotalItem());
	danhmuc.setTotalPage((int)Math.ceil((double) danhmuc.getTotalItem()/danhmuc.getMaxPageItem())+10);
	request.setAttribute(System_Constant.DANHMUC,danhmuc);
	RequestDispatcher rd=request.getRequestDispatcher("/views/admin/danhmuc/danhsach_danhmuc.jsp");
	rd.forward(request, response);
	}
	else if (action != null && action.equals("xoa_danhmuc"))
	{
		danhmuc_DAO danhmuc=new danhmuc_DAO();
		duanDAO duan=new duanDAO();
		  String maDanhMuc = request.getParameter("maDanhMuc");
		   request.setAttribute("maDanhMuc",maDanhMuc);
		   if (!maDanhMuc.isEmpty())
		   {
			   
		      int idMaDanhMuc=Integer.parseInt(maDanhMuc);
		        duan.update_danhmuc_null(idMaDanhMuc);
		        danhmuc.delete1(idMaDanhMuc);
				
				   String message1="Xóa thành công!";
					 request.setAttribute("successMessage_xoathanhcong", message1);
					 RequestDispatcher rd=request.getRequestDispatcher("/admin_quanly_danhmuc?action=danhsach_danhmuc&page=1&maxPageItem=20&sapxeptheothuoctinh=madanhmuc&sapxeptheochieu=asc");
						rd.forward(request, response);
		   }
		  
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		if(action !=null && action.equals("them_danhmuc"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
		String tenDanhMuc=request.getParameter("tenDanhMuc");
		request.setAttribute("tenDanhMuc",tenDanhMuc);
		 danhmuc_DAO danhmuc = new danhmuc_DAO();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Random r=new Random();
			int maDanhMuc=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_danhmuc_model dm = new bang_danhmuc_model(maDanhMuc,tenDanhMuc,ngayTao,manguoidung);
			danhmuc.insert(dm);
			response.sendRedirect(request.getContextPath()+"/admin_them_duan?action=them_duan");
			
	}
		else if(action !=null && action.equals("them_danhmuc_suaduan"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
		String tenDanhMuc=request.getParameter("tenDanhMuc");
		request.setAttribute("tenDanhMuc",tenDanhMuc);
		 danhmuc_DAO danhmuc = new danhmuc_DAO();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Random r=new Random();
			int maDanhMuc=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_danhmuc_model dm = new bang_danhmuc_model(maDanhMuc,tenDanhMuc,ngayTao,manguoidung);
			danhmuc.insert(dm);
			response.sendRedirect(request.getContextPath()+"/admin_sua_duan?action=sua_duan");
			
	}
	}

}
