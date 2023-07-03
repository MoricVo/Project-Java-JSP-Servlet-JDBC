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
import com.duan.database.donvitienteDAO;
import com.duan.database.duanDAO;
import com.duan.database.loaivientroDAO;
import com.duan.database.loaivientroDAO;
import com.duan.interface_of_service.bang_loaivientro_interface_service;
import com.duan.model.bang_coquanpheduyet_model;
import com.duan.model.bang_loaivientro_model;
import com.duan.model.bang_loaivientro_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class quanly_loaivientro_controller
 */
@WebServlet(urlPatterns= {"/admin_quanly_loaivientro","/admin_them_loaivientro","/admin_xoa_loaivientro"})
public class quanly_loaivientro_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	  bang_loaivientro_interface_service i_loaivientro_sv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanly_loaivientro_controller() {
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
	if(action !=null && action.equals("danhsach_loaivientro"))
	{
	bang_loaivientro_model loaivientro = form_utils.toModel(bang_loaivientro_model.class, request);
	pageble pageble1=new page_request (loaivientro.getPage(),loaivientro.getMaxPageItem(),
			new sorter(loaivientro.getSapxeptheothuoctinh(),loaivientro.getSapxeptheochieu()));
	loaivientro.setDanhsach(i_loaivientro_sv.laytoanbodanhsach_sv(pageble1));
	loaivientro.setTotalItem(i_loaivientro_sv.getTotalItem());
	loaivientro.setTotalPage((int)Math.ceil((double) loaivientro.getTotalItem()/loaivientro.getMaxPageItem())+10);
	request.setAttribute(System_Constant.LOAIVIENTRO,loaivientro);
	RequestDispatcher rd=request.getRequestDispatcher("/views/admin/loaivientro/danhsach_loaivientro.jsp");
	rd.forward(request, response);
	}
	else if (action != null && action.equals("xoa_loaivientro"))
	{
		loaivientroDAO vientro=new loaivientroDAO();
		duanDAO duan=new duanDAO();
		  String maLoaiVienTro = request.getParameter("maLoaiVienTro");
		   request.setAttribute("maLoaiVienTro",maLoaiVienTro);
		   if (!maLoaiVienTro.isEmpty())
		   {
			   
		      int idVienTro=Integer.parseInt(maLoaiVienTro);
		        duan.update_loaivientro_null(idVienTro);
		        vientro.delete1(idVienTro);
				
				

				 String message1="Xóa thành công!";
				 request.setAttribute("successMessage_xoathanhcong", message1);
				 RequestDispatcher rd=request.getRequestDispatcher("/admin_quanly_loaivientro?action=danhsach_loaivientro&page=1&maxPageItem=20&sapxeptheothuoctinh=maloaivientro&sapxeptheochieu=asc");
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
		if(action !=null && action.equals("them_loaivientro"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
		String tenLoaiVienTro=request.getParameter("tenLoaiVienTro");
		request.setAttribute("tenLoaiVienTro",tenLoaiVienTro);
		 loaivientroDAO loaivientro = new loaivientroDAO();
			Random r=new Random();
			int maLoaiVienTro=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_loaivientro_model dm = new bang_loaivientro_model(maLoaiVienTro,tenLoaiVienTro,ngayTao,manguoidung);
			loaivientro.insert(dm);
			response.sendRedirect(request.getContextPath()+"/admin_them_duan?action=them_duan");
			
		}
		else if(action !=null && action.equals("them_loaivientro_suaduan"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
		String tenLoaiVienTro=request.getParameter("tenLoaiVienTro");
		request.setAttribute("tenLoaiVienTro",tenLoaiVienTro);
		 loaivientroDAO loaivientro = new loaivientroDAO();
			Random r=new Random();
			int maLoaiVienTro=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_loaivientro_model dm = new bang_loaivientro_model(maLoaiVienTro,tenLoaiVienTro,ngayTao,manguoidung);
			loaivientro.insert(dm);
			response.sendRedirect(request.getContextPath()+"/admin_sua_duan?action=sua_duan");
			
		}
	}

}
