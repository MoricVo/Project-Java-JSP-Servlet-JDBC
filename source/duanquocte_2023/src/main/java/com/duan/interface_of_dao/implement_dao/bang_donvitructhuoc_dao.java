package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_donvitructhuoc_interface_dao;
import com.duan.mapper.bang_donvitructhuoc_mapper;
import com.duan.model.bang_donvitructhuoc_model;
import com.duan.paging.pageble;

public class bang_donvitructhuoc_dao extends abstract_dao<bang_donvitructhuoc_model> implements bang_donvitructhuoc_interface_dao {

	@Override
	public List<bang_donvitructhuoc_model> laytoanbodanhsach_dao(pageble pageble1) {
		StringBuilder sql=new StringBuilder("SELECT * FROM bang_donvitructhuoc ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_donvitructhuoc_mapper());
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
