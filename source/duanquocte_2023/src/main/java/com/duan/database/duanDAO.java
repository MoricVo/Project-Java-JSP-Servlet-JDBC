package com.duan.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.duan.model.bang_danhmuc_model;
import com.duan.model.bang_doitacthuchien_model;
import com.duan.model.bang_donvitiente_model;
import com.duan.model.bang_donvitructhuoc_model;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_file_dinhkem_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.model.bang_nhataitro_model;
public class duanDAO implements DAOInterface<bang_duan_model>
{
	public ArrayList<bang_duan_model> data = new ArrayList<>();
	@Override
	public ArrayList<bang_duan_model> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public bang_duan_model selectById(bang_duan_model t) {
		bang_duan_model ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_duanquocte WHERE maduan=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaDuAn());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				  int maDuAn = rs.getInt("maduan");
				  int maNguoiDung = rs.getInt("manguoidung");
				  int maDonViTrucThuoc=rs.getInt("madonvitructhuoc");
				  int maDanhMuc= rs.getInt("madanhmuc");
				  int maNhaTaiTro=rs.getInt("manhataitro");
				
				  int maLoaiVienTro=rs.getInt("maloaivientro");
				
				  int maCoQuanPheDuyet=rs.getInt("macoquanpheduyet");
				
				  int maDoiTacThucHien=rs.getInt("madoitacthuchien");
				
				  String tenDuAn_TiengViet=rs.getString("tenduan_tiengviet");
				  String tenDuAn_TiengAnh=rs.getString("tenduan_tienganh");
				  
				  String thanhVienThamGia=rs.getString("thanhvienthamgia");
				  String mucTieuDuAn=rs.getString("muctieuduan");
				  String noiDungThucHien=rs.getString("noidungthuchien");
				  String thietBiTaiTro=rs.getString("thietbitaitro");
				  
				  String kinhPhiDuAnNamTruoc=rs.getString("kinhphiduannamtruoc");
				  Float tongVonThucHien=rs.getFloat("tongvonthuchien");
				  Float vonTaiTro=rs.getFloat("vontaitro");
				  
