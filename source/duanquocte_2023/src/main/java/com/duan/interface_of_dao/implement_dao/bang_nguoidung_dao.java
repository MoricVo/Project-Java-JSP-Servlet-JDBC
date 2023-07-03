package com.duan.interface_of_dao.implement_dao;

import java.util.List;

import com.duan.interface_of_dao.bang_nguoidung_interface_dao;
import com.duan.mapper.bang_nguoidung_mapper;
import com.duan.model.bang_nguoidung_model;
import com.duan.paging.pageble;
import com.mysql.cj.Query;


public class bang_nguoidung_dao extends abstract_dao<bang_nguoidung_model> implements bang_nguoidung_interface_dao {
	

	@Override
	public List<bang_nguoidung_model> laytoanbodanhsach_dao(pageble pageble1) {
		StringBuilder sql=new StringBuilder("SELECT bang_nguoidung.*, bang_chucvu.tenchucvu AS tenchucvu,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc \r\n" + 
				"FROM bang_nguoidung\r\n" + 
				"JOIN bang_chucvu ON bang_nguoidung.machucvu = bang_chucvu.machucvu JOIN bang_donvitructhuoc ON bang_nguoidung.madonvitructhuoc = bang_donvitructhuoc.madonvitructhuoc   ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+", "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_nguoidung_mapper());
		
	}

	@Override
	public List<bang_nguoidung_model> laytoanbodanhsach_theochucvu_dao(int machucvu) {
		
		String sql="SELECT * FROM bang_nguoidung WHERE machucvu=?";
		return truyvandulieu_generic(sql, new bang_nguoidung_mapper(), machucvu);
		
	}

	@Override
	public int themnguoidung_dao(bang_nguoidung_model nguoidung) {
		String sql="INSERT INTO bang_nguoidung(machucvu,honguoidung,tennguoidung,sdt,diachi,gmail,matkhau,quyenhan,trangthai,anhdaidien,ngaylap,ngaycapnhat) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		return themdulieu_generic(sql, nguoidung.getMaChucVu(),nguoidung.getHoNguoiDung()
		,nguoidung.getTenNguoiDung(),nguoidung.getSdt()
		,nguoidung.getDiaChi(),nguoidung.getGmail(),nguoidung.getMatKhau()
		,nguoidung.getQuyenHan(),nguoidung.getTrangThai()
		,nguoidung.getAnhDaiDien(),nguoidung.getNgayLap(),nguoidung.getNgayCapNhat());
		
	}

	@Override
	public bang_nguoidung_model laymotnguoidung_dao(int manguoidung) {
		 String sql="SELECT * FROM bang_nguoidung";
		 List<bang_nguoidung_model>nguoidung=truyvandulieu_generic(sql,new bang_nguoidung_mapper(),manguoidung);
		 return nguoidung.isEmpty()?null:nguoidung.get(0);
	}

	@Override
	public void capnhatnguoidung_dao(bang_nguoidung_model nguoidung) {
		StringBuilder sql=new StringBuilder("UPDATE bang_nguoidung SET machucvu=?,honguoidung=?,tennguoidung=?,");
		sql.append("sdt=?,diachi=?,gmail=?,matkhau=?,quyenhan=?,trangthai=?,anhdaidien=?,ngaylap=?,ngaycapnhat=? WHERE manguoidung=?");
		
		capnhatdulieu_generic(sql.toString(),nguoidung.getMaChucVu(),nguoidung.getHoNguoiDung()
				,nguoidung.getTenNguoiDung(),nguoidung.getSdt()
				,nguoidung.getDiaChi(),nguoidung.getGmail(),nguoidung.getMatKhau()
				,nguoidung.getQuyenHan(),nguoidung.getTrangThai()
				,nguoidung.getAnhDaiDien(),nguoidung.getNgayLap(),nguoidung.getNgayCapNhat(),nguoidung.getMaNguoiDung());
		
	}

	@Override
	public void xoanguoidung_dao(int manguoidung) {
		String sql="DELETE FROM bang_nguoidung WHERE manguoidung=?";
		capnhatdulieu_generic(sql, manguoidung);
		
		
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT COUNT(*) FROM bang_nguoidung";
		return count(sql);
	}

