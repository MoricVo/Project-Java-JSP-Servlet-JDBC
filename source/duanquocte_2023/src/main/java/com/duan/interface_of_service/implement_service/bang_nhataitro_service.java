package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_nhataitro_interface_dao;
import com.duan.interface_of_service.bang_nhataitro_interface_service;
import com.duan.model.bang_nhataitro_model;
import com.duan.paging.pageble;

public class bang_nhataitro_service  implements bang_nhataitro_interface_service {
	@Inject
	private bang_nhataitro_interface_dao nhataitro_dao;
	@Override
	public List<bang_nhataitro_model> laytoanbodanhsach_sv(pageble pageble1) {
		// TODO Auto-generated method stub
		return nhataitro_dao.laytoanbodanhsach_dao(pageble1);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
