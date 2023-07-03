package com.duan.model;

import java.sql.Timestamp;

public class bang_coquanpheduyet_model extends abstract_model<bang_coquanpheduyet_model>{
private int maCoQuanPheDuyet;

private String tenCoQuanPheDuyet;
private Timestamp ngayTao;
private int nguoiTao;
private Timestamp ngayCapNhat;
public int getMaCoQuanPheDuyet() {
	return maCoQuanPheDuyet;
}
public void setMaCoQuanPheDuyet(int maCoQuanPheDuyet) {
	this.maCoQuanPheDuyet = maCoQuanPheDuyet;
}
public String getTenCoQuanPheDuyet() {
	return tenCoQuanPheDuyet;
}
public void setTenCoQuanPheDuyet(String tenCoQuanPheDuyet) {
	this.tenCoQuanPheDuyet = tenCoQuanPheDuyet;
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


public bang_coquanpheduyet_model(int maCoQuanPheDuyet, String tenCoQuanPheDuyet
		) {
	super();
	this.maCoQuanPheDuyet = maCoQuanPheDuyet;

	this.tenCoQuanPheDuyet = tenCoQuanPheDuyet;
	
}

public bang_coquanpheduyet_model(int maCoQuanPheDuyet, String tenCoQuanPheDuyet, Timestamp ngayTao,int nguoiTao) {
	super();
	this.maCoQuanPheDuyet = maCoQuanPheDuyet;
	this.tenCoQuanPheDuyet = tenCoQuanPheDuyet;
	this.ngayTao = ngayTao;
	this.nguoiTao=nguoiTao;
	
}
public bang_coquanpheduyet_model() {
	super();
}
public int getNguoiTao() {
	return nguoiTao;
}
public void setNguoiTao(int nguoiTao) {
	this.nguoiTao = nguoiTao;
}


}
