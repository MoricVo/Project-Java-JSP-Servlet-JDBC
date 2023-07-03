package com.duan.interface_of_dao;

import java.util.List;

import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public interface bang_duan_interface_dao extends generic_dao<bang_duan_model>
{
	List<bang_duan_model> laytoanbodanhsach_dao(pageble pageble1);
	List<bang_duan_model> laytoanbodanhsach_ketthuc_dao(pageble pageble1);
	List<bang_duan_model> laytoanbodanhsach_dangtrienkhai_dao();
	List<bang_duan_model> laytoanbodanhsach_dangtrienkhai_theokhoa_dao(int madonvitructhuoc);
	List<bang_duan_model> laytoanbodanhsach_theoquyvanam_dao(pageble pageble1,String thuocquy,String thuocnam);
	List<bang_duan_model>laytoanbodanhsach_theomanguoidung_dao(pageble pageble1,int manguoidung);
	List<bang_duan_model>laytoanbodanhsach_theokhoa_dao(pageble pageble1,int madonvitructhuoc);
	List<bang_duan_model>locduan_theodonvitructhuoc(int madonvitructhuoc);
	List<bang_duan_model>locduan_theotrangthai(int manguoidung, int trangthaiketthuc);
	int themduan_dao(bang_duan_model duan);
	bang_duan_model laymotduan_dao(int maduan);
	void capnhatduan_dao (bang_duan_model maduan);
	void xoaduan_dao(int maduan);
	int getTotalItem();
	
	
	
	List<bang_duan_model> timkiemduan_dao(String tenduan_tiengviet,String tenduan_tienganh);
}
