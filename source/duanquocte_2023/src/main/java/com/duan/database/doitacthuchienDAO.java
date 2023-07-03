package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.duan.model.bang_doitacthuchien_model;
import com.duan.model.bang_donvitructhuoc_model;


public class doitacthuchienDAO implements DAOInterface<bang_doitacthuchien_model>
{
	public ArrayList<bang_doitacthuchien_model> data = new ArrayList<>();

	@Override
	public ArrayList<bang_doitacthuchien_model> selectAll() {
		ArrayList<bang_doitacthuchien_model> ketQua = new ArrayList<bang_doitacthuchien_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_doitacthuchien ";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maDoiTacThucHien = rs.getInt("madoitac");
				String tenDoiTacThucHien = rs.getString("tendoitac");
				Timestamp ngaytao  = rs.getTimestamp("ngaytao");

				bang_doitacthuchien_model kh = new bang_doitacthuchien_model(maDoiTacThucHien,tenDoiTacThucHien,ngaytao,ngaytao);
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
	public ArrayList<bang_doitacthuchien_model> selectAll(int nguoitao) {
		ArrayList<bang_doitacthuchien_model> ketQua = new ArrayList<bang_doitacthuchien_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_doitacthuchien where nguoitao=? OR madoitac = 0";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,nguoitao);
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maDoiTacThucHien = rs.getInt("madoitac");
				String tenDoiTacThucHien = rs.getString("tendoitac");
				Timestamp ngaytao  = rs.getTimestamp("ngaytao");

				bang_doitacthuchien_model kh = new bang_doitacthuchien_model(maDoiTacThucHien,tenDoiTacThucHien,ngaytao,ngaytao);
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
	public bang_doitacthuchien_model selectById(bang_doitacthuchien_model t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(bang_doitacthuchien_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_doitacthuchien (madoitac,tendoitac,ngaytao,nguoitao)"
					+ " VALUES (?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaDoiTacThucHien());
			st.setString(2, t.getTenDoiTacThucHien());
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
	public int insertAll(ArrayList<bang_doitacthuchien_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(bang_doitacthuchien_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int delete1(int madoitac) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM bang_doitacthuchien WHERE madoitac  = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,madoitac);
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<bang_doitacthuchien_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_doitacthuchien_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
