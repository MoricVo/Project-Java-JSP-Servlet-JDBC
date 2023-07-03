package com.duan.model;

import java.sql.Timestamp;

public class bang_duan_dathamgia_model  extends abstract_model<bang_duan_dathamgia_model> {
private int maDuAn_DaThamGia;
private int maDuAn;
private String tenNguoiDung;
private String tenDonViTrucThuoc;
private String tenDanhMuc;
private String tenNhaTaiTro;

private String tenLoaiVienTro;

private String tenCoQuanPheDuyet;

private String tenDoiTacThucHien;

private String tenDuAn_TiengViet;
private String tenDuAn_TiengAnh;
private String thanhVienThamGia;
private String mucTieuDuAn;
private String noiDungThucHien;
private String thietBiTaiTro;
private String kinhPhiNamTruoc;
private String tongVonThucHien;
private String vonTaiTro;
private String vonVay;
private String vonKhac;
private String vonDoiUng;
private String tenDonViTienTe;
private String thoiGianThucHien;
private Timestamp thoiGianBatDau;
private Timestamp thoiGianKetThuc;
private String tienDoThucHien;
private String phanTramTienDoThucHien;
private String thuocQuy;
private String thuocNam;
private bang_duan_model duanquocte;


//đơn vị tiền tệ bổ sung//////
private String donViTienTeVonTaiTro;
private String donViTienTeVonVay;
private String donViTienTeVonKhac;
private String donViTienTeVonDoiUng;
private String donViTienTeTongVonThucHien;
///////////////////////////////////////

public int getMaDuAn_DaThamGia() {
	return maDuAn_DaThamGia;
}
public void setMaDuAn_DaThamGia(int maDuAn_DaThamGia) {
	this.maDuAn_DaThamGia = maDuAn_DaThamGia;
}
public int getMaDuAn() {
	return maDuAn;
}
public void setMaDuAn(int maDuAn) {
	this.maDuAn = maDuAn;
}

public String getTenNguoiDung() {
	return tenNguoiDung;
}
public void setTenNguoiDung(String tenNguoiDung) {
	this.tenNguoiDung = tenNguoiDung;
}
public String getTenDonViTrucThuoc() {
	return tenDonViTrucThuoc;
}
public void setTenDonViTrucThuoc(String tenDonViTrucThuoc) {
	this.tenDonViTrucThuoc = tenDonViTrucThuoc;
}
public String getTenDanhMuc() {
	return tenDanhMuc;
}
public void setTenDanhMuc(String tenDanhMuc) {
	this.tenDanhMuc = tenDanhMuc;
}
public String getTenNhaTaiTro() {
	return tenNhaTaiTro;
}
public void setTenNhaTaiTro(String tenNhaTaiTro) {
	this.tenNhaTaiTro = tenNhaTaiTro;
}
public String getTenLoaiVienTro() {
	return tenLoaiVienTro;
}
public void setTenLoaiVienTro(String tenLoaiVienTro) {
	this.tenLoaiVienTro = tenLoaiVienTro;
}
public String getTenCoQuanPheDuyet() {
	return tenCoQuanPheDuyet;
}
public void setTenCoQuanPheDuyet(String tenCoQuanPheDuyet) {
	this.tenCoQuanPheDuyet = tenCoQuanPheDuyet;
}
public String getTenDoiTacThucHien() {
	return tenDoiTacThucHien;
}
public void setTenDoiTacThucHien(String tenDoiTacThucHien) {
	this.tenDoiTacThucHien = tenDoiTacThucHien;
}
public String getTenDuAn_TiengViet() {
	return tenDuAn_TiengViet;
}
public void setTenDuAn_TiengViet(String tenDuAn_TiengViet) {
	this.tenDuAn_TiengViet = tenDuAn_TiengViet;
}
public String getTenDuAn_TiengAnh() {
	return tenDuAn_TiengAnh;
}
public void setTenDuAn_TiengAnh(String tenDuAn_TiengAnh) {
	this.tenDuAn_TiengAnh = tenDuAn_TiengAnh;
}
public String getThanhVienThamGia() {
	return thanhVienThamGia;
}
public void setThanhVienThamGia(String thanhVienThamGia) {
	this.thanhVienThamGia = thanhVienThamGia;
}
public String getMucTieuDuAn() {
	return mucTieuDuAn;
}
public void setMucTieuDuAn(String mucTieuDuAn) {
	this.mucTieuDuAn = mucTieuDuAn;
}
public String getNoiDungThucHien() {
	return noiDungThucHien;
}
public void setNoiDungThucHien(String noiDungThucHien) {
	this.noiDungThucHien = noiDungThucHien;
}
public String getThietBiTaiTro() {
	return thietBiTaiTro;
}
public void setThietBiTaiTro(String thietBiTaiTro) {
	this.thietBiTaiTro = thietBiTaiTro;
}
public String getKinhPhiNamTruoc() {
	return kinhPhiNamTruoc;
}
public void setKinhPhiNamTruoc(String kinhPhiNamTruoc) {
	this.kinhPhiNamTruoc = kinhPhiNamTruoc;
}
public String getTongVonThucHien() {
	return tongVonThucHien;
}
public void setTongVonThucHien(String tongVonThucHien) {
	this.tongVonThucHien = tongVonThucHien;
}
public String getVonTaiTro() {
	return vonTaiTro;
}
public void setVonTaiTro(String vonTaiTro) {
	this.vonTaiTro = vonTaiTro;
}
public String getVonVay() {
	return vonVay;
}
public void setVonVay(String vonVay) {
	this.vonVay = vonVay;
}
public String getVonKhac() {
	return vonKhac;
}
public void setVonKhac(String vonKhac) {
	this.vonKhac = vonKhac;
}
public String getVonDoiUng() {
	return vonDoiUng;
}
public void setVonDoiUng(String vonDoiUng) {
	this.vonDoiUng = vonDoiUng;
}
public String getTenDonViTienTe() {
	return tenDonViTienTe;
}
public void setTenDonViTienTe(String tenDonViTienTe) {
	this.tenDonViTienTe = tenDonViTienTe;
}
public String getThoiGianThucHien() {
	return thoiGianThucHien;
}
public void setThoiGianThucHien(String thoiGianThucHien) {
	this.thoiGianThucHien = thoiGianThucHien;
}
public Timestamp getThoiGianBatDau() {
	return thoiGianBatDau;
}
public void setThoiGianBatDau(Timestamp thoiGianBatDau) {
	this.thoiGianBatDau = thoiGianBatDau;
}
public Timestamp getThoiGianKetThuc() {
	return thoiGianKetThuc;
}
public void setThoiGianKetThuc(Timestamp thoiGianKetThuc) {
	this.thoiGianKetThuc = thoiGianKetThuc;
}
public String getTienDoThucHien() {
	return tienDoThucHien;
}
public void setTienDoThucHien(String tienDoThucHien) {
	this.tienDoThucHien = tienDoThucHien;
}
public String getPhanTramTienDoThucHien() {
	return phanTramTienDoThucHien;
}
public void setPhanTramTienDoThucHien(String phanTramTienDoThucHien) {
	this.phanTramTienDoThucHien = phanTramTienDoThucHien;
}
public String getThuocQuy() {
	return thuocQuy;
}
public void setThuocQuy(String thuocQuy) {
	this.thuocQuy = thuocQuy;
}
public String getThuocNam() {
	return thuocNam;
}
public void setThuocNam(String thuocNam) {
	this.thuocNam = thuocNam;
}
public bang_duan_model getDuanquocte() {
	return duanquocte;
}
public void setDuanquocte(bang_duan_model duanquocte) {
	this.duanquocte = duanquocte;
}


public String getDonViTienTeVonTaiTro() {
	return donViTienTeVonTaiTro;
}
public void setDonViTienTeVonTaiTro(String donViTienTeVonTaiTro) {
	this.donViTienTeVonTaiTro = donViTienTeVonTaiTro;
}
public String getDonViTienTeVonVay() {
	return donViTienTeVonVay;
}
public void setDonViTienTeVonVay(String donViTienTeVonVay) {
	this.donViTienTeVonVay = donViTienTeVonVay;
}
public String getDonViTienTeVonKhac() {
	return donViTienTeVonKhac;
}
public void setDonViTienTeVonKhac(String donViTienTeVonKhac) {
	this.donViTienTeVonKhac = donViTienTeVonKhac;
}
public String getDonViTienTeVonDoiUng() {
	return donViTienTeVonDoiUng;
}
public void setDonViTienTeVonDoiUng(String donViTienTeVonDoiUng) {
	this.donViTienTeVonDoiUng = donViTienTeVonDoiUng;
}
public String getDonViTienTeTongVonThucHien() {
	return donViTienTeTongVonThucHien;
}
public void setDonViTienTeTongVonThucHien(String donViTienTeTongVonThucHien) {
	this.donViTienTeTongVonThucHien = donViTienTeTongVonThucHien;
}
public bang_duan_dathamgia_model(int maDuAn_DaThamGia, int maDuAn, String thuocQuy,
		String thuocNam) {
	super();
	this.maDuAn_DaThamGia = maDuAn_DaThamGia;
	this.maDuAn = maDuAn;
	
	
	this.thuocQuy = thuocQuy;
	this.thuocNam = thuocNam;
}

public bang_duan_dathamgia_model(int maDuAn, String thuocQuy, String thuocNam) {
	super();
	this.maDuAn = maDuAn;
	this.thuocQuy = thuocQuy;
	this.thuocNam = thuocNam;
}
public bang_duan_dathamgia_model() {
	super();
}


}
