package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_duan_dathamgia_model;

public class bang_duan_dabaocao_mapper implements row_mapper<bang_duan_dathamgia_model> {

	@Override
	public bang_duan_dathamgia_model maprow(ResultSet rs) {
		bang_duan_dathamgia_model thamgiaduan=new bang_duan_dathamgia_model();
		try {
			
			thamgiaduan.setMaDuAn_DaThamGia(rs.getInt("maduan_dabaocao"));
			thamgiaduan.setMaDuAn(rs.getInt("maduan"));
			  thamgiaduan.setTenNguoiDung(rs.getString("chuduan"));
			  thamgiaduan.setTenDonViTrucThuoc(rs.getString("tendonvitructhuoc"));
			  thamgiaduan.setTenDanhMuc(rs.getString("tendanhmuc"));
			  thamgiaduan.setTenNhaTaiTro(rs.getString("tennhataitro"));
		
			  thamgiaduan.setTenLoaiVienTro(rs.getString("tenloaivientro"));
			
			  thamgiaduan.setTenCoQuanPheDuyet(rs.getString("tencoquanpheduyet"));
			 
			  thamgiaduan.setTenDoiTacThucHien(rs.getString("tendoitacthuchien"));
			 
			  thamgiaduan.setTenDuAn_TiengViet(rs.getString("tenduantiengviet"));
			  thamgiaduan.setTenDuAn_TiengAnh(rs.getString("tenduantienganh"));
			  //Mới thêm vô nè hihi
			  thamgiaduan.setThanhVienThamGia(rs.getString("thanhvienthamgia"));
			  thamgiaduan.setMucTieuDuAn(rs.getString("muctieuduan"));
			  thamgiaduan.setNoiDungThucHien(rs.getString("noidungthuchien"));
			  thamgiaduan.setThietBiTaiTro(rs.getString("thietbitaitro"));
			  
			  
			  thamgiaduan.setKinhPhiNamTruoc(rs.getString("kinhphinamtruoc"));
			  thamgiaduan.setTongVonThucHien(rs.getString("tongvonthuchien"));
			  thamgiaduan.setVonTaiTro(rs.getString("vontaitro"));
			  
			  thamgiaduan.setVonVay(rs.getString("vonvay"));
			  thamgiaduan.setVonKhac(rs.getString("vonkhac"));
			  thamgiaduan.setVonDoiUng(rs.getString("vondoiung"));
			  thamgiaduan.setTenDonViTienTe(rs.getString("tendonvitiente"));
			  thamgiaduan.setThoiGianThucHien(rs.getString("thoigianthuchien"));
			  thamgiaduan.setThoiGianBatDau(rs.getTimestamp("thoigianbatdau"));
			  thamgiaduan.setThoiGianKetThuc(rs.getTimestamp("thoigianketthuc"));
			  thamgiaduan.setTienDoThucHien(rs.getString("tiendothuchien"));
			  thamgiaduan.setPhanTramTienDoThucHien(rs.getString("phantramtiendo"));
			
			  thamgiaduan.setThuocQuy(rs.getString("thuocquy"));
			  thamgiaduan.setThuocNam(rs.getString("thuocnam"));
			
			  thamgiaduan.setDonViTienTeVonTaiTro(rs.getString("donvitientevontaitro"));
			  thamgiaduan.setDonViTienTeVonVay(rs.getString("donvitientevonvay"));
			  thamgiaduan.setDonViTienTeVonKhac(rs.getString("donvitientevonkhac"));
			  thamgiaduan.setDonViTienTeVonDoiUng(rs.getString("donvitientevondoiung"));
			  thamgiaduan.setDonViTienTeTongVonThucHien(rs.getString("donvitientetongvonthuchien"));
			
		  
				
				
			
			return thamgiaduan;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
