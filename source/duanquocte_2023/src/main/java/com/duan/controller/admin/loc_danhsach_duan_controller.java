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
import com.duan.interface_of_service.bang_duan_interface_service;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class loc_danhsach_duan_controller
 */
@WebServlet(urlPatterns= {"/admin_loc_duan_theoquynam","/admin_timkiem_duan","/admin_goiy_tukhoa"})
public class loc_danhsach_duan_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	bang_duan_interface_service i_duan_sv; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loc_danhsach_duan_controller() {
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
		if (action != null && action.equals("loc_duan_theoquynam")) {
			/*String thuocQuy=request.getParameter("thuocQuy");
			String thuocNam=request.getParameter("thuocNam");
			request.setAttribute("thuocQuy",thuocQuy);
			request.setAttribute("thuocNam",thuocNam);
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			pageble pageble1 = new page_request(duan.getPage(), duan.getMaxPageItem(),
					new sorter(duan.getSapxeptheothuoctinh(), duan.getSapxeptheochieu()));
			duan.setDanhsach(i_duan_sv.laytoanbodanhsach_theoquyvanam_sv(pageble1,thuocQuy,thuocNam));
			duan.setTotalItem(i_duan_sv.getTotalItem());
			duan.setTotalPage((int) Math.ceil((double) duan.getTotalItem() / duan.getMaxPageItem() + 3));
			request.setAttribute(System_Constant.DUAN, duan);*/
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan_theoboloc.jsp");
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
		if (action != null && action.equals("loc_duan_theoquynam_post")) {
			String thuocQuy=request.getParameter("thuocQuy");
			String thuocNam=request.getParameter("thuocNam");
			request.setAttribute("thuocQuy",thuocQuy);
			request.setAttribute("thuocNam",thuocNam);
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			pageble pageble1 = new page_request(duan.getPage(), duan.getMaxPageItem(),
					new sorter(duan.getSapxeptheothuoctinh(), duan.getSapxeptheochieu()));
			duan.setDanhsach(i_duan_sv.laytoanbodanhsach_theoquyvanam_sv(pageble1,thuocQuy,thuocNam));
			duan.setTotalItem(i_duan_sv.getTotalItem());
			duan.setTotalPage((int) Math.ceil((double) duan.getTotalItem() / duan.getMaxPageItem() + 3));
			request.setAttribute(System_Constant.DUAN, duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan_theoboloc.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("timkiem_duan_post")) {
			String tenDuAn_TiengViet=request.getParameter("tenDuAn_TiengViet");
			request.setAttribute("tenDuAn_TiengViet",tenDuAn_TiengViet);
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			duan.setDanhsach(i_duan_sv.timkiemduan_sv(tenDuAn_TiengViet,tenDuAn_TiengViet));
			request.setAttribute(System_Constant.DUAN, duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan.jsp");
			rd.forward(request, response);
		}
	}

}
