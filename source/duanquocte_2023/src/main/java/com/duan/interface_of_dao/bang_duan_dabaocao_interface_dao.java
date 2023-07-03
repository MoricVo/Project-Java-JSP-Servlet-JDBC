package com.duan.interface_of_dao;

import java.util.List;

import com.duan.model.bang_duan_dathamgia_model;
import com.duan.model.bang_duan_model;
import com.duan.paging.pageble;

public interface bang_duan_dabaocao_interface_dao extends generic_dao<bang_duan_dathamgia_model>  {
	List<bang_duan_dathamgia_model> laytoanbodanhsach_dao(pageble pageble1);
	List<bang_duan_dathamgia_model> laytoanbodanhsach_theomanguoidung_dao(pageble pageble1,int manguoidung);
    List<bang_duan_dathamgia_model>laytoanbodanhsach_theoquyvanam_dao(String thuocQuy,String thuocNam);
    List<bang_duan_dathamgia_model>laytoanbodanhsach_theoquyvanam_theomanguoidung_dao(String thuocQuy,String thuocNam,int manguoidung);
	int getTotalItem();
	List<bang_duan_dathamgia_model> timkiemduan_dao(String tenduan_tiengviet,String tenduan_tienganh);
}
