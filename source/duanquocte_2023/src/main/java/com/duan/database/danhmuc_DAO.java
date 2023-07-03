package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.duan.model.bang_danhmuc_model;
import com.duan.model.bang_nguoidung_model;

public class danhmuc_DAO implements DAOInterface<bang_danhmuc_model>  {
	public ArrayList<bang_danhmuc_model> data = new ArrayList<>();

	@Override
	public ArrayList<bang_danhmuc_model> selectAll() {
		ArrayList<bang_danhmuc_model> ketQua = new ArrayList<bang_danhmuc_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_danhmuc";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maDanhMuc = rs.getInt("madanhmuc");
				String tenDanhMuc = rs.getString("tendanhmuc");
				Timestamp ngaytao  = rs.getTimestamp("ngaytao");

				bang_danhmuc_model kh = new bang_danhmuc_model(maDanhMuc, tenDanhMuc,ngaytao);
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
	public ArrayList<bang_danhmuc_model> selectAll(int nguoitao) {
		ArrayList<bang_danhmuc_model> ketQua = new ArrayList<bang_danhmuc_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_danhmuc where nguoitao=? OR madanhmuc = 0";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,nguoitao);
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maDanhMuc = rs.getInt("madanhmuc");
				String tenDanhMuc = rs.getString("tendanhmuc");
				Timestamp ngaytao  = rs.getTimestamp("ngaytao");

				bang_danhmuc_model kh = new bang_danhmuc_model(maDanhMuc, tenDanhMuc,ngaytao);
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

	@Override
	public bang_danhmuc_model selectById(bang_danhmuc_model t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(bang_danhmuc_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_danhmuc (madanhmuc,tendanhmuc,ngaytao,nguoitao)"
					+ " VALUES (?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaDanhMuc());
			st.setString(2, t.getTenDanhMuc());
			st.setTimestamp(3, t.getNgayTao());
			st.setInt(4, t.getNguoiTao());
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
	public int insertAll(ArrayList<bang_danhmuc_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}
   
	@Override
	public int delete(bang_danhmuc_model t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM bang_danhmuc WHERE madanhmuc  = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaDanhMuc());
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	public int delete1(int madanhmuc) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM bang_danhmuc WHERE madanhmuc  = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, madanhmuc);
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<bang_danhmuc_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_danhmuc_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
