package com.duan.model;

import java.sql.Timestamp;

public class bang_nguoidung_model extends abstract_model<bang_nguoidung_model> {
	private int maNguoiDung;
	private int maDonViTrucThuoc;
	private int maChucVu;
	private String hoNguoiDung;
	private String tenNguoiDung;
	private String sdt;
	private String diaChi;
	private String gmail;
	private String matKhau;
	private String quyenHan;
	private int trangThai;
	private String anhDaiDien;
	private Timestamp ngayLap;
	private Timestamp ngayCapNhat;
	private String maXacThuc;
	private Boolean trangThaiXacThuc;
	private Timestamp thoiGianHieuLuc;
    private bang_chucvu_model bangchucvu  =new bang_chucvu_model();
    private bang_donvitructhuoc_model donvitructhuoc  =new bang_donvitructhuoc_model();
   
	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public int getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getHoNguoiDung() {
		return hoNguoiDung;
	}

	public void setHoNguoiDung(String hoNguoiDung) {
		this.hoNguoiDung = hoNguoiDung;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyenHan() {
		return quyenHan;
	}

	public void setQuyenHan(String quyenHan) {
		this.quyenHan = quyenHan;
	}



	public String getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public Timestamp getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Timestamp ngayLap) {
		this.ngayLap = ngayLap;
	}

	public Timestamp getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Timestamp ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public bang_chucvu_model getBangchucvu() {
		return bangchucvu;
	}

	public void setBangchucvu(bang_chucvu_model bangchucvu) {
		this.bangchucvu = bangchucvu;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getMaDonViTrucThuoc() {
		return maDonViTrucThuoc;
	}

	public void setMaDonViTrucThuoc(int maDonViTrucThuoc) {
		this.maDonViTrucThuoc = maDonViTrucThuoc;
	}

	public bang_donvitructhuoc_model getDonvitructhuoc() {
		return donvitructhuoc;
	}

	public void setDonvitructhuoc(bang_donvitructhuoc_model donvitructhuoc) {
		this.donvitructhuoc = donvitructhuoc;
	}

	

	/*public bang_nguoidung_model(  String hoNguoiDung, String tenNguoiDung,  String gmail, String matKhau
			) {
		super();
		
		this.hoNguoiDung = hoNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.gmail = gmail;
		this.matKhau = matKhau;
		
		
		
	}*/
	

	public bang_nguoidung_model() {
		super();
	}
	public bang_nguoidung_model(int maNguoiDung, int maChucVu, String hoNguoiDung, String tenNguoiDung, String sdt,
			String diaChi, String gmail, String matKhau, String quyenHan, int trangThai, String anhDaiDien
			) {
		super();
		this.maNguoiDung = maNguoiDung;
	
		this.maChucVu = maChucVu;
		this.hoNguoiDung = hoNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.gmail = gmail;
		this.matKhau = matKhau;
		this.quyenHan = quyenHan;
		this.trangThai = trangThai;
		this.anhDaiDien = anhDaiDien;
	
	}
	
	public bang_nguoidung_model(int maNguoiDung, int maChucVu, String hoNguoiDung, String tenNguoiDung, String sdt,
			String diaChi, String gmail, String matKhau, String quyenHan, int trangThai, String anhDaiDien,
			bang_donvitructhuoc_model donvitructhuoc) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maChucVu = maChucVu;
		this.hoNguoiDung = hoNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.gmail = gmail;
		this.matKhau = matKhau;
		this.quyenHan = quyenHan;
		this.trangThai = trangThai;
		this.anhDaiDien = anhDaiDien;
		this.donvitructhuoc = donvitructhuoc;
	}

	public bang_nguoidung_model(int maNguoiDung,int maDonViTrucThuoc, int maChucVu, String hoNguoiDung, String tenNguoiDung, String sdt,
			String diaChi, String gmail, String matKhau, String quyenHan, int trangThai, String anhDaiDien
			) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maDonViTrucThuoc=maDonViTrucThuoc;
		this.maChucVu = maChucVu;
		this.hoNguoiDung = hoNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.gmail = gmail;
		this.matKhau = matKhau;
		this.quyenHan = quyenHan;
		this.trangThai = trangThai;
		this.anhDaiDien = anhDaiDien;
	
	}
	public bang_nguoidung_model(int maNguoiDung, int maChucVu, String hoNguoiDung, String tenNguoiDung, String sdt,
			String diaChi, String gmail, String matKhau, String quyenHan, int trangThai
			) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maChucVu = maChucVu;
		this.hoNguoiDung = hoNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.gmail = gmail;
		this.matKhau = matKhau;
		this.quyenHan = quyenHan;
		this.trangThai = trangThai;
		
	
	}
	public bang_nguoidung_model(int maNguoiDung,  String tenNguoiDung
			) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		
		
	
	}
	
	
	public bang_nguoidung_model(int maNguoiDung) {
		super();
		this.maNguoiDung = maNguoiDung;
	}

	public bang_nguoidung_model(int maNguoiDung, int maDonViTrucThuoc, int maChucVu, String hoNguoiDung,
			String tenNguoiDung, String gmail, String matKhau) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maDonViTrucThuoc = maDonViTrucThuoc;
		this.maChucVu = maChucVu;
		this.hoNguoiDung = hoNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.gmail = gmail;
		this.matKhau = matKhau;
	}
	
   
	

	public bang_nguoidung_model(int maNguoiDung, int maDonViTrucThuoc, int maChucVu, String hoNguoiDung,
			String tenNguoiDung, String sdt, String diaChi, String gmail, String anhDaiDien, String maXacThuc,
			Boolean trangThaiXacThuc, Timestamp thoiGianHieuLuc) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maDonViTrucThuoc = maDonViTrucThuoc;
		this.maChucVu = maChucVu;
		this.hoNguoiDung = hoNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.gmail = gmail;
		this.anhDaiDien = anhDaiDien;
		this.maXacThuc = maXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
		this.thoiGianHieuLuc = thoiGianHieuLuc;
	}
    
	public bang_nguoidung_model(int maNguoiDung, int maDonViTrucThuoc, int maChucVu, String hoNguoiDung,
			String tenNguoiDung, String gmail, String matKhau, String quyenHan, int trangThai) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maDonViTrucThuoc = maDonViTrucThuoc;
		this.maChucVu = maChucVu;
		this.hoNguoiDung = hoNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
		this.gmail = gmail;
		this.matKhau = matKhau;
		this.quyenHan = quyenHan;
		this.trangThai = trangThai;
	}
	

	public bang_nguoidung_model(String gmail, String matKhau) {
		super();
		this.gmail = gmail;
		this.matKhau = matKhau;
	}

	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	public Boolean getTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(Boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	public Timestamp getThoiGianHieuLuc() {
		return thoiGianHieuLuc;
	}

	public void setThoiGianHieuLuc(Timestamp thoiGianHieuLuc) {
		this.thoiGianHieuLuc = thoiGianHieuLuc;
	}


	



}
