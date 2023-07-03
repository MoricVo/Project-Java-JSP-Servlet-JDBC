package com.duan.interface_of_dao;

import java.util.List;

import com.duan.model.bang_duan_model;
import com.duan.model.bang_thamgiaduan_model;
import com.duan.paging.pageble;

public interface bang_thamgiaduan_interface_dao  extends generic_dao<bang_thamgiaduan_model> 
{
	List<bang_thamgiaduan_model> laytoanbodanhsach_dao(pageble pageble1);
	List<bang_thamgiaduan_model>laytoanbodanhsach_theochuduan_dao(pageble pageble1,int manguoidung);
	List<bang_thamgiaduan_model>laytoanbodanhsach_theoduan_dao(pageble pageble1,int manguoidung);
	int getTotalItem();
}
