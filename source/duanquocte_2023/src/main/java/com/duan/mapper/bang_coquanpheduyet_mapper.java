package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_chucvu_model;
import com.duan.model.bang_coquanpheduyet_model;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;

public class bang_coquanpheduyet_mapper  implements row_mapper<bang_coquanpheduyet_model> {

	@Override
	public bang_coquanpheduyet_model maprow(ResultSet rs) {
		bang_coquanpheduyet_model coquanpheduyet=new bang_coquanpheduyet_model();
		try {
			
			coquanpheduyet.setMaCoQuanPheDuyet(rs.getInt("macoquanpheduyet"));
			coquanpheduyet.setTenCoQuanPheDuyet(rs.getString("tencoquanpheduyet"));
			coquanpheduyet.setNgayTao(rs.getTimestamp("ngaytao"));
			coquanpheduyet.setNgayCapNhat(rs.getTimestamp("ngaycapnhat"));
			
			
			return coquanpheduyet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
