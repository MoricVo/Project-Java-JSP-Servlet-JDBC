package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_chucvu_interface_dao;
import com.duan.mapper.bang_chucvu_mapper;
import com.duan.model.bang_chucvu_model;
import com.duan.paging.pageble;

public class bang_chucvu_dao extends abstract_dao<bang_chucvu_model> implements bang_chucvu_interface_dao
{

	@Override
	public List<bang_chucvu_model> laytoanbodanhsach_dao(pageble pageble1) {
		StringBuilder sql=new StringBuilder("SELECT * FROM bang_chucvu ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_chucvu_mapper());
	}

	@Override
	public int themchucvu_dao(bang_chucvu_model chucvu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public bang_chucvu_model laymotchucvu_dao(int chucvu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void capnhatchucvu_dao(bang_chucvu_model chucvu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoachucvu_dao(int machucvu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
