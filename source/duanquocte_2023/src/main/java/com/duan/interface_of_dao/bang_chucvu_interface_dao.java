package com.duan.interface_of_dao;

import java.util.List;

import com.duan.model.bang_chucvu_model;
import com.duan.model.bang_coquanpheduyet_model;
import com.duan.paging.pageble;

public interface bang_chucvu_interface_dao extends generic_dao<bang_chucvu_model> {
	List<bang_chucvu_model> laytoanbodanhsach_dao(pageble pageble1);
	int themchucvu_dao(bang_chucvu_model chucvu);
	bang_chucvu_model laymotchucvu_dao(int chucvu);
	void capnhatchucvu_dao (bang_chucvu_model chucvu);
	void xoachucvu_dao(int machucvu);
	int getTotalItem();
}