				  Float vonVay=rs.getFloat("vonvay");
				  Float vonKhac=rs.getFloat("vonkhac");
				  Float vonDoiUng=rs.getFloat("vondoiung");
				 int maDonViTienTe=rs.getInt("madonvitiente");
				  String thoiGianThucHien=rs.getString("thoigianthuchien");
				  String tienDoThucHien=rs.getString("tiendothuchien");
				  String phanTramTienDoThucHien=rs.getString("phantramtiendo");
				  Timestamp ngayTao=rs.getTimestamp("ngaytao");
				  ketQua = new bang_duan_model(maDuAn, maNguoiDung,maDonViTrucThuoc,maDanhMuc,
							maNhaTaiTro,maLoaiVienTro,maCoQuanPheDuyet,maDoiTacThucHien,
							tenDuAn_TiengViet, tenDuAn_TiengAnh,thanhVienThamGia,mucTieuDuAn,noiDungThucHien,thietBiTaiTro, kinhPhiDuAnNamTruoc, tongVonThucHien, vonTaiTro,
							vonVay, vonKhac,vonDoiUng,maDonViTienTe, thoiGianThucHien, tienDoThucHien,
							phanTramTienDoThucHien,ngayTao);
				 
				
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public ArrayList<bang_file_dinhkem_model> selectAll12() {
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
	public ArrayList<bang_duan_model> select_ma_nguoidung(int manguoidung) {
		ArrayList<bang_duan_model> ketQua = new ArrayList<bang_duan_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_duanquocte WHERE manguoidung=? AND maduan NOT IN (SELECT maduan FROM bang_file_dinhkem)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, manguoidung);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				  int maDuAn = rs.getInt("maduan");
				  int maNguoiDung = rs.getInt("manguoidung");
				  int maDonViTrucThuoc=rs.getInt("madonvitructhuoc");
				  int maDanhMuc= rs.getInt("madanhmuc");
				  int maNhaTaiTro=rs.getInt("manhataitro");
				
				  int maLoaiVienTro=rs.getInt("maloaivientro");
				
				  int maCoQuanPheDuyet=rs.getInt("macoquanpheduyet");
				
				  int maDoiTacThucHien=rs.getInt("madoitacthuchien");
				
				  String tenDuAn_TiengViet=rs.getString("tenduan_tiengviet");
				  String tenDuAn_TiengAnh=rs.getString("tenduan_tienganh");
				  
				  String thanhVienThamGia=rs.getString("thanhvienthamgia");
				  String mucTieuDuAn=rs.getString("muctieuduan");
				  String noiDungThucHien=rs.getString("noidungthuchien");
				  String thietBiTaiTro=rs.getString("thietbitaitro");
				  
				  String kinhPhiDuAnNamTruoc=rs.getString("kinhphiduannamtruoc");
				  Float tongVonThucHien=rs.getFloat("tongvonthuchien");
				  Float vonTaiTro=rs.getFloat("vontaitro");
				  
				  Float vonVay=rs.getFloat("vonvay");
				  Float vonKhac=rs.getFloat("vonkhac");
				  Float vonDoiUng=rs.getFloat("vondoiung");
				  int maDonViTienTe=rs.getInt("madonvitiente");
				  String thoiGianThucHien=rs.getString("thoigianthuchien");
				  String tienDoThucHien=rs.getString("tiendothuchien");
				  String phanTramTienDo=rs.getString("phantramtiendo");
				  Timestamp ngayTao=rs.getTimestamp("ngaytao");
				  bang_duan_model duan = new bang_duan_model(maDuAn, maNguoiDung,maDonViTrucThuoc,maDanhMuc,
							maNhaTaiTro,maLoaiVienTro,maCoQuanPheDuyet,maDoiTacThucHien,
							tenDuAn_TiengViet, tenDuAn_TiengAnh,thanhVienThamGia,mucTieuDuAn,noiDungThucHien,thietBiTaiTro, kinhPhiDuAnNamTruoc, tongVonThucHien, vonTaiTro,
							vonVay, vonKhac,vonDoiUng,maDonViTienTe, thoiGianThucHien, tienDoThucHien,
							phanTramTienDo,ngayTao);
				  ketQua.add(duan);
				
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public boolean kiemTraMaDuAnTonTai(int maduan) {
	    boolean ketQua = false;
	    try {
	        // Bước 1: tạo kết nối đến CSDL
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: tạo ra đối tượng statement
	        String sql = "SELECT maduan FROM bang_duanquocte WHERE maduan = ?";
	        PreparedStatement st = con.prepareStatement(sql);

	        st.setInt(1,maduan);

	        // Bước 3: thực thi câu lệnh SQL
	        System.out.println(sql);
	        ResultSet rs = st.executeQuery();

	        // Bước 4:
	        if (rs.next()) { // kiểm tra có file hay không
	            ketQua=true;
	        }

	        // Bước 5:
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ketQua;
	}
	
	public bang_duan_model FindKeyWord(String tenduan_tiengviet) {
		bang_duan_model ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "	SELECT tenduan_tiengviet FROM bang_duanquocte WHERE tenduan_tiengviet LIKE ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,"%"+tenduan_tiengviet+"%");

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				
				  String tenDuAn_TiengViet=rs.getString("tenduan_tiengviet");
				  ketQua = new bang_duan_model(tenDuAn_TiengViet);
				
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
	public int insert(bang_duan_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_duanquocte (maduan,manguoidung,madonvitructhuoc,madanhmuc,"
					+ "manhataitro,maloaivientro,macoquanpheduyet,madoitacthuchien "
					+ ",tenduan_tiengviet,tenduan_tienganh,thanhvienthamgia,muctieuduan,noidungthuchien,thietbitaitro,kinhphiduannamtruoc,tongvonthuchien,"
					+ "vontaitro,vonvay,vonkhac,vondoiung,madonvitiente,thoigianthuchien,thoigianbatdau,thoigianketthuc,tiendothuchien,phantramtiendo,ngaytao,donvitiente_vontaitro,donvitiente_vonvay,donvitiente_vonkhac,donvitiente_vondoiung,donvitiente_tongvonthuchien)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
		   st.setInt(1,t.getMaDuAn());
		   st.setInt(2,t.getMaNguoiDung());
		   st.setInt(3,t.getMaDonViTrucThuoc());
		   st.setInt(4,t.getMaDanhMuc());
		   st.setInt(5,t.getMaNhaTaiTro());
		  
		   st.setInt(6,t.getMaLoaiVienTro());
		  
		   st.setInt(7,t.getMaCoQuanPheDuyet());
		
		   st.setInt(8,t.getMaDoiTacThucHien());
		   
		   st.setString(9, t.getTenDuAn_TiengViet());
		   st.setString(10,t.getTenDuAn_TiengAnh());
		   
		   st.setString(11,t.getThanhVienThamGia());
		   st.setString(12,t.getMucTieuDuAn());
		   st.setString(13,t.getNoiDungThucHien());
		   st.setString(14,t.getThietBiTaiTro());
		  
		   st.setString(15,t.getKinhPhiNamTruoc());
		   st.setFloat(16,t.getTongVonThucHien());
		   st.setFloat(17,t.getVonTaiTro());
		   st.setFloat(18,t.getVonVay());
		   st.setFloat(19,t.getVonKhac());
		   st.setFloat(20,t.getVonDoiUng());
		   st.setInt(21,t.getMaDonViTienTe());
		   st.setString(22,t.getThoiGianThucHien());
		   st.setTimestamp(23,t.getThoiGianBatDau());
		   st.setTimestamp(24,t.getThoiGianKetThuc());
		   st.setString(25,t.getTienDoThucHien());
		   st.setString(26,t.getPhanTramTienDoThucHien());
		   st.setTimestamp(27,t.getNgayTao());
		   st.setString(28, t.getDonViTienTe_VonTaiTro());
		   st.setString(29, t.getDonViTienTe_VonVay());
		   st.setString(30, t.getDonViTienTe_VonKhac());
		   st.setString(31, t.getDonViTienTe_VonDoiUng());
		   st.setString(32, t.getDonViTienTe_TongVonThucHien());
		   
		   
	        

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

	@Override
	public int insertAll(ArrayList<bang_duan_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(bang_duan_model t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<bang_duan_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_duan_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_duanquocte " + " SET "+ " manguoidung=?"+ 
			",madonvitructhuoc=?"+",madanhmuc=?"+",manhataitro=?"+",maloaivientro=?"+
			",macoquanpheduyet=?"+",madoitacthuchien=?"+",tenduan_tiengviet=?"+
			",tenduan_tienganh=?"+",thanhvienthamgia=?"+",muctieuduan=?"+",noidungthuchien=?"+",thietbitaitro=?"+",kinhphiduannamtruoc=?"+",tongvonthuchien=?"+
			",vontaitro=?"+",vonvay=?"+",vonkhac=?"+",vondoiung=?"+",madonvitiente=?"+",thoigianthuchien=?"+",thoigianbatdau=?"+",thoigianketthuc=?"+
			",tiendothuchien=?"+",phantramtiendo=?"+",ngaycapnhat=?" +",donvitiente_vontaitro=?" +",donvitiente_vonvay=?" +",donvitiente_vonkhac=?" +",donvitiente_vondoiung=?" +",donvitiente_tongvonthuchien=?"   + " WHERE maduan=?";

			PreparedStatement st = con.prepareStatement(sql);
			   st.setInt(1,t.getMaNguoiDung());
			   st.setInt(2,t.getMaDonViTrucThuoc());
			   st.setInt(3,t.getMaDanhMuc());
			   st.setInt(4,t.getMaNhaTaiTro());
			
			   st.setInt(5,t.getMaLoaiVienTro());
			 
			   st.setInt(6,t.getMaCoQuanPheDuyet());
			 
			   st.setInt(7,t.getMaDoiTacThucHien());
			 
			   st.setString(8, t.getTenDuAn_TiengViet());
			   st.setString(9,t.getTenDuAn_TiengAnh());
			   
			   st.setString(10,t.getThanhVienThamGia());
			   st.setString(11,t.getMucTieuDuAn());
			   st.setString(12,t.getNoiDungThucHien());
			   st.setString(13,t.getThietBiTaiTro());
			   
			   
			   st.setString(14,t.getKinhPhiNamTruoc());
			   st.setFloat(15,t.getTongVonThucHien());
			   st.setFloat(16,t.getVonTaiTro());
			   st.setFloat(17,t.getVonVay());
			   st.setFloat(18,t.getVonKhac());
			   st.setFloat(19,t.getVonDoiUng());
			   st.setInt(20,t.getMaDonViTienTe());
			   st.setString(21,t.getThoiGianThucHien());
			   st.setTimestamp(22,t.getThoiGianBatDau());
			   st.setTimestamp(23,t.getThoiGianKetThuc());
			   st.setString(24,t.getTienDoThucHien());
			   st.setString(25,t.getPhanTramTienDoThucHien());
			  
			   st.setTimestamp(26,t.getNgayCapNhat());
			   st.setString(27, t.getDonViTienTe_VonTaiTro());
			   st.setString(28, t.getDonViTienTe_VonVay());
			   st.setString(29, t.getDonViTienTe_VonKhac());
			   st.setString(30, t.getDonViTienTe_VonDoiUng());
			   st.setString(31, t.getDonViTienTe_TongVonThucHien());
			   st.setInt(32,t.getMaDuAn());
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
	public int update_trangthai(String[] madonvitructhuoc) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_duanquocte \r\n" + 
					"SET trangthaiduan = 0 \r\n" + 
					"WHERE trangthaiduan=2 AND maduan = ? ";

			PreparedStatement st = con.prepareStatement(sql);
			   
		    // Bước 3: Thực hiện lặp qua từng mã bài viết và thực hiện cập nhật
	        for (String maDonVi : madonvitructhuoc) {
	        	 String[] ids = maDonVi.split("\\|\\|");
	        	  String maDuAn = ids[0];
	        	 
	            // Chuyển đổi mã bài viết từ kiểu String sang kiểu int
	        	  int maDuAnInt = Integer.parseInt(maDuAn);
	           
	            
	            // Thiết lập tham số cho câu lệnh PreparedStatement
	            st.setInt(1,maDuAnInt);
	          

	            // Thực thi câu lệnh SQL
	            ketQua += st.executeUpdate();
	        }
			 
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
	public int update_trangthai_0(bang_duan_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_duanquocte \r\n" + 
					"SET trangthaiduan = 0 \r\n" + 
					"WHERE maduan = ?";

			PreparedStatement st = con.prepareStatement(sql);
			   
			
			   st.setInt(1,t.getMaDuAn());
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
	public int update_trangthai_2(bang_duan_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_duanquocte \r\n" + 
					"SET trangthaiduan = 1 \r\n" + 
					"WHERE maduan = ?";

			PreparedStatement st = con.prepareStatement(sql);
			   
			
			   st.setInt(1,t.getMaDuAn());
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
	public int update_trangthai_ketthuc(bang_duan_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_duanquocte \r\n" + 
					"SET trangthaiketthuc = 1 \r\n" + 
					"WHERE maduan = ?";

			PreparedStatement st = con.prepareStatement(sql);
			   
			
			   st.setInt(1,t.getMaDuAn());
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
	public int update_trangthai_3(String[] madonvitructhuoc) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_duanquocte \r\n" + 
					"SET trangthaiduan = 2 \r\n" + 
					"WHERE trangthaiduan=1 AND maduan = ? AND madonvitructhuoc=?";

			PreparedStatement st = con.prepareStatement(sql);
			   
		    // Bước 3: Thực hiện lặp qua từng mã bài viết và thực hiện cập nhật
	        for (String maDonVi : madonvitructhuoc) {
	        	  String[] ids = maDonVi.split(",");
	        	  String maDuAn = ids[0];
	        	  String maDonViTrucThuoc = ids[1];
	            // Chuyển đổi mã bài viết từ kiểu String sang kiểu int
	        	  int maDuAnInt = Integer.parseInt(maDuAn);
	            int maDonViTrucThucInt = Integer.parseInt(maDonViTrucThuoc);
	            
	            // Thiết lập tham số cho câu lệnh PreparedStatement
	            st.setInt(1,maDuAnInt);
	            st.setInt(2,maDonViTrucThucInt);

	            // Thực thi câu lệnh SQL
	            ketQua += st.executeUpdate();
	        }
			 
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
		public int count_duan_conhoatdong(int manguoidung) {
				
				
				int userCount = 0;
				try {
					// Bước 1: tạo kết nối đến CSDL
					Connection con = JDBCUtil.getConnection();
		
					// Bước 2: tạo ra đối tượng statement
					String sql = "SELECT COUNT(*) FROM bang_duanquocte where trangthaiketthuc=0 and manguoidung=? ";
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1,manguoidung);
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
						 userCount = rs.getInt(1);
					}
					// Bước 4:
				
					
					// Bước 5:
					JDBCUtil.closeConnection(con);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return userCount;
				
			}
		public List<bang_duan_model> count_thongke_duan() {
		    List<bang_duan_model> list = new ArrayList<>();
		    try {
		        // Bước 1: tạo kết nối đến CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: tạo ra đối tượng statement
		        String sql = "SELECT bang_donvitructhuoc.tendonvitructhuoc, \r\n" + 
		        		"       COUNT(*) AS tongso, \r\n" + 
		        		"       SUM(CASE WHEN bang_duanquocte.trangthaiketthuc = 0 THEN 1 ELSE 0 END) AS hoatdong, \r\n" + 
		        		"       SUM(CASE WHEN bang_duanquocte.trangthaiketthuc = 1 THEN 1 ELSE 0 END) AS ketthuc \r\n" + 
		        		"FROM bang_duanquocte \r\n" + 
		        		"LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc = bang_donvitructhuoc.madonvitructhuoc \r\n" + 
		        		"GROUP BY bang_donvitructhuoc.tendonvitructhuoc ";
		        PreparedStatement st = con.prepareStatement(sql);

		        ResultSet rs = st.executeQuery();
		        while (rs.next()) {
		        	 bang_donvitructhuoc_model donvitructhuoc=new bang_donvitructhuoc_model();
					 donvitructhuoc.setTenDonViTrucThuoc(rs.getString("tendonvitructhuoc"));
					
		            int soluong = rs.getInt("tongso");
		            int soluonghd=rs.getInt("hoatdong");
		            int soluongkt=rs.getInt("ketthuc");
		            bang_duan_model tk = new bang_duan_model(soluong,soluonghd,soluongkt,donvitructhuoc);
		            list.add(tk);
		        }
		        // Bước 4:
		        JDBCUtil.closeConnection(con);
		        // Bước 5:
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    } 
		    return list;
		}
		public int count_duan_conhoatdong_dabaocao(int manguoidung) {
			
			
			int userCount = 0;
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();
		
				// Bước 2: tạo ra đối tượng statement
				String sql = "SELECT COUNT(*) FROM bang_duanquocte\r\n" + 
						"WHERE (trangthaiduan=1 OR trangthaiduan=2) AND trangthaiketthuc=0 AND manguoidung=? \r\n" + 
						" ";
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1,manguoidung);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					 userCount = rs.getInt(1);
				}
				// Bước 4:
			
				
				// Bước 5:
				JDBCUtil.closeConnection(con);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return userCount;
			
		}
		
		public int count_duan_conhoatdong_chuabaocao(int manguoidung) {
			
			
			int userCount = 0;
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();
		
				// Bước 2: tạo ra đối tượng statement
				String sql = "SELECT COUNT(*) FROM bang_duanquocte where trangthaiduan=0 AND  trangthaiketthuc=0 AND manguoidung=? ";
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1,manguoidung);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					 userCount = rs.getInt(1);
				}
				// Bước 4:
			
				
				// Bước 5:
				JDBCUtil.closeConnection(con);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return userCount;
			
		}
		
	
		public ArrayList<bang_duan_model> selectVonLon(int manguoidung) {
			ArrayList<bang_duan_model> ketQua = new ArrayList<bang_duan_model>();
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "SELECT bang_duanquocte.tongvonthuchien,bang_duanquocte.tenduan_tiengviet,bang_nhataitro.tennhataitro,bang_donvitiente.tendonvitiente,bang_duanquocte.donvitiente_tongvonthuchien\r\n" + 
						"FROM bang_duanquocte\r\n" + 
						"LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro = bang_nhataitro.manhataitro\r\n" + 
						"LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
						" WHERE manguoidung=? ORDER BY tongvonthuchien DESC LIMIT 5";
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, manguoidung);

				// Bước 3: thực thi câu lệnh SQL
				System.out.println(sql);
				ResultSet rs = st.executeQuery();

				// Bước 4:
				while (rs.next()) {
					 String tenDuAn_TiengViet=rs.getString("tenduan_tiengviet");
					  Float tongVonThucHien=rs.getFloat("tongvonthuchien");
					  bang_donvitiente_model tt=new bang_donvitiente_model();
					  tt.setTenDonViTienTe(rs.getString("tendonvitiente"));
					  
					  
					  bang_nhataitro_model ntt=new bang_nhataitro_model();
						 ntt.setTenNhaTaiTro(rs.getString("tennhataitro"));
						 String donViTienTe_TongVonThucHien=rs.getString("donvitiente_tongvonthuchien");
							bang_duan_model kh = new bang_duan_model(tenDuAn_TiengViet,tongVonThucHien,tt,ntt,donViTienTe_TongVonThucHien);
							ketQua.add(kh);
				}

				// Bước 5:
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ketQua;
		}
		
		public ArrayList<bang_duan_model> selectVonLonAll() {
			ArrayList<bang_duan_model> ketQua = new ArrayList<bang_duan_model>();
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "SELECT  bang_duanquocte.tongvonthuchien,bang_duanquocte.tenduan_tiengviet,bang_nhataitro.tennhataitro,bang_donvitiente.tendonvitiente,bang_donvitructhuoc.tendonvitructhuoc,bang_duanquocte.donvitiente_tongvonthuchien\r\n" + 
						"FROM bang_duanquocte\r\n" + 
						"LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro = bang_nhataitro.manhataitro\r\n" + 
						"LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente \r\n" + 
						"LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc = bang_donvitructhuoc.madonvitructhuoc ORDER BY tongvonthuchien DESC LIMIT 5";
				PreparedStatement st = con.prepareStatement(sql);
			

				// Bước 3: thực thi câu lệnh SQL
				System.out.println(sql);
				ResultSet rs = st.executeQuery();

				// Bước 4:
				while (rs.next()) {
					 bang_donvitructhuoc_model donvitructhuoc=new bang_donvitructhuoc_model();
					 donvitructhuoc.setTenDonViTrucThuoc(rs.getString("tendonvitructhuoc"));
					 String tenDuAn_TiengViet=rs.getString("tenduan_tiengviet");
					  Float tongVonThucHien=rs.getFloat("tongvonthuchien");
					  bang_donvitiente_model tt=new bang_donvitiente_model();
					  tt.setTenDonViTienTe(rs.getString("tendonvitiente"));
					  
					  
					  bang_nhataitro_model ntt=new bang_nhataitro_model();
						 ntt.setTenNhaTaiTro(rs.getString("tennhataitro"));
					String donViTienTe_TongVonThucHien=rs.getString("donvitiente_tongvonthuchien");
							bang_duan_model kh = new bang_duan_model(tenDuAn_TiengViet,tongVonThucHien,donvitructhuoc,tt,ntt,donViTienTe_TongVonThucHien);
							ketQua.add(kh);
				}

				// Bước 5:
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ketQua;
		}



//Cập nhật trạng thái null.

		public int update_danhmuc_null(int madanhmuc) {
			int ketQua = 0;
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "UPDATE bang_duanquocte \r\n" + 
						"SET madanhmuc = 0 \r\n" + 
						"WHERE madanhmuc = ?";

				PreparedStatement st = con.prepareStatement(sql);
				   
				
				   st.setInt(1,madanhmuc);
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
		
		public int update_doitacthuchien_null(int madoitacthuchien) {
			int ketQua = 0;
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "UPDATE bang_duanquocte \r\n" + 
						"SET madoitacthuchien = 0 \r\n" + 
						"WHERE madoitacthuchien = ?";

				PreparedStatement st = con.prepareStatement(sql);
				   
				
				   st.setInt(1,madoitacthuchien);
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
		public int update_coquanpheduyet_null(int macoquanpheduyet) {
			int ketQua = 0;
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "UPDATE bang_duanquocte \r\n" + 
						"SET macoquanpheduyet = 0 \r\n" + 
						"WHERE macoquanpheduyet = ?";

				PreparedStatement st = con.prepareStatement(sql);
				   
				
				   st.setInt(1,macoquanpheduyet);
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
		public int update_donvitiente_null(int madonvitiente) {
			int ketQua = 0;
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "UPDATE bang_duanquocte \r\n" + 
						"SET madonvitiente = 0 \r\n" + 
						"WHERE madonvitiente = ?";

				PreparedStatement st = con.prepareStatement(sql);
				   
				
				   st.setInt(1,madonvitiente);
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
		public int update_donvitructhuoc_null(int madonvitructhuoc) {
			int ketQua = 0;
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "UPDATE bang_duanquocte \r\n" + 
						"SET madonvitructhuoc = NULL \r\n" + 
						"WHERE madonvitructhuoc = ?";

				PreparedStatement st = con.prepareStatement(sql);
				   
				
				   st.setInt(1,madonvitructhuoc);
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
		public int update_loaivientro_null(int maloaivientro) {
			int ketQua = 0;
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "UPDATE bang_duanquocte \r\n" + 
						"SET maloaivientro = 0 \r\n" + 
						"WHERE maloaivientro = ?";

				PreparedStatement st = con.prepareStatement(sql);
				   
				
				   st.setInt(1,maloaivientro);
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
		public int update_nhataitro_null(int manhataitro) {
			int ketQua = 0;
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "UPDATE bang_duanquocte \r\n" + 
						"SET manhataitro = 0 \r\n" + 
						"WHERE manhataitro = ?";

				PreparedStatement st = con.prepareStatement(sql);
				   
				
				   st.setInt(1,manhataitro);
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
