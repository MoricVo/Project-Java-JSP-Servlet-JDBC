package com.duan.model;

import java.sql.Timestamp;

public class bang_doitacthuchien_model extends abstract_model<bang_doitacthuchien_model> {
private int maDoiTacThucHien;
private String tenDoiTacThucHien;
private Timestamp ngayTao;
private int nguoiTao;
private Timestamp ngayCapNhat;
public int getMaDoiTacThucHien() {
	return maDoiTacThucHien;
}
public void setMaDoiTacThucHien(int maDoiTacThucHien) {
	this.maDoiTacThucHien = maDoiTacThucHien;
}
public String getTenDoiTacThucHien() {
	return tenDoiTacThucHien;
}
public void setTenDoiTacThucHien(String tenDoiTacThucHien) {
	this.tenDoiTacThucHien = tenDoiTacThucHien;
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
public bang_doitacthuchien_model(int maDoiTacThucHien, String tenDoiTacThucHien, Timestamp ngayTao,
		Timestamp ngayCapNhat) {
	super();
	this.maDoiTacThucHien = maDoiTacThucHien;
	this.tenDoiTacThucHien = tenDoiTacThucHien;
	this.ngayTao = ngayTao;
	this.ngayCapNhat = ngayCapNhat;
}


public bang_doitacthuchien_model(int maDoiTacThucHien, String tenDoiTacThucHien, Timestamp ngayTao, int nguoiTao) {
	super();
	this.maDoiTacThucHien = maDoiTacThucHien;
	this.tenDoiTacThucHien = tenDoiTacThucHien;
	this.ngayTao = ngayTao;
	this.nguoiTao = nguoiTao;
}
public bang_doitacthuchien_model() {
	super();
}
public int getNguoiTao() {
	return nguoiTao;
}
public void setNguoiTao(int nguoiTao) {
	this.nguoiTao = nguoiTao;
}
 
}
