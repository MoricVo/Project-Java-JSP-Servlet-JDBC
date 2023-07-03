package com.duan.controller.admin;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.duan.constant.System_Constant;
import com.duan.database.coquanpheduyetDAO;
import com.duan.database.danhmuc_DAO;
import com.duan.database.doitacthuchienDAO;
import com.duan.database.donvitienteDAO;
import com.duan.database.donvitructhuocDAO;
import com.duan.database.duanDAO;
import com.duan.database.file_dinhkemDAO;
import com.duan.database.loaivientroDAO;
import com.duan.database.nhataitroDAO;
import com.duan.interface_of_service.bang_file_dinhkem_interface_service;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_file_dinhkem_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.utils.form_utils;

/**
 * Servlet implementation class quanly_file_dinhkem_controller
 */
@MultipartConfig()
@WebServlet(urlPatterns= {"/admin_them_file_dinhkem","/admin_chitiet_file_dinhkem","/admin_sua_file_dinhkem"})
public class quanly_file_dinhkem_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	bang_file_dinhkem_interface_service i_file_dk_sv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanly_file_dinhkem_controller() {
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
		if (action != null && action.equals("them_file_dinhkem")) 
		{
			Object obj = request.getSession().getAttribute("nguoiDung");
			bang_nguoidung_model nguoiDung = null;
			if (obj != null)
				nguoiDung = (bang_nguoidung_model) obj;
			int maNguoiDung = nguoiDung.getMaNguoiDung();
			duanDAO duan = new duanDAO();
			request.setAttribute("duans", duan.select_ma_nguoidung(maNguoiDung));
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/file_dinhkem/add.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("sua_file_dinhkem")) 
		{
			
			bang_file_dinhkem_model filedinhkem =new bang_file_dinhkem_model();
			file_dinhkemDAO dk=new file_dinhkemDAO();
			String maDuAn = request.getParameter("maDuAn");
			int Imaduan = Integer.parseInt(maDuAn);
			if(Imaduan!=0)
			{
				
				if(!dk.kiemTraMaDuAnTrungLap(Imaduan))
				{
					
					Object obj = request.getSession().getAttribute("nguoiDung");
					bang_nguoidung_model nguoiDung = null;
					if (obj != null)
						nguoiDung = (bang_nguoidung_model) obj;
					int maNguoiDung = nguoiDung.getMaNguoiDung();
					duanDAO duan = new duanDAO();
					request.setAttribute("duans", duan.select_ma_nguoidung(maNguoiDung));
					
					  String message1 = "Dự án của bạn chưa được thêm file upload!Không thể cập nhật vui lòng chọn dự án cần thêm.";
		 			  request.setAttribute("successMessage_file", message1);
					
					RequestDispatcher rd = request.getRequestDispatcher("/views/admin/file_dinhkem/add.jsp");
					rd.forward(request, response);
				}
				 request.setAttribute("file1",dk.Layfiletheoma(Imaduan));
					
					RequestDispatcher rd = request.getRequestDispatcher("/views/admin/file_dinhkem/edit.jsp");
					rd.forward(request, response);
			}
			
		}
		/*else if (action != null && action.equals("chitiet_file_dinhkem")) {
		
			bang_file_dinhkem_model filedinhkem = form_utils.toModel(bang_file_dinhkem_model.class, request);
			if(filedinhkem.getMaduan()!=0)
			{
				
				filedinhkem=i_file_dk_sv.laymotfile_sv(filedinhkem.getMaduan());
				
				request.setAttribute(System_Constant.FILEDINHKEM, filedinhkem);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/duan/detail.jsp");
			rd.forward(request, response);
			}
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		file_dinhkemDAO file_dinhkem=new file_dinhkemDAO();
		String action = request.getParameter("action");
		if (action != null && action.equals("them_file_dinhkem_post")) {
			String maDuAn =request.getParameter("maDuAn");
			Collection<Part> parts = request.getParts();
			try
			{
				int ImaDuAn=Integer.parseInt(maDuAn);
				request.setAttribute("maDuAn",ImaDuAn);
				String file1 = null;
				String file2 = null;
				String file3 = null;
				String file4 = null;
				String file5 = null;
				String file6 = null;
				String file7 = null;
				String file8 = null;
				String file9 = null;
				String file10 = null;
				String file11 = null;
				String file12 = null;
				String file13 = null;
				String file14 = null;
				String file15 = null;
				String file16 = null;
				
				for (Part part : parts) {
					
					// Lấy tên của part
					String partName = part.getName();

					// Kiểm tra xem part có phải là file hay không
					if (part.getContentType() != null) {

						// Lấy tên file và đường dẫn lưu trữ trên server
						String fileName = extractFileName(part);
						String filePath = getServletContext().getRealPath("/source_file_upload") + File.separator
								+ fileName;
						File file = new File(fileName);
					
						if (fileName != null && !fileName.isEmpty()) {
							String fileName_2= fileName;
							part.write(filePath);
							if (part.getName().equals("file_decuongduan")) {
								file1 = fileName_2;
								
							} else if (part.getName().equals("file_thucahpnhanthuchien")) {
								file2 = fileName_2;
							}
							else if (part.getName().equals("file_totrinhxinphepthuchien")) {
								file3 = fileName_2;
							}
							else if (part.getName().equals("file_quyetdinhgiaokinhphi")) {
								file4 = fileName_2;
							}
							else if (part.getName().equals("file_quyetdinhthanhlapbanquanly")) {
								file5 = fileName_2;
							}
							else if (part.getName().equals("file_quyetdinhchophepthuchien")) {
								file6 = fileName_2;
							}
							else if (part.getName().equals("file_hopdongthoathuan_moa")) {
								file7 = fileName_2;
							}
							else if (part.getName().equals("file_kehoachtrienkhaiduan")) {
								file8 = fileName_2;
							}
							else if (part.getName().equals("file_baocaotiendogiuaky")) {
								file9 = fileName_2;
							}
							else if (part.getName().equals("file_baocaotongket")) {
								file10 = fileName_2;
							}
							else if (part.getName().equals("file_xacnhanketthucduan")) {
								file11 = fileName_2;
							}
							else if (part.getName().equals("file_lylichkhoahoccuachunhiemduan")) {
								file12 = fileName_2;
							}
							else if (part.getName().equals("file_bienbangiaitrinh")) {
								file13 = fileName_2;
							}
							else if (part.getName().equals("file_hinhanhthongtinhoatdongtrienkhai")) {
								file14 = fileName_2;
							}
							else if (part.getName().equals("file_cacminhchungkhac")) {
								file15 = fileName_2;
							}
							else if (part.getName().equals("file_cacminhchungkhac_2")) {
								file16 = fileName_2;
							}
						}
						// Thực hiện các thao tác khác, ví dụ như lưu thông tin vào CSDL
						
					}

				}
				Random r = new Random();
				int maDinhKem = r.nextInt(90000);
				
				bang_file_dinhkem_model cq = new bang_file_dinhkem_model(maDinhKem,ImaDuAn,file1,file2,file3,file4,file5,file6,file7,file8,file9,file10,file11,file12,file13,file14,file15,file16);
				file_dinhkem.insert(cq);

				response.sendRedirect(request.getContextPath()
						+ "/admin_quanly_duan?action=danhsach_duan_cuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("utf-8");
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
			}
			
		}
		else if (action != null && action.equals("sua_file_dinhkem_post")) {
			file_dinhkemDAO file_dk=new file_dinhkemDAO();
			String maDuAn =request.getParameter("maDuAn");
			Collection<Part> parts = request.getParts();
			try
			{
				int ImaDuAn=Integer.parseInt(maDuAn);
				request.setAttribute("maDuAn",ImaDuAn);
				bang_file_dinhkem_model cq1 =file_dk.Layfiletheoma(ImaDuAn);
				 String oldFile1 = cq1.getFile_decuongduan(); // Lấy tên file gốc của file đính kèm cũ
		         String oldFile2 = cq1.getFile_thucahpnhanthuchien();
		         String oldFile3 = cq1.getFile_totrinhxinphepthuchien();
		         String oldFile4 = cq1.getFile_quyetdinhgiaokinhphi();
		         String oldFile5 = cq1.getFile_quyetdinhthanhlapbanquanly();
		         String oldFile6 = cq1.getFile_quyetdinhchophepthuchien();
		         String oldFile7 = cq1.getFile_hopdongthoathuan_moa();
		         String oldFile8 = cq1.getFile_kehoachtrienkhaiduan();
		         String oldFile9 = cq1.getFile_baocaotiendogiuaky();
		         String oldFile10 = cq1.getFile_baocaotongket();
		         String oldFile11 = cq1.getFile_xacnhanketthucduan();
		         String oldFile12 = cq1.getFile_lylichkhoahoccuachunhiemduan();
		         String oldFile13 = cq1.getFile_bienbangiaitrinh();
		         String oldFile14 = cq1.getFile_hinhanhthongtinhoatdongtrienkhai();
		         String oldFile15 = cq1.getFile_cacminhchungkhac();
		         String oldFile16 = cq1.getFile_cacminhchungkhac_2();
		         String newFile1 = oldFile1;
		         String newFile2 = oldFile2;
		         String newFile3 = oldFile3;
		         String newFile4 = oldFile4;
		         String newFile5 = oldFile5;
		         String newFile6 = oldFile6;
		         String newFile7 = oldFile7;
		         String newFile8 = oldFile8;
		         String newFile9 = oldFile9;
		         String newFile10 = oldFile10;
		         String newFile11 = oldFile11;
		         String newFile12 = oldFile12;
		         String newFile13 = oldFile13;
		         String newFile14 = oldFile14;
		         String newFile15 = oldFile15;
		         String newFile16 = oldFile16;
					
					for (Part part : parts) {
						 if (part.getContentType() != null) { // Kiểm tra xem part có phải là file hay không
						        // Lấy tên file mới và đường dẫn lưu trữ trên server
							 String fileName = extractFileName(part);
						        String filePath = getServletContext().getRealPath("/source_file_upload") + File.separator + fileName;
						        File file = new File(filePath);
						        if (!fileName.isEmpty()) { // Kiểm tra xem file có được upload hay không
						        	String fileName_2= fileName;
						            if (part.getName().equals("file_decuongduan")) { // Nếu là file đính kèm 1
						                // Xóa file cũ nếu có
						                if (oldFile1 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile1);
						                    oldFile.delete();
						                }
						                // Lưu file mới
						                part.write(filePath);
						                // Lưu trữ tên file mới vào biến
						                newFile1 = fileName_2;
						            } else if (part.getName().equals("file_thucahpnhanthuchien")) { // Tương tự với file đính kèm 2
						                if (oldFile2 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile2);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile2 = fileName_2;
						            } else if (part.getName().equals("file_totrinhxinphepthuchien")) { // Tương tự với file đính kèm 3
						                if (oldFile3 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile3);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile3 = fileName_2;
						            } 
						            else if (part.getName().equals("file_quyetdinhgiaokinhphi")) { // Tương tự với file đính kèm 3
						                if (oldFile4 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile4);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile4 = fileName_2;
						            } 
						            
						            else if (part.getName().equals("file_quyetdinhthanhlapbanquanly")) { // Tương tự với file đính kèm 2
						                if (oldFile5 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile5);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile5 = fileName_2;
						            } else if (part.getName().equals("file_quyetdinhchophepthuchien")) { // Tương tự với file đính kèm 3
						                if (oldFile6 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile6);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile6 = fileName_2;
						            } 
						            else if (part.getName().equals("file_hopdongthoathuan_moa")) { // Tương tự với file đính kèm 3
						                if (oldFile7 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile7);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile7 = fileName_2;
						            } 
						            
						            else if (part.getName().equals("file_kehoachtrienkhaiduan")) { // Tương tự với file đính kèm 2
						                if (oldFile8 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile8);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile8 = fileName_2;
						            } else if (part.getName().equals("file_baocaotiendogiuaky")) { // Tương tự với file đính kèm 3
						                if (oldFile9 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile9);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile9 = fileName_2;
						            } 
						            else if (part.getName().equals("file_baocaotongket")) { // Tương tự với file đính kèm 3
						                if (oldFile10 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile10);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile10 = fileName_2;
						            } 
						            
						            else if (part.getName().equals("file_xacnhanketthucduan")) { // Tương tự với file đính kèm 2
						                if (oldFile11 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile11);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile11 = fileName_2;
						            } else if (part.getName().equals("file_lylichkhoahoccuachunhiemduan")) { // Tương tự với file đính kèm 3
						                if (oldFile12 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile12);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile12 = fileName_2;
						            } 
						            else if (part.getName().equals("file_bienbangiaitrinh")) { // Tương tự với file đính kèm 3
						                if (oldFile13 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile13);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile13 = fileName_2;
						            } 
						            else if (part.getName().equals("file_hinhanhthongtinhoatdongtrienkhai")) { // Tương tự với file đính kèm 3
						                if (oldFile14 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile14);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile14 = fileName_2;
						            } 
						            else if (part.getName().equals("file_cacminhchungkhac")) { // Tương tự với file đính kèm 3
						                if (oldFile15 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile15);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile15 = fileName_2;
						            } 
						            else if (part.getName().equals("file_cacminhchungkhac_2")) { // Tương tự với file đính kèm 3
						                if (oldFile16 != null && !part.getSubmittedFileName().isEmpty()) {
						                    File oldFile = new File(getServletContext().getRealPath("/source_file_upload") + File.separator + oldFile16);
						                    oldFile.delete();
						                }
						                part.write(filePath);
						                newFile16 = fileName_2;
						            } 
						           
						        }
						    }
					}
					bang_file_dinhkem_model cq = new bang_file_dinhkem_model(ImaDuAn,newFile1,newFile2,newFile3,newFile4
							,newFile5,newFile6,newFile7,newFile8,newFile9,newFile10,newFile11,newFile12,newFile13
							,newFile14,newFile15,newFile16);
					file_dinhkem.update(cq);
					
					response.sendRedirect(request.getContextPath()
							+ "/admin_quanly_duan?action=danhsach_duan_cuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc");
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("utf-8");
		         
				
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
			}
		}
	}
	private String extractFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		return "";
	}

}
