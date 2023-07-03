package com.duan.model;

import java.sql.Timestamp;

public class bang_thamgiaduan_model extends abstract_model<bang_thamgiaduan_model>
{
private int maThamGia;
private int maNguoiDung;
private int maDuAn;
private Timestamp ngayThamGia;
private String tinhTrang;
private String ghiChu;
private bang_duan_model duan;
private bang_nguoidung_model nguoidung;

public bang_thamgiaduan_model(int maThamGia, int maNguoiDung, int maDuAn, Timestamp ngayThamGia, String tinhTrang,
		String ghiChu) {
	super();
	this.maThamGia = maThamGia;
	this.maNguoiDung = maNguoiDung;
	this.maDuAn = maDuAn;
	this.ngayThamGia = ngayThamGia;
	this.tinhTrang = tinhTrang;
	this.ghiChu = ghiChu;
}

public bang_thamgiaduan_model(int maThamGia) {
	super();
	this.maThamGia = maThamGia;
	
}
public bang_thamgiaduan_model() {
	super();
}
public int getMaThamGia() {
	return maThamGia;
}
public void setMaThamGia(int maThamGia) {
	this.maThamGia = maThamGia;
}
public int getMaNguoiDung() {
	return maNguoiDung;
}
public void setMaNguoiDung(int maNguoiDung) {
	this.maNguoiDung = maNguoiDung;
}
public int getMaDuAn() {
	return maDuAn;
}
public void setMaDuAn(int maDuAn) {
	this.maDuAn = maDuAn;
}
public Timestamp getNgayThamGia() {
	return ngayThamGia;
}
public void setNgayThamGia(Timestamp ngayThamGia) {
	this.ngayThamGia = ngayThamGia;
}
public String getTinhTrang() {
	return tinhTrang;
}
public void setTinhTrang(String tinhTrang) {
	this.tinhTrang = tinhTrang;
}
public String getGhiChu() {
	return ghiChu;
}
public void setGhiChu(String ghiChu) {
	this.ghiChu = ghiChu;
}
public bang_duan_model getDuan() {
	return duan;
}
public void setDuan(bang_duan_model duan) {
	this.duan = duan;
}
public bang_nguoidung_model getNguoidung() {
	return nguoidung;
}
public void setNguoidung(bang_nguoidung_model nguoidung) {
	this.nguoidung = nguoidung;
}


}
