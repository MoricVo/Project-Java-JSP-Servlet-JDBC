package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.duan.model.bang_thamgiaduan_model;

public class thamgiaduanDAO implements DAOInterface<bang_thamgiaduan_model> {
	public ArrayList<bang_thamgiaduan_model> data = new ArrayList<>();

	@Override
	public ArrayList<bang_thamgiaduan_model> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public bang_thamgiaduan_model selectById(bang_thamgiaduan_model t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(bang_thamgiaduan_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_thamgiaduan (mathamgia,manguoidung,maduan,ngaythamgia,tinhtrang,ghichu)"
					+ " VALUES (?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaThamGia());
			st.setInt(2,t.getMaNguoiDung());
			st.setInt(3,t.getMaDuAn());
			st.setTimestamp(4,t.getNgayThamGia());
			st.setString(5,t.getTinhTrang());
			st.setString(6,t.getGhiChu());
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
	public int insertAll(ArrayList<bang_thamgiaduan_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}
  
	@Override
	public int delete(bang_thamgiaduan_model t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM bang_thamgiaduan WHERE mathamgia  = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaThamGia());
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<bang_thamgiaduan_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_thamgiaduan_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean kiemTraMaNguoiDungandMaDuAn(int maNguoiDung,int maDuAn) {
		boolean ketQua = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_thamgiaduan WHERE manguoidung=? AND maduan=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,maNguoiDung);
			st.setInt(2,maDuAn);

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
