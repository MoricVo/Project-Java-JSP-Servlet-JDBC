package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_duan_dabaocao_interface_dao;
import com.duan.mapper.bang_duan_dabaocao_mapper;
import com.duan.mapper.bang_duan_mapper;
import com.duan.model.bang_duan_dathamgia_model;
import com.duan.paging.pageble;

public class bang_duan_dabaocao_dao extends abstract_dao<bang_duan_dathamgia_model> implements bang_duan_dabaocao_interface_dao {

	@Override
	public List<bang_duan_dathamgia_model> laytoanbodanhsach_dao(pageble pageble1) {
		StringBuilder sql=new StringBuilder("SELECT * FROM bang_duanquocte_dabaocao ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_dabaocao_mapper());
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT COUNT(*) FROM bang_duanquocte_dabaocao";
		return count(sql);
	}

	@Override
	public List<bang_duan_dathamgia_model> laytoanbodanhsach_theoquyvanam_dao( String thuocQuy,
			String thuocNam) {
		StringBuilder sql=new StringBuilder(" SELECT * FROM bang_duanquocte_dabaocao  WHERE bang_duanquocte_dabaocao.thuocquy=? AND bang_duanquocte_dabaocao.thuocnam=? ");
		 
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_dabaocao_mapper(),thuocQuy,thuocNam);
	}

	@Override
	public List<bang_duan_dathamgia_model> timkiemduan_dao(String tenduan_tiengviet, String tenduan_tienganh) {
			StringBuilder sql=new StringBuilder(" SELECT * FROM bang_duanquocte_dabaocao WHERE tenduantiengviet LIKE ? OR tenduantienganh LIKE ? ");
			 
			
				 return truyvandulieu_generic(sql.toString(),new bang_duan_dabaocao_mapper(),"%"+tenduan_tiengviet+"%","%"+tenduan_tienganh+"%");
	}

	@Override
	public List<bang_duan_dathamgia_model> laytoanbodanhsach_theomanguoidung_dao(pageble pageble1, int manguoidung) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte_dabaocao.*\r\n" + 
				"				FROM bang_duanquocte_dabaocao\r\n" + 
				"				JOIN bang_duanquocte ON bang_duanquocte_dabaocao.maduan = bang_duanquocte.maduan\r\n" + 
				"			   WHERE bang_duanquocte.manguoidung= ? ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_dabaocao_mapper(), manguoidung);
	}

	@Override
	public List<bang_duan_dathamgia_model> laytoanbodanhsach_theoquyvanam_theomanguoidung_dao(String thuocQuy,
			String thuocNam, int manguoidung) {
		StringBuilder sql=new StringBuilder(" SELECT bang_duanquocte_dabaocao.* FROM bang_duanquocte_dabaocao"
				+ " JOIN bang_duanquocte ON bang_duanquocte_dabaocao.maduan = bang_duanquocte.maduan"
				+ "  WHERE bang_duanquocte_dabaocao.thuocquy=? AND bang_duanquocte_dabaocao.thuocnam=? AND bang_duanquocte.manguoidung=?  ");
		 
		
		 return truyvandulieu_generic(sql.toString(),new bang_duan_dabaocao_mapper(),thuocQuy,thuocNam,manguoidung);
	}

}