	@Override
	public bang_nguoidung_model laytoanbodanhsachtheo_gmail_tennguoidung_matkhau_trangthai(String gmail,
			 String matkhau, Integer trangthai) {
		StringBuilder sql=new StringBuilder("SELECT * FROM bang_nguoidung AS u ");
		sql.append(" INNER JOIN bang_chucvu AS r ON r.machucvu = u.machucvu ");
		sql.append(" INNER JOIN bang_donvitructhuoc AS r1 ON r1.madonvitructhuoc = u.madonvitructhuoc ");
		sql.append(" WHERE gmail=? AND matkhau=? AND trangthai=? " );
		 List<bang_nguoidung_model> nguoidung=truyvandulieu_generic(sql.toString(),new bang_nguoidung_mapper(),gmail,matkhau,trangthai);
		 return nguoidung.isEmpty()?null:nguoidung.get(0);
		 
	}

	@Override
	public List<bang_nguoidung_model> timkiemnguoidung_dao(String tennguoidung, String gmail, String quyenhan) {
		StringBuilder sql=new StringBuilder("SELECT bang_nguoidung.*, bang_chucvu.tenchucvu AS tenchucvu,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc \r\n" + 
				"FROM bang_nguoidung\r\n" + 
				"JOIN bang_chucvu ON bang_nguoidung.machucvu = bang_chucvu.machucvu JOIN bang_donvitructhuoc ON bang_nguoidung.madonvitructhuoc = bang_donvitructhuoc.madonvitructhuoc "
				+ " WHERE tennguoidung LIKE ? OR gmail LIKE ? OR quyenhan LIKE ? ");
		
		
			 return truyvandulieu_generic(sql.toString(),new bang_nguoidung_mapper(),"%"+tennguoidung+"%","%"+gmail+"%","%"+quyenhan+"%");
	}

	@Override
	public List<bang_nguoidung_model> laytoanbodanhsach_theokhoa_dao(pageble pageble1,int maDonViTrucThuoc) {
		StringBuilder sql=new StringBuilder("SELECT bang_nguoidung.*, bang_chucvu.tenchucvu AS tenchucvu,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc \r\n" + 
				"FROM bang_nguoidung\r\n" + 
				"JOIN bang_chucvu ON bang_nguoidung.machucvu = bang_chucvu.machucvu JOIN bang_donvitructhuoc ON bang_nguoidung.madonvitructhuoc = bang_donvitructhuoc.madonvitructhuoc "
				+ "WHERE bang_nguoidung.madonvitructhuoc=?  ");
		if(pageble1.getSorter()!=null)
		{
			sql.append(" ORDER BY "+pageble1.getSorter().getSapxeptheothuoctinh()+"  "+pageble1.getSorter().getSapxeotheochieu()+" ");
		}
		if(pageble1.getOffset()!=null && pageble1.getLimit()!=null)
		{
			sql.append(" LIMIT  "+pageble1.getOffset()+", "+pageble1.getLimit()+"  ");
		}	 
		
			 return truyvandulieu_generic(sql.toString(),new bang_nguoidung_mapper(),maDonViTrucThuoc);
	}

	@Override
	public List<bang_nguoidung_model> laytoanbodanhsach_dangbikhoa_dao() {
		StringBuilder sql=new StringBuilder("SELECT bang_nguoidung.*, bang_chucvu.tenchucvu AS tenchucvu,bang_donvitructhuoc.tendonvitructhuoc AS tendonvitructhuoc \r\n" + 
				"FROM bang_nguoidung\r\n" + 
				"JOIN bang_chucvu ON bang_nguoidung.machucvu = bang_chucvu.machucvu JOIN bang_donvitructhuoc ON bang_nguoidung.madonvitructhuoc = bang_donvitructhuoc.madonvitructhuoc where trangthai=0 ");
			 return truyvandulieu_generic(sql.toString(),new bang_nguoidung_mapper());
	}
}
