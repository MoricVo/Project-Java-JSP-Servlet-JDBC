package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_file_dinhkem_model;

public class bang_file_dinhkem_mapper implements row_mapper<bang_file_dinhkem_model> {

	@Override
	public bang_file_dinhkem_model maprow(ResultSet rs) {
		bang_file_dinhkem_model dinhkem=new bang_file_dinhkem_model();
		try {
			dinhkem.setMafileupload(rs.getInt("mafileupload"));
			dinhkem.setMaduan(rs.getInt("maduan"));
			dinhkem.setFile_decuongduan(rs.getString("file_decuongduan"));
			dinhkem.setFile_thucahpnhanthuchien(rs.getString("file_thucahpnhanthuchien"));
			dinhkem.setFile_totrinhxinphepthuchien(rs.getString("file_totrinhxinphepthuchien"));
			dinhkem.setFile_quyetdinhgiaokinhphi(rs.getString("file_quyetdinhgiaokinhphi"));
			dinhkem.setFile_quyetdinhthanhlapbanquanly(rs.getString("file_quyetdinhthanhlapbanquanly"));
			dinhkem.setFile_quyetdinhchophepthuchien(rs.getString("file_quyetdinhchophepthuchien"));
			dinhkem.setFile_hopdongthoathuan_moa(rs.getString("file_hopdongthoathuan_moa"));
			dinhkem.setFile_kehoachtrienkhaiduan(rs.getString("file_kehoachtrienkhaiduan"));
			dinhkem.setFile_baocaotiendogiuaky(rs.getString("file_baocaotiendogiuaky"));
			dinhkem.setFile_baocaotongket(rs.getString("file_baocaotongket"));
			dinhkem.setFile_xacnhanketthucduan(rs.getString("file_xacnhanketthucduan"));
			dinhkem.setFile_lylichkhoahoccuachunhiemduan(rs.getString("file_lylichkhoahoccuachunhiemduan"));
			dinhkem.setFile_bienbangiaitrinh(rs.getString("file_bienbangiaitrinh"));
			dinhkem.setFile_hinhanhthongtinhoatdongtrienkhai(rs.getString("file_hinhanhthongtinhoatdongtrienkhai"));
			dinhkem.setFile_cacminhchungkhac(rs.getString("file_cacminhchungkhac"));
			dinhkem.setFile_cacminhchungkhac_2(rs.getString("file_cacminhchungkhac_2"));
			
			return dinhkem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
