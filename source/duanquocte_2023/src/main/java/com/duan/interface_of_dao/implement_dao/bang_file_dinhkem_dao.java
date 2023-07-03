package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_file_dinhkem_interface_dao;
import com.duan.mapper.bang_file_dinhkem_mapper;
import com.duan.model.bang_file_dinhkem_model;

public class bang_file_dinhkem_dao extends abstract_dao<bang_file_dinhkem_model> implements bang_file_dinhkem_interface_dao {

	@Override
	public bang_file_dinhkem_model laymotfile_dao(int maduan) {
		StringBuilder sql=new StringBuilder("SELECT * FROM bang_file_dinhkem WHERE maduan=? ");
		 List<bang_file_dinhkem_model>duan=truyvandulieu_generic(sql.toString(),new bang_file_dinhkem_mapper(),maduan);
		 return duan.isEmpty()?null:duan.get(0);
	}

}
