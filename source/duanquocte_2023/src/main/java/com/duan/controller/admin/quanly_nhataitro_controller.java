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
import javax.servlet.http.HttpSession;

import com.duan.constant.System_Constant;
import com.duan.database.donvitructhuocDAO;
import com.duan.database.duanDAO;
import com.duan.database.loaivientroDAO;
import com.duan.database.nhataitroDAO;
import com.duan.interface_of_service.bang_nhataitro_interface_service;
import com.duan.interface_of_service.bang_nhataitro_interface_service;
import com.duan.model.bang_donvitructhuoc_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.model.bang_nhataitro_model;
import com.duan.model.bang_nhataitro_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class quanly_nhataitro_controller
 */
@WebServlet(urlPatterns= {"/admin_quanly_nhataitro","/admin_them_nhataitro","/admin_xoa_nhataitro"})
public class quanly_nhataitro_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	  bang_nhataitro_interface_service i_nhataitro_sv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanly_nhataitro_controller() {
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
	if(action !=null && action.equals("danhsach_nhataitro"))
	{
	bang_nhataitro_model nhataitro = form_utils.toModel(bang_nhataitro_model.class, request);
	pageble pageble1=new page_request (nhataitro.getPage(),nhataitro.getMaxPageItem(),
			new sorter(nhataitro.getSapxeptheothuoctinh(),nhataitro.getSapxeptheochieu()));
	nhataitro.setDanhsach(i_nhataitro_sv.laytoanbodanhsach_sv(pageble1));
	nhataitro.setTotalItem(i_nhataitro_sv.getTotalItem());
	nhataitro.setTotalPage((int)Math.ceil((double) nhataitro.getTotalItem()/nhataitro.getMaxPageItem())+10);
	request.setAttribute(System_Constant.NHATAITRO,nhataitro);
	RequestDispatcher rd=request.getRequestDispatcher("/views/admin/nhataitro/danhsach_nhataitro.jsp");
	rd.forward(request, response);
	}
	else if (action != null && action.equals("xoa_nhataitro"))
	{
		nhataitroDAO nhataitro=new nhataitroDAO();
		duanDAO duan=new duanDAO();
		  String maNhaTaiTro = request.getParameter("maNhaTaiTro");
		   request.setAttribute("maNhaTaiTro",maNhaTaiTro);
		   if (!maNhaTaiTro.isEmpty())
		   {
			   
		      int idNhaTaiTro=Integer.parseInt(maNhaTaiTro);
		        duan.update_nhataitro_null(idNhaTaiTro);
		        nhataitro.delete1(idNhaTaiTro);
		      
				
				 String message1="Xóa thành công!";
				 request.setAttribute("successMessage_xoathanhcong", message1);
				 RequestDispatcher rd=request.getRequestDispatcher("/admin_quanly_nhataitro?action=danhsach_nhataitro&page=1&maxPageItem=20&sapxeptheothuoctinh=manhataitro&sapxeptheochieu=asc");
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
		if(action !=null && action.equals("them_nhataitro"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
		String tenNhaTaiTro=request.getParameter("tenNhaTaiTro");
		request.setAttribute("tenNhaTaiTro",tenNhaTaiTro);
		 nhataitroDAO nhataitro = new nhataitroDAO();
			Random r=new Random();
			int maNhaTaiTro=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_nhataitro_model dm = new bang_nhataitro_model(maNhaTaiTro,tenNhaTaiTro,ngayTao,manguoidung);
			nhataitro.insert(dm);
			response.sendRedirect(request.getContextPath()+"/admin_them_duan?action=them_duan");
			
		}
		else if(action !=null && action.equals("them_nhataitro_suaduan"))
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
		String tenNhaTaiTro=request.getParameter("tenNhaTaiTro");
		request.setAttribute("tenNhaTaiTro",tenNhaTaiTro);
		 nhataitroDAO nhataitro = new nhataitroDAO();
			Random r=new Random();
			int maNhaTaiTro=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_nhataitro_model dm = new bang_nhataitro_model(maNhaTaiTro,tenNhaTaiTro,ngayTao,manguoidung);
			nhataitro.insert(dm);
			response.sendRedirect(request.getContextPath()+"/admin_sua_duan?action=sua_duan");
			
		}
	}

}
