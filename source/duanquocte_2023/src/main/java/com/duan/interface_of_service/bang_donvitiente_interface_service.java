package com.duan.interface_of_service;

import java.util.List;

import com.duan.model.bang_donvitiente_model;
import com.duan.paging.pageble;

public interface bang_donvitiente_interface_service {
	List<bang_donvitiente_model> laytoanbodanhsach_sv(pageble pageble1);
	int getTotalItem();
}
