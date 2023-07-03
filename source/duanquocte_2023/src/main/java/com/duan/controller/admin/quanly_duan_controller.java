package com.duan.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.constant.System_Constant;
import com.duan.database.coquanpheduyetDAO;
import com.duan.database.danhmuc_DAO;
import com.duan.database.doitacthuchienDAO;
import com.duan.database.donvitienteDAO;
import com.duan.database.donvitructhuocDAO;
import com.duan.database.duanDAO;
import com.duan.database.duan_dabaocaoDAO;
import com.duan.database.file_dinhkemDAO;
import com.duan.database.lichsucapnhatDAO;
import com.duan.database.loaivientroDAO;
import com.duan.database.nhataitroDAO;
import com.duan.interface_of_service.bang_duan_interface_service;
import com.duan.interface_of_service.bang_nguoidung_interface_service;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_lichsucapnhat_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.page_request;
import com.duan.paging.pageble;
import com.duan.sort.sorter;
import com.duan.utils.form_utils;

@MultipartConfig()
@WebServlet(urlPatterns = { "/admin_quanly_duan", "/admin_quanlyduan_ketthuc","/admin_them_duan", 
		"/admin_quanly_duan_cuatoi", "/admin_sua_duan", "/admin_chitiet_duan", 
		"/admin_laytoanbodanhsach_duan_dangtrienkhai","/admin_capnhat_trangthai_them",
		"/admin_laytoanboduan_theokhoa",
		"/admin_laytoanboduan_theokhoa_dangtrienkhai","/admin_capnhat_trangthai_ketthuc","/admin_loc_duan_theodonvitructhuoc","/admin_loc_duan_theotrangthai"})
