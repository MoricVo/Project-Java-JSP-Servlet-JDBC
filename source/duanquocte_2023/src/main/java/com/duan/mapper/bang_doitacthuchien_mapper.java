package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_doitacthuchien_model;



public class bang_doitacthuchien_mapper implements row_mapper<bang_doitacthuchien_model>  {

	@Override
	public bang_doitacthuchien_model maprow(ResultSet rs) {
		bang_doitacthuchien_model coquanpheduyet=new bang_doitacthuchien_model();
		try {
			
			coquanpheduyet.setMaDoiTacThucHien(rs.getInt("madoitac"));
			coquanpheduyet.setTenDoiTacThucHien(rs.getString("tendoitac"));
			coquanpheduyet.setNgayTao(rs.getTimestamp("ngaytao"));
			coquanpheduyet.setNgayCapNhat(rs.getTimestamp("ngaycapnhat"));
			
			return coquanpheduyet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}


}
