package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_danhmuc_model;
import com.duan.model.bang_donvitructhuoc_model;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_lichsucapnhat_model;
import com.duan.model.bang_loaivientro_model;
import com.duan.model.bang_nguoidung_model;

public class bang_lichsucapnhat_mapper implements row_mapper<bang_lichsucapnhat_model>  {

	@Override
	public bang_lichsucapnhat_model maprow(ResultSet rs) {
		bang_lichsucapnhat_model coquanpheduyet=new bang_lichsucapnhat_model();
		try {
			
			coquanpheduyet.setMaLichSuCapNhat(rs.getInt("malichsucapnhat"));
			coquanpheduyet.setMaDuAn(rs.getInt("maduan"));
			coquanpheduyet.setMaNguoiDung(rs.getInt("manguoidung"));
			coquanpheduyet.setNgayCapNhat(rs.getTimestamp("ngaycapnhat"));
			
			  bang_duan_model duan=new bang_duan_model();
				duan.setTenDuAn_TiengViet(rs.getString("tenduan_tiengviet"));
				duan.setTenDuAn_TiengAnh(rs.getString("tenduan_tienganh"));
				coquanpheduyet.setDuanquocte(duan);
				
				bang_donvitructhuoc_model donvitructhuoc=new bang_donvitructhuoc_model();
				donvitructhuoc.setTenDonViTrucThuoc(rs.getString("tendonvitructhuoc"));	
			    coquanpheduyet.setDonvitructhuoc(donvitructhuoc);
				
			    
			    bang_danhmuc_model danhmuc=new bang_danhmuc_model();
			    danhmuc.setTenDanhMuc(rs.getString("tendanhmuc"));
			    coquanpheduyet.setDanhmuc(danhmuc);
					
					bang_nguoidung_model nguoidung=new bang_nguoidung_model();
					nguoidung.setTenNguoiDung(rs.getString("tennguoidung"));
					/*nguoidung.setAnhDaiDien(rs.getString("anhdaidien"));*/
					coquanpheduyet.setNguoidung(nguoidung);
			return coquanpheduyet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
