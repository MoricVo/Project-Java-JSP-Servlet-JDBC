package com.duan.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duan.model.bang_chucvu_model;
import com.duan.model.bang_coquanpheduyet_model;
import com.duan.model.bang_danhmuc_model;
import com.duan.model.bang_doitacthuchien_model;
import com.duan.model.bang_donvitiente_model;
import com.duan.model.bang_donvitructhuoc_model;
import com.duan.model.bang_duan_model;
import com.duan.model.bang_loaivientro_model;
import com.duan.model.bang_nguoidung_model;
import com.duan.model.bang_nhataitro_model;

public class bang_duan_mapper  implements row_mapper<bang_duan_model>
{

	@Override
	public bang_duan_model maprow(ResultSet rs) {
		bang_duan_model duan=new bang_duan_model();
		try {
			  duan.setMaDuAn(rs.getInt("maduan"));
			  duan.setMaNguoiDung(rs.getInt("manguoidung"));
			  duan.setMaDonViTrucThuoc(rs.getInt("madonvitructhuoc"));
			  duan.setMaDanhMuc(rs.getInt("madanhmuc"));
			  duan.setMaNhaTaiTro(rs.getInt("manhataitro"));
		
			  duan.setMaLoaiVienTro(rs.getInt("maloaivientro"));
			
			  duan.setMaCoQuanPheDuyet(rs.getInt("macoquanpheduyet"));
			 
			  duan.setMaDoiTacThucHien(rs.getInt("madoitacthuchien"));
			 
			  duan.setTenDuAn_TiengViet(rs.getString("tenduan_tiengviet"));
			  duan.setTenDuAn_TiengAnh(rs.getString("tenduan_tienganh"));
			  //Mới thêm vô nè hihi
			  duan.setThanhVienThamGia(rs.getString("thanhvienthamgia"));
			  duan.setMucTieuDuAn(rs.getString("muctieuduan"));
			  duan.setNoiDungThucHien(rs.getString("noidungthuchien"));
			  duan.setThietBiTaiTro(rs.getString("thietbitaitro"));
			  
			  
			  duan.setKinhPhiNamTruoc(rs.getString("kinhphiduannamtruoc"));
			  duan.setTongVonThucHien(rs.getFloat("tongvonthuchien"));
			  duan.setVonTaiTro(rs.getFloat("vontaitro"));
			  
			  duan.setVonVay(rs.getFloat("vonvay"));
			  duan.setVonKhac(rs.getFloat("vonkhac"));
			  duan.setVonDoiUng(rs.getFloat("vondoiung"));
			  duan.setMaDonViTienTe(rs.getInt("madonvitiente"));
			  duan.setThoiGianThucHien(rs.getString("thoigianthuchien"));
			  duan.setThoiGianBatDau(rs.getTimestamp("thoigianbatdau"));
			  duan.setThoiGianKetThuc(rs.getTimestamp("thoigianketthuc"));
			  duan.setTienDoThucHien(rs.getString("tiendothuchien"));
			  duan.setPhanTramTienDoThucHien(rs.getString("phantramtiendo"));
			  duan.setNgayTao(rs.getTimestamp("ngaytao"));
			  duan.setNgayCapNhat(rs.getTimestamp("ngaycapnhat"));
			
			  duan.setTrangThaiDuAn(rs.getInt("trangthaiduan"));
			  duan.setTrangThaiKetThuc(rs.getInt("trangthaiketthuc"));
			  
			  duan.setDonViTienTe_VonTaiTro(rs.getString("donvitiente_vontaitro"));
			  duan.setDonViTienTe_VonVay(rs.getString("donvitiente_vonvay"));
			  duan.setDonViTienTe_VonKhac(rs.getString("donvitiente_vonkhac"));
			  duan.setDonViTienTe_VonDoiUng(rs.getString("donvitiente_vondoiung"));
			  duan.setDonViTienTe_TongVonThucHien(rs.getString("donvitiente_tongvonthuchien"));
		    
				 try
				 {
					 bang_nguoidung_model nguoidung=new bang_nguoidung_model();
					 nguoidung.setTenNguoiDung(rs.getString("tennguoidung"));
					 duan.setNguoidung(nguoidung);
					 
					 bang_donvitructhuoc_model donvitructhuoc=new bang_donvitructhuoc_model();
					 donvitructhuoc.setTenDonViTrucThuoc(rs.getString("tendonvitructhuoc"));
					 duan.setDonvitructhuoc(donvitructhuoc);
					 
					 
					bang_danhmuc_model danhmuc=new bang_danhmuc_model();
					 danhmuc.setTenDanhMuc(rs.getString("tendanhmuc"));
					 duan.setDanhmuc(danhmuc);
					 
					 bang_doitacthuchien_model doitacthuchien =new bang_doitacthuchien_model();
					 doitacthuchien.setTenDoiTacThucHien(rs.getString("tendoitac"));
					 duan.setDoitacthuchien(doitacthuchien);
					 
				
					 
					 
					 bang_nhataitro_model nhataitro=new bang_nhataitro_model();
					 nhataitro.setTenNhaTaiTro(rs.getString("tennhataitro"));
					 duan.setNhataitro(nhataitro);
					 
					 
					 bang_loaivientro_model loaivientro=new bang_loaivientro_model();
					 loaivientro.setTenLoaiVienTro(rs.getString("tenloaivientro"));
					 duan.setLoaivientro(loaivientro);
					 
					 
					 bang_coquanpheduyet_model coquanpheduyet =new bang_coquanpheduyet_model();
					 coquanpheduyet.setTenCoQuanPheDuyet(rs.getString("tencoquanpheduyet"));
					 duan.setCoquanpheduyet(coquanpheduyet);
					 
					 bang_donvitiente_model donvitiente =new bang_donvitiente_model();
					 donvitiente.setTenDonViTienTe(rs.getString("tendonvitiente"));
					 duan.setDonvitiente(donvitiente);
				 
				 }
				 catch(SQLException e)
				 {
					 e.printStackTrace();
				 }
				
			
			return duan;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
