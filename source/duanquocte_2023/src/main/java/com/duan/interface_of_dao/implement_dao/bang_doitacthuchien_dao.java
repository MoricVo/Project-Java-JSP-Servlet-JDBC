package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_doitacthuchien_interface_dao;
import com.duan.mapper.bang_doitacthuchien_mapper;
import com.duan.model.bang_doitacthuchien_model;
import com.duan.paging.pageble;

public class bang_doitacthuchien_dao extends abstract_dao<bang_doitacthuchien_model> implements bang_doitacthuchien_interface_dao {

	@Override
	public List<bang_doitacthuchien_model> laytoanbodanhsach_dao(pageble pageble1) {
		StringBuilder sql=new StringBuilder("SELECT * FROM bang_doitacthuchien ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_doitacthuchien_mapper());
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT COUNT(*) FROM bang_doitacthuchien";
		return count(sql);
	}

}
