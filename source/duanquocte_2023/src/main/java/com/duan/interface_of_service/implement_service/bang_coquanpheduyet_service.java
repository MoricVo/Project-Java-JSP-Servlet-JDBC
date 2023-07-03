package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_coquanpheduyet_interface_dao;
import com.duan.interface_of_service.bang_coquanpheduyet_interface_service;
import com.duan.model.bang_coquanpheduyet_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public class bang_coquanpheduyet_service implements bang_coquanpheduyet_interface_service  {
	@Inject
	private bang_coquanpheduyet_interface_dao coquanpheduyet_dao;

	@Override
	public List<bang_coquanpheduyet_model> laytoanbodanhsach_sv(pageble pageble1) {
		return coquanpheduyet_dao.laytoanbodanhsach_dao(pageble1);
		
	}

	@Override
	public int themcoquan_dao(bang_coquanpheduyet_model coquan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public bang_nguoidung_model laymotnguoidung_dao(int coquan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void capnhatnguoidung_dao(bang_coquanpheduyet_model coquan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoanguoidung_dao(int manguoidung) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalItem() {
		 return coquanpheduyet_dao.getTotalItem();
	}
	

}
