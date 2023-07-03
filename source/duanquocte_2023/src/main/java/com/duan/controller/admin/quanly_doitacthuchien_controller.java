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
import com.duan.database.doitacthuchienDAO;
import com.duan.database.duanDAO;
import com.duan.interface_of_dao.implement_dao.bang_doitacthuchien_dao;
import com.duan.interface_of_service.bang_doitacthuchien_interface_service;
import com.duan.model.bang_doitacthuchien_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class quanly_doitacthuchien_controller
 */
@WebServlet(urlPatterns= {"/admin_quanly_doitacthuchien","/admin_them_doitacthuchien","/admin_xoa_doitacthuchien"})
public class quanly_doitacthuchien_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	  bang_doitacthuchien_interface_service i_doitac_sv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanly_doitacthuchien_controller() {
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
	if(action !=null && action.equals("danhsach_doitacthuchien"))
	{
	bang_doitacthuchien_model doitacthuchien = form_utils.toModel(bang_doitacthuchien_model.class, request);
	pageble pageble1=new page_request (doitacthuchien.getPage(),doitacthuchien.getMaxPageItem(),
			new sorter(doitacthuchien.getSapxeptheothuoctinh(),doitacthuchien.getSapxeptheochieu()));
	doitacthuchien.setDanhsach(i_doitac_sv.laytoanbodanhsach_sv(pageble1));
	doitacthuchien.setTotalItem(i_doitac_sv.getTotalItem());
	doitacthuchien.setTotalPage((int)Math.ceil((double) doitacthuchien.getTotalItem()/doitacthuchien.getMaxPageItem())+10);
	request.setAttribute(System_Constant.DOITACTHUCHIEN,doitacthuchien);
	RequestDispatcher rd=request.getRequestDispatcher("/views/admin/doitacthuchien/danhsach_doitacthuchien.jsp");
	rd.forward(request, response);
	}
	else if (action != null && action.equals("xoa_doitacthuchien"))
	{
		doitacthuchienDAO doitac=new doitacthuchienDAO();
		duanDAO duan=new duanDAO();
		  String maDoiTacThucHien = request.getParameter("maDoiTacThucHien");
		   request.setAttribute("maDoiTacThucHien",maDoiTacThucHien);
		   if (!maDoiTacThucHien.isEmpty())
		   {
			   
		      int idMaDoiTac=Integer.parseInt(maDoiTacThucHien);
		        duan.update_doitacthuchien_null(idMaDoiTac);
		        doitac.delete1(idMaDoiTac);
				
				
				   String message1="Xóa thành công!";
					 request.setAttribute("successMessage_xoathanhcong", message1);
					 RequestDispatcher rd=request.getRequestDispatcher("/admin_quanly_doitacthuchien?action=danhsach_doitacthuchien&page=1&maxPageItem=20&sapxeptheothuoctinh=madoitac&sapxeptheochieu=asc");
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
		if(action !=null && action.equals("them_doitacthuchien"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
		String tenDoiTacThucHien=request.getParameter("tenDoiTacThucHien");
		request.setAttribute("tenDoiTacThucHien",tenDoiTacThucHien);
		 doitacthuchienDAO doitacthuchien = new doitacthuchienDAO();
			Random r=new Random();
			int maDoiTacThucHien=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_doitacthuchien_model dm = new bang_doitacthuchien_model(maDoiTacThucHien,tenDoiTacThucHien,ngayTao,manguoidung);
			doitacthuchien.insert(dm);
			response.sendRedirect(request.getContextPath()+"/admin_them_duan?action=them_duan");
			
		}
		else if(action !=null && action.equals("them_doitacthuchien_suaduan"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
		String tenDoiTacThucHien=request.getParameter("tenDoiTacThucHien");
		request.setAttribute("tenDoiTacThucHien",tenDoiTacThucHien);
		 doitacthuchienDAO doitacthuchien = new doitacthuchienDAO();
			Random r=new Random();
			int maDoiTacThucHien=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_doitacthuchien_model dm = new bang_doitacthuchien_model(maDoiTacThucHien,tenDoiTacThucHien,ngayTao,manguoidung);
			doitacthuchien.insert(dm);
			
			
		}
	}

}
