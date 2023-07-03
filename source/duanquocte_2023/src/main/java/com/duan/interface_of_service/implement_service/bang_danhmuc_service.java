package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_danhmuc_interface_dao;
import com.duan.interface_of_service.bang_danhmuc_interface_service;
import com.duan.model.bang_danhmuc_model;
import com.duan.paging.pageble;

public class bang_danhmuc_service implements bang_danhmuc_interface_service {
	@Inject
	private bang_danhmuc_interface_dao duan_dao;

	@Override
	public List<bang_danhmuc_model> laytoanbodanhsach_sv(pageble pageble1) {
		return duan_dao.laytoanbodanhsach_dao(pageble1);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
}
