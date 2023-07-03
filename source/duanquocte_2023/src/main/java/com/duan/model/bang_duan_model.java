package com.duan.model;

import java.sql.Timestamp;

public class bang_duan_model extends abstract_model<bang_duan_model> {
private int maDuAn;
private int maNguoiDung;
private int maDonViTrucThuoc;
private int maDanhMuc;
private int maNhaTaiTro;
private int maLoaiVienTro;
private int maCoQuanPheDuyet;
private int maDoiTacThucHien;
private String tenDuAn_TiengViet;
private String tenDuAn_TiengAnh;
private String thanhVienThamGia;
private String mucTieuDuAn;
private String noiDungThucHien;
private String thietBiTaiTro;
private String kinhPhiNamTruoc;
private float tongVonThucHien;
private float vonTaiTro;
private float vonVay;
private float vonKhac;
private float vonDoiUng;
private int maDonViTienTe;
private String thoiGianThucHien;
private Timestamp thoiGianBatDau;
private Timestamp thoiGianKetThuc;
private String tienDoThucHien;
private String phanTramTienDoThucHien;
private Timestamp ngayTao;
private Timestamp ngayCapNhat;
private int trangThaiDuAn;
private int trangThaiKetThuc;


//thống kê/////////
private int soluong;
private int soluongduanconhoatdong;
private int soluongduanketthuc;
///////////////////
//đơn vị tiền tệ bổ sung//////
private String donViTienTe_VonTaiTro;
private String donViTienTe_VonVay;
private String donViTienTe_VonKhac;
private String donViTienTe_VonDoiUng;
private String donViTienTe_TongVonThucHien;
///////////////////////////////////////



private bang_nguoidung_model nguoidung=new bang_nguoidung_model();
private bang_donvitructhuoc_model donvitructhuoc=new bang_donvitructhuoc_model();
private bang_danhmuc_model danhmuc=new bang_danhmuc_model();
private bang_doitacthuchien_model doitacthuchien =new bang_doitacthuchien_model();
private bang_donvitiente_model donvitiente=new bang_donvitiente_model();
private bang_nhataitro_model nhataitro=new bang_nhataitro_model();
private bang_loaivientro_model loaivientro=new bang_loaivientro_model();
private bang_coquanpheduyet_model coquanpheduyet =new bang_coquanpheduyet_model();
public int getMaDuAn() {
	return maDuAn;
}
public void setMaDuAn(int maDuAn) {
	this.maDuAn = maDuAn;
}
public int getMaNguoiDung() {
	return maNguoiDung;
}
public void setMaNguoiDung(int maNguoiDung) {
	this.maNguoiDung = maNguoiDung;
}
public int getMaDonViTrucThuoc() {
	return maDonViTrucThuoc;
}
public void setMaDonViTrucThuoc(int maDonViTrucThuoc) {
	this.maDonViTrucThuoc = maDonViTrucThuoc;
}
public int getMaDanhMuc() {
	return maDanhMuc;
}
public void setMaDanhMuc(int maDanhMuc) {
	this.maDanhMuc = maDanhMuc;
}
public int getMaNhaTaiTro() {
	return maNhaTaiTro;
}
public void setMaNhaTaiTro(int maNhaTaiTro) {
	this.maNhaTaiTro = maNhaTaiTro;
}

public int getMaLoaiVienTro() {
	return maLoaiVienTro;
}
public void setMaLoaiVienTro(int maLoaiVienTro) {
	this.maLoaiVienTro = maLoaiVienTro;
}

public int getMaCoQuanPheDuyet() {
	return maCoQuanPheDuyet;
}
public void setMaCoQuanPheDuyet(int maCoQuanPheDuyet) {
	this.maCoQuanPheDuyet = maCoQuanPheDuyet;
}

public int getMaDoiTacThucHien() {
	return maDoiTacThucHien;
}
public void setMaDoiTacThucHien(int maDoiTacThucHien) {
	this.maDoiTacThucHien = maDoiTacThucHien;
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
public String getKinhPhiNamTruoc() {
	return kinhPhiNamTruoc;
}
public void setKinhPhiNamTruoc(String kinhPhiNamTruoc) {
	this.kinhPhiNamTruoc = kinhPhiNamTruoc;
}
public float getTongVonThucHien() {
	return tongVonThucHien;
}
public void setTongVonThucHien(float tongVonThucHien) {
	this.tongVonThucHien = tongVonThucHien;
}
public float getVonTaiTro() {
	return vonTaiTro;
}
public void setVonTaiTro(float vonTaiTro) {
	this.vonTaiTro = vonTaiTro;
}
public float getVonVay() {
	return vonVay;
}
public void setVonVay(float vonVay) {
	this.vonVay = vonVay;
}
public float getVonKhac() {
	return vonKhac;
}
public void setVonKhac(float vonKhac) {
	this.vonKhac = vonKhac;
}
public float getVonDoiUng() {
	return vonDoiUng;
}
public void setVonDoiUng(float vonDoiUng) {
	this.vonDoiUng = vonDoiUng;
}
public int getMaDonViTienTe() {
	return maDonViTienTe;
}
public void setMaDonViTienTe(int maDonViTienTe) {
	this.maDonViTienTe = maDonViTienTe;
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

public int getTrangThaiDuAn() {
	return trangThaiDuAn;
}
public void setTrangThaiDuAn(int trangThaiDuAn) {
	this.trangThaiDuAn = trangThaiDuAn;
}
public bang_nguoidung_model getNguoidung() {
	return nguoidung;
}
public void setNguoidung(bang_nguoidung_model nguoidung) {
	this.nguoidung = nguoidung;
}
public bang_donvitructhuoc_model getDonvitructhuoc() {
	return donvitructhuoc;
}
public void setDonvitructhuoc(bang_donvitructhuoc_model donvitructhuoc) {
	this.donvitructhuoc = donvitructhuoc;
}
public bang_danhmuc_model getDanhmuc() {
	return danhmuc;
}
public void setDanhmuc(bang_danhmuc_model danhmuc) {
	this.danhmuc = danhmuc;
}
public bang_doitacthuchien_model getDoitacthuchien() {
	return doitacthuchien;
}
public void setDoitacthuchien(bang_doitacthuchien_model doitacthuchien) {
	this.doitacthuchien = doitacthuchien;
}
public bang_donvitiente_model getDonvitiente() {
	return donvitiente;
}
public void setDonvitiente(bang_donvitiente_model donvitiente) {
	this.donvitiente = donvitiente;
}
public bang_nhataitro_model getNhataitro() {
	return nhataitro;
}
public void setNhataitro(bang_nhataitro_model nhataitro) {
	this.nhataitro = nhataitro;
}
public bang_loaivientro_model getLoaivientro() {
	return loaivientro;
}
public void setLoaivientro(bang_loaivientro_model loaivientro) {
	this.loaivientro = loaivientro;
}
public bang_coquanpheduyet_model getCoquanpheduyet() {
	return coquanpheduyet;
}
public void setCoquanpheduyet(bang_coquanpheduyet_model coquanpheduyet) {
	this.coquanpheduyet = coquanpheduyet;
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

public int getTrangThaiKetThuc() {
	return trangThaiKetThuc;
}
public void setTrangThaiKetThuc(int trangThaiKetThuc) {
	this.trangThaiKetThuc = trangThaiKetThuc;
}

//thống kê////////////////////////
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}
public int getSoluongduanconhoatdong() {
	return soluongduanconhoatdong;
}
public void setSoluongduanconhoatdong(int soluongduanconhoatdong) {
	this.soluongduanconhoatdong = soluongduanconhoatdong;
}
public int getSoluongduanketthuc() {
	return soluongduanketthuc;
}
public void setSoluongduanketthuc(int soluongduanketthuc) {
	this.soluongduanketthuc = soluongduanketthuc;
}

//đơn vị tiền tệ////////////////
public String getDonViTienTe_VonTaiTro() {
	return donViTienTe_VonTaiTro;
}
public void setDonViTienTe_VonTaiTro(String donViTienTe_VonTaiTro) {
	this.donViTienTe_VonTaiTro = donViTienTe_VonTaiTro;
}
public String getDonViTienTe_VonVay() {
	return donViTienTe_VonVay;
}
public void setDonViTienTe_VonVay(String donViTienTe_VonVay) {
	this.donViTienTe_VonVay = donViTienTe_VonVay;
}
public String getDonViTienTe_VonKhac() {
	return donViTienTe_VonKhac;
}
public void setDonViTienTe_VonKhac(String donViTienTe_VonKhac) {
	this.donViTienTe_VonKhac = donViTienTe_VonKhac;
}
public String getDonViTienTe_VonDoiUng() {
	return donViTienTe_VonDoiUng;
}
public void setDonViTienTe_VonDoiUng(String donViTienTe_VonDoiUng) {
	this.donViTienTe_VonDoiUng = donViTienTe_VonDoiUng;
}
public String getDonViTienTe_TongVonThucHien() {
	return donViTienTe_TongVonThucHien;
}
public void setDonViTienTe_TongVonThucHien(String donViTienTe_TongVonThucHien) {
	this.donViTienTe_TongVonThucHien = donViTienTe_TongVonThucHien;
}
///////////////////////////////////////////////////////////////////


public bang_duan_model(int maDuAn, int maNguoiDung, int maDonViTrucThuoc, int maDanhMuc, int maNhaTaiTro,
		int maLoaiVienTro, int maCoQuanPheDuyet, int maDoiTacThucHien, String tenDuAn_TiengViet,
		String tenDuAn_TiengAnh, String kinhPhiNamTruoc, float tongVonThucHien, float vonTaiTro, float vonVay,
		float vonKhac, float vonDoiUng,int maDonViTienTe, String thoiGianThucHien, String tienDoThucHien, String phanTramTienDoThucHien,
		Timestamp ngayTao) {
	super();
	this.maDuAn = maDuAn;
	this.maNguoiDung = maNguoiDung;
	this.maDonViTrucThuoc = maDonViTrucThuoc;
	this.maDanhMuc = maDanhMuc;
	this.maNhaTaiTro = maNhaTaiTro;

	this.maLoaiVienTro = maLoaiVienTro;
	
	this.maCoQuanPheDuyet = maCoQuanPheDuyet;
	
	this.maDoiTacThucHien = maDoiTacThucHien;
	
	this.tenDuAn_TiengViet = tenDuAn_TiengViet;
	this.tenDuAn_TiengAnh = tenDuAn_TiengAnh;
	this.kinhPhiNamTruoc = kinhPhiNamTruoc;
	this.tongVonThucHien = tongVonThucHien;
	this.vonTaiTro = vonTaiTro;
	this.vonVay = vonVay;
	this.vonKhac = vonKhac;
	this.vonDoiUng = vonDoiUng;
	this.maDonViTienTe=maDonViTienTe;
	this.thoiGianThucHien = thoiGianThucHien;
	this.tienDoThucHien = tienDoThucHien;
	this.phanTramTienDoThucHien = phanTramTienDoThucHien;
	this.ngayTao = ngayTao;
}

public bang_duan_model(int maDuAn, int maNguoiDung, int maDonViTrucThuoc, int maDanhMuc, int maNhaTaiTro,
		int maLoaiVienTro, int maCoQuanPheDuyet, int maDoiTacThucHien, String tenDuAn_TiengViet,
		String tenDuAn_TiengAnh, String kinhPhiNamTruoc, float tongVonThucHien, float vonTaiTro, float vonVay,
		float vonKhac, float vonDoiUng, String thoiGianThucHien, String tienDoThucHien, String phanTramTienDoThucHien,
		Timestamp ngayTao) {
	super();
	this.maDuAn = maDuAn;
	this.maNguoiDung = maNguoiDung;
	this.maDonViTrucThuoc = maDonViTrucThuoc;
	this.maDanhMuc = maDanhMuc;
	this.maNhaTaiTro = maNhaTaiTro;
	this.maLoaiVienTro = maLoaiVienTro;
	this.maCoQuanPheDuyet = maCoQuanPheDuyet;
	this.maDoiTacThucHien = maDoiTacThucHien;
	this.tenDuAn_TiengViet = tenDuAn_TiengViet;
	this.tenDuAn_TiengAnh = tenDuAn_TiengAnh;
	this.kinhPhiNamTruoc = kinhPhiNamTruoc;
	this.tongVonThucHien = tongVonThucHien;
	this.vonTaiTro = vonTaiTro;
	this.vonVay = vonVay;
	this.vonKhac = vonKhac;
	this.vonDoiUng = vonDoiUng;
	this.thoiGianThucHien = thoiGianThucHien;
	this.tienDoThucHien = tienDoThucHien;
	this.phanTramTienDoThucHien = phanTramTienDoThucHien;
	this.ngayTao = ngayTao;
}



public bang_duan_model(int maDuAn, int maNguoiDung, int maDonViTrucThuoc, int maDanhMuc, int maNhaTaiTro,
		 int maLoaiVienTro, int maCoQuanPheDuyet,
		 int maDoiTacThucHien, 
		String tenDuAn_TiengViet, String tenDuAn_TiengAnh, String kinhPhiNamTruoc, float tongVonThucHien,
		float vonTaiTro, float vonVay, float vonKhac, float vonDoiUng, int maDonViTienTe, String thoiGianThucHien,
		String tienDoThucHien, String phanTramTienDoThucHien, Timestamp ngayTao, 
		int trangThaiDuAn) {
	super();
	this.maDuAn = maDuAn;
	this.maNguoiDung = maNguoiDung;
	this.maDonViTrucThuoc = maDonViTrucThuoc;
	this.maDanhMuc = maDanhMuc;
	this.maNhaTaiTro = maNhaTaiTro;
	
	this.maLoaiVienTro = maLoaiVienTro;
	
	this.maCoQuanPheDuyet = maCoQuanPheDuyet;
	
	this.maDoiTacThucHien = maDoiTacThucHien;

	this.tenDuAn_TiengViet = tenDuAn_TiengViet;
	this.tenDuAn_TiengAnh = tenDuAn_TiengAnh;
	this.kinhPhiNamTruoc = kinhPhiNamTruoc;
	this.tongVonThucHien = tongVonThucHien;
	this.vonTaiTro = vonTaiTro;
	this.vonVay = vonVay;
	this.vonKhac = vonKhac;
	this.vonDoiUng = vonDoiUng;
	this.maDonViTienTe = maDonViTienTe;
	this.thoiGianThucHien = thoiGianThucHien;
	this.tienDoThucHien = tienDoThucHien;
	this.phanTramTienDoThucHien = phanTramTienDoThucHien;
	this.ngayTao = ngayTao;
	
	this.trangThaiDuAn = trangThaiDuAn;
}



public bang_duan_model(int maDuAn, int maNguoiDung, int maDonViTrucThuoc, int maDanhMuc, int maNhaTaiTro,
		int maLoaiVienTro, int maCoQuanPheDuyet, int maDoiTacThucHien, String tenDuAn_TiengViet,
		String tenDuAn_TiengAnh, String thanhVienThamGia, String mucTieuDuAn, String noiDungThucHien,
		String thietBiTaiTro, String kinhPhiNamTruoc, float tongVonThucHien, float vonTaiTro, float vonVay,
		float vonKhac, float vonDoiUng, int maDonViTienTe, String thoiGianThucHien, String tienDoThucHien,
		String phanTramTienDoThucHien, Timestamp ngayTao) {
	super();
	this.maDuAn = maDuAn;
	this.maNguoiDung = maNguoiDung;
	this.maDonViTrucThuoc = maDonViTrucThuoc;
	this.maDanhMuc = maDanhMuc;
	this.maNhaTaiTro = maNhaTaiTro;
	this.maLoaiVienTro = maLoaiVienTro;
	this.maCoQuanPheDuyet = maCoQuanPheDuyet;
	this.maDoiTacThucHien = maDoiTacThucHien;
	this.tenDuAn_TiengViet = tenDuAn_TiengViet;
	this.tenDuAn_TiengAnh = tenDuAn_TiengAnh;
	this.thanhVienThamGia = thanhVienThamGia;
	this.mucTieuDuAn = mucTieuDuAn;
	this.noiDungThucHien = noiDungThucHien;
	this.thietBiTaiTro = thietBiTaiTro;
	this.kinhPhiNamTruoc = kinhPhiNamTruoc;
	this.tongVonThucHien = tongVonThucHien;
	this.vonTaiTro = vonTaiTro;
	this.vonVay = vonVay;
	this.vonKhac = vonKhac;
	this.vonDoiUng = vonDoiUng;
	this.maDonViTienTe = maDonViTienTe;
	this.thoiGianThucHien = thoiGianThucHien;
	this.tienDoThucHien = tienDoThucHien;
	this.phanTramTienDoThucHien = phanTramTienDoThucHien;
	this.ngayTao = ngayTao;
	
	
}


public bang_duan_model(int maDuAn, int maNguoiDung, int maDonViTrucThuoc, int maDanhMuc, int maNhaTaiTro,
		int maLoaiVienTro, int maCoQuanPheDuyet, int maDoiTacThucHien, String tenDuAn_TiengViet,
		String tenDuAn_TiengAnh, String thanhVienThamGia, String mucTieuDuAn, String noiDungThucHien,
		String thietBiTaiTro, String kinhPhiNamTruoc, float tongVonThucHien, float vonTaiTro, float vonVay,
		float vonKhac, float vonDoiUng, int maDonViTienTe, String thoiGianThucHien, Timestamp thoiGianBatDau,
		Timestamp thoiGianKetThuc, String tienDoThucHien, String phanTramTienDoThucHien, Timestamp ngayTao
		) {
	super();
	this.maDuAn = maDuAn;
	this.maNguoiDung = maNguoiDung;
	this.maDonViTrucThuoc = maDonViTrucThuoc;
	this.maDanhMuc = maDanhMuc;
	this.maNhaTaiTro = maNhaTaiTro;
	this.maLoaiVienTro = maLoaiVienTro;
	this.maCoQuanPheDuyet = maCoQuanPheDuyet;
	this.maDoiTacThucHien = maDoiTacThucHien;
	this.tenDuAn_TiengViet = tenDuAn_TiengViet;
	this.tenDuAn_TiengAnh = tenDuAn_TiengAnh;
	this.thanhVienThamGia = thanhVienThamGia;
	this.mucTieuDuAn = mucTieuDuAn;
	this.noiDungThucHien = noiDungThucHien;
	this.thietBiTaiTro = thietBiTaiTro;
	this.kinhPhiNamTruoc = kinhPhiNamTruoc;
	this.tongVonThucHien = tongVonThucHien;
	this.vonTaiTro = vonTaiTro;
	this.vonVay = vonVay;
	this.vonKhac = vonKhac;
	this.vonDoiUng = vonDoiUng;
	this.maDonViTienTe = maDonViTienTe;
	this.thoiGianThucHien = thoiGianThucHien;
	this.thoiGianBatDau = thoiGianBatDau;
	this.thoiGianKetThuc = thoiGianKetThuc;
	this.tienDoThucHien = tienDoThucHien;
	this.phanTramTienDoThucHien = phanTramTienDoThucHien;
	this.ngayTao = ngayTao;
	
}


public bang_duan_model(int maDuAn) {
	super();
	this.maDuAn = maDuAn;
}

public bang_duan_model(String tenDuAn_TiengViet) {
	super();
	this.tenDuAn_TiengViet = tenDuAn_TiengViet;
}
public bang_duan_model() {
	super();
}



public bang_duan_model(int soluong, int soluongduanconhoatdong, int soluongduanketthuc,
		bang_donvitructhuoc_model donvitructhuoc) {
	super();
	this.soluong = soluong;
	this.soluongduanconhoatdong = soluongduanconhoatdong;
	this.soluongduanketthuc = soluongduanketthuc;
	this.donvitructhuoc = donvitructhuoc;
}

public bang_duan_model(String tenDuAn_TiengViet, float tongVonThucHien,bang_donvitiente_model donvitiente, bang_nhataitro_model nhataitro,String donViTienTe_TongVonThucHien) {
	super();
	this.tenDuAn_TiengViet = tenDuAn_TiengViet;
	this.tongVonThucHien = tongVonThucHien;
	this.donvitiente=donvitiente;
	this.nhataitro = nhataitro;
	this.donViTienTe_TongVonThucHien=donViTienTe_TongVonThucHien;
	
	
}
public bang_duan_model(String tenDuAn_TiengViet, float tongVonThucHien, bang_donvitructhuoc_model donvitructhuoc,
		bang_donvitiente_model donvitiente, bang_nhataitro_model nhataitro,String donViTienTe_TongVonThucHien) {
	super();
	this.tenDuAn_TiengViet = tenDuAn_TiengViet;
	this.tongVonThucHien = tongVonThucHien;
	this.donvitructhuoc = donvitructhuoc;
	this.donvitiente = donvitiente;
	this.nhataitro = nhataitro;
	this.donViTienTe_TongVonThucHien=donViTienTe_TongVonThucHien;
}
public bang_duan_model(int maDuAn, int maNguoiDung, int maDonViTrucThuoc, int maDanhMuc, int maNhaTaiTro,
		int maLoaiVienTro, int maCoQuanPheDuyet, int maDoiTacThucHien, String tenDuAn_TiengViet,
		String tenDuAn_TiengAnh, String thanhVienThamGia, String mucTieuDuAn, String noiDungThucHien,
		String thietBiTaiTro, String kinhPhiNamTruoc, float tongVonThucHien, float vonTaiTro, float vonVay,
		float vonKhac, float vonDoiUng, int maDonViTienTe, String thoiGianThucHien, Timestamp thoiGianBatDau,
		Timestamp thoiGianKetThuc, String tienDoThucHien, String phanTramTienDoThucHien, Timestamp ngayTao,
		 String donViTienTe_VonTaiTro, String donViTienTe_VonVay, String donViTienTe_VonKhac,
		String donViTienTe_VonDoiUng, String donViTienTe_TongVonThucHien) {
	super();
	this.maDuAn = maDuAn;
	this.maNguoiDung = maNguoiDung;
	this.maDonViTrucThuoc = maDonViTrucThuoc;
	this.maDanhMuc = maDanhMuc;
	this.maNhaTaiTro = maNhaTaiTro;
	this.maLoaiVienTro = maLoaiVienTro;
	this.maCoQuanPheDuyet = maCoQuanPheDuyet;
	this.maDoiTacThucHien = maDoiTacThucHien;
	this.tenDuAn_TiengViet = tenDuAn_TiengViet;
	this.tenDuAn_TiengAnh = tenDuAn_TiengAnh;
	this.thanhVienThamGia = thanhVienThamGia;
	this.mucTieuDuAn = mucTieuDuAn;
	this.noiDungThucHien = noiDungThucHien;
	this.thietBiTaiTro = thietBiTaiTro;
	this.kinhPhiNamTruoc = kinhPhiNamTruoc;
	this.tongVonThucHien = tongVonThucHien;
	this.vonTaiTro = vonTaiTro;
	this.vonVay = vonVay;
	this.vonKhac = vonKhac;
	this.vonDoiUng = vonDoiUng;
	this.maDonViTienTe = maDonViTienTe;
	this.thoiGianThucHien = thoiGianThucHien;
	this.thoiGianBatDau = thoiGianBatDau;
	this.thoiGianKetThuc = thoiGianKetThuc;
	this.tienDoThucHien = tienDoThucHien;
	this.phanTramTienDoThucHien = phanTramTienDoThucHien;
	this.ngayTao = ngayTao;
	
	this.donViTienTe_VonTaiTro = donViTienTe_VonTaiTro;
	this.donViTienTe_VonVay = donViTienTe_VonVay;
	this.donViTienTe_VonKhac = donViTienTe_VonKhac;
	this.donViTienTe_VonDoiUng = donViTienTe_VonDoiUng;
	this.donViTienTe_TongVonThucHien = donViTienTe_TongVonThucHien;
}




//thống kê////////////////////////


}
