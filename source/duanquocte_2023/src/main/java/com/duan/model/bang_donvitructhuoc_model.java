package com.duan.model;

import java.sql.Timestamp;

public class bang_donvitructhuoc_model extends abstract_model<bang_donvitructhuoc_model> {
private int maDonViTrucThuoc;
private String tenDonViTrucThuoc;
private Timestamp ngayTao;
private Timestamp ngayCapNhat;
public int getMaDonViTrucThuoc() {
	return maDonViTrucThuoc;
}
public void setMaDonViTrucThuoc(int maDonViTrucThuoc) {
	this.maDonViTrucThuoc = maDonViTrucThuoc;
}
public String getTenDonViTrucThuoc() {
	return tenDonViTrucThuoc;
}
public void setTenDonViTrucThuoc(String tenDonViTrucThuoc) {
	this.tenDonViTrucThuoc = tenDonViTrucThuoc;
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
public bang_donvitructhuoc_model(int maDonViTrucThuoc, String tenDonViTrucThuoc, Timestamp ngayTao,
		Timestamp ngayCapNhat) {
	super();
	this.maDonViTrucThuoc = maDonViTrucThuoc;
	this.tenDonViTrucThuoc = tenDonViTrucThuoc;
	this.ngayTao = ngayTao;
	this.ngayCapNhat = ngayCapNhat;
}
public bang_donvitructhuoc_model() {
	super();
}

}
