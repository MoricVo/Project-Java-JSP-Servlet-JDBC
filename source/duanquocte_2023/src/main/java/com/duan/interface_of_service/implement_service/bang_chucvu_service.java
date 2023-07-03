package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_chucvu_interface_dao;
import com.duan.interface_of_service.bang_chucvu_interface_service;
import com.duan.interface_of_service.bang_coquanpheduyet_interface_service;
import com.duan.model.bang_chucvu_model;
import com.duan.paging.pageble;

public class bang_chucvu_service implements bang_chucvu_interface_service  {
    @Inject
    bang_chucvu_interface_dao chucvu_dao;
	@Override
	public List<bang_chucvu_model> laytoanbodanhsach_sv(pageble pageble1) {
		return chucvu_dao.laytoanbodanhsach_dao(pageble1);
	}

	@Override
	public int themchucvu_sv(bang_chucvu_model chucvu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public bang_chucvu_model laymotchucvu_sv(int chucvu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void capnhatchucvu_sv(bang_chucvu_model chucvu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoachucvu_sv(int machucvu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
