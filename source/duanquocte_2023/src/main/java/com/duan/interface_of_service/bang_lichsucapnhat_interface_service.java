package com.duan.interface_of_service;

import java.util.List;

import com.duan.model.bang_duan_dathamgia_model;
import com.duan.model.bang_lichsucapnhat_model;
import com.duan.paging.pageble;

public interface bang_lichsucapnhat_interface_service {
	List<bang_lichsucapnhat_model> laytoanbodanhsach_sv(pageble pageble1,int maNguoiDung);
	int getTotalItem();
	List<bang_lichsucapnhat_model> timkiemduan_sv(String tenduan_tiengviet,String tenduan_tienganh);
}
