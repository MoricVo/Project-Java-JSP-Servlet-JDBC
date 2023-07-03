package com.duan.interface_of_dao;

import java.util.List;

import com.duan.model.bang_donvitructhuoc_model;
import com.duan.paging.pageble;

public interface bang_donvitructhuoc_interface_dao {
	List<bang_donvitructhuoc_model> laytoanbodanhsach_dao(pageble pageble1);
	int getTotalItem();
}
