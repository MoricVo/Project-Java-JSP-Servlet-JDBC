package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_duan_interface_dao;
import com.duan.interface_of_dao.bang_nguoidung_interface_dao;
import com.duan.mapper.bang_duan_mapper;
import com.duan.mapper.bang_nguoidung_mapper;
import com.duan.mapper.row_mapper;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;

public class bang_duan_dao extends abstract_dao<bang_duan_model> implements bang_duan_interface_dao {

	@Override
	public List<bang_duan_model> laytoanbodanhsach_dao(pageble pageble1) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc,\r\n" + 
				"bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"bang_doitacthuchien.tendoitac AS tendoitac ,bang_donvitiente.tendonvitiente AS tendonvitiente \r\n" + 
				"FROM bang_duanquocte\r\n" + 
				"LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc\r\n" + 
				"LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet\r\n" + 
				"LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_mapper());
		
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_theomanguoidung_dao(pageble pageble1,int manguoidung) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc,\r\n" + 
				"bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"bang_doitacthuchien.tendoitac AS tendoitac ,bang_donvitiente.tendonvitiente AS tendonvitiente \r\n" + 
				"FROM bang_duanquocte\r\n" + 
				"LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc\r\n" + 
				"LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet\r\n" + 
				"LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac WHERE bang_duanquocte.manguoidung=? ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_mapper(),manguoidung);
	}

	@Override
	public int themduan_dao(bang_duan_model duan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public bang_duan_model laymotduan_dao(int maduan) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc,\r\n" + 
				"bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"bang_doitacthuchien.tendoitac AS tendoitac,bang_donvitiente.tendonvitiente AS tendonvitiente \r\n" + 
				"FROM bang_duanquocte\r\n" + 
				"LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc\r\n" + 
				"LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet\r\n" + 
				"LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac WHERE bang_duanquocte.maduan=? ");
		 List<bang_duan_model>duan=truyvandulieu_generic(sql.toString(),new bang_duan_mapper(),maduan);
		 return duan.isEmpty()?null:duan.get(0);
	}

	@Override
	public void capnhatduan_dao(bang_duan_model maduan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoaduan_dao(int maduan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT COUNT(*) FROM bang_duanquocte";
		return count(sql);
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_dangtrienkhai_dao() {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc,\r\n" + 
				"bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"bang_doitacthuchien.tendoitac AS tendoitac ,bang_donvitiente.tendonvitiente AS tendonvitiente \r\n" + 
				"FROM bang_duanquocte\r\n" + 
				"LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc\r\n" + 
				"LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet\r\n" + 
				"LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac WHERE bang_duanquocte.trangthaiduan=2 ORDER BY madonvitructhuoc  ");
		
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_mapper());
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_theoquyvanam_dao(pageble pageble1,String thuocquy,String thuocnam) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc, \r\n" + 
				"	bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"			bang_doitacthuchien.tendoitac AS tendoitac,bang_donvitiente.tendonvitiente AS tendonvitiente \r\n" + 
				"			FROM bang_duanquocte\r\n" + 
				"			LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"			LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"			LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc \r\n" + 
				"			LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"			LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"			LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet \r\n" + 
				"           LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"			LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac WHERE bang_duanquocte.thuocquy=? AND bang_duanquocte.thuocnam=? ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_mapper(),thuocquy,thuocnam);
	}

	@Override
	public List<bang_duan_model> timkiemduan_dao(String tenduan_tiengviet, String tenduan_tienganh) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc,\r\n" + 
				"bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"bang_doitacthuchien.tendoitac AS tendoitac ,bang_donvitiente.tendonvitiente AS tendonvitiente \r\n" + 
				"FROM bang_duanquocte\r\n" + 
				"LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc\r\n" + 
				"LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet\r\n" + 
				"LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac WHERE tenduan_tiengviet LIKE ? OR tenduan_tienganh LIKE ? ");	
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_mapper(),"%"+tenduan_tiengviet+"%","%"+tenduan_tienganh+"%");
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_theokhoa_dao(pageble pageble1,int madonvitructhuoc) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc,\r\n" + 
				"bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"bang_doitacthuchien.tendoitac AS tendoitac ,bang_donvitiente.tendonvitiente AS tendonvitiente\r\n" + 
				"FROM bang_duanquocte\r\n" + 
				"LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc\r\n" + 
				"LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet\r\n" + 
				"LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac WHERE bang_duanquocte.madonvitructhuoc=? ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_mapper(),madonvitructhuoc);
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_dangtrienkhai_theokhoa_dao( int madonvitructhuoc) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc,\r\n" + 
				"bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"bang_doitacthuchien.tendoitac AS tendoitac ,bang_donvitiente.tendonvitiente AS tendonvitiente \r\n" + 
				"FROM bang_duanquocte\r\n" + 
				"LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc\r\n" + 
				"LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet\r\n" + 
				"           LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac WHERE bang_duanquocte.trangthaiduan=1 AND bang_duanquocte.madonvitructhuoc=?  ");
		 
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_mapper(),madonvitructhuoc);
	}

	@Override
	public List<bang_duan_model> laytoanbodanhsach_ketthuc_dao(pageble pageble1) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc,\r\n" + 
				"bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"bang_doitacthuchien.tendoitac AS tendoitac ,bang_donvitiente.tendonvitiente AS tendonvitiente \r\n" + 
				"FROM bang_duanquocte\r\n" + 
				"LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc\r\n" + 
				"LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet\r\n" + 
				"           LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac WHERE bang_duanquocte.trangthaiketthuc= 1  ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+" , "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_mapper());
	}

	@Override
	public List<bang_duan_model> locduan_theodonvitructhuoc( int madonvitructhuoc) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc, \r\n" + 
				"	bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"			bang_doitacthuchien.tendoitac AS tendoitac,bang_donvitiente.tendonvitiente AS tendonvitiente \r\n" + 
				"			FROM bang_duanquocte\r\n" + 
				"			LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"			LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"			LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc \r\n" + 
				"			LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"			LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"			LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet \r\n" + 
				"           LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"			LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac WHERE bang_duanquocte.madonvitructhuoc=?  ");
		
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_mapper(),madonvitructhuoc);
	}

	@Override
	public List<bang_duan_model> locduan_theotrangthai(int manguoidung,int trangthaiketthuc) {
		StringBuilder sql=new StringBuilder("SELECT bang_duanquocte.*, bang_danhmuc.tendanhmuc AS tendanhmuc,bang_nguoidung.tennguoidung AS tennguoidung,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc, \r\n" + 
				"	bang_nhataitro.tennhataitro AS tennhataitro,bang_loaivientro.tenloaivientro AS tenloaivientro,bang_coquanpheduyet.tencoquanpheduyet AS tencoquanpheduyet,\r\n" + 
				"			bang_doitacthuchien.tendoitac AS tendoitac,bang_donvitiente.tendonvitiente AS tendonvitiente \r\n" + 
				"			FROM bang_duanquocte\r\n" + 
				"			LEFT JOIN bang_danhmuc ON bang_duanquocte.madanhmuc = bang_danhmuc.madanhmuc\r\n" + 
				"			LEFT JOIN bang_nguoidung ON bang_duanquocte.manguoidung=bang_nguoidung.manguoidung\r\n" + 
				"			LEFT JOIN bang_donvitructhuoc ON bang_duanquocte.madonvitructhuoc=bang_donvitructhuoc.madonvitructhuoc \r\n" + 
				"			LEFT JOIN bang_nhataitro ON bang_duanquocte.manhataitro=bang_nhataitro.manhataitro\r\n" + 
				"			LEFT JOIN bang_loaivientro ON bang_duanquocte.maloaivientro=bang_loaivientro.maloaivientro\r\n" + 
				"			LEFT JOIN bang_coquanpheduyet ON bang_duanquocte.macoquanpheduyet=bang_coquanpheduyet.macoquanpheduyet \r\n" + 
				"           LEFT JOIN bang_donvitiente ON bang_duanquocte.madonvitiente=bang_donvitiente.madonvitiente\r\n" + 
				"			LEFT JOIN bang_doitacthuchien ON bang_duanquocte.madoitacthuchien=bang_doitacthuchien.madoitac WHERE  bang_duanquocte.manguoidung=? AND bang_duanquocte.trangthaiketthuc=?  ");
		
		
			 return truyvandulieu_generic(sql.toString(),new bang_duan_mapper(),manguoidung,trangthaiketthuc);
	}


	
	

}
