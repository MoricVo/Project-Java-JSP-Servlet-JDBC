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
import com.duan.database.nguoidungDAO;
import com.duan.database.thamgiaduanDAO;
import com.duan.interface_of_service.bang_thamgiaduan_interface_service;
import com.duan.model.bang_chucvu_model;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.model.bang_thamgiaduan_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class quanly_thamgiaduan_controller
 */
@WebServlet(urlPatterns = { "/admin_quanly_thamgiaduan","/admin_quanly_thanhvien_cuatoi","/admin_quanly_duanthamgia_cuatoi","/admin_xoa_thanhvien"})
public class quanly_thamgiaduan_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Inject
	  bang_thamgiaduan_interface_service i_thamgiaduan_sv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanly_thamgiaduan_controller() {
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
		if (action != null && action.equals("them_thanhvien"))
		{
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			if(duan.getMaDuAn()!=0)
			{
				Object obj = request.getSession().getAttribute("nguoiDung");
				bang_nguoidung_model nguoiDung = null;
				if (obj != null)
					nguoiDung = (bang_nguoidung_model) obj;
				int madonvitructhuoc = nguoiDung.getMaDonViTrucThuoc();
			nguoidungDAO nguoidung=new nguoidungDAO();
			request.setAttribute("nguoidungs", nguoidung.selectAll());
			request.setAttribute("nguoidungs_2", nguoidung.selectAll_ByUser(madonvitructhuoc));
			
			request.setAttribute(System_Constant.DUAN, duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/thamgia_duan.jsp");
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			rd.forward(request, response);
			}
			
		}
		else if (action != null && action.equals("danhsach_thanhvien_cuatoi"))
		{
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaNguoiDung();
		bang_thamgiaduan_model thamgiaduan = form_utils.toModel(bang_thamgiaduan_model.class, request);
		pageble pageble1=new page_request (thamgiaduan.getPage(),thamgiaduan.getMaxPageItem(),
				new sorter(thamgiaduan.getSapxeptheothuoctinh(),thamgiaduan.getSapxeptheochieu()));
		thamgiaduan.setDanhsach(i_thamgiaduan_sv.laytoanbodanhsach_theochuduan_sv(pageble1, manguoidung));
		thamgiaduan.setTotalItem(i_thamgiaduan_sv.getTotalItem());
		thamgiaduan.setTotalPage((int)Math.ceil((double) thamgiaduan.getTotalItem()/thamgiaduan.getMaxPageItem()+20));
		request.setAttribute(System_Constant.THAMGIADUAN,thamgiaduan);
		RequestDispatcher rd=request.getRequestDispatcher("/views/admin/duan/danhsach_thanhvien_thamgia_duan_cuatoi.jsp");
		rd.forward(request, response);
		}
		else if (action != null && action.equals("danhsach_duan_dathamgia"))
		{
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaNguoiDung();
		bang_thamgiaduan_model thamgiaduan = form_utils.toModel(bang_thamgiaduan_model.class, request);
		pageble pageble1=new page_request (thamgiaduan.getPage(),thamgiaduan.getMaxPageItem(),
				new sorter(thamgiaduan.getSapxeptheothuoctinh(),thamgiaduan.getSapxeptheochieu()));
		thamgiaduan.setDanhsach(i_thamgiaduan_sv.laytoanbodanhsach_theoduan_sv(pageble1, manguoidung));
		thamgiaduan.setTotalItem(i_thamgiaduan_sv.getTotalItem());
		thamgiaduan.setTotalPage((int)Math.ceil((double) thamgiaduan.getTotalItem()/thamgiaduan.getMaxPageItem()+20));
		request.setAttribute(System_Constant.THAMGIADUAN,thamgiaduan);
		RequestDispatcher rd=request.getRequestDispatcher("/views/admin/duan/danhsach_duan_dathamgia.jsp");
		rd.forward(request, response);
		}
		else if (action != null && action.equals("xoa_thanhvien"))
		{
			thamgiaduanDAO thamgiaduan=new thamgiaduanDAO();
			  String maThamGia = request.getParameter("maThamGia");
			   request.setAttribute("maThamGia",maThamGia);
			   if (!maThamGia.isEmpty())
			   {
				   
			      int idMaThamGia=Integer.parseInt(maThamGia);
			      bang_thamgiaduan_model dm = new bang_thamgiaduan_model(idMaThamGia);
			        thamgiaduan.delete(dm);
			        response.sendRedirect(request.getContextPath()
							+ "/admin_quanly_thanhvien_cuatoi?action=danhsach_thanhvien_cuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=maduan&sapxeptheochieu=desc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
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
		
		String action = request.getParameter("action");
		if (action != null && action.equals("them_thanhvien"))
		{
			thamgiaduanDAO thamgiaduan=new thamgiaduanDAO();
		    String maDuAn = request.getParameter("maDuAn");
		    String tinhTrang=request.getParameter("tinhTrang");
		    String ghiChu=request.getParameter("ghiChu");
		    String maNguoiDung = request.getParameter("maNguoiDung");
		    String baoLoi = "";
		    request.setAttribute("maDuAn",maDuAn);
		    int idDuAn=Integer.parseInt(maDuAn);
		    if (!maNguoiDung.isEmpty()) {
		    	  String[] maNguoiDungArr = maNguoiDung.split(",");
		      for (String nguoidungId : maNguoiDungArr) {
		    	 
		    	  request.setAttribute("tinhTrang",tinhTrang);
		    	  request.setAttribute("ghiChu",ghiChu);
		    	
		    	  int id = Integer.parseInt(nguoidungId.trim());
		        
		        Object obj = request.getSession().getAttribute("nguoiDung");
				bang_nguoidung_model nguoiDung = null;
				if (obj != null)
					nguoiDung = (bang_nguoidung_model) obj;
				int manguoidung = nguoiDung.getMaNguoiDung();
			       if(id==manguoidung)
			       {
			    	   continue;
			       }
			       if (thamgiaduan.kiemTraMaNguoiDungandMaDuAn(id,idDuAn)) {
			    	      continue; // bỏ qua nếu người dùng đã tồn tại
			    	    }
		        else
		        {
		        	Random r=new Random();
					int maThamGia=r.nextInt(90000);
					Timestamp ngayThamGia;
					Date now = new Date(); // Lấy thời gian hiện tại
					ngayThamGia = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
					bang_thamgiaduan_model dm = new bang_thamgiaduan_model(maThamGia,id,idDuAn,ngayThamGia,tinhTrang,ghiChu);
			        thamgiaduan.insert(dm);
			        response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
		        }
		        
		      }
		    }
		    response.sendRedirect(request.getContextPath()
					+ "/admin_quanly_thanhvien_cuatoi?action=danhsach_thanhvien_cuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=maduan&sapxeptheochieu=desc");
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			

		}
		
		
	}

}
