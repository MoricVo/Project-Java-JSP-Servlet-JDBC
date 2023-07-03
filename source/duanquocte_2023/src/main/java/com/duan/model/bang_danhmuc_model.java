package com.duan.model;

import java.sql.Timestamp;

public class bang_danhmuc_model extends abstract_model<bang_danhmuc_model> {
private int maDanhMuc;
private String tenDanhMuc;
private Timestamp ngayTao;
private int nguoiTao;
private Timestamp ngayCapNhat;
public int getMaDanhMuc() {
	return maDanhMuc;
}
public void setMaDanhMuc(int maDanhMuc) {
	this.maDanhMuc = maDanhMuc;
}
public String getTenDanhMuc() {
	return tenDanhMuc;
}
public void setTenDanhMuc(String tenDanhMuc) {
	this.tenDanhMuc = tenDanhMuc;
}
public Timestamp getNgayTao() {
	return ngayTao;
}
public void setNgayTao(Timestamp ngayTao) {
	this.ngayTao = ngayTao;
}
public Timestamp getNgayCapNhat() {
	return ngayCapNhat;
}
public void setNgayCapNhat(Timestamp ngayCapNhat) {
	this.ngayCapNhat = ngayCapNhat;
}
public bang_danhmuc_model(int maDanhMuc, String tenDanhMuc, Timestamp ngayTao, int nguoiTao) {
	super();
	this.maDanhMuc = maDanhMuc;
	this.tenDanhMuc = tenDanhMuc;
	this.ngayTao = ngayTao;
	this.nguoiTao = nguoiTao;
}

public bang_danhmuc_model(int maDanhMuc, String tenDanhMuc, Timestamp ngayTao) {
	super();
	this.maDanhMuc = maDanhMuc;
	this.tenDanhMuc = tenDanhMuc;
	this.ngayTao = ngayTao;
}
public bang_danhmuc_model() {
	super();
}
public int getNguoiTao() {
	return nguoiTao;
}
public void setNguoiTao(int nguoiTao) {
	this.nguoiTao = nguoiTao;
}

}
