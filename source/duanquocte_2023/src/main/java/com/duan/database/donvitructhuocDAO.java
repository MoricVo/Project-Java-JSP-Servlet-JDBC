package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.duan.model.bang_danhmuc_model;
import com.duan.model.bang_donvitructhuoc_model;
import com.duan.model.bang_nguoidung_model;

public class donvitructhuocDAO implements DAOInterface<bang_donvitructhuoc_model> {
	public ArrayList<bang_donvitructhuoc_model> data = new ArrayList<>();

	@Override
	public ArrayList<bang_donvitructhuoc_model> selectAll() {
		ArrayList<bang_donvitructhuoc_model> ketQua = new ArrayList<bang_donvitructhuoc_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_donvitructhuoc";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maDonViTrucThuoc = rs.getInt("madonvitructhuoc");
				String tenDonViTrucThuoc = rs.getString("tendonvitructhuoc");
				Timestamp ngaytao  = rs.getTimestamp("ngaytao");

				bang_donvitructhuoc_model kh = new bang_donvitructhuoc_model(maDonViTrucThuoc,tenDonViTrucThuoc,ngaytao,ngaytao);
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
	public bang_donvitructhuoc_model selectById(bang_donvitructhuoc_model t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(bang_donvitructhuoc_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_donvitructhuoc (madonvitructhuoc,tendonvitructhuoc,ngaytao)"
					+ " VALUES (?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaDonViTrucThuoc());
			st.setString(2, t.getTenDonViTrucThuoc());
			st.setTimestamp(3, t.getNgayTao());
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
	public int insertAll(ArrayList<bang_donvitructhuoc_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(bang_donvitructhuoc_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int delete1(int madonvitructhuoc) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM bang_donvitructhuoc WHERE madonvitructhuoc  = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, madonvitructhuoc);
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<bang_donvitructhuoc_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_donvitructhuoc_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
