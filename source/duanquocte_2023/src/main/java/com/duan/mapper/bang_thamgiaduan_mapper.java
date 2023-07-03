package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_chucvu_model;
import com.duan.model.bang_danhmuc_model;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.model.bang_thamgiaduan_model;

public class bang_thamgiaduan_mapper implements row_mapper<bang_thamgiaduan_model> {

	@Override
	public bang_thamgiaduan_model maprow(ResultSet rs) {
		bang_thamgiaduan_model thamgiaduan=new bang_thamgiaduan_model();
		try {
			
			thamgiaduan.setMaThamGia(rs.getInt("mathamgia"));
			thamgiaduan.setMaNguoiDung(rs.getInt("manguoidung"));
			thamgiaduan.setMaDuAn(rs.getInt("maduan"));
			thamgiaduan.setNgayThamGia(rs.getTimestamp("ngaythamgia"));
			thamgiaduan.setTinhTrang(rs.getString("tinhtrang"));
			thamgiaduan.setGhiChu(rs.getString("ghichu"));
			
				bang_duan_model duan=new bang_duan_model();
				duan.setTenDuAn_TiengViet(rs.getString("tenduan_tiengviet"));
				
				thamgiaduan.setDuan(duan);
				
				
				bang_nguoidung_model nguoidung=new bang_nguoidung_model();
				nguoidung.setTenNguoiDung(rs.getString("tennguoidung"));
				nguoidung.setAnhDaiDien(rs.getString("anhdaidien"));
				thamgiaduan.setNguoidung(nguoidung);
				
				
			
			return thamgiaduan;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
