package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_donvitructhuoc_model;

public class bang_donvitructhuoc_mapper implements row_mapper<bang_donvitructhuoc_model> {

	@Override
	public bang_donvitructhuoc_model maprow(ResultSet rs) {
		bang_donvitructhuoc_model coquanpheduyet=new bang_donvitructhuoc_model();
		try {
			
			coquanpheduyet.setMaDonViTrucThuoc(rs.getInt("madonvitructhuoc"));
			coquanpheduyet.setTenDonViTrucThuoc(rs.getString("tendonvitructhuoc"));
			coquanpheduyet.setNgayTao(rs.getTimestamp("ngaytao"));
			coquanpheduyet.setNgayCapNhat(rs.getTimestamp("ngaycapnhat"));
			
			return coquanpheduyet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
