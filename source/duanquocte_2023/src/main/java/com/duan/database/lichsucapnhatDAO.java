package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.duan.model.bang_lichsucapnhat_model;

public class lichsucapnhatDAO  implements DAOInterface<bang_lichsucapnhat_model>{

	@Override
	public ArrayList<bang_lichsucapnhat_model> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public bang_lichsucapnhat_model selectById(bang_lichsucapnhat_model t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(bang_lichsucapnhat_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_lichsucapnhat (malichsucapnhat,maduan,manguoidung,ngaycapnhat)"
					+ " VALUES (?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaLichSuCapNhat());
			st.setInt(2,t.getMaDuAn());
			st.setInt(3,t.getMaNguoiDung());
			st.setTimestamp(4,t.getNgayCapNhat());
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
	public int insertAll(ArrayList<bang_lichsucapnhat_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(bang_lichsucapnhat_model t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<bang_lichsucapnhat_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_lichsucapnhat_model t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
