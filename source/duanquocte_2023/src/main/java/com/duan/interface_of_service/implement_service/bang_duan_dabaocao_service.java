package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_duan_dabaocao_interface_dao;
import com.duan.interface_of_service.bang_duan_dabaocao_interface_service;
import com.duan.model.bang_duan_dathamgia_model;
import com.duan.paging.pageble;

public class bang_duan_dabaocao_service implements bang_duan_dabaocao_interface_service {
	@Inject
	private bang_duan_dabaocao_interface_dao duan_dao;
	@Override
	public List<bang_duan_dathamgia_model> laytoanbodanhsach_sv(pageble pageble1) {
		 return duan_dao.laytoanbodanhsach_dao(pageble1);
	}
	@Override
	public int getTotalItem() {
		return duan_dao.getTotalItem();
	}
	@Override
	public List<bang_duan_dathamgia_model> laytoanbodanhsach_theoquyvanam_sv(String thuocQuy, String thuocNam) {
		// TODO Auto-generated method stub
		return duan_dao.laytoanbodanhsach_theoquyvanam_dao(thuocQuy, thuocNam);
	}
	@Override
	public List<bang_duan_dathamgia_model> timkiemduan_sv(String tenduan_tiengviet, String tenduan_tienganh) {
		return duan_dao.timkiemduan_dao(tenduan_tiengviet, tenduan_tienganh);
	}
	@Override
	public List<bang_duan_dathamgia_model> laytoanbodanhsach_theomanguoidung_sv(pageble pageble1, int manguoidung) {
		// TODO Auto-generated method stub
		return duan_dao.laytoanbodanhsach_theomanguoidung_dao(pageble1, manguoidung);
	}
	@Override
	public List<bang_duan_dathamgia_model> laytoanbodanhsach_theoquyvanam_theomanguoidung_sv(String thuocQuy,
			String thuocNam, int manguoidung) {
		// TODO Auto-generated method stub
		return duan_dao.laytoanbodanhsach_theoquyvanam_theomanguoidung_dao(thuocQuy, thuocNam, manguoidung);
	}

}
