package com.duan.interface_of_service.implement_service;

import java.util.List;

import javax.inject.Inject;

import com.duan.interface_of_dao.bang_danhmuc_interface_dao;
import com.duan.interface_of_dao.bang_duan_interface_dao;
import com.duan.interface_of_dao.bang_nguoidung_interface_dao;
import com.duan.interface_of_service.bang_duan_interface_service;
import com.duan.interface_of_service.bang_nguoidung_interface_service;
import com.duan.model.bang_danhmuc_model;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public class bang_duan_service implements bang_duan_interface_service {

	@Inject
	private bang_duan_interface_dao duan_dao;
    @Inject
    private bang_danhmuc_interface_dao danhmuc_dao;
	@Override
	public List<bang_duan_model> laytoanbodanhsach_sv(pageble pageble1) {
		return duan_dao.laytoanbodanhsach_dao(pageble1);
		
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_theomanguoidung_sv(pageble pageble1,int manguoidung) {
		 return duan_dao.laytoanbodanhsach_theomanguoidung_dao(pageble1, manguoidung);
	}

	@Override
	public int themduan_sv(bang_duan_model duan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public bang_duan_model laymotduan_sv(int maduan) {
		bang_duan_model duan=duan_dao.laymotduan_dao(maduan);
		bang_danhmuc_model danhmuc=danhmuc_dao.laymotdanhmuc(duan.getMaDanhMuc());
		duan.setMaDuAn(duan.getMaDuAn());
		return duan;
	}

	@Override
	public void capnhatduan_sv(bang_duan_model maduan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoaduan_sv(int maduan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalItem() {
		return duan_dao.getTotalItem();
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_dangtrienkhai_sv() {
		return duan_dao.laytoanbodanhsach_dangtrienkhai_dao();
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_theoquyvanam_sv(pageble pageble1, String thuocquy, String thuocnam) {
		 return duan_dao.laytoanbodanhsach_theoquyvanam_dao(pageble1,thuocquy,thuocnam);
	}

	@Override
	public List<bang_duan_model> timkiemduan_sv(String tenduan_tiengviet, String tenduan_tienganh) {
		return duan_dao.timkiemduan_dao(tenduan_tiengviet, tenduan_tienganh);
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_theokhoa_sv(pageble pageble1, int madonvitructhuoc) {
		return duan_dao.laytoanbodanhsach_theokhoa_dao(pageble1, madonvitructhuoc);
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_dangtrienkhai_theokhoa_sv( int madonvitructhuoc) {
		return duan_dao.laytoanbodanhsach_dangtrienkhai_theokhoa_dao( madonvitructhuoc);
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_ketthuc_sv(pageble pageble1) {
		// TODO Auto-generated method stub
		return duan_dao.laytoanbodanhsach_ketthuc_dao(pageble1);
	}

	@Override
	public List<bang_duan_model> locduan_theodonvitructhuoc_sv( int madonvitructhuoc) {
		 return duan_dao.locduan_theodonvitructhuoc( madonvitructhuoc);
	}

	@Override
	public List<bang_duan_model> locduan_theotrangthai_sv(int manguoidung, int trangthaiketthuc) {
		// TODO Auto-generated method stub
		return duan_dao.locduan_theotrangthai( manguoidung,trangthaiketthuc);
	}

}
