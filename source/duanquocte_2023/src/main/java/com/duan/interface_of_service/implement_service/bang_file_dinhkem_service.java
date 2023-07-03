package com.duan.interface_of_service.implement_service;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_file_dinhkem_interface_dao;
import com.duan.interface_of_service.bang_file_dinhkem_interface_service;
import com.duan.model.bang_file_dinhkem_model;

public class bang_file_dinhkem_service implements bang_file_dinhkem_interface_service {
	@Inject
	private bang_file_dinhkem_interface_dao file_dk;
	@Override
	public bang_file_dinhkem_model laymotfile_sv(int maduan) {
		// TODO Auto-generated method stub
		return file_dk.laymotfile_dao(maduan);
	}

}
