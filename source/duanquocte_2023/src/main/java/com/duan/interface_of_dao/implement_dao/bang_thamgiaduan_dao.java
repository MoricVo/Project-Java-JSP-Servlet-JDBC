package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_thamgiaduan_interface_dao;
import com.duan.mapper.bang_duan_mapper;
import com.duan.mapper.bang_thamgiaduan_mapper;
import com.duan.model.bang_thamgiaduan_model;
import com.duan.paging.pageble;

public class bang_thamgiaduan_dao extends abstract_dao<bang_thamgiaduan_model> implements bang_thamgiaduan_interface_dao {

	@Override
	public List<bang_thamgiaduan_model> laytoanbodanhsach_dao(pageble pageble1) {
		return null;
	}

	@Override
	public List<bang_thamgiaduan_model> laytoanbodanhsach_theochuduan_dao(pageble pageble1, int manguoidung) {
		StringBuilder sql=new StringBuilder("SELECT bang_thamgiaduan.*, bang_nguoidung.tennguoidung AS tennguoidung,bang_nguoidung.anhdaidien AS anhdaidien, bang_duanquocte.tenduan_tiengviet AS tenduan_tiengviet\r\n" + 
				"FROM bang_thamgiaduan\r\n" + 
				"LEFT JOIN bang_nguoidung ON bang_thamgiaduan.manguoidung = bang_nguoidung.manguoidung\r\n" + 
				"LEFT JOIN bang_duanquocte ON bang_thamgiaduan.maduan = bang_duanquocte.maduan\r\n" + 
				"WHERE bang_duanquocte.maduan IN (\r\n" + 
				"    SELECT bang_duanquocte.maduan \r\n" + 
				"    FROM bang_duanquocte \r\n" + 
				"    WHERE bang_duanquocte.manguoidung =? \r\n" + 
				") ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_thamgiaduan_mapper(),manguoidung);
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT COUNT(*) FROM bang_thamgiaduan";
		return count(sql);
	}

	@Override
	public List<bang_thamgiaduan_model> laytoanbodanhsach_theoduan_dao(pageble pageble1, int manguoidung) {
		StringBuilder sql=new StringBuilder("SELECT \r\n" + 
				"    bang_thamgiaduan.*, \r\n" + 
				"    bang_duanquocte.tenduan_tiengviet AS tenduan_tiengviet,\r\n" + 
				"    bang_nguoidung.tennguoidung AS tennguoidung,bang_nguoidung.anhdaidien AS anhdaidien\r\n" + 
				"FROM bang_thamgiaduan \r\n" + 
				"LEFT JOIN bang_duanquocte ON bang_thamgiaduan.maduan = bang_duanquocte.maduan \r\n" + 
				"LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung = bang_nguoidung.manguoidung \r\n" + 
				"WHERE bang_thamgiaduan.manguoidung = ? ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_thamgiaduan_mapper(),manguoidung);
	}

}
