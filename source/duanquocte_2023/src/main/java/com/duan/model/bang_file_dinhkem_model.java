package com.duan.model;

public class bang_file_dinhkem_model extends abstract_model<bang_file_dinhkem_model> 
{
private  int mafileupload;
private  int maduan;
private  String file_decuongduan;
private  String file_thucahpnhanthuchien;
private  String file_totrinhxinphepthuchien;
private  String file_quyetdinhgiaokinhphi;
private  String file_quyetdinhthanhlapbanquanly;
private  String file_quyetdinhchophepthuchien;
private  String file_hopdongthoathuan_moa;
private  String file_kehoachtrienkhaiduan;
private  String file_baocaotiendogiuaky;
private  String file_baocaotongket;
private  String file_xacnhanketthucduan;
private  String file_lylichkhoahoccuachunhiemduan;
private  String file_bienbangiaitrinh;
private  String file_hinhanhthongtinhoatdongtrienkhai;
private  String file_cacminhchungkhac;
private  String file_cacminhchungkhac_2;
private bang_duan_model duan;
public  int getMafileupload() {
	return mafileupload;
}
public void setMafileupload( int mafileupload) {
	this.mafileupload = mafileupload;
}
public  int getMaduan() {
	return maduan;
}
public void setMaduan( int maduan) {
	this.maduan = maduan;
}
public  String getFile_decuongduan() {
	return file_decuongduan;
}
public void setFile_decuongduan( String file_decuongduan) {
	this.file_decuongduan = file_decuongduan;
}
public  String getFile_thucahpnhanthuchien() {
	return file_thucahpnhanthuchien;
}
public void setFile_thucahpnhanthuchien( String file_thucahpnhanthuchien) {
	this.file_thucahpnhanthuchien = file_thucahpnhanthuchien;
}
public  String getFile_totrinhxinphepthuchien() {
	return file_totrinhxinphepthuchien;
}
public void setFile_totrinhxinphepthuchien( String file_totrinhxinphepthuchien) {
	this.file_totrinhxinphepthuchien = file_totrinhxinphepthuchien;
}
public  String getFile_quyetdinhgiaokinhphi() {
	return file_quyetdinhgiaokinhphi;
}
public void setFile_quyetdinhgiaokinhphi( String file_quyetdinhgiaokinhphi) {
	this.file_quyetdinhgiaokinhphi = file_quyetdinhgiaokinhphi;
}
public  String getFile_quyetdinhthanhlapbanquanly() {
	return file_quyetdinhthanhlapbanquanly;
}
public void setFile_quyetdinhthanhlapbanquanly( String file_quyetdinhthanhlapbanquanly) {
	this.file_quyetdinhthanhlapbanquanly = file_quyetdinhthanhlapbanquanly;
}
public  String getFile_quyetdinhchophepthuchien() {
	return file_quyetdinhchophepthuchien;
}
public void setFile_quyetdinhchophepthuchien( String file_quyetdinhchophepthuchien) {
	this.file_quyetdinhchophepthuchien = file_quyetdinhchophepthuchien;
}
public  String getFile_hopdongthoathuan_moa() {
	return file_hopdongthoathuan_moa;
}
public void setFile_hopdongthoathuan_moa( String file_hopdongthoathuan_moa) {
	this.file_hopdongthoathuan_moa = file_hopdongthoathuan_moa;
}
public  String getFile_kehoachtrienkhaiduan() {
	return file_kehoachtrienkhaiduan;
}
public void setFile_kehoachtrienkhaiduan( String file_kehoachtrienkhaiduan) {
	this.file_kehoachtrienkhaiduan = file_kehoachtrienkhaiduan;
}
public  String getFile_baocaotiendogiuaky() {
	return file_baocaotiendogiuaky;
}
public void setFile_baocaotiendogiuaky( String file_baocaotiendogiuaky) {
	this.file_baocaotiendogiuaky = file_baocaotiendogiuaky;
}
public  String getFile_baocaotongket() {
	return file_baocaotongket;
}
public void setFile_baocaotongket( String file_baocaotongket) {
	this.file_baocaotongket = file_baocaotongket;
}
public  String getFile_xacnhanketthucduan() {
	return file_xacnhanketthucduan;
}
public void setFile_xacnhanketthucduan( String file_xacnhanketthucduan) {
	this.file_xacnhanketthucduan = file_xacnhanketthucduan;
}
public  String getFile_lylichkhoahoccuachunhiemduan() {
	return file_lylichkhoahoccuachunhiemduan;
}
public void setFile_lylichkhoahoccuachunhiemduan( String file_lylichkhoahoccuachunhiemduan) {
	this.file_lylichkhoahoccuachunhiemduan = file_lylichkhoahoccuachunhiemduan;
}
public  String getFile_bienbangiaitrinh() {
	return file_bienbangiaitrinh;
}
public void setFile_bienbangiaitrinh( String file_bienbangiaitrinh) {
	this.file_bienbangiaitrinh = file_bienbangiaitrinh;
}
public  String getFile_hinhanhthongtinhoatdongtrienkhai() {
	return file_hinhanhthongtinhoatdongtrienkhai;
}
public void setFile_hinhanhthongtinhoatdongtrienkhai( String file_hinhanhthongtinhoatdongtrienkhai) {
	this.file_hinhanhthongtinhoatdongtrienkhai = file_hinhanhthongtinhoatdongtrienkhai;
}
public  String getFile_cacminhchungkhac() {
	return file_cacminhchungkhac;
}
public void setFile_cacminhchungkhac( String file_cacminhchungkhac) {
	this.file_cacminhchungkhac = file_cacminhchungkhac;
}
public  String getFile_cacminhchungkhac_2() {
	return file_cacminhchungkhac_2;
}
public void setFile_cacminhchungkhac_2( String file_cacminhchungkhac_2) {
	this.file_cacminhchungkhac_2 = file_cacminhchungkhac_2;
}
public bang_file_dinhkem_model( int mafileupload,  int maduan,  String file_decuongduan,  String file_thucahpnhanthuchien,
		 String file_totrinhxinphepthuchien,  String file_quyetdinhgiaokinhphi,  String file_quyetdinhthanhlapbanquanly,
		 String file_quyetdinhchophepthuchien,  String file_hopdongthoathuan_moa,  String file_kehoachtrienkhaiduan,
		 String file_baocaotiendogiuaky,  String file_baocaotongket,  String file_xacnhanketthucduan,
		 String file_lylichkhoahoccuachunhiemduan,  String file_bienbangiaitrinh,  String file_hinhanhthongtinhoatdongtrienkhai,
		 String file_cacminhchungkhac,  String file_cacminhchungkhac_2) {
	super();
	this.mafileupload = mafileupload;
	this.maduan = maduan;
	this.file_decuongduan = file_decuongduan;
	this.file_thucahpnhanthuchien = file_thucahpnhanthuchien;
	this.file_totrinhxinphepthuchien = file_totrinhxinphepthuchien;
	this.file_quyetdinhgiaokinhphi = file_quyetdinhgiaokinhphi;
	this.file_quyetdinhthanhlapbanquanly = file_quyetdinhthanhlapbanquanly;
	this.file_quyetdinhchophepthuchien = file_quyetdinhchophepthuchien;
	this.file_hopdongthoathuan_moa = file_hopdongthoathuan_moa;
	this.file_kehoachtrienkhaiduan = file_kehoachtrienkhaiduan;
	this.file_baocaotiendogiuaky = file_baocaotiendogiuaky;
	this.file_baocaotongket = file_baocaotongket;
	this.file_xacnhanketthucduan = file_xacnhanketthucduan;
	this.file_lylichkhoahoccuachunhiemduan = file_lylichkhoahoccuachunhiemduan;
	this.file_bienbangiaitrinh = file_bienbangiaitrinh;
	this.file_hinhanhthongtinhoatdongtrienkhai = file_hinhanhthongtinhoatdongtrienkhai;
	this.file_cacminhchungkhac = file_cacminhchungkhac;
	this.file_cacminhchungkhac_2 = file_cacminhchungkhac_2;
}

public bang_file_dinhkem_model(String file_decuongduan, String file_thucahpnhanthuchien,
		String file_totrinhxinphepthuchien, String file_quyetdinhgiaokinhphi, String file_quyetdinhthanhlapbanquanly,
		String file_quyetdinhchophepthuchien, String file_hopdongthoathuan_moa, String file_kehoachtrienkhaiduan,
		String file_baocaotiendogiuaky, String file_baocaotongket, String file_xacnhanketthucduan,
		String file_lylichkhoahoccuachunhiemduan, String file_bienbangiaitrinh,
		String file_hinhanhthongtinhoatdongtrienkhai, String file_cacminhchungkhac, String file_cacminhchungkhac_2) {
	super();
	this.file_decuongduan = file_decuongduan;
	this.file_thucahpnhanthuchien = file_thucahpnhanthuchien;
	this.file_totrinhxinphepthuchien = file_totrinhxinphepthuchien;
	this.file_quyetdinhgiaokinhphi = file_quyetdinhgiaokinhphi;
	this.file_quyetdinhthanhlapbanquanly = file_quyetdinhthanhlapbanquanly;
	this.file_quyetdinhchophepthuchien = file_quyetdinhchophepthuchien;
	this.file_hopdongthoathuan_moa = file_hopdongthoathuan_moa;
	this.file_kehoachtrienkhaiduan = file_kehoachtrienkhaiduan;
	this.file_baocaotiendogiuaky = file_baocaotiendogiuaky;
	this.file_baocaotongket = file_baocaotongket;
	this.file_xacnhanketthucduan = file_xacnhanketthucduan;
	this.file_lylichkhoahoccuachunhiemduan = file_lylichkhoahoccuachunhiemduan;
	this.file_bienbangiaitrinh = file_bienbangiaitrinh;
	this.file_hinhanhthongtinhoatdongtrienkhai = file_hinhanhthongtinhoatdongtrienkhai;
	this.file_cacminhchungkhac = file_cacminhchungkhac;
	this.file_cacminhchungkhac_2 = file_cacminhchungkhac_2;
}

public bang_file_dinhkem_model(int maduan, String file_decuongduan, String file_thucahpnhanthuchien,
		String file_totrinhxinphepthuchien, String file_quyetdinhgiaokinhphi, String file_quyetdinhthanhlapbanquanly,
		String file_quyetdinhchophepthuchien, String file_hopdongthoathuan_moa, String file_kehoachtrienkhaiduan,
		String file_baocaotiendogiuaky, String file_baocaotongket, String file_xacnhanketthucduan,
		String file_lylichkhoahoccuachunhiemduan, String file_bienbangiaitrinh,
		String file_hinhanhthongtinhoatdongtrienkhai, String file_cacminhchungkhac, String file_cacminhchungkhac_2) {
	super();
	this.maduan = maduan;
	this.file_decuongduan = file_decuongduan;
	this.file_thucahpnhanthuchien = file_thucahpnhanthuchien;
	this.file_totrinhxinphepthuchien = file_totrinhxinphepthuchien;
	this.file_quyetdinhgiaokinhphi = file_quyetdinhgiaokinhphi;
	this.file_quyetdinhthanhlapbanquanly = file_quyetdinhthanhlapbanquanly;
	this.file_quyetdinhchophepthuchien = file_quyetdinhchophepthuchien;
	this.file_hopdongthoathuan_moa = file_hopdongthoathuan_moa;
	this.file_kehoachtrienkhaiduan = file_kehoachtrienkhaiduan;
	this.file_baocaotiendogiuaky = file_baocaotiendogiuaky;
	this.file_baocaotongket = file_baocaotongket;
	this.file_xacnhanketthucduan = file_xacnhanketthucduan;
	this.file_lylichkhoahoccuachunhiemduan = file_lylichkhoahoccuachunhiemduan;
	this.file_bienbangiaitrinh = file_bienbangiaitrinh;
	this.file_hinhanhthongtinhoatdongtrienkhai = file_hinhanhthongtinhoatdongtrienkhai;
	this.file_cacminhchungkhac = file_cacminhchungkhac;
	this.file_cacminhchungkhac_2 = file_cacminhchungkhac_2;
}

public bang_file_dinhkem_model(int maduan, String file_decuongduan, String file_thucahpnhanthuchien,
		String file_totrinhxinphepthuchien, String file_quyetdinhgiaokinhphi, String file_quyetdinhthanhlapbanquanly,
		String file_quyetdinhchophepthuchien, String file_hopdongthoathuan_moa, String file_kehoachtrienkhaiduan,
		String file_baocaotiendogiuaky, String file_baocaotongket, String file_xacnhanketthucduan,
		String file_lylichkhoahoccuachunhiemduan, String file_bienbangiaitrinh,
		String file_hinhanhthongtinhoatdongtrienkhai, String file_cacminhchungkhac, String file_cacminhchungkhac_2,
		bang_duan_model duan) {
	super();
	this.maduan = maduan;
	this.file_decuongduan = file_decuongduan;
	this.file_thucahpnhanthuchien = file_thucahpnhanthuchien;
	this.file_totrinhxinphepthuchien = file_totrinhxinphepthuchien;
	this.file_quyetdinhgiaokinhphi = file_quyetdinhgiaokinhphi;
	this.file_quyetdinhthanhlapbanquanly = file_quyetdinhthanhlapbanquanly;
	this.file_quyetdinhchophepthuchien = file_quyetdinhchophepthuchien;
	this.file_hopdongthoathuan_moa = file_hopdongthoathuan_moa;
	this.file_kehoachtrienkhaiduan = file_kehoachtrienkhaiduan;
	this.file_baocaotiendogiuaky = file_baocaotiendogiuaky;
	this.file_baocaotongket = file_baocaotongket;
	this.file_xacnhanketthucduan = file_xacnhanketthucduan;
	this.file_lylichkhoahoccuachunhiemduan = file_lylichkhoahoccuachunhiemduan;
	this.file_bienbangiaitrinh = file_bienbangiaitrinh;
	this.file_hinhanhthongtinhoatdongtrienkhai = file_hinhanhthongtinhoatdongtrienkhai;
	this.file_cacminhchungkhac = file_cacminhchungkhac;
	this.file_cacminhchungkhac_2 = file_cacminhchungkhac_2;
	this.duan = duan;
}
public bang_file_dinhkem_model(int maduan) {
	super();
	this.maduan = maduan;
}
public bang_file_dinhkem_model() {
	super();
}
public bang_duan_model getDuan() {
	return duan;
}
public void setDuan(bang_duan_model duan) {
	this.duan = duan;
}


}
