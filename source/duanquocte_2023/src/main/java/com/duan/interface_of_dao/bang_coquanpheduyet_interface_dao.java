package com.duan.interface_of_dao;

import java.util.List;

import com.duan.model.bang_coquanpheduyet_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public interface bang_coquanpheduyet_interface_dao extends generic_dao<bang_coquanpheduyet_model>
{
	List<bang_coquanpheduyet_model> laytoanbodanhsach_dao(pageble pageble1);
	int themcoquan_dao(bang_coquanpheduyet_model coquan);
	bang_coquanpheduyet_model laymotnguoidung_dao(int coquan);
	void capnhatnguoidung_dao (bang_coquanpheduyet_model coquan);
	void xoanguoidung_dao(int manguoidung);
	int getTotalItem();
	
	
}
