package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_donvitiente_interface_dao;
import com.duan.interface_of_service.bang_donvitiente_interface_service;
import com.duan.model.bang_donvitiente_model;
import com.duan.paging.pageble;

public class bang_donvitiente_service implements bang_donvitiente_interface_service {
	@Inject
	private bang_donvitiente_interface_dao donvitiente_dao;
	@Override
	public List<bang_donvitiente_model> laytoanbodanhsach_sv(pageble pageble1) {
		return donvitiente_dao.laytoanbodanhsach_dao(pageble1);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
