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
import com.duan.database.duan_dabaocaoDAO;
import com.duan.database.loaivientroDAO;
import com.duan.interface_of_service.bang_duan_dabaocao_interface_service;
import com.duan.model.bang_duan_dathamgia_model;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class quanly_duan_dabaocao_controller
 */
@WebServlet(urlPatterns = { "/admin_quanlyduan_dabaocao","/admin_danhsach_duan_dabaocao_theonguoidung","/admin_loc_duandabaocao_theoquynam_post","/admin_loc_duandabaocao_theoquynam_theomanguoidung_post","/admin_timkiem_duandabaocao_theoquynam_post","/admin_xoa_duan_dabaocao"})
public class quanly_duan_dabaocao_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Inject
	  bang_duan_dabaocao_interface_service i_duandabaocao_sv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanly_duan_dabaocao_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action != null && action.equals("danhsach_duan_dabaocao"))
		{
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaNguoiDung();
		bang_duan_dathamgia_model duandabaocao = form_utils.toModel(bang_duan_dathamgia_model.class, request);
		pageble pageble1=new page_request (duandabaocao.getPage(),duandabaocao.getMaxPageItem(),
				new sorter(duandabaocao.getSapxeptheothuoctinh(),duandabaocao.getSapxeptheochieu()));
		duandabaocao.setDanhsach(i_duandabaocao_sv.laytoanbodanhsach_sv(pageble1));
		duandabaocao.setTotalItem(i_duandabaocao_sv.getTotalItem());
		duandabaocao.setTotalPage((int)Math.ceil((double) duandabaocao.getTotalItem()/duandabaocao.getMaxPageItem()+20));
		request.setAttribute(System_Constant.DUANDABAOCAO,duandabaocao);
		RequestDispatcher rd=request.getRequestDispatcher("/views/admin/duan/danhsach_duan_dabaocao.jsp");
		rd.forward(request, response);
		}
		else if (action != null && action.equals("danhsach_duan_dabaocao_theonguoidung"))
		{
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaNguoiDung();
		bang_duan_dathamgia_model duandabaocao = form_utils.toModel(bang_duan_dathamgia_model.class, request);
		pageble pageble1=new page_request (duandabaocao.getPage(),duandabaocao.getMaxPageItem(),
				new sorter(duandabaocao.getSapxeptheothuoctinh(),duandabaocao.getSapxeptheochieu()));
		duandabaocao.setDanhsach(i_duandabaocao_sv.laytoanbodanhsach_theomanguoidung_sv(pageble1, manguoidung));
		duandabaocao.setTotalItem(i_duandabaocao_sv.getTotalItem());
		duandabaocao.setTotalPage((int)Math.ceil((double) duandabaocao.getTotalItem()/duandabaocao.getMaxPageItem()+20));
		request.setAttribute(System_Constant.DUANDABAOCAO,duandabaocao);
		RequestDispatcher rd=request.getRequestDispatcher("/views/admin/duan/danhsach_duan_dabaocao_theonguoidung.jsp");
		rd.forward(request, response);
		}
		else if (action != null && action.equals("xoa_duan_dabaocao"))
		{
			duan_dabaocaoDAO duanold=new duan_dabaocaoDAO();
			
			  String maDuAn_DaThamGia = request.getParameter("maDuAn_DaThamGia");
			   request.setAttribute("maDuAn_DaThamGia",maDuAn_DaThamGia);
			   if (!maDuAn_DaThamGia.isEmpty())
			   {
				   
			      int idDATG=Integer.parseInt(maDuAn_DaThamGia);
			      
			        duanold.delete1(idDATG);
					
					

					 String message1="Xóa thành công!";
					 request.setAttribute("successMessage_xoathanhcong", message1);
					 RequestDispatcher rd=request.getRequestDispatcher("/admin_quanlyduan_dabaocao?action=danhsach_duan_dabaocao&page=1&maxPageItem=40&sapxeptheothuoctinh=thuocnam&sapxeptheochieu=desc");
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
		String action = request.getParameter("action");
		if (action != null && action.equals("loc_duandabaocao_theoquynam_post")) {
			String thuocQuy=request.getParameter("thuocQuy");
			String thuocNam=request.getParameter("thuocNam");
			request.setAttribute("thuocQuy",thuocQuy);
			request.setAttribute("thuocNam",thuocNam);
			bang_duan_dathamgia_model duandabaocao = form_utils.toModel(bang_duan_dathamgia_model.class, request);
			duandabaocao.setDanhsach(i_duandabaocao_sv.laytoanbodanhsach_theoquyvanam_sv(thuocQuy,thuocNam));
			request.setAttribute(System_Constant.DUANDABAOCAO,duandabaocao);
			RequestDispatcher rd=request.getRequestDispatcher("/views/admin/duan/danhsach_duan_dabaocao.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("loc_duandabaocao_theoquynam_theomanguoidung_post")) {
			String thuocQuy=request.getParameter("thuocQuy");
			String thuocNam=request.getParameter("thuocNam");
			request.setAttribute("thuocQuy",thuocQuy);
			request.setAttribute("thuocNam",thuocNam);
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaNguoiDung();
			bang_duan_dathamgia_model duandabaocao = form_utils.toModel(bang_duan_dathamgia_model.class, request);
			duandabaocao.setDanhsach(i_duandabaocao_sv.laytoanbodanhsach_theoquyvanam_theomanguoidung_sv(thuocQuy, thuocNam, manguoidung));
			request.setAttribute(System_Constant.DUANDABAOCAO,duandabaocao);
			RequestDispatcher rd=request.getRequestDispatcher("/views/admin/duan/danhsach_duan_dabaocao_theonguoidung.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("timkiem_duandabaocao_theoquynam_post")) {
			String tenDuAn_TiengViet=request.getParameter("tenDuAn_TiengViet");
			request.setAttribute("tenDuAn_TiengViet",tenDuAn_TiengViet);
			bang_duan_dathamgia_model duandabaocao = form_utils.toModel(bang_duan_dathamgia_model.class, request);
			duandabaocao.setDanhsach(i_duandabaocao_sv.timkiemduan_sv(tenDuAn_TiengViet,tenDuAn_TiengViet));
			request.setAttribute(System_Constant.DUANDABAOCAO,duandabaocao);
			RequestDispatcher rd=request.getRequestDispatcher("/views/admin/duan/danhsach_duan_dabaocao.jsp");
			rd.forward(request, response);
		}
	}

}
