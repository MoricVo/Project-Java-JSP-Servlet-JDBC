package com.duan.model;

import java.sql.Timestamp;

public class bang_nhataitro_model extends abstract_model<bang_nhataitro_model> {
private int maNhaTaiTro;
private String tenNhaTaiTro;
private Timestamp ngayTao;
private int nguoiTao;
private Timestamp ngayCapNhat;
public int getMaNhaTaiTro() {
	return maNhaTaiTro;
}
public void setMaNhaTaiTro(int maNhaTaiTro) {
	this.maNhaTaiTro = maNhaTaiTro;
}
public String getTenNhaTaiTro() {
	return tenNhaTaiTro;
}
public void setTenNhaTaiTro(String tenNhaTaiTro) {
	this.tenNhaTaiTro = tenNhaTaiTro;
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
public bang_nhataitro_model(int maNhaTaiTro, String tenNhaTaiTro, Timestamp ngayTao, Timestamp ngayCapNhat) {
	super();
	this.maNhaTaiTro = maNhaTaiTro;
	this.tenNhaTaiTro = tenNhaTaiTro;
	this.ngayTao = ngayTao;
	this.ngayCapNhat = ngayCapNhat;
}

public bang_nhataitro_model(int maNhaTaiTro, String tenNhaTaiTro, Timestamp ngayTao, int nguoiTao) {
	super();
	this.maNhaTaiTro = maNhaTaiTro;
	this.tenNhaTaiTro = tenNhaTaiTro;
	this.ngayTao = ngayTao;
	this.nguoiTao = nguoiTao;
}
public bang_nhataitro_model() {
	super();
}
public int getNguoiTao() {
	return nguoiTao;
}
public void setNguoiTao(int nguoiTao) {
	this.nguoiTao = nguoiTao;
}

}
