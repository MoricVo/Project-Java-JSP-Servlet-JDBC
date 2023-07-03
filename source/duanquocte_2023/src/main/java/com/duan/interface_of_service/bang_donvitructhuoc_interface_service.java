package com.duan.interface_of_service;

import java.util.List;

import com.duan.model.bang_donvitructhuoc_model;
import com.duan.paging.pageble;

public interface bang_donvitructhuoc_interface_service {
	List<bang_donvitructhuoc_model> laytoanbodanhsach_sv(pageble pageble1);
	int getTotalItem();
}
