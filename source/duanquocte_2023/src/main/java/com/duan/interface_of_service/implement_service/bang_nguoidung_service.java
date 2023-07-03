package com.duan.interface_of_service.implement_service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_nguoidung_interface_dao;
import com.duan.interface_of_dao.implement_dao.bang_nguoidung_dao;
import com.duan.interface_of_service.bang_nguoidung_interface_service;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public class bang_nguoidung_service implements bang_nguoidung_interface_service {

	@Inject
	private bang_nguoidung_interface_dao nguoidung_dao;
	@Override
	public List<bang_nguoidung_model> laytoanbodanhsach_service(pageble pageble1) {
		// TODO Auto-generated method stub
		return nguoidung_dao.laytoanbodanhsach_dao(pageble1);
	}
	@Override
	public List<bang_nguoidung_model> laytoanbodanhsach_theochucvu_service(int machucvu) {
		
		return nguoidung_dao.laytoanbodanhsach_theochucvu_dao(machucvu);
	}
	@Override
	public bang_nguoidung_model themnguoidung_service(bang_nguoidung_model nguoidung) 
	{
		nguoidung.setNgayLap(new Timestamp(System.currentTimeMillis()));
		nguoidung.setNgayCapNhat(new Timestamp(System.currentTimeMillis()));
		int manguoidung= nguoidung_dao.themnguoidung_dao(nguoidung);		
		return nguoidung_dao.laymotnguoidung_dao(manguoidung);
		
	}
	@Override
	public bang_nguoidung_model capnhatnguoidung_service(bang_nguoidung_model nguoidung) {
		bang_nguoidung_model old_nguoidung = nguoidung_dao.laymotnguoidung_dao(nguoidung.getMaNguoiDung());
		nguoidung.setNgayLap(old_nguoidung.getNgayLap());
		nguoidung.setNgayCapNhat(old_nguoidung.getNgayCapNhat());
		nguoidung_dao.capnhatnguoidung_dao(nguoidung);
		return nguoidung_dao.laymotnguoidung_dao(nguoidung.getMaNguoiDung());
	}
	@Override
	public void xoanguoidung_service(int[] manguoidungs) {
		for(int manguoidung:manguoidungs)
		{
			nguoidung_dao.xoanguoidung_dao(manguoidung);
		}
		
	}
	@Override
	public int getTotalItem() {
	
		return nguoidung_dao.getTotalItem();
	}
	@Inject 
	private bang_nguoidung_interface_dao i_nguoidung_dao;
	@Override
	public bang_nguoidung_model laytoanbodanhsachtheo_gmail_tennguoidung_matkhau_trangthai(String gmail,
			 String matkhau, Integer trangthai) {
		
		return i_nguoidung_dao.laytoanbodanhsachtheo_gmail_tennguoidung_matkhau_trangthai(gmail, matkhau, trangthai);
	}
	@Override
	public List<bang_nguoidung_model> timkiemnguoidung_sv(String tennguoidung, String gmail, String quyenhan) {
		// TODO Auto-generated method stub
		return i_nguoidung_dao.timkiemnguoidung_dao(tennguoidung, gmail, quyenhan);
	}
	@Override
	public List<bang_nguoidung_model> laytoanbodanhsach_theokhoa_service(pageble pageble1, int maDonViTrucThuoc) {
		return i_nguoidung_dao.laytoanbodanhsach_theokhoa_dao(pageble1, maDonViTrucThuoc);
	}
	@Override
	public List<bang_nguoidung_model> laytoanbodanhsach_dangbikhoa_sv() {
		// TODO Auto-generated method stub
		return i_nguoidung_dao.laytoanbodanhsach_dangbikhoa_dao();
	}
	
	
	

	

}
