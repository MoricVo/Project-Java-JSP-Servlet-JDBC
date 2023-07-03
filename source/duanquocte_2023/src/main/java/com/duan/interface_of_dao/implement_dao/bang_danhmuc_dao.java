package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_danhmuc_interface_dao;
import com.duan.mapper.bang_coquanpheduyet_mapper;
import com.duan.mapper.bang_danhmuc_mapper;
import com.duan.mapper.bang_duan_mapper;
import com.duan.model.bang_danhmuc_model;
import com.duan.model.bang_duan_model;
import com.duan.paging.pageble;

public class bang_danhmuc_dao extends abstract_dao<bang_danhmuc_model> implements bang_danhmuc_interface_dao {

	@Override
	public bang_danhmuc_model laymotdanhmuc(int madanhmuc) {
		String sql="SELECT * FROM bang_danhmuc where madanhmuc=?";
		 List<bang_danhmuc_model>duan=truyvandulieu_generic(sql,new bang_danhmuc_mapper(),madanhmuc);
		 return duan.isEmpty()?null:duan.get(0);
	}

	@Override
	public List<bang_danhmuc_model> laytoanbodanhsach_dao(pageble pageble1) {
		StringBuilder sql=new StringBuilder("SELECT * FROM bang_danhmuc ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_danhmuc_mapper());
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
