package com.duan.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.duan.model.bang_donvitructhuoc_model;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;

public class nguoidungDAO implements DAOInterface<bang_nguoidung_model> {
	public ArrayList<bang_nguoidung_model> data = new ArrayList<>();

	@Override
	public ArrayList<bang_nguoidung_model> selectAll() {
	  ArrayList<bang_nguoidung_model> ketQua = new ArrayList<bang_nguoidung_model>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_nguoidung";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maNguoiDung = rs.getInt("manguoidung");
				int maChucVu = rs.getInt("machucvu");
				String hoNguoiDung = rs.getString("honguoidung");
				String tenNguoiDung = rs.getString("tennguoidung");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diachi");
				String gmail = rs.getString("gmail");
			
				String anhDaiDien=rs.getString("anhdaidien");
				bang_nguoidung_model nguoidung = new bang_nguoidung_model(maNguoiDung,maChucVu,hoNguoiDung,tenNguoiDung,sdt, diaChi,gmail,
						 "","",1,anhDaiDien);
				ketQua.add(nguoidung);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	public ArrayList<bang_nguoidung_model> selectAll_ByManager() {
		  ArrayList<bang_nguoidung_model> ketQua = new ArrayList<bang_nguoidung_model>();
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "SELECT bang_nguoidung.*,bang_donvitructhuoc.tendonvitructhuoc"
						+ " FROM bang_nguoidung   "
						+ "LEFT JOIN bang_donvitructhuoc ON bang_nguoidung.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc "
						+ " where quyenhan='manager'";
				PreparedStatement st = con.prepareStatement(sql);

				// Bước 3: thực thi câu lệnh SQL
				System.out.println(sql);
				ResultSet rs = st.executeQuery();

				// Bước 4:
				while (rs.next()) {
					int maNguoiDung = rs.getInt("manguoidung");
					int maChucVu = rs.getInt("machucvu");
					String hoNguoiDung = rs.getString("honguoidung");
					String tenNguoiDung = rs.getString("tennguoidung");
					String sdt = rs.getString("sdt");
					String diaChi = rs.getString("diachi");
					String gmail = rs.getString("gmail");
					String anhDaiDien=rs.getString("anhdaidien");
					  bang_donvitructhuoc_model duan=new bang_donvitructhuoc_model();
					   duan.setTenDonViTrucThuoc(rs.getString("tendonvitructhuoc"));
					  
					bang_nguoidung_model nguoidung = new bang_nguoidung_model(maNguoiDung,maChucVu,hoNguoiDung,tenNguoiDung,sdt, diaChi,gmail,
							 "","",1,anhDaiDien,duan);
					ketQua.add(nguoidung);
				}

				// Bước 5:
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ketQua;
		}
	public ArrayList<bang_nguoidung_model> selectAll_ByUser(int madonvitructhuoc) {
		  ArrayList<bang_nguoidung_model> ketQua = new ArrayList<bang_nguoidung_model>();
			try {
				// Bước 1: tạo kết nối đến CSDL
				Connection con = JDBCUtil.getConnection();

				// Bước 2: tạo ra đối tượng statement
				String sql = "SELECT bang_nguoidung.*,bang_donvitructhuoc.tendonvitructhuoc"
						+ " FROM bang_nguoidung   "
						+ "LEFT JOIN bang_donvitructhuoc ON bang_nguoidung.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc "
						+ " where bang_nguoidung.quyenhan='user' AND bang_nguoidung.madonvitructhuoc=? ";
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, madonvitructhuoc);
				// Bước 3: thực thi câu lệnh SQL
				System.out.println(sql);
				ResultSet rs = st.executeQuery();

				// Bước 4:
				while (rs.next()) {
					int maNguoiDung = rs.getInt("manguoidung");
					int maChucVu = rs.getInt("machucvu");
					String hoNguoiDung = rs.getString("honguoidung");
					String tenNguoiDung = rs.getString("tennguoidung");
					String sdt = rs.getString("sdt");
					String diaChi = rs.getString("diachi");
					String gmail = rs.getString("gmail");
					String anhDaiDien=rs.getString("anhdaidien");
					  bang_donvitructhuoc_model duan=new bang_donvitructhuoc_model();
					   duan.setTenDonViTrucThuoc(rs.getString("tendonvitructhuoc"));
					  
					bang_nguoidung_model nguoidung = new bang_nguoidung_model(maNguoiDung,maChucVu,hoNguoiDung,tenNguoiDung,sdt, diaChi,gmail,
							 "","",1,anhDaiDien,duan);
					ketQua.add(nguoidung);
				}

				// Bước 5:
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ketQua;
		}
	public boolean changePassword(bang_nguoidung_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_nguoidung " + " SET "  + " matkhau=?" + " WHERE manguoidung=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMatKhau());
			st.setInt(2, t.getMaNguoiDung());
		
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

		return ketQua>0;
	}
	public boolean changePasswordIfForgotPass(bang_nguoidung_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_nguoidung " + " SET "  + " matkhau=?" + " WHERE gmail=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMatKhau());
			st.setString(2, t.getGmail());
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

