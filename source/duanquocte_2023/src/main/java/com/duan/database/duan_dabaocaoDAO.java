package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

import com.duan.model.bang_duan_dathamgia_model;
import com.duan.model.bang_duan_model;

public class duan_dabaocaoDAO implements DAOInterface<bang_duan_dathamgia_model> {

	@Override
	public ArrayList<bang_duan_dathamgia_model> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public bang_duan_dathamgia_model selectById(bang_duan_dathamgia_model t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(bang_duan_dathamgia_model t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<bang_duan_dathamgia_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(bang_duan_dathamgia_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int delete1(int maduan_dabaocao) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM bang_duanquocte_dabaocao WHERE maduan_dabaocao  = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, maduan_dabaocao);
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}


	@Override
	public int deleteAll(ArrayList<bang_duan_dathamgia_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_duan_dathamgia_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int InsertAll(String[] thuoctinh) {
		int ketQua = 0;
		try {
			
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_duanquocte_dabaocao (maduan_dabaocao,maduan,chuduan,tendonvitructhuoc,tendanhmuc,tennhataitro,tenloaivientro,tencoquanpheduyet,tendoitacthuchien,tenduantiengviet,tenduantienganh,thanhvienthamgia,muctieuduan,noidungthuchien,thietbitaitro,kinhphinamtruoc,tongvonthuchien,vontaitro,vonvay,vonkhac,vondoiung,tendonvitiente,thoigianthuchien,thoigianbatdau,thoigianketthuc,tiendothuchien,phantramtiendo,thuocquy,thuocnam,donvitientevontaitro,donvitientevonvay,donvitientevonkhac,donvitientevondoiung,donvitientetongvonthuchien) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			   
		    // Bước 3: Thực hiện lặp qua từng mã bài viết và thực hiện cập nhật
	        for (String Cacthuoctinh : thuoctinh) {
	        	  String[] ids = Cacthuoctinh.split("\\|\\|");
	        	  String maDuAn = ids[0];
	        	  String tenNguoiDung = ids[1];
	        	  String tenDonViTrucThuoc = ids[2];
	        	  String tenDanhMuc = ids[3];
	        	  String tenNhaTaiTro = ids[4];
	        	  String tenLoaiVienTro = ids[5];
	        	  String tenCoQuanPheDuyet = ids[6];
	        	  String tenDoiTacThucHien = ids[7];
	        	  String tenDuAn_TiengViet = ids[8];
	        	  String tenDuAn_TiengAnh = ids[9];
	        	  String thanhVienThamGia = ids[10];
	        	  String  mucTieuDuAn = ids[11];
	        	  String noiDungThucHien= ids[12];
	        	  String thietBiTaiTro = ids[13];
	        	  String kinhPhiNamTruoc = ids[14];
	        	  String tongVonThucHien = ids[15];
	        	  String vonTaiTro = ids[16];
	        	  String vonVay = ids[17];
	        	  String vonKhac = ids[18];
	        	  String vonDoiUng = ids[19];
	        	  String  tenDonViTienTe = ids[20];
	        	  String thoiGianThucHien = ids[21];
	        	  String thoiGianBatDau = ids[22];
	        	  String thoiGianKetThuc = ids[23];
	        	  String tienDoThucHien = ids[24];
	        	  String phanTramTienDoThucHien = ids[25];
	        	  String donViTienTeVonTaiTro=ids[26];
	        	  String donViTienTeVonVay=ids[27];
	        	  String donViTienTeVonKhac=ids[28];
	        	  String donViTienTeVonDoiUng=ids[29];
	        	  String donViTienTeTongVonThucHien=ids[30];
	        	  String thuocQuy = ids[31];
	        	  String thuocNam = ids[32];
	        	 
	        	  Timestamp Tthoigianbatdau = null;
				  Timestamp Tthoigianketthuc = null;
					

					 try {
					     if (thoiGianBatDau != null && !thoiGianBatDau.isEmpty()) {
					        
					        
					         Tthoigianbatdau = Timestamp.valueOf(thoiGianBatDau);
					     }
					     
					     if (thoiGianKetThuc != null && !thoiGianKetThuc.isEmpty()) {
					     

					         Tthoigianketthuc = Timestamp.valueOf(thoiGianKetThuc);
					     }
					   
					 } catch (IllegalArgumentException e) {
					     System.out.println("Loi: " + e.getMessage());
					 }
	            // Chuyển đổi mã bài viết từ kiểu String sang kiểu int
	        	    Random r = new Random();
					int maDuAn_DaBaoCao =r.nextInt(90000);
	        	    int maDuAnInt = Integer.parseInt(maDuAn);
	              if(this.kiemTraMaDuAn(maDuAnInt,thuocQuy,thuocNam))
	              {
	            	  continue;
	              }
	              else if(this.kiemTraMaDuAn_DaBaoCao_DaTonTai(maDuAn_DaBaoCao)==false)
	              {
	            	st.setInt(1,maDuAn_DaBaoCao);
	  	            st.setInt(2,maDuAnInt);
	  	            st.setString(3,tenNguoiDung);
	  	            st.setString(4,tenDonViTrucThuoc);
			  	    st.setString(5,tenDanhMuc);
			  	    st.setString(6,tenNhaTaiTro);
			  	    st.setString(7,tenLoaiVienTro);
			  	    st.setString(8,tenCoQuanPheDuyet);
			  	    st.setString(9,tenDoiTacThucHien);
			  	    st.setString(10,tenDuAn_TiengViet);
			  	    st.setString(11,tenDuAn_TiengAnh);
			  	    st.setString(12,thanhVienThamGia);
			  	    st.setString(13,mucTieuDuAn);
			  	    st.setString(14,noiDungThucHien);
			  	    st.setString(15,thietBiTaiTro);
			  	    st.setString(16,kinhPhiNamTruoc);
			  	    st.setString(17,tongVonThucHien);
			  	    st.setString(18,vonTaiTro);
			  	    st.setString(19,vonVay);
			  	    st.setString(20,vonKhac);
			  	    st.setString(21,vonDoiUng);
			  	    st.setString(22,tenDonViTienTe);
			  	    st.setString(23,thoiGianThucHien);
			  	    st.setTimestamp(24,Tthoigianbatdau);
			  	    st.setTimestamp(25,Tthoigianketthuc);
			  	    st.setString(26,tienDoThucHien);
			  	    st.setString(27,phanTramTienDoThucHien);
	  	            st.setString(28,thuocQuy);
	  	            st.setString(29,thuocNam);
	  	            st.setString(30,donViTienTeVonTaiTro);
	  	            st.setString(31,donViTienTeVonVay);
	  	            st.setString(32,donViTienTeVonKhac);
	  	            st.setString(33,donViTienTeVonDoiUng);
	  	            st.setString(34,donViTienTeTongVonThucHien);
	  	            
	  	         
	  	            

	  	            // Thực thi câu lệnh SQL
	  	            ketQua += st.executeUpdate();
		  	      				
	              }
	              else
	              {
	            	  int maDuAn_DaBaoCao2 = r.nextInt(90000);
	            	  st.setInt(1,maDuAn_DaBaoCao2);
		  	            st.setInt(2,maDuAnInt);
		  	            st.setString(3,tenNguoiDung);
		  	            st.setString(4,tenDonViTrucThuoc);
				  	    st.setString(5,tenDanhMuc);
				  	    st.setString(6,tenNhaTaiTro);
				  	    st.setString(7,tenLoaiVienTro);
				  	    st.setString(8,tenCoQuanPheDuyet);
				  	    st.setString(9,tenDoiTacThucHien);
				  	    st.setString(10,tenDuAn_TiengViet);
				  	    st.setString(11,tenDuAn_TiengAnh);
				  	    st.setString(12,thanhVienThamGia);
				  	    st.setString(13,mucTieuDuAn);
				  	    st.setString(14,noiDungThucHien);
				  	    st.setString(15,thietBiTaiTro);
				  	    st.setString(16,kinhPhiNamTruoc);
				  	    st.setString(17,tongVonThucHien);
				  	    st.setString(18,vonTaiTro);
				  	    st.setString(19,vonVay);
				  	    st.setString(20,vonKhac);
				  	    st.setString(21,vonDoiUng);
				  	    st.setString(22,tenDonViTienTe);
				  	    st.setString(23,thoiGianThucHien);
				  	    st.setTimestamp(24,Tthoigianbatdau);
				  	    st.setTimestamp(25,Tthoigianketthuc);
				  	    st.setString(26,tienDoThucHien);
				  	    st.setString(27,phanTramTienDoThucHien);
		  	            st.setString(28,thuocQuy);
		  	            st.setString(29,thuocNam);
		  	            st.setString(30,donViTienTeVonTaiTro);
		  	            st.setString(31,donViTienTeVonVay);
		  	            st.setString(32,donViTienTeVonKhac);
		  	            st.setString(33,donViTienTeVonDoiUng);
		  	            st.setString(34,donViTienTeTongVonThucHien);
		  	         
		  	            

		  	            // Thực thi câu lệnh SQL
		  	            ketQua += st.executeUpdate();
			  	      
	              }
	           
	          
	        }
	        JDBCUtil.closeConnection(con);
			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");
			 
			// Bước 3: thực thi câu lệnh SQL

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public boolean kiemTraMaDuAn_DaBaoCao_DaTonTai(int maduan) {
	    boolean ketQua = false;
	    try {
	        // Bước 1: tạo kết nối đến CSDL
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: tạo ra đối tượng statement
	        String sql = "SELECT maduan_dabaocao FROM bang_duanquocte_dabaocao WHERE maduan_dabaocao = ?";
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
	public boolean kiemTraMaDuAn(int maDuAn,String thuocQuy,String thuocNam) {
		boolean ketQua = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_duanquocte_dabaocao WHERE maduan=? AND thuocquy=? AND thuocnam=?";
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setInt(1,maDuAn);
            st.setString(2,thuocQuy);
            st.setString(3,thuocNam);
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
	

}
