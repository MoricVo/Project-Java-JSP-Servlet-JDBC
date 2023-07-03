package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_donvitructhuoc_interface_dao;
import com.duan.interface_of_service.bang_donvitructhuoc_interface_service;
import com.duan.model.bang_donvitructhuoc_model;
import com.duan.paging.pageble;

public class bang_donvitructhuoc_service implements bang_donvitructhuoc_interface_service {
	@Inject
	private bang_donvitructhuoc_interface_dao donvitiente_dao;
	@Override
	public List<bang_donvitructhuoc_model> laytoanbodanhsach_sv(pageble pageble1) {
		// TODO Auto-generated method stub
		return donvitiente_dao.laytoanbodanhsach_dao(pageble1);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
