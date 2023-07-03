package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_nhataitro_model;

public class bang_nhataitro_mapper implements row_mapper<bang_nhataitro_model> {

	@Override
	public bang_nhataitro_model maprow(ResultSet rs) {
		bang_nhataitro_model coquanpheduyet=new bang_nhataitro_model();
		try {
			
			coquanpheduyet.setMaNhaTaiTro(rs.getInt("manhataitro"));
			coquanpheduyet.setTenNhaTaiTro(rs.getString("tennhataitro"));
			coquanpheduyet.setNgayTao(rs.getTimestamp("ngaytao"));
			coquanpheduyet.setNgayCapNhat(rs.getTimestamp("ngaycapnhat"));
			return coquanpheduyet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
