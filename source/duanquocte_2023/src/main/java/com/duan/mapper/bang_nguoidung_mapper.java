package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_chucvu_model;
import com.duan.model.bang_donvitructhuoc_model;
import com.duan.model.bang_nguoidung_model;

public class bang_nguoidung_mapper implements row_mapper<bang_nguoidung_model> {

	@Override
	public bang_nguoidung_model maprow(ResultSet rs) {
		bang_nguoidung_model nguoidung1=new bang_nguoidung_model();
		try {
			nguoidung1.setMaNguoiDung(rs.getInt("manguoidung"));
			nguoidung1.setMaChucVu(rs.getInt("machucvu"));
			nguoidung1.setMaDonViTrucThuoc(rs.getInt("madonvitructhuoc"));
			nguoidung1.setHoNguoiDung(rs.getString("honguoidung"));
			nguoidung1.setTenNguoiDung(rs.getString("tennguoidung"));
			nguoidung1.setSdt(rs.getString("sdt"));
			nguoidung1.setDiaChi(rs.getString("diachi"));
			nguoidung1.setGmail(rs.getString("gmail"));
			nguoidung1.setMatKhau(rs.getString("matkhau"));
			nguoidung1.setQuyenHan(rs.getString("quyenhan"));
			nguoidung1.setTrangThai(rs.getInt("trangthai"));
			nguoidung1.setAnhDaiDien(rs.getString("anhdaidien"));
			nguoidung1.setNgayLap(rs.getTimestamp("ngaylap"));
			nguoidung1.setNgayCapNhat(rs.getTimestamp("ngaycapnhat"));
			nguoidung1.setTrangThaiXacThuc(rs.getBoolean("trangthaixacthuc"));
			try
			{
				bang_chucvu_model chucvu=new bang_chucvu_model();
				chucvu.setTenchucvu(rs.getString("tenchucvu"));
				nguoidung1.setBangchucvu(chucvu);
				
				bang_donvitructhuoc_model donvitructhuoc=new bang_donvitructhuoc_model();
				donvitructhuoc.setTenDonViTrucThuoc(rs.getString("tendonvitructhuoc"));
				nguoidung1.setDonvitructhuoc(donvitructhuoc);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
			return nguoidung1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	
	}

	

}
