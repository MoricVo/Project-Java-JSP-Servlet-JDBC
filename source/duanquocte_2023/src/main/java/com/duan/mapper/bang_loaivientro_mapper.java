package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_loaivientro_model;

public class bang_loaivientro_mapper implements row_mapper<bang_loaivientro_model> {

	@Override
	public bang_loaivientro_model maprow(ResultSet rs) {
		bang_loaivientro_model coquanpheduyet=new bang_loaivientro_model();
		try {
			
			coquanpheduyet.setMaLoaiVienTro(rs.getInt("maloaivientro"));
			coquanpheduyet.setTenLoaiVienTro(rs.getString("tenloaivientro"));
			coquanpheduyet.setNgayTao(rs.getTimestamp("ngaytao"));
			coquanpheduyet.setNgayCapNhat(rs.getTimestamp("ngaycapnhat"));
			return coquanpheduyet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
