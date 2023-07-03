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
import com.duan.database.doitacthuchienDAO;
import com.duan.database.donvitienteDAO;
import com.duan.database.duanDAO;
import com.duan.interface_of_service.bang_donvitiente_interface_service;
import com.duan.model.bang_donvitiente_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class quanly_donvitiente_controller
 */
@WebServlet(urlPatterns= {"/admin_quanly_donvitiente","/admin_them_donvitiente","/admin_xoa_donvitiente"})
public class quanly_donvitiente_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	  bang_donvitiente_interface_service i_donvitiente_sv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanly_donvitiente_controller() {
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
	if(action !=null && action.equals("danhsach_donvitiente"))
	{
	bang_donvitiente_model donvitiente = form_utils.toModel(bang_donvitiente_model.class, request);
	pageble pageble1=new page_request (donvitiente.getPage(),donvitiente.getMaxPageItem(),
			new sorter(donvitiente.getSapxeptheothuoctinh(),donvitiente.getSapxeptheochieu()));
	donvitiente.setDanhsach(i_donvitiente_sv.laytoanbodanhsach_sv(pageble1));
	donvitiente.setTotalItem(i_donvitiente_sv.getTotalItem());
	donvitiente.setTotalPage((int)Math.ceil((double) donvitiente.getTotalItem()/donvitiente.getMaxPageItem())+10);
	request.setAttribute(System_Constant.DONVITIENTE,donvitiente);
	RequestDispatcher rd=request.getRequestDispatcher("/views/admin/donvitiente/danhsach_donvitiente.jsp");
	rd.forward(request, response);
	}
	else if (action != null && action.equals("xoa_donvitiente"))
	{
		donvitienteDAO tiente=new donvitienteDAO();
		duanDAO duan=new duanDAO();
		  String maDonViTienTe = request.getParameter("maDonViTienTe");
		   request.setAttribute("maDonViTienTe",maDonViTienTe);
		   if (!maDonViTienTe.isEmpty())
		   {
			   
		      int idMaDonViTienTe=Integer.parseInt(maDonViTienTe);
		        duan.update_donvitiente_null(idMaDonViTienTe);
		        tiente.delete1(idMaDonViTienTe);
				

				   String message1="Xóa thành công!";
					 request.setAttribute("successMessage_xoathanhcong", message1);
					 RequestDispatcher rd=request.getRequestDispatcher("/admin_quanly_donvitiente?action=danhsach_donvitiente&page=1&maxPageItem=20&sapxeptheothuoctinh=madonvitiente&sapxeptheochieu=asc");
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
		if(action !=null && action.equals("them_donvitiente"))
		{
		String tenDonViTienTe=request.getParameter("tenDonViTienTe");
		request.setAttribute("tenDonViTienTe",tenDonViTienTe);
		 donvitienteDAO donvitiente = new donvitienteDAO();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Random r=new Random();
			int maDonViTienTe=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_donvitiente_model dm = new bang_donvitiente_model(maDonViTienTe,tenDonViTienTe,ngayTao,ngayTao);
			donvitiente.insert(dm);
			response.sendRedirect(request.getContextPath()+"/admin_them_duan?action=them_duan");
			
	}
		else if(action !=null && action.equals("them_donvitiente_suaduan"))
		{
		String tenDonViTienTe=request.getParameter("tenDonViTienTe");
		request.setAttribute("tenDonViTienTe",tenDonViTienTe);
		 donvitienteDAO donvitiente = new donvitienteDAO();
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Random r=new Random();
			int maDonViTienTe=r.nextInt(10000);
			Timestamp ngayTao;
			Date now = new Date(); // Lấy thời gian hiện tại
			ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
			bang_donvitiente_model dm = new bang_donvitiente_model(maDonViTienTe,tenDonViTienTe,ngayTao,ngayTao);
			donvitiente.insert(dm);
			response.sendRedirect(request.getContextPath()+"/admin_sua_duan?action=sua_duan");
			
	}
	}

}
