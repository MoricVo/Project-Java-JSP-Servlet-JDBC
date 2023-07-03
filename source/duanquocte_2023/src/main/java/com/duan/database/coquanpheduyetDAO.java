package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.duan.model.bang_coquanpheduyet_model;
import com.duan.model.bang_donvitructhuoc_model;


public class coquanpheduyetDAO implements DAOInterface<bang_coquanpheduyet_model> {
	public ArrayList<bang_coquanpheduyet_model> data = new ArrayList<>();

	@Override
	public ArrayList<bang_coquanpheduyet_model> selectAll() {
		ArrayList<bang_coquanpheduyet_model> ketQua = new ArrayList<bang_coquanpheduyet_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_coquanpheduyet";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maCoQuanPheDuyet = rs.getInt("macoquanpheduyet");
				String tenCoQuanPheDuyet = rs.getString("tencoquanpheduyet");
                
				bang_coquanpheduyet_model kh = new bang_coquanpheduyet_model(maCoQuanPheDuyet,tenCoQuanPheDuyet);
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
	public ArrayList<bang_coquanpheduyet_model> selectAll(int nguoitao) {
		ArrayList<bang_coquanpheduyet_model> ketQua = new ArrayList<bang_coquanpheduyet_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_coquanpheduyet where nguoitao=? OR macoquanpheduyet = 0";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,nguoitao);
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maCoQuanPheDuyet = rs.getInt("macoquanpheduyet");
				String tenCoQuanPheDuyet = rs.getString("tencoquanpheduyet");
                
				bang_coquanpheduyet_model kh = new bang_coquanpheduyet_model(maCoQuanPheDuyet,tenCoQuanPheDuyet);
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
	public bang_coquanpheduyet_model selectById(bang_coquanpheduyet_model t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(bang_coquanpheduyet_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_coquanpheduyet (macoquanpheduyet,tencoquanpheduyet,ngaytao,nguoitao)"
					+ " VALUES (?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaCoQuanPheDuyet());
			st.setString(2, t.getTenCoQuanPheDuyet());
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
	public int insertAll(ArrayList<bang_coquanpheduyet_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(bang_coquanpheduyet_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int delete1(int macoquanpheduyet) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM bang_coquanpheduyet WHERE macoquanpheduyet  = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,macoquanpheduyet);
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<bang_coquanpheduyet_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_coquanpheduyet_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
