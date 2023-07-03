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
import com.duan.interface_of_service.bang_lichsucapnhat_interface_service;
import com.duan.model.bang_duan_dathamgia_model;
import com.duan.model.bang_lichsucapnhat_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class quanly_lichsucapnhat_controller
 */
@WebServlet(urlPatterns= {"/admin_quanly_lichsucapnhat","/admin_timkiem_duan_dacapnhat_post"})
public class quanly_lichsucapnhat_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	  bang_lichsucapnhat_interface_service i_lichsucapnhat_sv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanly_lichsucapnhat_controller() {
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
	if(action !=null && action.equals("danhsach_lichsucapnhat"))
	{
		Object obj = request.getSession().getAttribute("nguoiDung");
		bang_nguoidung_model nguoiDung = null;
		if (obj != null)
			nguoiDung = (bang_nguoidung_model) obj;
		int manguoidung = nguoiDung.getMaNguoiDung();
	bang_lichsucapnhat_model lichsucapnhat = form_utils.toModel(bang_lichsucapnhat_model.class, request);
	pageble pageble1=new page_request (lichsucapnhat.getPage(),lichsucapnhat.getMaxPageItem(),
			new sorter(lichsucapnhat.getSapxeptheothuoctinh(),lichsucapnhat.getSapxeptheochieu()));
	lichsucapnhat.setDanhsach(i_lichsucapnhat_sv.laytoanbodanhsach_sv(pageble1,manguoidung));
	lichsucapnhat.setTotalItem(i_lichsucapnhat_sv.getTotalItem());
	lichsucapnhat.setTotalPage((int)Math.ceil((double) lichsucapnhat.getTotalItem()/lichsucapnhat.getMaxPageItem())+10);
	request.setAttribute(System_Constant.LICHSUCAPNHAT,lichsucapnhat);
	RequestDispatcher rd=request.getRequestDispatcher("/views/admin/lichsucapnhat/danhsach_lichsucapnhat.jsp");
	rd.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action != null && action.equals("timkiem_duan_dacapnhat_post")) {
			String tenDuAn_TiengViet=request.getParameter("tenDuAn_TiengViet");
			request.setAttribute("tenDuAn_TiengViet",tenDuAn_TiengViet);
			bang_lichsucapnhat_model lichsucapnhat = form_utils.toModel(bang_lichsucapnhat_model.class, request);
			lichsucapnhat.setDanhsach(i_lichsucapnhat_sv.timkiemduan_sv(tenDuAn_TiengViet,tenDuAn_TiengViet));
			request.setAttribute(System_Constant.LICHSUCAPNHAT,lichsucapnhat);
			RequestDispatcher rd=request.getRequestDispatcher("/views/admin/lichsucapnhat/danhsach_lichsucapnhat.jsp");
			rd.forward(request, response);
		}
	}

}
