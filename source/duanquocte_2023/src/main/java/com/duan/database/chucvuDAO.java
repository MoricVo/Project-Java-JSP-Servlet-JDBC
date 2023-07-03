package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.duan.model.bang_chucvu_model;


public class chucvuDAO implements DAOInterface<bang_chucvu_model> {
	public ArrayList<bang_chucvu_model> data = new ArrayList<>();

	@Override
	public ArrayList<bang_chucvu_model> selectAll() {
		ArrayList<bang_chucvu_model> ketQua = new ArrayList<bang_chucvu_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_chucvu";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int machucvu = rs.getInt("machucvu");
				String tenchucvu = rs.getString("tenchucvu");

				bang_chucvu_model kh = new bang_chucvu_model(machucvu,tenchucvu);
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
	public bang_chucvu_model selectById(bang_chucvu_model t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(bang_chucvu_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_chucvu (machucvu,tenchucvu,ngaytao)"
					+ " VALUES (?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMachucvu());
			st.setString(2, t.getTenchucvu());
			st.setTimestamp(3, t.getNgaytao());
			
			
			
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
	public int insertAll(ArrayList<bang_chucvu_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(bang_chucvu_model t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<bang_chucvu_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int delete1(int machucvu) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM bang_chucvu WHERE machucvu  = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, machucvu);
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(bang_chucvu_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
