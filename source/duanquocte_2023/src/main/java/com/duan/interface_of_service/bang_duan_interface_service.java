package com.duan.interface_of_service;

import java.util.List;

import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public interface bang_duan_interface_service
{
	List<bang_duan_model> laytoanbodanhsach_sv(pageble pageble1);
	List<bang_duan_model> laytoanbodanhsach_ketthuc_sv(pageble pageble1);
	List<bang_duan_model> laytoanbodanhsach_theoquyvanam_sv(pageble pageble1,String thuocquy,String thuocnam);
	List<bang_duan_model> laytoanbodanhsach_dangtrienkhai_sv();
	List<bang_duan_model> laytoanbodanhsach_dangtrienkhai_theokhoa_sv(int madonvitructhuoc);
	List<bang_duan_model>laytoanbodanhsach_theomanguoidung_sv(pageble pageble1,int manguoidung);
	List<bang_duan_model>laytoanbodanhsach_theokhoa_sv(pageble pageble1,int madonvitructhuoc);
	int themduan_sv(bang_duan_model duan);
	bang_duan_model laymotduan_sv(int maduan);
	void capnhatduan_sv (bang_duan_model maduan);
	void xoaduan_sv(int maduan);
	int getTotalItem();
	List<bang_duan_model>locduan_theodonvitructhuoc_sv(int madonvitructhuoc);
	List<bang_duan_model>locduan_theotrangthai_sv(int manguoidung,int trangthaiketthuc);
	List<bang_duan_model> timkiemduan_sv(String tenduan_tiengviet,String tenduan_tienganh);
}
