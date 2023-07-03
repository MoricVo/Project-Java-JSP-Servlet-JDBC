package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_chucvu_model;
import com.duan.model.bang_chucvu_model;

public class bang_chucvu_mapper implements row_mapper<bang_chucvu_model>
{

	@Override
	public bang_chucvu_model maprow(ResultSet rs) {
		bang_chucvu_model chucvu=new bang_chucvu_model();
		try {
			
			chucvu.setMachucvu(rs.getInt("machucvu"));
			chucvu.setTenchucvu(rs.getString("tenchucvu"));			
			return chucvu;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
