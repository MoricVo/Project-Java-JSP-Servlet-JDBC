package com.duan.interface_of_dao;

import java.util.List;

import com.duan.model.bang_donvitiente_model;
import com.duan.paging.pageble;

public interface bang_donvitiente_interface_dao {
	List<bang_donvitiente_model> laytoanbodanhsach_dao(pageble pageble1);
	int getTotalItem();
}
