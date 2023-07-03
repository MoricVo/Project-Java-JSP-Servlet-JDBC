package com.duan.model;

import java.sql.Timestamp;

public class bang_loaivientro_model extends abstract_model<bang_loaivientro_model> {
private int maLoaiVienTro;
private String tenLoaiVienTro;
private Timestamp ngayTao;
private int nguoiTao;
private Timestamp ngayCapNhat;
public int getMaLoaiVienTro() {
	return maLoaiVienTro;
}
public void setMaLoaiVienTro(int maLoaiVienTro) {
	this.maLoaiVienTro = maLoaiVienTro;
}
public String getTenLoaiVienTro() {
	return tenLoaiVienTro;
}
public void setTenLoaiVienTro(String tenLoaiVienTro) {
	this.tenLoaiVienTro = tenLoaiVienTro;
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
public bang_loaivientro_model(int maLoaiVienTro, String tenLoaiVienTro, Timestamp ngayTao, Timestamp ngayCapNhat) {
	super();
	this.maLoaiVienTro = maLoaiVienTro;
	this.tenLoaiVienTro = tenLoaiVienTro;
	this.ngayTao = ngayTao;
	this.ngayCapNhat = ngayCapNhat;
}

public bang_loaivientro_model(int maLoaiVienTro, String tenLoaiVienTro, Timestamp ngayTao, int nguoiTao) {
	super();
	this.maLoaiVienTro = maLoaiVienTro;
	this.tenLoaiVienTro = tenLoaiVienTro;
	this.ngayTao = ngayTao;
	this.nguoiTao = nguoiTao;
}
public bang_loaivientro_model() {
	super();
}
public int getNguoiTao() {
	return nguoiTao;
}
public void setNguoiTao(int nguoiTao) {
	this.nguoiTao = nguoiTao;
}

}
