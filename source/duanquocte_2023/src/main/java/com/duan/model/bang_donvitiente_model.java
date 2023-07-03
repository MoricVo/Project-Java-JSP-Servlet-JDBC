package com.duan.model;

import java.sql.Timestamp;

public class bang_donvitiente_model extends abstract_model<bang_donvitiente_model> {
private int maDonViTienTe;
private String tenDonViTienTe;
private Timestamp ngayTao;
private Timestamp ngayCapNhat;
public int getMaDonViTienTe() {
	return maDonViTienTe;
}
public void setMaDonViTienTe(int maDonViTienTe) {
	this.maDonViTienTe = maDonViTienTe;
}
public String getTenDonViTienTe() {
	return tenDonViTienTe;
}
public void setTenDonViTienTe(String tenDonViTienTe) {
	this.tenDonViTienTe = tenDonViTienTe;
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
public bang_donvitiente_model(int maDonViTienTe, String tenDonViTienTe, Timestamp ngayTao, Timestamp ngayCapNhat) {
	super();
	this.maDonViTienTe = maDonViTienTe;
	this.tenDonViTienTe = tenDonViTienTe;
	this.ngayTao = ngayTao;
	this.ngayCapNhat = ngayCapNhat;
}
public bang_donvitiente_model() {
	super();
}


}
