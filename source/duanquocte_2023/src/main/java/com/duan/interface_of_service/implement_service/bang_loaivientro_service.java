package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_loaivientro_interface_dao;
import com.duan.interface_of_service.bang_loaivientro_interface_service;
import com.duan.model.bang_loaivientro_model;
import com.duan.paging.pageble;

public class bang_loaivientro_service implements bang_loaivientro_interface_service {
	@Inject
	private bang_loaivientro_interface_dao loaivientro_dao;
	@Override
	public List<bang_loaivientro_model> laytoanbodanhsach_sv(pageble pageble1) {
		// TODO Auto-generated method stub
		return loaivientro_dao.laytoanbodanhsach_dao(pageble1);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
