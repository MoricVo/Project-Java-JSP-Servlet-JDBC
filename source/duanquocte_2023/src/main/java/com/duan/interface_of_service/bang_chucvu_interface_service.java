package com.duan.interface_of_service;

import java.util.List;

import com.duan.model.bang_chucvu_model;
import com.duan.model.bang_coquanpheduyet_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public interface bang_chucvu_interface_service {
	List<bang_chucvu_model> laytoanbodanhsach_sv(pageble pageble1);
	int themchucvu_sv(bang_chucvu_model chucvu);
	bang_chucvu_model laymotchucvu_sv(int chucvu);
	void capnhatchucvu_sv (bang_chucvu_model chucvu);
	void xoachucvu_sv(int machucvu);
	int getTotalItem();
}
