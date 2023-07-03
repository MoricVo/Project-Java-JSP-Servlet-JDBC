package com.duan.interface_of_service;

import java.util.List;

import com.duan.model.bang_nhataitro_model;
import com.duan.paging.pageble;

public interface bang_nhataitro_interface_service {
	List<bang_nhataitro_model> laytoanbodanhsach_sv(pageble pageble1);
	int getTotalItem();
}
