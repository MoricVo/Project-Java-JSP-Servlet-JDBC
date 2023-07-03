package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.duan.model.bang_duan_model;
import com.duan.model.bang_file_dinhkem_model;
import com.duan.model.bang_nguoidung_model;

public class file_dinhkemDAO implements DAOInterface<bang_file_dinhkem_model>{

	@Override
	public ArrayList<bang_file_dinhkem_model> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public bang_file_dinhkem_model selectById(bang_file_dinhkem_model t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(bang_file_dinhkem_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_file_dinhkem (mafileupload,maduan,file_decuongduan,file_thucahpnhanthuchien"
					+ ",file_totrinhxinphepthuchien,file_quyetdinhgiaokinhphi,file_quyetdinhthanhlapbanquanly,file_quyetdinhchophepthuchien"
					+ ",file_hopdongthoathuan_moa,file_kehoachtrienkhaiduan,file_baocaotiendogiuaky,file_baocaotongket,file_xacnhanketthucduan,"
					+ "file_lylichkhoahoccuachunhiemduan,file_bienbangiaitrinh,file_hinhanhthongtinhoatdongtrienkhai,"
					+ "file_cacminhchungkhac,file_cacminhchungkhac_2)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

						PreparedStatement st = con.prepareStatement(sql);
					   st.setInt(1,t.getMafileupload());
					   st.setInt(2,t.getMaduan());
					   st.setString(3,t.getFile_decuongduan());
					   st.setString(4,t.getFile_thucahpnhanthuchien());
					   st.setString(5,t.getFile_totrinhxinphepthuchien());
					  
					   st.setString(6,t.getFile_quyetdinhgiaokinhphi());
					  
					   st.setString(7,t.getFile_quyetdinhthanhlapbanquanly());
					
					   st.setString(8,t.getFile_quyetdinhchophepthuchien());
					   st.setString(9,t.getFile_hopdongthoathuan_moa());
					   st.setString(10,t.getFile_kehoachtrienkhaiduan());
					   st.setString(11,t.getFile_baocaotiendogiuaky());
					   st.setString(12,t.getFile_baocaotongket());
					   st.setString(13,t.getFile_xacnhanketthucduan());
					   st.setString(14,t.getFile_lylichkhoahoccuachunhiemduan());
					   st.setString(15,t.getFile_bienbangiaitrinh());
					
					   st.setString(16,t.getFile_hinhanhthongtinhoatdongtrienkhai());
					   st.setString(17,t.getFile_cacminhchungkhac());
					   st.setString(18,t.getFile_cacminhchungkhac_2());
					 
					
					   
					  

			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public ArrayList<bang_file_dinhkem_model> selectAll1() {
		 ArrayList<bang_file_dinhkem_model> ketQua = new ArrayList<bang_file_dinhkem_model>();
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "SELECT * FROM bang_file_dinhkem";
				PreparedStatement st = con.prepareStatement(sql);

				// Bước 3: thực thi câu lệnh SQL
				System.out.println(sql);
				ResultSet rs = st.executeQuery();

				// Bước 4:
				while (rs.next()) {
					int maDuAn = rs.getInt("maduan");
					
					bang_file_dinhkem_model file_dk = new bang_file_dinhkem_model(maDuAn);
					ketQua.add(file_dk);
				}

				// Bước 5:
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ketQua;
	}
	public boolean kiemTraMaDuAnTrungLap(int maDuAn) {
		boolean ketQua = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_file_dinhkem WHERE maduan=?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,maDuAn);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				ketQua = true;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public boolean kiemTraFileKetThuc(int maduan) {
	    boolean ketQua = false;
	    try {
	        // Bước 1: tạo kết nối đến CSDL
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: tạo ra đối tượng statement
	        String sql = "SELECT bang_file_dinhkem.file_xacnhanketthucduan FROM bang_file_dinhkem WHERE maduan=?";
	        PreparedStatement st = con.prepareStatement(sql);

	        st.setInt(1,maduan);

	        // Bước 3: thực thi câu lệnh SQL
	        System.out.println(sql);
	        ResultSet rs = st.executeQuery();

	        // Bước 4:
	        if (rs.next()) { // kiểm tra có file hay không
	            String fileName = rs.getString("file_xacnhanketthucduan");
	            if (fileName == null) { // nếu file null thì trả về false
	                ketQua = false;
	            } else { // nếu có file thì trả về true
	                ketQua = true;
	            }
	        }

	        // Bước 5:
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ketQua;
	}
	
	public bang_file_dinhkem_model Layfiletheoma(int maduan) {
		bang_file_dinhkem_model ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "	SELECT \r\n" + 
					"  bang_file_dinhkem.* , \r\n" + 
					"  bang_duanquocte.tenduan_tiengviet AS tenduan_tiengviet,\r\n" + 
					"  bang_duanquocte.tenduan_tienganh AS tenduan_tienganh \r\n" + 
					"FROM \r\n" + 
					"  bang_file_dinhkem\r\n" + 
					"  LEFT JOIN bang_duanquocte ON bang_file_dinhkem.maduan=bang_duanquocte.maduan\r\n" + 
					"WHERE \r\n" + 
					"  bang_file_dinhkem.maduan=? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,maduan);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				  int maduan1=rs.getInt("maduan");
				   String file_decuongduan=rs.getString("file_decuongduan");
				   String file_thucahpnhanthuchien=rs.getString("file_thucahpnhanthuchien");
				   String file_totrinhxinphepthuchien=rs.getString("file_totrinhxinphepthuchien");
				   String file_quyetdinhgiaokinhphi=rs.getString("file_quyetdinhgiaokinhphi");
				   String file_quyetdinhthanhlapbanquanly=rs.getString("file_quyetdinhthanhlapbanquanly");
				   String file_quyetdinhchophepthuchien=rs.getString("file_quyetdinhchophepthuchien");
				   String file_hopdongthoathuan_moa=rs.getString("file_hopdongthoathuan_moa");
				   String file_kehoachtrienkhaiduan=rs.getString("file_kehoachtrienkhaiduan");
				   String file_baocaotiendogiuaky=rs.getString("file_baocaotiendogiuaky");
				   String file_baocaotongket=rs.getString("file_baocaotongket");
				   String file_xacnhanketthucduan=rs.getString("file_xacnhanketthucduan");
				   String file_lylichkhoahoccuachunhiemduan=rs.getString("file_lylichkhoahoccuachunhiemduan");
				   String file_bienbangiaitrinh=rs.getString("file_bienbangiaitrinh");
				   String file_hinhanhthongtinhoatdongtrienkhai=rs.getString("file_hinhanhthongtinhoatdongtrienkhai");
				   String file_cacminhchungkhac=rs.getString("file_cacminhchungkhac");
				   String file_cacminhchungkhac_2=rs.getString("file_cacminhchungkhac_2");
				  
				   bang_duan_model duan=new bang_duan_model();
				   duan.setTenDuAn_TiengViet(rs.getString("tenduan_tiengviet"));
				   duan.setTenDuAn_TiengAnh(rs.getString("tenduan_tienganh"));
				  ketQua = new bang_file_dinhkem_model(maduan1,file_decuongduan,file_thucahpnhanthuchien,file_totrinhxinphepthuchien
						  ,file_quyetdinhgiaokinhphi,file_quyetdinhthanhlapbanquanly,file_quyetdinhchophepthuchien,
						  file_hopdongthoathuan_moa,file_kehoachtrienkhaiduan,file_baocaotiendogiuaky,
						  file_baocaotongket,file_xacnhanketthucduan,file_lylichkhoahoccuachunhiemduan,
						  file_bienbangiaitrinh,file_hinhanhthongtinhoatdongtrienkhai,file_cacminhchungkhac,file_cacminhchungkhac_2,duan);
				
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<bang_file_dinhkem_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(bang_file_dinhkem_model t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<bang_file_dinhkem_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_file_dinhkem_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_file_dinhkem " + " SET "+ " file_decuongduan=?"+ 
			",file_thucahpnhanthuchien=?"+",file_totrinhxinphepthuchien=?"+",file_quyetdinhgiaokinhphi=?"+",file_quyetdinhthanhlapbanquanly=?"+
			",file_quyetdinhchophepthuchien=?"+",file_hopdongthoathuan_moa=?"+",file_kehoachtrienkhaiduan=?"+
			",file_baocaotiendogiuaky=?"+",file_baocaotongket=?"+",file_xacnhanketthucduan=?"+",file_lylichkhoahoccuachunhiemduan=?"+
			",file_bienbangiaitrinh=?"+",file_hinhanhthongtinhoatdongtrienkhai=?"+",file_cacminhchungkhac=?"+
			",file_cacminhchungkhac_2=? " + " WHERE maduan=?";

			PreparedStatement st = con.prepareStatement(sql);
			
			  
			   st.setString(1,t.getFile_decuongduan());
			   st.setString(2,t.getFile_thucahpnhanthuchien());
			   st.setString(3,t.getFile_totrinhxinphepthuchien());
			  
			   st.setString(4,t.getFile_quyetdinhgiaokinhphi());
			  
			   st.setString(5,t.getFile_quyetdinhthanhlapbanquanly());
			
			   st.setString(6,t.getFile_quyetdinhchophepthuchien());
			   st.setString(7,t.getFile_hopdongthoathuan_moa());
			   st.setString(8,t.getFile_kehoachtrienkhaiduan());
			   st.setString(9,t.getFile_baocaotiendogiuaky());
			   st.setString(10,t.getFile_baocaotongket());
			   st.setString(11,t.getFile_xacnhanketthucduan());
			   st.setString(12,t.getFile_lylichkhoahoccuachunhiemduan());
			   st.setString(13,t.getFile_bienbangiaitrinh());
			
			   st.setString(14,t.getFile_hinhanhthongtinhoatdongtrienkhai());
			   st.setString(15,t.getFile_cacminhchungkhac());
			   st.setString(16,t.getFile_cacminhchungkhac_2());
			   st.setInt(17,t.getMaduan());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

}
