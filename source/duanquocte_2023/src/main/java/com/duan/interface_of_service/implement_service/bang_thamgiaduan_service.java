package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_thamgiaduan_interface_dao;
import com.duan.interface_of_service.bang_thamgiaduan_interface_service;
import com.duan.model.bang_thamgiaduan_model;
import com.duan.paging.pageble;

public class bang_thamgiaduan_service implements bang_thamgiaduan_interface_service {
	 @Inject
	    private bang_thamgiaduan_interface_dao thamgiaduan_dao;
	@Override
	public List<bang_thamgiaduan_model> laytoanbodanhsach_theochuduan_sv(pageble pageble1, int manguoidung) {
		return thamgiaduan_dao.laytoanbodanhsach_theochuduan_dao(pageble1, manguoidung);
	}
	@Override
	public int getTotalItem() {
		return thamgiaduan_dao.getTotalItem();
	}
	@Override
	public List<bang_thamgiaduan_model> laytoanbodanhsach_theoduan_sv(pageble pageble1, int manguoidung) {
		return thamgiaduan_dao.laytoanbodanhsach_theoduan_dao(pageble1, manguoidung);
	}

}
