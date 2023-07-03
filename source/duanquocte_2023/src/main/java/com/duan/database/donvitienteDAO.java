package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.duan.model.bang_danhmuc_model;
import com.duan.model.bang_donvitiente_model;


public class donvitienteDAO implements DAOInterface<bang_donvitiente_model> {
	public ArrayList<bang_donvitiente_model> data = new ArrayList<>();

	@Override
	public ArrayList<bang_donvitiente_model> selectAll() {
		ArrayList<bang_donvitiente_model> ketQua = new ArrayList<bang_donvitiente_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_donvitiente";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maDonViTienTe = rs.getInt("madonvitiente");
				String tenDonViTienTe = rs.getString("tendonvitiente");
				Timestamp ngaytao  = rs.getTimestamp("ngaytao");

				bang_donvitiente_model kh = new bang_donvitiente_model(maDonViTienTe,tenDonViTienTe,ngaytao,ngaytao);
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
	public bang_donvitiente_model selectById(bang_donvitiente_model t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(bang_donvitiente_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_donvitiente (madonvitiente,tendonvitiente,ngaytao)"
					+ " VALUES (?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaDonViTienTe());
			st.setString(2, t.getTenDonViTienTe());
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
	public int insertAll(ArrayList<bang_donvitiente_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(bang_donvitiente_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int delete1(int madonvitiente) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM bang_donvitiente WHERE madonvitiente  = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, madonvitiente);
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<bang_donvitiente_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_donvitiente_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
