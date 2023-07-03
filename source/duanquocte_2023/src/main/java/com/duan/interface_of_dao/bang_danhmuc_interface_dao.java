package com.duan.interface_of_dao;

import java.util.List;

import com.duan.model.bang_danhmuc_model;
import com.duan.paging.pageble;

public interface bang_danhmuc_interface_dao {
	List<bang_danhmuc_model> laytoanbodanhsach_dao(pageble pageble1);
bang_danhmuc_model laymotdanhmuc(int madanhmuc);
int getTotalItem();
}
