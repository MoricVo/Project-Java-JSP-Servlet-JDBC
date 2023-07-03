package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_doitacthuchien_interface_dao;
import com.duan.interface_of_service.bang_doitacthuchien_interface_service;
import com.duan.model.bang_doitacthuchien_model;
import com.duan.paging.pageble;

public class bang_doitacthuchien_service implements bang_doitacthuchien_interface_service {
	@Inject
	private bang_doitacthuchien_interface_dao doitac_dao;
	@Override
	public List<bang_doitacthuchien_model> laytoanbodanhsach_sv(pageble pageble1) {
		// TODO Auto-generated method stub
		return doitac_dao.laytoanbodanhsach_dao(pageble1);
	}
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return doitac_dao.getTotalItem();
	}

}
