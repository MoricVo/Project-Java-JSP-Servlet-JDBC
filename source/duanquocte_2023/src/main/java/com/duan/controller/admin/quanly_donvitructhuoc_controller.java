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
import com.duan.database.donvitienteDAO;
import com.duan.database.donvitructhuocDAO;
import com.duan.database.duanDAO;
import com.duan.database.nguoidungDAO;
import com.duan.interface_of_service.bang_donvitructhuoc_interface_service;
import com.duan.model.bang_donvitructhuoc_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class quanly_donvitructhuoc_controller
 */
@WebServlet(urlPatterns= {"/admin_quanly_donvitructhuoc","/admin_xoa_donvitructhuoc","/dang-ky_them_donvitructhuoc"})
public class quanly_donvitructhuoc_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	  bang_donvitructhuoc_interface_service i_donvitructhuoc_sv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanly_donvitructhuoc_controller() {
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
	if(action !=null && action.equals("danhsach_donvitructhuoc"))
	{
	bang_donvitructhuoc_model donvitructhuoc = form_utils.toModel(bang_donvitructhuoc_model.class, request);
	pageble pageble1=new page_request (donvitructhuoc.getPage(),donvitructhuoc.getMaxPageItem(),
			new sorter(donvitructhuoc.getSapxeptheothuoctinh(),donvitructhuoc.getSapxeptheochieu()));
	donvitructhuoc.setDanhsach(i_donvitructhuoc_sv.laytoanbodanhsach_sv(pageble1));
	donvitructhuoc.setTotalItem(i_donvitructhuoc_sv.getTotalItem());
	donvitructhuoc.setTotalPage((int)Math.ceil((double) donvitructhuoc.getTotalItem()/donvitructhuoc.getMaxPageItem())+10);
	request.setAttribute(System_Constant.DONVITRUCTHUOC,donvitructhuoc);
	RequestDispatcher rd=request.getRequestDispatcher("/views/admin/donvitructhuoc/danhsach_donvitructhuoc.jsp");
	rd.forward(request, response);
	}
	else if (action != null && action.equals("xoa_donvitructhuoc"))
	{
		donvitructhuocDAO donvitructhuoc=new donvitructhuocDAO();
		duanDAO duan=new duanDAO();
		nguoidungDAO nguoidung=new nguoidungDAO();
		  String maDonViTrucThuoc = request.getParameter("maDonViTrucThuoc");
		   request.setAttribute("maDonViTrucThuoc",maDonViTrucThuoc);
		   if (!maDonViTrucThuoc.isEmpty())
		   {
			   
		      int idMaDonViTrucThuoc=Integer.parseInt(maDonViTrucThuoc);
		        duan.update_donvitructhuoc_null(idMaDonViTrucThuoc);
		        nguoidung.update_donvitructhuoc_null(idMaDonViTrucThuoc);
		        donvitructhuoc.delete1(idMaDonViTrucThuoc);
		
				
				
				 String message1="Xóa thành công!";
				 request.setAttribute("successMessage_xoathanhcong", message1);
				 RequestDispatcher rd=request.getRequestDispatcher("/admin_quanly_donvitructhuoc?action=danhsach_donvitructhuoc&page=1&maxPageItem=20&sapxeptheothuoctinh=madonvitructhuoc&sapxeptheochieu=asc");
					rd.forward(request, response);
		   }
		  
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		if(action !=null && action.equals("them_donvitructhuoc"))
		{
		String tenDonViTrucThuoc=request.getParameter("tenDonViTrucThuoc");
		request.setAttribute("tenDonViTrucThuoc",tenDonViTrucThuoc);
		 donvitructhuocDAO donvitructhuoc = new donvitructhuocDAO();
			Random r=new Random();
			int maDonViTrucThuoc=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_donvitructhuoc_model dm = new bang_donvitructhuoc_model(maDonViTrucThuoc,tenDonViTrucThuoc,ngayTao,ngayTao);
			donvitructhuoc.insert(dm);
			response.sendRedirect(request.getContextPath()+"/dang-ky?action=dangky_taikhoan");
		}
		else if(action !=null && action.equals("them_donvitructhuoc_trangquantri"))
		{
		String tenDonViTrucThuoc=request.getParameter("tenDonViTrucThuoc");
		request.setAttribute("tenDonViTrucThuoc",tenDonViTrucThuoc);
		 donvitructhuocDAO donvitructhuoc = new donvitructhuocDAO();
			Random r=new Random();
			int maDonViTrucThuoc=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_donvitructhuoc_model dm = new bang_donvitructhuoc_model(maDonViTrucThuoc,tenDonViTrucThuoc,ngayTao,ngayTao);
			donvitructhuoc.insert(dm);
			response.sendRedirect(request.getContextPath()+"/dang-ky-taikhoan-quantri?action=dangky_taikhoan_quantri");
		}
	}

}
