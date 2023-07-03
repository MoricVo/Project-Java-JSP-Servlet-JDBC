package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_donvitiente_model;

public class bang_donvtiente_mapper implements row_mapper<bang_donvitiente_model> {

	@Override
	public bang_donvitiente_model maprow(ResultSet rs) {
		bang_donvitiente_model coquanpheduyet=new bang_donvitiente_model();
		try {
			
			coquanpheduyet.setMaDonViTienTe(rs.getInt("madonvitiente"));
			coquanpheduyet.setTenDonViTienTe(rs.getString("tendonvitiente"));
			coquanpheduyet.setNgayTao(rs.getTimestamp("ngaytao"));
			coquanpheduyet.setNgayCapNhat(rs.getTimestamp("ngaycapnhat"));
			
			return coquanpheduyet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
