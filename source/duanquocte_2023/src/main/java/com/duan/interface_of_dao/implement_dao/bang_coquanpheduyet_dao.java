package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_coquanpheduyet_interface_dao;
import com.duan.interface_of_dao.bang_duan_interface_dao;
import com.duan.mapper.bang_coquanpheduyet_mapper;
import com.duan.mapper.bang_duan_mapper;
import com.duan.model.bang_coquanpheduyet_model;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public class bang_coquanpheduyet_dao extends abstract_dao<bang_coquanpheduyet_model> implements bang_coquanpheduyet_interface_dao {

	@Override
	public List<bang_coquanpheduyet_model> laytoanbodanhsach_dao(pageble pageble1) {
		StringBuilder sql=new StringBuilder("SELECT * FROM bang_coquanpheduyet ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_coquanpheduyet_mapper());
	}

	@Override
	public int themcoquan_dao(bang_coquanpheduyet_model coquan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public bang_coquanpheduyet_model laymotnguoidung_dao(int coquan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void capnhatnguoidung_dao(bang_coquanpheduyet_model coquan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoanguoidung_dao(int manguoidung) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
