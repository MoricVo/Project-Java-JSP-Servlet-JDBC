package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_coquanpheduyet_model;
import com.duan.model.bang_danhmuc_model;

public class bang_danhmuc_mapper implements row_mapper<bang_danhmuc_model> {

	@Override
	public bang_danhmuc_model maprow(ResultSet rs) {
		bang_danhmuc_model coquanpheduyet=new bang_danhmuc_model();
		try {
			
			coquanpheduyet.setMaDanhMuc(rs.getInt("madanhmuc"));
			coquanpheduyet.setTenDanhMuc(rs.getString("tendanhmuc"));
			coquanpheduyet.setNgayTao(rs.getTimestamp("ngaytao"));
			coquanpheduyet.setNgayCapNhat(rs.getTimestamp("ngaycapnhat"));
			
			return coquanpheduyet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
