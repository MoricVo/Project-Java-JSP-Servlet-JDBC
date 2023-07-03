package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_lichsucapnhat_interface_dao;
import com.duan.interface_of_service.bang_lichsucapnhat_interface_service;
import com.duan.model.bang_duan_dathamgia_model;
import com.duan.model.bang_lichsucapnhat_model;
import com.duan.paging.pageble;

public class bang_lichsucapnhat_service implements bang_lichsucapnhat_interface_service {
	@Inject
	private bang_lichsucapnhat_interface_dao lichsu_dao;
	@Override
	public List<bang_lichsucapnhat_model> laytoanbodanhsach_sv(pageble pageble1, int maNguoiDung) {
		// TODO Auto-generated method stub
		return lichsu_dao.laytoanbodanhsach_dao(pageble1, maNguoiDung);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<bang_lichsucapnhat_model> timkiemduan_sv(String tenduan_tiengviet, String tenduan_tienganh) {
		// TODO Auto-generated method stub
		return lichsu_dao.timkiemduan_dao(tenduan_tiengviet, tenduan_tienganh);
	}

}
