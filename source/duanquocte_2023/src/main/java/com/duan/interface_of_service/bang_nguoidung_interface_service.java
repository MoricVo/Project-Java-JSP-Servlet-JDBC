package com.duan.interface_of_service;

import java.util.List;


import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public interface bang_nguoidung_interface_service
{
	//load danh sach nguoi dung
	List<bang_nguoidung_model> laytoanbodanhsach_service(pageble pageble1);
	List<bang_nguoidung_model> laytoanbodanhsach_theokhoa_service(pageble pageble1,int maDonViTrucThuoc);
	//load danh sách người dùng theo chức vụ
	List<bang_nguoidung_model>laytoanbodanhsach_theochucvu_service(int machucvu);
	//thêm người dùng
	bang_nguoidung_model themnguoidung_service(bang_nguoidung_model nguoidung);
	bang_nguoidung_model capnhatnguoidung_service(bang_nguoidung_model nguoidung);
	void xoanguoidung_service (int [] manguoidungs);
	int getTotalItem();
	List<bang_nguoidung_model> timkiemnguoidung_sv(String tennguoidung,String gmail,String quyenhan);
	bang_nguoidung_model laytoanbodanhsachtheo_gmail_tennguoidung_matkhau_trangthai(String gmail,String matkhau,Integer trangthai);
	List<bang_nguoidung_model> laytoanbodanhsach_dangbikhoa_sv();
}
