package com.duan.interface_of_service;

import java.util.List;

import com.duan.model.bang_thamgiaduan_model;
import com.duan.paging.pageble;

public interface bang_thamgiaduan_interface_service {
	List<bang_thamgiaduan_model>laytoanbodanhsach_theochuduan_sv(pageble pageble1,int manguoidung);
	int getTotalItem();
	List<bang_thamgiaduan_model>laytoanbodanhsach_theoduan_sv(pageble pageble1,int manguoidung);
}