		return ketQua>0;
	}
	

	@Override
	public bang_nguoidung_model selectById(bang_nguoidung_model t) {
		bang_nguoidung_model ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_nguoidung WHERE manguoidung=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaNguoiDung());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maNguoiDung = rs.getInt("manguoidung");
				int maDonViTrucThuoc=rs.getInt("madonvitructhuoc");
				int maChucVu = rs.getInt("machucvu");
				String hoNguoiDung = rs.getString("honguoidung");
				String tenNguoiDung = rs.getString("tennguoidung");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diachi");
				String gmail = rs.getString("gmail");
				String anhDaiDien=rs.getString("anhdaidien");
				String maXacThuc=rs.getString("maxacthuc_gmail");
				Boolean trangThaiXacThuc=rs.getBoolean("trangthaixacthuc");
				Timestamp thoiGianHieuLuc=rs.getTimestamp("thoiGianHieuLuc");
				
				ketQua = new bang_nguoidung_model(maNguoiDung,maDonViTrucThuoc,maChucVu,hoNguoiDung,tenNguoiDung,sdt, diaChi,gmail,
						anhDaiDien,maXacThuc,trangThaiXacThuc,thoiGianHieuLuc);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public bang_nguoidung_model timkiem_nguoidung(bang_nguoidung_model t) {
		bang_nguoidung_model ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_nguoidung WHERE tennguoidung LIKE ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + t.getTenNguoiDung() + "%");

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maNguoiDung = rs.getInt("manguoidung");
				String tenNguoiDung = rs.getString("tennguoidung");
				ketQua = new bang_nguoidung_model(maNguoiDung,tenNguoiDung);
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
	public int insert(bang_nguoidung_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_nguoidung (manguoidung,madonvitructhuoc,machucvu,honguoidung,tennguoidung,gmail,matkhau)"
					+ " VALUES (?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaNguoiDung());
			st.setInt(2,t.getMaDonViTrucThuoc());
			st.setInt(3,t.getMaChucVu());
			st.setString(4, t.getHoNguoiDung());
			st.setString(5, t.getTenNguoiDung());
			
			
			st.setString(6, t.getGmail());
			st.setString(7, t.getMatKhau());
	        

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
	public int insert_nguoidung2(bang_nguoidung_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO bang_nguoidung (manguoidung,madonvitructhuoc,machucvu,honguoidung,tennguoidung,gmail,matkhau,quyenhan,trangthai)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaNguoiDung());
			st.setInt(2,t.getMaDonViTrucThuoc());
			st.setInt(3,t.getMaChucVu());
			st.setString(4, t.getHoNguoiDung());
			st.setString(5, t.getTenNguoiDung());
			
			
			st.setString(6, t.getGmail());
			st.setString(7, t.getMatKhau());
			st.setString(8, t.getQuyenHan());
			st.setInt(9, t.getTrangThai());
	        

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
	public int insertAll(ArrayList<bang_nguoidung_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(bang_nguoidung_model t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<bang_nguoidung_model> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(bang_nguoidung_model t) {
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean kiemTraGmail(String gmail) {
		boolean ketQua = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_nguoidung WHERE gmail=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, gmail);

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
	
	public int updateInfo(bang_nguoidung_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_nguoidung " + " SET "+ " machucvu=?" + ", honguoidung=?" + ", tennguoidung=?"
					+ ", sdt=?" + ", diachi=?" + ", gmail=?" +" , anhdaidien=? " + " WHERE manguoidung=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getMaChucVu());
			st.setString(2, t.getHoNguoiDung());
			st.setString(3, t.getTenNguoiDung());
			st.setString(4, t.getSdt());
			st.setString(5, t.getDiaChi());
			st.setString(6, t.getGmail());
			st.setString(7, t.getAnhDaiDien());
			st.setInt(8, t.getMaNguoiDung());
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
	public int updateVeryfyAndInformation(bang_nguoidung_model t) {
		
		
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_nguoidung " + " SET "+ " maxacthuc_gmail=?" + ", trangthaixacthuc=?" + ", thoigianhieuluc=?"
					 + " WHERE manguoidung=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaXacThuc());
			st.setBoolean(2, t.getTrangThaiXacThuc());
			st.setTimestamp(3, t.getThoiGianHieuLuc());
			st.setInt(4, t.getMaNguoiDung());
			
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
public int count_account_notveryfy() {
		
		
		int userCount = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT COUNT(*) FROM bang_nguoidung where trangthai=0 ";
			PreparedStatement st = con.prepareStatement(sql);
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
	public bang_nguoidung_model selectByGmailAndPassWord(bang_nguoidung_model t)
	{
		bang_nguoidung_model ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM bang_nguoidung WHERE gmail=? and matkhau=? ";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(t.getGmail()+"/"+t.getMatKhau());
			st.setString(1, t.getGmail());
			st.setString(2, t.getMatKhau());
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int maNguoiDung = rs.getInt("manguoidung");
				int maChucVu = rs.getInt("machucvu");
				int maDonViTrucThuoc=rs.getInt("madonvitructhuoc");
				String hoNguoiDung = rs.getString("honguoidung");
				String tenNguoiDung = rs.getString("tennguoidung");
				String sdt = rs.getString("sdt");
				String diaChi = rs.getString("diachi");
				String gmail = rs.getString("gmail");
				String matkhau = rs.getString("matkhau");
				String anhDaiDien=rs.getString("anhdaidien");
				ketQua = new bang_nguoidung_model(maNguoiDung,maDonViTrucThuoc,maChucVu,hoNguoiDung,tenNguoiDung,sdt, diaChi,gmail,
						 matkhau,"",1,anhDaiDien);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public int updateImage(bang_nguoidung_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_nguoidung " + " SET " + " anhdaidien=?"  +  " WHERE manguoidung=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getAnhDaiDien());
			st.setInt(2, t.getMaNguoiDung());
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
	public int update_trangthai_nguoidung_0(bang_nguoidung_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_nguoidung \r\n" + 
					"SET trangthai = 0 \r\n" + 
					"WHERE manguoidung = ?";

			PreparedStatement st = con.prepareStatement(sql);
			   
			
			   st.setInt(1,t.getMaNguoiDung());
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
	public int update_trangthai_nguoidung_1(bang_nguoidung_model t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_nguoidung \r\n" + 
					"SET trangthai = 1 \r\n" + 
					"WHERE manguoidung = ?";

			PreparedStatement st = con.prepareStatement(sql);
			   
			
			   st.setInt(1,t.getMaNguoiDung());
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
			String sql = "UPDATE bang_nguoidung \r\n" + 
					"SET madonvitructhuoc = 0 \r\n" + 
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
	public int update_chucvu_null(int machucvu) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE bang_nguoidung \r\n" + 
					"SET machucvu = 0 \r\n" + 
					"WHERE machucvu = ?";

			PreparedStatement st = con.prepareStatement(sql);
			   
			
			   st.setInt(1,machucvu);
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
