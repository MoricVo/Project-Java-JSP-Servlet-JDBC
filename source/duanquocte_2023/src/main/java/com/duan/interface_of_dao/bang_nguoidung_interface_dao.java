package com.duan.interface_of_dao;

import java.util.List;

import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public interface bang_nguoidung_interface_dao extends generic_dao<bang_nguoidung_model>
{
	List<bang_nguoidung_model> laytoanbodanhsach_dao(pageble pageble1);
	List<bang_nguoidung_model> laytoanbodanhsach_theokhoa_dao(pageble pageble1,int maDonViTrucThuoc);
	List<bang_nguoidung_model>laytoanbodanhsach_theochucvu_dao(int machucvu);
	int themnguoidung_dao(bang_nguoidung_model nguoidung);
	bang_nguoidung_model laymotnguoidung_dao(int manguoidung);
	void capnhatnguoidung_dao (bang_nguoidung_model nguoidung);
	void xoanguoidung_dao(int manguoidung);
	int getTotalItem();
	bang_nguoidung_model laytoanbodanhsachtheo_gmail_tennguoidung_matkhau_trangthai(String gmail,String matkhau,Integer trangthai);
	List<bang_nguoidung_model> timkiemnguoidung_dao(String tennguoidung,String gmail,String quyenhan);
	List<bang_nguoidung_model> laytoanbodanhsach_dangbikhoa_dao();
}
