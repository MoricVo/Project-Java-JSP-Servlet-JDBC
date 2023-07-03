package com.duan.model;

import java.util.ArrayList;
import java.util.List;

public class abstract_model<T> {
	 private int [] maNguoiDungs;
     private List<T> danhsach=new ArrayList<>();
     private Integer page;
     private Integer maxPageItem;
     private Integer totalPage;
     private Integer totalItem;
     private String sapxeptheothuoctinh;
     private String sapxeptheochieu;
	public int [] getMaNguoiDungs() {
		return maNguoiDungs;
	}

	public void setMaNguoiDungs(int [] maNguoiDungs) {
		this.maNguoiDungs = maNguoiDungs;
	}

	public List<T> getDanhsach() {
		return danhsach;
	}

	public void setDanhsach(List<T> danhsach) {
		this.danhsach = danhsach;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMaxPageItem() {
		return maxPageItem;
	}

	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	public String getSapxeptheochieu() {
		return sapxeptheochieu;
	}

	public void setSapxeptheochieu(String sapxeptheochieu) {
		this.sapxeptheochieu = sapxeptheochieu;
	}

	public String getSapxeptheothuoctinh() {
		return sapxeptheothuoctinh;
	}

	public void setSapxeptheothuoctinh(String sapxeptheothuoctinh) {
		this.sapxeptheothuoctinh = sapxeptheothuoctinh;
	}
    

}
