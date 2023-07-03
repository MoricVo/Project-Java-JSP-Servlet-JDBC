package com.duan.model;

import java.sql.Timestamp;

public class bang_lichsucapnhat_model extends abstract_model<bang_lichsucapnhat_model> {
private int maLichSuCapNhat;
private int maDuAn;
private int maNguoiDung;
private Timestamp ngayCapNhat;
private bang_duan_model duanquocte;
private bang_donvitructhuoc_model donvitructhuoc;
private bang_danhmuc_model danhmuc;
private bang_nguoidung_model nguoidung;
public int getMaLichSuCapNhat() {
	return maLichSuCapNhat;
}
public void setMaLichSuCapNhat(int maLichSuCapNhat) {
	this.maLichSuCapNhat = maLichSuCapNhat;
}
public int getMaDuAn() {
	return maDuAn;
}
public void setMaDuAn(int maDuAn) {
	this.maDuAn = maDuAn;
}
public int getMaNguoiDung() {
	return maNguoiDung;
}
public void setMaNguoiDung(int maNguoiDung) {
	this.maNguoiDung = maNguoiDung;
}
public Timestamp getNgayCapNhat() {
	return ngayCapNhat;
}
public void setNgayCapNhat(Timestamp ngayCapNhat) {
	this.ngayCapNhat = ngayCapNhat;
}

public bang_duan_model getDuanquocte() {
	return duanquocte;
}
public void setDuanquocte(bang_duan_model duanquocte) {
	this.duanquocte = duanquocte;
}
public bang_donvitructhuoc_model getDonvitructhuoc() {
	return donvitructhuoc;
}
public void setDonvitructhuoc(bang_donvitructhuoc_model donvitructhuoc) {
	this.donvitructhuoc = donvitructhuoc;
}
public bang_danhmuc_model getDanhmuc() {
	return danhmuc;
}
public void setDanhmuc(bang_danhmuc_model danhmuc) {
	this.danhmuc = danhmuc;
}
public bang_nguoidung_model getNguoidung() {
	return nguoidung;
}
public void setNguoidung(bang_nguoidung_model nguoidung) {
	this.nguoidung = nguoidung;
}
public bang_lichsucapnhat_model(int maLichSuCapNhat, int maDuAn, int maNguoiDung,
		Timestamp ngayCapNhat) {
	super();
	this.maLichSuCapNhat = maLichSuCapNhat;
	this.maDuAn = maDuAn;
	this.maNguoiDung = maNguoiDung;
	
	this.ngayCapNhat = ngayCapNhat;
}
public bang_lichsucapnhat_model() {
	super();
}

}
