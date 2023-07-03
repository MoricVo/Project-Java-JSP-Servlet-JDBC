package com.duan.interface_of_service;

import java.util.List;

import com.duan.model.bang_duan_dathamgia_model;
import com.duan.model.bang_duan_model;
import com.duan.paging.pageble;

public interface bang_duan_dabaocao_interface_service {
	List<bang_duan_dathamgia_model> laytoanbodanhsach_sv(pageble pageble1);
	List<bang_duan_dathamgia_model> laytoanbodanhsach_theomanguoidung_sv(pageble pageble1,int manguoidung);
      List<bang_duan_dathamgia_model> laytoanbodanhsach_theoquyvanam_sv(String thuocQuy,String thuocNam);
      List<bang_duan_dathamgia_model> laytoanbodanhsach_theoquyvanam_theomanguoidung_sv(String thuocQuy,String thuocNam,int manguoidung);
	int getTotalItem();
	List<bang_duan_dathamgia_model> timkiemduan_sv(String tenduan_tiengviet,String tenduan_tienganh);
}
