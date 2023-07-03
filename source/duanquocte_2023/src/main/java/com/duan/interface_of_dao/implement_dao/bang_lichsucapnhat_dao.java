package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_lichsucapnhat_interface_dao;
import com.duan.mapper.bang_duan_dabaocao_mapper;
import com.duan.mapper.bang_lichsucapnhat_mapper;
import com.duan.model.bang_lichsucapnhat_model;
import com.duan.paging.pageble;

public class bang_lichsucapnhat_dao extends abstract_dao<bang_lichsucapnhat_model> implements bang_lichsucapnhat_interface_dao {

	@Override
	public List<bang_lichsucapnhat_model> laytoanbodanhsach_dao(pageble pageble1,int maNguoiDung) {
		StringBuilder sql=new StringBuilder("SELECT bang_lichsucapnhat.*, bang_duanquocte.tenduan_tiengviet, bang_duanquocte.tenduan_tienganh, bang_danhmuc.tendanhmuc,bang_donvitructhuoc.tendonvitructhuoc,bang_nguoidung.tennguoidung \r\n" + 
				"				FROM bang_lichsucapnhat\r\n" + 
				"				JOIN bang_duanquocte ON bang_lichsucapnhat.maduan = bang_duanquocte.maduan\r\n" + 
				"				JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"				JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc = bang_donvitructhuoc.madonvitructhuoc \r\n" + 
				"				JOIN bang_nguoidung ON bang_lichsucapnhat.manguoidung = bang_nguoidung.manguoidung WHERE bang_duanquocte.manguoidung=? ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_lichsucapnhat_mapper(),maNguoiDung);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<bang_lichsucapnhat_model> timkiemduan_dao(String tenduan_tiengviet, String tenduan_tienganh) {
		StringBuilder sql=new StringBuilder(" SELECT bang_lichsucapnhat.*, bang_duanquocte.tenduan_tiengviet, bang_duanquocte.tenduan_tienganh, bang_danhmuc.tendanhmuc,bang_donvitructhuoc.tendonvitructhuoc,bang_nguoidung.tennguoidung\r\n" + 
				"FROM bang_lichsucapnhat\r\n" + 
				"JOIN bang_duanquocte ON bang_lichsucapnhat.maduan = bang_duanquocte.maduan\r\n" + 
				"JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc = bang_donvitructhuoc.madonvitructhuoc\r\n" + 
				"JOIN bang_nguoidung ON bang_lichsucapnhat.manguoidung = bang_nguoidung.manguoidung WHERE bang_duanquocte.tenduan_tiengviet LIKE ? OR bang_duanquocte.tenduan_tienganh LIKE ? ");
		 
		
			 return truyvandulieu_generic(sql.toString(),new bang_lichsucapnhat_mapper(),"%"+tenduan_tiengviet+"%","%"+tenduan_tienganh+"%");
	}

}
