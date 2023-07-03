package com.duan.model;

import java.sql.Timestamp;

public class bang_chucvu_model  extends abstract_model<bang_chucvu_model> {
private int machucvu;
private String tenchucvu;
private Timestamp ngaytao;
private Timestamp ngaycapnhat;
public int getMachucvu() {
	return machucvu;
}
public void setMachucvu(int machucvu) {
	this.machucvu = machucvu;
}
public String getTenchucvu() {
	return tenchucvu;
}
public void setTenchucvu(String tenchucvu) {
	this.tenchucvu = tenchucvu;
}
public Timestamp getNgaytao() {
	return ngaytao;
}
public void setNgaytao(Timestamp ngaytao) {
	this.ngaytao = ngaytao;
}
public Timestamp getNgaycapnhat() {
	return ngaycapnhat;
}
public void setNgaycapnhat(Timestamp ngaycapnhat) {
	this.ngaycapnhat = ngaycapnhat;
}
public bang_chucvu_model(int machucvu, String tenchucvu) {
	super();
	this.machucvu = machucvu;
	this.tenchucvu = tenchucvu;
	
}
public bang_chucvu_model(int machucvu, String tenchucvu, Timestamp ngaytao) {
	super();
	this.machucvu = machucvu;
	this.tenchucvu = tenchucvu;
	this.ngaytao = ngaytao;
}
public bang_chucvu_model() {
	super();
}

}