public class quanly_duan_controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	bang_duan_interface_service i_duan_sv;
	bang_nguoidung_interface_service i_nguoidung_sv;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action != null && action.equals("danhsach_duan")) {
			donvitructhuocDAO donvitructhuoc = new donvitructhuocDAO();
			request.setAttribute("donvitructhuocs", donvitructhuoc.selectAll());
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			pageble pageble1 = new page_request(duan.getPage(), duan.getMaxPageItem(),
					new sorter(duan.getSapxeptheothuoctinh(), duan.getSapxeptheochieu()));
			duan.setDanhsach(i_duan_sv.laytoanbodanhsach_sv(pageble1));
			duan.setTotalItem(i_duan_sv.getTotalItem());
			duan.setTotalPage((int) Math.ceil((double) duan.getTotalItem() / duan.getMaxPageItem() + 20));
			request.setAttribute(System_Constant.DUAN, duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("danhsach_duan_cuatoi")) {
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaNguoiDung();
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			pageble pageble1 = new page_request(duan.getPage(), duan.getMaxPageItem(),
					new sorter(duan.getSapxeptheothuoctinh(), duan.getSapxeptheochieu()));
			duan.setDanhsach(i_duan_sv.laytoanbodanhsach_theomanguoidung_sv(pageble1, manguoidung));
			duan.setTotalItem(i_duan_sv.getTotalItem());
			duan.setTotalPage((int) Math.ceil((double) duan.getTotalItem() / duan.getMaxPageItem() + 20));
			request.setAttribute(System_Constant.DUAN, duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan_cuatoi.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("danhsach_duan_ketthuc")) {
			
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			pageble pageble1 = new page_request(duan.getPage(), duan.getMaxPageItem(),
					new sorter(duan.getSapxeptheothuoctinh(), duan.getSapxeptheochieu()));
			duan.setDanhsach(i_duan_sv.laytoanbodanhsach_ketthuc_sv(pageble1));
			duan.setTotalItem(i_duan_sv.getTotalItem());
			duan.setTotalPage((int) Math.ceil((double) duan.getTotalItem() / duan.getMaxPageItem() + 20));
			request.setAttribute(System_Constant.DUAN, duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan_ketthuc.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("danhsach_duan_cuakhoa")) {
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int madonvitructhuoc = nguoiDung.getMaDonViTrucThuoc();
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			pageble pageble1 = new page_request(duan.getPage(), duan.getMaxPageItem(),
					new sorter(duan.getSapxeptheothuoctinh(), duan.getSapxeptheochieu()));
			duan.setDanhsach(i_duan_sv.laytoanbodanhsach_theokhoa_sv(pageble1, madonvitructhuoc));
			duan.setTotalItem(i_duan_sv.getTotalItem());
			duan.setTotalPage((int) Math.ceil((double) duan.getTotalItem() / duan.getMaxPageItem() + 20));
			request.setAttribute(System_Constant.DUAN, duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan_cuakhoa.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("danhsach_duan_dangtrienkhai_cuakhoa")) {
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int madonvitructhuoc = nguoiDung.getMaDonViTrucThuoc();
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			
			duan.setDanhsach(i_duan_sv.laytoanbodanhsach_dangtrienkhai_theokhoa_sv( madonvitructhuoc));
			request.setAttribute(System_Constant.DUAN, duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan_dangtrienkhai_khoa.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("danhsach_duan_dangtrienkhai")) {
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			donvitructhuocDAO donvitructhuocs =new donvitructhuocDAO();

			duan.setDanhsach(i_duan_sv.laytoanbodanhsach_dangtrienkhai_sv());
			
			request.setAttribute("donvitructhuocs",donvitructhuocs.selectAll());
			request.setAttribute(System_Constant.DUAN, duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan_dangtrienkhai.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("them_duan")) {
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int manguoidung = nguoiDung.getMaDonViTrucThuoc();
			danhmuc_DAO danhmuc = new danhmuc_DAO();
			donvitructhuocDAO donvitructhuoc = new donvitructhuocDAO();
			nhataitroDAO nhataitro = new nhataitroDAO();
			loaivientroDAO loaivientro = new loaivientroDAO();
			coquanpheduyetDAO coquanpheduyet = new coquanpheduyetDAO();
			doitacthuchienDAO doitacthuchien = new doitacthuchienDAO();
			donvitienteDAO donvitiente=new donvitienteDAO();
			request.setAttribute("donvitientes", donvitiente.selectAll());
			request.setAttribute("doitacthuchiens", doitacthuchien.selectAll(manguoidung));
			request.setAttribute("coquanpheduyets", coquanpheduyet.selectAll(manguoidung));
			request.setAttribute("loaivientros", loaivientro.selectAll(manguoidung));
			request.setAttribute("nhataitros", nhataitro.selectAll(manguoidung));
			request.setAttribute("donvitructhuocs", donvitructhuoc.selectAll());
			request.setAttribute("danhmucs", danhmuc.selectAll(manguoidung));
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/add.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("sua_duan")) {
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			if(duan.getMaDuAn()!=0)
			{
				Object obj = request.getSession().getAttribute("nguoiDung");
				bang_nguoidung_model nguoiDung = null;
				if (obj != null)
					nguoiDung = (bang_nguoidung_model) obj;
				int manguoidung = nguoiDung.getMaDonViTrucThuoc();
				danhmuc_DAO danhmuc = new danhmuc_DAO();
				donvitructhuocDAO donvitructhuoc = new donvitructhuocDAO();
				nhataitroDAO nhataitro = new nhataitroDAO();
				loaivientroDAO loaivientro = new loaivientroDAO();
				coquanpheduyetDAO coquanpheduyet = new coquanpheduyetDAO();
				doitacthuchienDAO doitacthuchien = new doitacthuchienDAO();
				donvitienteDAO donvitiente=new donvitienteDAO();
				request.setAttribute("doitacthuchiens", doitacthuchien.selectAll(manguoidung));
				request.setAttribute("coquanpheduyets", coquanpheduyet.selectAll(manguoidung));
				request.setAttribute("loaivientros", loaivientro.selectAll(manguoidung));
				request.setAttribute("nhataitros", nhataitro.selectAll(manguoidung));
				request.setAttribute("donvitructhuocs", donvitructhuoc.selectAll());
				request.setAttribute("danhmucs", danhmuc.selectAll(manguoidung));
				request.setAttribute("donvitientes", donvitiente.selectAll());
				duan=i_duan_sv.laymotduan_sv(duan.getMaDuAn());
			
				request.setAttribute(System_Constant.DUAN, duan);
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/edit.jsp");
				rd.forward(request, response);
			}
			
			
			
		}
		else if (action != null && action.equals("chitiet_duan")) {
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
	        file_dinhkemDAO file=new file_dinhkemDAO();
			if(duan.getMaDuAn()!=0 )
			{
				duan=i_duan_sv.laymotduan_sv(duan.getMaDuAn());
				request.setAttribute("files",file.Layfiletheoma(duan.getMaDuAn()));
				request.setAttribute(System_Constant.DUAN, duan);
				
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/detail.jsp");
			rd.forward(request, response);
			}
		}
		else if (action != null && action.equals("capnhat_trangthai_them2"))
		{
			duanDAO duan=new duanDAO();
			  String maDuAn = request.getParameter("maDuAn");
			   request.setAttribute("maDuAn",maDuAn);
			 
			   if (!maDuAn.isEmpty())
			   {
				   
			      int idMaDuAn=Integer.parseInt(maDuAn);
			      bang_duan_model dm = new bang_duan_model(idMaDuAn);
			        duan.update_trangthai_2(dm);

					response.sendRedirect(request.getContextPath()
							+ "/admin_quanly_duan?action=danhsach_duan_cuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("utf-8");
			   }
			  
		}
		else if (action != null && action.equals("capnhat_trangthai_them0"))
		{
			duanDAO duan=new duanDAO();
			  String maDuAn = request.getParameter("maDuAn");
			   request.setAttribute("maDuAn",maDuAn);
			 
			   if (!maDuAn.isEmpty())
			   {
				   
			      int idMaDuAn=Integer.parseInt(maDuAn);
			      bang_duan_model dm = new bang_duan_model(idMaDuAn);
			        duan.update_trangthai_0(dm);
			        response.sendRedirect(request.getContextPath()
							+ "/admin_laytoanbodanhsach_duan_dangtrienkhai?action=danhsach_duan_dangtrienkhai&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
			   }
			  
		}
		else if (action != null && action.equals("capnhat_trangthai_ketthuc"))
		{
			duanDAO duan=new duanDAO();
			file_dinhkemDAO dinhkem=new file_dinhkemDAO();
			  String maDuAn = request.getParameter("maDuAn");
			   request.setAttribute("maDuAn",maDuAn);
			 
			   if (!maDuAn.isEmpty())
			   {
				   int idMaDuAn=Integer.parseInt(maDuAn);
				   if(dinhkem.kiemTraFileKetThuc(idMaDuAn))
				   {
			     
			      bang_duan_model dm = new bang_duan_model(idMaDuAn);
			        duan.update_trangthai_ketthuc(dm);
			        response.sendRedirect(request.getContextPath()
							+ "/admin_quanly_duan?action=danhsach_duan_cuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("utf-8");
				   }
				   else
				   {
						String message1="Bạn cần upload file minh chứng đã kết thúc dự án trước khi kết thúc dự án!";
						 request.setAttribute("dangerMessage_chuauploadfileketthuc", message1);
					   RequestDispatcher rd = request.getRequestDispatcher("/admin_quanly_duan?action=danhsach_duan_cuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
						rd.forward(request, response);
				   }
			   }
			  
		}
		else if (action != null && action.equals("capnhat_trangthai_them0_khoa"))
		{
			duanDAO duan=new duanDAO();
			  String maDuAn = request.getParameter("maDuAn");
			   request.setAttribute("maDuAn",maDuAn);
			 
			   if (!maDuAn.isEmpty())
			   {
				   
			      int idMaDuAn=Integer.parseInt(maDuAn);
			      bang_duan_model dm = new bang_duan_model(idMaDuAn);
			        duan.update_trangthai_0(dm);
			        response.sendRedirect(request.getContextPath()
							+ "/admin_laytoanboduan_theokhoa_dangtrienkhai?action=danhsach_duan_dangtrienkhai_cuakhoa&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
			   }
			  
		}
		
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action != null && action.equals("them_duan")) {
			duanDAO duan = new duanDAO();
		/*	String maDonViTrucThuoc = request.getParameter("maDonViTrucThuoc");*/
			String maDanhMuc = request.getParameter("maDanhMuc");
			String maNhaTaiTro = request.getParameter("maNhaTaiTro");

			
		/*	Collection<Part> parts = request.getParts();*/
			
			String maLoaiVienTro = request.getParameter("maLoaiVienTro");
			String maCoQuanPheDuyet = request.getParameter("maCoQuanPheDuyet");
			String maDoiTacThucHien = request.getParameter("maDoiTacThucHien");
			String tenDuAn_TiengViet = request.getParameter("tenDuAn_TiengViet");
			String tenDuAn_TiengAnh = request.getParameter("tenDuAn_TiengAnh");
			String thanhVienThamGia=request.getParameter("thanhVienThamGia");
			String mucTieuDuAn=request.getParameter("mucTieuDuAn");
			String noiDungThucHien=request.getParameter("noiDungThucHien");
			String thietBiTaiTro=request.getParameter("thietBiTaiTro");
			String kinhPhiDuAnNamTruoc = request.getParameter("kinhPhiDuAnNamTruoc");
			String tongVonThucHien = request.getParameter("tongVonThucHien");
			String vonTaiTro = request.getParameter("vonTaiTro");
			String vonVay = request.getParameter("vonVay");
			String vonKhac = request.getParameter("vonKhac");
			String vonDoiUng = request.getParameter("vonDoiUng");
			 String maDonViTienTe=request.getParameter("maDonViTienTe");
			String thoiGianThucHien = request.getParameter("thoiGianThucHien");
			String thoiGianBatDau = request.getParameter("thoiGianBatDau");
			String thoiGianKetThuc = request.getParameter("thoiGianKetThuc");
			String tienDoThucHien = request.getParameter("tienDoThucHien");
			String phanTramTienDoThucHien = request.getParameter("phanTramTienDoThucHien");
			String donViTienTe_VonTaiTro=request.getParameter("donViTienTe_VonTaiTro");
			String donViTienTe_VonVay=request.getParameter("donViTienTe_VonVay");
			String donViTienTe_VonKhac=request.getParameter("donViTienTe_VonKhac");
			String donViTienTe_VonDoiUng=request.getParameter("donViTienTe_VonDoiUng");
			String donViTienTe_TongVonThucHien=request.getParameter("donViTienTe_TongVonThucHien");
			
			try {
				/*int ImaDonViTrucThuoc = Integer.parseInt(maDonViTrucThuoc);*/
				int ImaDanhMuc = Integer.parseInt(maDanhMuc);
				int ImaNhaTaiTro = Integer.parseInt(maNhaTaiTro);
				int ImaLoaiVienTro = Integer.parseInt(maLoaiVienTro);
				int ImaCoQuanPheDuyet = Integer.parseInt(maCoQuanPheDuyet);
				int ImaDoiTacThucHien = Integer.parseInt(maDoiTacThucHien);
				float ItongVonThucHien = Float.parseFloat(tongVonThucHien);
				float IvonTaiTro = Float.parseFloat(vonTaiTro);
				float IvonVay = Float.parseFloat(vonVay);
				float IvonKhac = Float.parseFloat(vonKhac);
				float IvonDoiDung = Float.parseFloat(vonDoiUng);
				 int ImaDonViTienTe=Integer.parseInt(maDonViTienTe);
				 Timestamp Tthoigianbatdau = null;
				 Timestamp Tthoigianketthuc = null;

				 try {
				     if (thoiGianBatDau != null && !thoiGianBatDau.isEmpty()) {
				         String thoiGianBatDauFormatted = thoiGianBatDau.replace("T", " ") + ":00";
				        
				         Tthoigianbatdau = Timestamp.valueOf(thoiGianBatDauFormatted);
				     }
				     
				     if (thoiGianKetThuc != null && !thoiGianKetThuc.isEmpty()) {
				         String thoiGianKetThucFormatted = thoiGianKetThuc.replace("T", " ") + ":00";

				         Tthoigianketthuc = Timestamp.valueOf(thoiGianKetThucFormatted);
				     }
				 } catch (IllegalArgumentException e) {
				     System.out.println("Loi: " + e.getMessage());
				 }
				 
			/*	request.setAttribute("maDonViTrucThuoc", ImaDonViTrucThuoc);*/
				request.setAttribute("maDanhMuc", ImaDanhMuc);
				request.setAttribute("maNhaTaiTro", ImaNhaTaiTro);
				request.setAttribute("maLoaiVienTro", ImaLoaiVienTro);
				request.setAttribute("maCoQuanPheDuyet", ImaCoQuanPheDuyet);
				request.setAttribute("maDoiTacThucHien", ImaDoiTacThucHien);
				request.setAttribute("tenDuAn_TiengViet", tenDuAn_TiengViet);
				request.setAttribute("tenDuAn_TiengAnh", tenDuAn_TiengAnh);
				request.setAttribute("thanhVienThamGia",thanhVienThamGia);
				request.setAttribute("mucTieuDuAn",mucTieuDuAn);
				request.setAttribute("noiDungThucHien",noiDungThucHien);
				request.setAttribute("thietBiTaiTro",thietBiTaiTro);
				
				
				
				request.setAttribute("kinhPhiDuAnNamTruoc", kinhPhiDuAnNamTruoc);
				request.setAttribute("tongVonThucHien", ItongVonThucHien);
				request.setAttribute("vonTaiTro", IvonTaiTro);
				request.setAttribute("vonVay", IvonVay);
				request.setAttribute("vonKhac", IvonKhac);
				request.setAttribute("vonDoiUng", IvonDoiDung);
				request.setAttribute("maDonViTienTe",ImaDonViTienTe);
				request.setAttribute("thoiGianThucHien", thoiGianThucHien);
				request.setAttribute("tienDoThucHien", tienDoThucHien);
				request.setAttribute("phanTramTienDo", phanTramTienDoThucHien);
				Object obj = request.getSession().getAttribute("nguoiDung");
				bang_nguoidung_model nguoiDung = null;
				if (obj != null)
					nguoiDung = (bang_nguoidung_model) obj;
				Random r = new Random();
				int maDuAn =r.nextInt(90000);
				int maNguoiDung = nguoiDung.getMaNguoiDung();
				int maDonViTrucThuoc = nguoiDung.getMaDonViTrucThuoc();
				Timestamp ngayTao;
				Date now = new Date(); // Lấy thời gian hiện tại
				ngayTao = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
				
				if(duan.kiemTraMaDuAnTonTai(maDuAn)==false)
				{
				bang_duan_model cq = new bang_duan_model(maDuAn, maNguoiDung, maDonViTrucThuoc, ImaDanhMuc,
						ImaNhaTaiTro, ImaLoaiVienTro, ImaCoQuanPheDuyet, ImaDoiTacThucHien,
						tenDuAn_TiengViet, tenDuAn_TiengAnh,thanhVienThamGia,mucTieuDuAn,noiDungThucHien,thietBiTaiTro, kinhPhiDuAnNamTruoc, ItongVonThucHien, IvonTaiTro,
						IvonVay, IvonKhac, IvonDoiDung,ImaDonViTienTe, thoiGianThucHien,Tthoigianbatdau,Tthoigianketthuc, tienDoThucHien,
						phanTramTienDoThucHien, ngayTao,donViTienTe_VonTaiTro,donViTienTe_VonVay,donViTienTe_VonKhac,donViTienTe_VonDoiUng,donViTienTe_TongVonThucHien);
				duan.insert(cq);
				response.sendRedirect(request.getContextPath()
						+ "/admin_quanly_duan?action=danhsach_duancuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("utf-8");
				}
				else
				{
					int maDuAn2 =r.nextInt(90000);
					bang_duan_model cq = new bang_duan_model(maDuAn2, maNguoiDung, maDonViTrucThuoc, ImaDanhMuc,
							ImaNhaTaiTro, ImaLoaiVienTro, ImaCoQuanPheDuyet, ImaDoiTacThucHien,
							tenDuAn_TiengViet, tenDuAn_TiengAnh,thanhVienThamGia,mucTieuDuAn,noiDungThucHien,thietBiTaiTro, kinhPhiDuAnNamTruoc, ItongVonThucHien, IvonTaiTro,
							IvonVay, IvonKhac, IvonDoiDung,ImaDonViTienTe, thoiGianThucHien,Tthoigianbatdau,Tthoigianketthuc, tienDoThucHien,
							phanTramTienDoThucHien, ngayTao,donViTienTe_VonTaiTro,donViTienTe_VonVay,donViTienTe_VonKhac,donViTienTe_VonDoiUng,donViTienTe_TongVonThucHien);
					duan.insert(cq);
					response.sendRedirect(request.getContextPath()
							+ "/admin_quanly_duan?action=danhsach_duancuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("utf-8");
					
				}
			} catch (NumberFormatException e) {

				System.out.println("Không thể chuyển đổi " + maDanhMuc + " sang kiểu số nguyên");
			}

		}
		else if(action != null && action.equals("sua_duan"))
		{
			  duanDAO duan=new duanDAO();
			  lichsucapnhatDAO lichsucapnhat=new lichsucapnhatDAO();
			  String maDuAn=request.getParameter("maDuAn");
			  String maNguoiDung=request.getParameter("maNguoiDung");
			  String maDonViTrucThuoc=request.getParameter("maDonViTrucThuoc");
			  String maDanhMuc=request.getParameter("maDanhMuc");
			  String maNhaTaiTro=request.getParameter("maNhaTaiTro");
			  String maLoaiVienTro=request.getParameter("maLoaiVienTro");
			  String maCoQuanPheDuyet=request.getParameter("maCoQuanPheDuyet");
			  String maDoiTacThucHien=request.getParameter("maDoiTacThucHien");
			  String tenDuAn_TiengViet=request.getParameter("tenDuAn_TiengViet");
			  String tenDuAn_TiengAnh=request.getParameter("tenDuAn_TiengAnh");
			  
			  String thanhVienThamGia=request.getParameter("thanhVienThamGia");
				String mucTieuDuAn=request.getParameter("mucTieuDuAn");
				String noiDungThucHien=request.getParameter("noiDungThucHien");
				String thietBiTaiTro=request.getParameter("thietBiTaiTro");
			  
			  String kinhPhiDuAnNamTruoc=request.getParameter("kinhPhiDuAnNamTruoc");
			  String tongVonThucHien=request.getParameter("tongVonThucHien");
			  String vonTaiTro=request.getParameter("vonTaiTro");
			  String vonVay=request.getParameter("vonVay");
			  String vonKhac=request.getParameter("vonKhac");
			  String vonDoiUng=request.getParameter("vonDoiUng");
			  String maDonViTienTe=request.getParameter("maDonViTienTe");
			  String thoiGianThucHien=request.getParameter("thoiGianThucHien");
			  String thoiGianBatDau = request.getParameter("thoiGianBatDau");
			  String thoiGianKetThuc = request.getParameter("thoiGianKetThuc");
			 
			  String tienDoThucHien=request.getParameter("tienDoThucHien");
			  String phanTramTienDoThucHien=request.getParameter("phanTramTienDoThucHien");
			  
			  String donViTienTe_VonTaiTro=request.getParameter("donViTienTe_VonTaiTro");
			  String donViTienTe_VonVay=request.getParameter("donViTienTe_VonVay");
			  String donViTienTe_VonKhac=request.getParameter("donViTienTe_VonKhac");
			  String donViTienTe_VonDoiUng=request.getParameter("donViTienTe_VonDoiUng");
			  String donViTienTe_TongVonThucHien=request.getParameter("donViTienTe_TongVonThucHien");
			
			  
			/*  Collection<Part> parts = request.getParts();*/
			 try
			 {
				 int ImaDuAn=Integer.parseInt(maDuAn);
				 int ImaNguoiDung=Integer.parseInt(maNguoiDung);
				 int ImaDonViTrucThuoc=Integer.parseInt(maDonViTrucThuoc);
				 int ImaDanhMuc=Integer.parseInt(maDanhMuc);
				 int ImaNhaTaiTro=Integer.parseInt(maNhaTaiTro);
				 int ImaLoaiVienTro=Integer.parseInt(maLoaiVienTro);
				 int ImaCoQuanPheDuyet=Integer.parseInt(maCoQuanPheDuyet);
				 int ImaDoiTacThucHien=Integer.parseInt(maDoiTacThucHien);
				 float ItongVonThucHien=Float.parseFloat(tongVonThucHien);
				 float IvonTaiTro=Float.parseFloat(vonTaiTro);
				 float IvonVay=Float.parseFloat(vonVay);
				 float IvonKhac=Float.parseFloat(vonKhac);
				 float IvonDoiDung=Float.parseFloat(vonDoiUng);
				 int ImaDonViTienTe=Integer.parseInt(maDonViTienTe);
				 request.setAttribute("maDuAn",ImaDuAn);
				 request.setAttribute("maNguoiDung",ImaNguoiDung);
				 request.setAttribute("maDonViTrucThuoc",ImaDonViTrucThuoc);
				 request.setAttribute("maDanhMuc",ImaDanhMuc);
				 request.setAttribute("maNhaTaiTro",ImaNhaTaiTro);
				 request.setAttribute("maLoaiVienTro",ImaLoaiVienTro);
				 request.setAttribute("maCoQuanPheDuyet",ImaCoQuanPheDuyet);
				 request.setAttribute("maDoiTacThucHien",ImaDoiTacThucHien);
		         request.setAttribute("tenDuAn_TiengViet",tenDuAn_TiengViet);
		         request.setAttribute("tenDuAn_TiengAnh",tenDuAn_TiengAnh);
		         request.setAttribute("thanhVienThamGia",thanhVienThamGia);
					request.setAttribute("mucTieuDuAn",mucTieuDuAn);
					request.setAttribute("noiDungThucHien",noiDungThucHien);
					request.setAttribute("thietBiTaiTro",thietBiTaiTro);
		         request.setAttribute("kinhPhiDuAnNamTruoc",kinhPhiDuAnNamTruoc);
		         request.setAttribute("tongVonThucHien",ItongVonThucHien);
		         request.setAttribute("vonTaiTro",IvonTaiTro);
		         request.setAttribute("vonVay",IvonVay);
		         request.setAttribute("vonKhac",IvonKhac);
		         request.setAttribute("vonDoiUng",IvonDoiDung);
		         request.setAttribute("maDonViTienTe",ImaDonViTienTe);
		         request.setAttribute("thoiGianThucHien",thoiGianThucHien);
		         request.setAttribute("tienDoThucHien",tienDoThucHien);
		         request.setAttribute("phanTramTienDo",phanTramTienDoThucHien);
		        /* bang_duan_model cq1 = duan.selectFileById(ImaDuAn);
		         String oldFile1 = cq1.getFile_dinhkem_nhataitro(); // Lấy tên file gốc của file đính kèm cũ
		         String oldFile2 = cq1.getFile_dinhkem_vientro();
		         String oldFile3 = cq1.getFile_dinhkem_coquanpheduyet();
		         String oldFile4 = cq1.getFile_dinhkem_doitacthuchien();
		         // Lưu trữ tên file mới của file đính kèm
		         String newFile1 = oldFile1;
		         String newFile2 = oldFile2;
		         String newFile3 = oldFile3;
		         String newFile4 = oldFile4;
		         */
		         Timestamp Tthoigianbatdau = null;
				 Timestamp Tthoigianketthuc = null;
				

				 try {
				     if (thoiGianBatDau != null && !thoiGianBatDau.isEmpty()) {
				         String thoiGianBatDauFormatted = thoiGianBatDau.replace("T", " ") + ":00";
				        
				         Tthoigianbatdau = Timestamp.valueOf(thoiGianBatDauFormatted);
				     }
				     
				     if (thoiGianKetThuc != null && !thoiGianKetThuc.isEmpty()) {
				         String thoiGianKetThucFormatted = thoiGianKetThuc.replace("T", " ") + ":00";

				         Tthoigianketthuc = Timestamp.valueOf(thoiGianKetThucFormatted);
				     }
				   
				 } catch (IllegalArgumentException e) {
				     System.out.println("Loi: " + e.getMessage());
				 }
		         
				Random r=new Random();
				Timestamp ngayCapNhat;
				Date now = new Date(); // Lấy thời gian hiện tại
				ngayCapNhat = new Timestamp(now.getTime()); // Chuyển đổi thành Timestamp
				
				
				int maLichSuCapNhat = r.nextInt(90000);
				Object obj = request.getSession().getAttribute("nguoiDung");
				bang_nguoidung_model nguoiDung = null;
				if (obj != null)
					nguoiDung = (bang_nguoidung_model) obj;
				int nguoidungcapnhat = nguoiDung.getMaNguoiDung();
				
				
				bang_duan_model cq = new bang_duan_model(ImaDuAn,ImaNguoiDung,ImaDonViTrucThuoc
				,ImaDanhMuc,ImaNhaTaiTro,ImaLoaiVienTro,ImaCoQuanPheDuyet
				,ImaDoiTacThucHien,tenDuAn_TiengViet,tenDuAn_TiengAnh,thanhVienThamGia,mucTieuDuAn,noiDungThucHien,thietBiTaiTro,kinhPhiDuAnNamTruoc,
				ItongVonThucHien,IvonTaiTro,IvonVay,IvonKhac,IvonDoiDung,ImaDonViTienTe,thoiGianThucHien,Tthoigianbatdau,Tthoigianketthuc,
				tienDoThucHien,phanTramTienDoThucHien,ngayCapNhat,donViTienTe_VonTaiTro,donViTienTe_VonVay,donViTienTe_VonKhac,donViTienTe_VonDoiUng,donViTienTe_TongVonThucHien);
				bang_lichsucapnhat_model ls=new bang_lichsucapnhat_model(maLichSuCapNhat,ImaDuAn,nguoidungcapnhat,ngayCapNhat);
				duan.update(cq);
				lichsucapnhat.insert(ls);
				duan.selectById(cq);
				response.sendRedirect(request.getContextPath()+"/admin_quanly_duan?action=danhsach_duan_cuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("utf-8");	
			 }
			 catch(NumberFormatException e)
			 {
				
				 System.out.println("Không thể chuyển đổi " + maDanhMuc +" sang kiểu số nguyên");
			 }
		}
		
		else if (action != null && action.equals("loc_duan_theodonvitructhuoc")) {
			donvitructhuocDAO donvitructhuoc = new donvitructhuocDAO();
			request.setAttribute("donvitructhuocs", donvitructhuoc.selectAll());
			String maDonViTrucThuoc=request.getParameter("maDonViTrucThuoc");
			int ImaDonViTrucThuoc=Integer.parseInt(maDonViTrucThuoc);
			
			
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			duan.setDanhsach(i_duan_sv.locduan_theodonvitructhuoc_sv(ImaDonViTrucThuoc));
			request.setAttribute(System_Constant.DUAN,duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("loc_duan_theotrangthai")) {
		 
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int mnd = nguoiDung.getMaNguoiDung();
			
			
		   String trangthaiketthuc=request.getParameter("trangthaiketthuc");
		 
		   int Itrangthaiketthuc=Integer.parseInt(trangthaiketthuc);
			
			
			bang_duan_model duan = form_utils.toModel(bang_duan_model.class, request);
			duan.setDanhsach(i_duan_sv.locduan_theotrangthai_sv(mnd,Itrangthaiketthuc));
			request.setAttribute(System_Constant.DUAN,duan);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/danhsach_duan_cuatoi.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("capnhat_trangthai_them3"))
		{
			duanDAO duan=new duanDAO();
		
			  String [] maDonViTrucThuoc = request.getParameterValues("maDonViTrucThuoc");
			   request.setAttribute("maDonViTrucThuoc",maDonViTrucThuoc);
			        duan.update_trangthai_3(maDonViTrucThuoc);
			        response.sendRedirect(request.getContextPath()
							+ "/admin_laytoanboduan_theokhoa_dangtrienkhai?action=danhsach_duan_dangtrienkhai_cuakhoa&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
			  
			  
		}
		else if (action != null && action.equals("capnhat_trangthai_them"))
		{
			duanDAO duan=new duanDAO();
			duan_dabaocaoDAO duan_dabaocao=new duan_dabaocaoDAO();
			  String [] maDonViTrucThuoc = request.getParameterValues("maDonViTrucThuoc");
			   request.setAttribute("maDonViTrucThuoc",maDonViTrucThuoc);
			        duan.update_trangthai(maDonViTrucThuoc);
			        duan_dabaocao.InsertAll(maDonViTrucThuoc);
			        response.sendRedirect(request.getContextPath()
							+ "/admin_laytoanbodanhsach_duan_dangtrienkhai?action=danhsach_duan_dangtrienkhai&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");
			  
			  
		}

	}

	/*private String extractFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		return "";
	}*/
}
