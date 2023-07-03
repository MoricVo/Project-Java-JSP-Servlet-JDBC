package com.duan.interface_of_dao;

import java.util.List;

import com.duan.model.bang_lichsucapnhat_model;
import com.duan.paging.pageble;

public interface bang_lichsucapnhat_interface_dao {
	List<bang_lichsucapnhat_model> laytoanbodanhsach_dao(pageble pageble1,int maNguoiDung);
	int getTotalItem();
	List<bang_lichsucapnhat_model> timkiemduan_dao(String tenduan_tiengviet,String tenduan_tienganh);
}
