<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@page import="com.duan.model.bang_nguoidung_model" %>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%
		Object obj = session.getAttribute("nguoiDung");
	  
		bang_nguoidung_model nguoiDung = null;
		if (obj != null)
			nguoiDung = (bang_nguoidung_model) obj;
		if (nguoiDung == null) {
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<%
		}

		else

		{
	%>
	<%
		int maNguoiDung = nguoiDung.getMaNguoiDung();
	   String tenDuAn_TiengViet = request.getParameter("tenDuAn_TiengViet"); 
	%>
	<div class="content-wrapper">
		<div class="container-xxl flex-grow-1 container-p-y">
			<div class="row">
				<!-- Basic Layout -->
				<!-- Basic with Icons -->
				<div class="col-xxl">
					<div class="card mb-4">
						<div
							class="card-header d-flex align-items-center justify-content-between">
							<h5 class="mb-0">Thêm dự án mới</h5>
							<small class="text-muted float-end">Vui lòng điền thông
								tin bên dưới!</small>
						</div>
						<div class="card-body">
							<form action="<c:url value='/admin_them_duan?action=them_duan'/>"
		             	id="form_submit" method="post"  >
							<div class="divider text-start">
                        <div style="color:black;border-radius: 8px;" class="divider-text bg-danger">1.Thông tin về tên dự án</div>
                      </div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-fullname">Tên dự án(Tiếng
										việt)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span id="basic-icon-default-fullname2"
												class="input-group-text"><i class='bx bxs-notepad'></i> </span> <input type="text"
												class="form-control" 
												id="input_tenduan_tiengviet"
												maxlength="700"
												name="tenDuAn_TiengViet" placeholder="Nhập tên dự án tiếng việt(nếu có)"
												aria-label="John Doe"
												aria-describedby="basic-icon-default-fullname2" />
												
										</div>
										<div class="form-text">*Không bắt buộc</div>
										 
									</div>
								</div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-fullname">Tên dự án(Tiếng anh)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span id="basic-icon-default-fullname2"
												class="input-group-text"><i class='bx bxs-notepad'></i> </span> <input type="text"
												class="form-control" 
												id="input_tenduan_tienganh"
											    maxlength="700"
												name="tenDuAn_TiengAnh" placeholder="Nhập tên dự án"
												aria-label="John Doe"
												aria-describedby="basic-icon-default-fullname2" />
										</div>
										<div class="form-text text-danger">*Bắt buộc</div>
										 
									</div>
								</div>
								<div class="divider text-start">
                        <div style="color:black; border-radius: 8px;" class="divider-text bg-danger">2.Các thông tin liên quan</div>
                      </div>
                      
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Danh mục dự án</label>
									<div class="col-sm-6">
										<div class="input-group input-group-merge">
										   <span id="basic-icon-default-fullname2"
												class="input-group-text"><i class='bx bxs-category' ></i> </span>
										    <select id="input_danhmuc"  name="maDanhMuc" class="form-select">
										     <option value="0" selected>Chọn danh mục</option>
										    <c:forEach var="item" items="${danhmucs}">
					
					                          <option value="${item.maDanhMuc}" >${item.tenDanhMuc}</option>
					                          	</c:forEach>
					                        </select>
										  
											
											<a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal2" href=""
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>
										</div>
                                         <div class="form-text">*Không bắt buộc</div>  	 
									</div>
								</div>
							<%-- 	<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đơn vị trực thuộc</label>
									<div class="col-sm-6">
										<div class="input-group input-group-merge">
										<select  name="maDonViTrucThuoc" id="input_donvitructhuoc" class="form-select">
										     <option value="0" selected>Chọn đơn vị trực thuộc</option>
										    <c:forEach var="item" items="${donvitructhuocs}">
					
					                          <option value="${item.maDonViTrucThuoc}" >${item.tenDonViTrucThuoc}</option>
					                          	</c:forEach>
					                        </select>
											<a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal3" href=""
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>
										</div>
									</div>
								</div> --%>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Nhà tài trợ(Cơ quan,tổ chức,cá nhân...,)</label>
									<div class="col-sm-6">
										<div class="input-group input-group-merge">
										 <span id="basic-icon-default-fullname2"
												class="input-group-text"><i class='bx bxs-bank'></i> </span>
											 <select  name="maNhaTaiTro" id="input_nhataitro" class="form-select">
										     <option value="0" selected>Chọn nhà tài trợ</option>
										    <c:forEach var="item" items="${nhataitros}">
					
					                          <option value="${item.maNhaTaiTro}" >${item.tenNhaTaiTro}</option>
					                          	</c:forEach>
					                        </select>
											<a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal4" href=""
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>
										</div>
										 <div class="form-text">*Không bắt buộc</div>  	
											 
									</div>
								</div>
							<!-- 	<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đính kèm file(nhà tài
										trợ)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												<label class="input-group-text" for="inputGroupFile01">Upload</label>
												<input type="file" class="form-control"
												name="file_dinhkem_nhataitro"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div> -->
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Loại viện trợ</label>
									<div class="col-sm-6">
										<div class="input-group input-group-merge">
										<span id="basic-icon-default-fullname2"
												class="input-group-text"><i class='bx bxs-copy-alt'></i> </span>
											 <select  name="maLoaiVienTro" id="input_loaivientro" class="form-select">
										     <option value="0" selected>Chọn loại viện trợ</option>
										    <c:forEach var="item" items="${loaivientros}">
					
					                          <option value="${item.maLoaiVienTro}" >${item.tenLoaiVienTro}</option>
					                          	</c:forEach>
					                        </select>
												<a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal5" href=""
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>
										</div>
											  <div class="form-text">*Không bắt buộc</div>  	
									</div>
								</div>
						<!-- 		<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đính kèm file(Loại
										viện trợ)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												<label class="input-group-text" for="inputGroupFile01">Upload</label>
												<input type="file" class="form-control"
												  name="file_dinhkem_vientro"
													id="inputGroupFile01" />
											</div>
										</div>
									</div>
								</div> -->
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Cơ quan phê duyệt dự án phía Việt Nam</label>
									<div class="col-sm-6">
										<div class="input-group input-group-merge">
										<span id="basic-icon-default-fullname2"
												class="input-group-text"><i class='bx bxs-building-house'></i> </span>
											 <select  name="maCoQuanPheDuyet" id="input_coquanpheduyet" class="form-select">
										     <option value="0" selected>Chọn cơ quan phê duyệt</option>
										    <c:forEach var="item" items="${coquanpheduyets}">
					
					                          <option value="${item.maCoQuanPheDuyet}">${item.tenCoQuanPheDuyet}</option>
					                          	</c:forEach>
					                        </select>
											<a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal"
												href='<c:url value="/admin_them_coquanpheduyet?action=them_coquanpheduyet"/>'
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>



										</div>
											 <div class="form-text">*Không bắt buộc</div>  	 
									</div>
								</div>
							<!-- 	<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đính kèm file(cơ quan
										phê duyệt)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												<label class="input-group-text" for="inputGroupFile01">Upload</label>
												<input type="file" class="form-control"
												name="file_dinhkem_coquanpheduyet"
													id="inputGroupFile01" />
											</div>
										</div>
									</div>
								</div> -->
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đối tác cùng thực hiện</label>
									<div class="col-sm-6">
										<div class="input-group input-group-merge">
										<span id="basic-icon-default-fullname2"
												class="input-group-text"><i class='bx bx-group'></i> </span>
											 <select  name="maDoiTacThucHien" id="input_doitacthuchien" class="form-select">
										     <option value="0" selected>Chọn đối tác thực hiện</option>
										    <c:forEach var="item" items="${doitacthuchiens}">
					
					                          <option value="${item.maDoiTacThucHien}" >${item.tenDoiTacThucHien}</option>
					                          	</c:forEach>
					                        </select>
											<a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal6" href=""
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>
										</div>
											 <div class="form-text">*Không bắt buộc</div>  	 
									</div>
								</div>
							<!-- 	<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đính kèm file(đối tác
										thực hiện)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												<label class="input-group-text" for="inputGroupFile01">Upload</label>
												<input type="file" class="form-control"
												name="file_dinhkem_doitacthuchien"
													id="inputGroupFile01" />
											</div>
										</div>
									</div>
								</div> -->
								<div class="divider text-start">
                        <div style="color:black;border-radius: 8px;" class="divider-text bg-danger">3.Các thông tin về mục tiêu và nội dung và các loại thiết bị tài trợ của dự án</div>
                        <input id="textarea_thanhvienthamgia" type="hidden" value="">
                      </div>
                      
									<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-default-message">Mục tiêu dự án</label>
									<div class="col-sm-10">
										<textarea style="height:100px;" id="textarea_muctieuduan" class="form-control"
											placeholder="Điền thông tin mục tiêu dự án?"
											aria-label="Hi, Do you have a moment to talk Joe?"
											aria-describedby="basic-icon-default-message2"
											name="mucTieuDuAn"
											></textarea>
												 <div class="form-text">*Không bắt buộc</div>  	 
									</div>
								</div>
									<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-default-message">Nội dung thực hiện</label>
									<div class="col-sm-10">
										<textarea style="height:250px;" id="textarea_noidungthuchien" class="form-control"
											placeholder="Nội dung thực hiện?"
											aria-label="Hi, Do you have a moment to talk Joe?"
											aria-describedby="basic-icon-default-message2"
											name="noiDungThucHien"
											></textarea>
												 <div class="form-text text-danger">*Bắt buộc</div>  	 
									</div>
								</div>
									<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-default-message">Các thiết bị tài trợ</label>
									<div class="col-sm-10">
										<textarea style="height:100px;" id="textarea_thietbitaitro" class="form-control"
											placeholder="Thiết bị được tài trợ?"
											aria-label="Hi, Do you have a moment to talk Joe?"
											aria-describedby="basic-icon-default-message2"
										    maxlength="700"
											name="thietBiTaiTro"
											></textarea>
											 <div class="form-text">*Không bắt buộc</div>  		 
									</div>
								</div>
								
                      	<div class="divider text-start">
                                   <div style="color:black;border-radius: 8px;" class="divider-text bg-danger">4.Các thông tin về kinh phí dự án và các mục liên quan</div>
                        
                      </div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Kinh phí dự án năm
										trước</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i class='bx bxs-credit-card'></i></span> <input type="text"
												id="input_kinhphinamtruoc" class="form-control"
												placeholder="Nhập kinh phí dự án năm trước"
												aria-label="john.doe"
												name="kinhPhiDuAnNamTruoc"
												maxlength="700"
												aria-describedby="basic-icon-default-email2" />
										</div>
										  <div class="form-text">*Không bắt buộc</div>  	
									</div>
								</div>
							
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Vốn tài trợ,viện trợ</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i class='bx bxs-credit-card'></i></span> <input type="number"
												id="input_vontaitro" class="form-control"
												name="vonTaiTro"
												value="0"
												placeholder="Nhập vốn tài trợ" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2" onchange="calculateTotal()"
											    oninput="formatNumber('input_vontaitro', 'infoSpan_vontaitro')"
												 />
							               <select  id="capital-currency"  name="donViTienTe_VonTaiTro" class="form-select btn-success">
										     <option value="0" selected>Chọn đơn vị tiền tệ</option>
										    
					                           <option value="VND" >VND</option>
					                           <option value="USD" >USD</option>
					                           <option value="Euro">Euro</option>
					                           <option value="CNY">CNY</option>
				
					                        </select>
										</div>
										  <div id="infoSpan_vontaitro" class="form-text text-warning"></div>  	
									</div>
								</div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Vốn vay</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i class='bx bxs-credit-card'></i></span> <input type="number"
												id="input_vonvay" class="form-control"
												name="vonVay"
												value="0"
												placeholder="Nhập vốn vay" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2" onchange="calculateTotal()"
												 oninput="formatNumber('input_vonvay', 'infoSpan_vonvay')"
												 />
												 <select  id="loan-currency"  name="donViTienTe_VonVay" class="form-select btn-success">
										     <option value="0" selected>Chọn đơn vị tiền tệ</option>
										    
					                            <option value="VND" >VND</option>
					                           <option value="USD" >USD</option>
					                           <option value="Euro">Euro</option>
					                           <option value="CNY">CNY</option>
				
					                        </select>
										</div>
										
										  <div id="infoSpan_vonvay" class="form-text text-warning"></div>  		
									</div>
								</div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Vốn khác</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i class='bx bxs-credit-card'></i></span> <input type="number"
												id="input_vonkhac" class="form-control"
												placeholder="Nhập vốn khác" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2"
												name="vonKhac"
												value="0"
												onchange="calculateTotal()"
												 oninput="formatNumber('input_vonkhac', 'infoSpan_vonkhac')"
												 />
												 <select  id="other-currency"  name="donViTienTe_VonKhac" class="form-select btn-success">
										     <option value="0" selected>Chọn đơn vị tiền tệ</option>
										    
					                             <option value="VND" >VND</option>
					                           <option value="USD" >USD</option>
					                           <option value="Euro">Euro</option>
					                           <option value="CNY">CNY</option>
				
					                        </select>
										</div>
										 <div id="infoSpan_vonkhac" class="form-text text-warning"></div>  	
									</div>
								</div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Vốn đối ứng</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i class='bx bxs-credit-card'></i></span> <input type="number"
												id="input_vondoiung" class="form-control"
												placeholder="Nhập vốn đối ứng" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2"
												name="vonDoiUng"
												value="0"
												onchange="calculateTotal()"
												 oninput="formatNumber('input_vondoiung', 'infoSpan_vondoiung')"
												 />
												 <select  id="doiung-currency"  name="donViTienTe_VonDoiUng" class="form-select btn-success">
										     <option value="0" selected>Chọn đơn vị tiền tệ</option>
										    
					                             <option value="VND" >VND</option>
					                           <option value="USD" >USD</option>
					                           <option value="Euro">Euro</option>
					                           <option value="CNY">CNY</option>
				
					                        </select>
										</div>
										 <div id="infoSpan_vondoiung" class="form-text text-warning"></div>   	
									</div>
								</div>
									<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Tổng vốn thực hiện</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text text-info"><a  onclick="convertNumberToText()" ><i class='bx bxs-credit-card'></i></a></span> <input 
												id="input_tongvonthuchien" class="form-control" type="number"
												name="tongVonThucHien"
												value="0"
												placeholder="Nhập tổng vốn thực hiện" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2" onchange="calculateTotal()"
												
												readonly
											
												 />
												 <select  id="total-currency" name="donViTienTe_TongVonThucHien"  class="form-select btn-warning">
										     <option value="0" selected>Quy đổi đơn vị tiền tệ</option>
										    
					                            <option value="VND" >VND</option>
					                           <option value="USD" >USD</option>
					                           <option value="Euro">Euro</option>
					                           <option value="CNY">CNY</option>
				
					                        </select>
										</div>
										    <span id="spanTongVon"></span>
										
									
										 
									</div>
									
								</div>
								<input name="maDonViTienTe" value="0" type="hidden">
								<div class="divider text-start">
                        <div style="color:black;border-radius: 8px;" class="divider-text bg-danger">5.Các thông tin về tiến độ của dự án</div>
                      </div>
                      	<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-default-message">Tình trạng tiến độ dự án(Bao gồm tiến độ triển khai và tiến độ giải ngân)</label>
									<div class="col-sm-10">
										<textarea style="height:250px;" id="textarea_tiendoduan" class="form-control"
											placeholder="Dự án của bạn đang trong tình trạng ra sao?"
											aria-label="Hi, Do you have a moment to talk Joe?"
											aria-describedby="basic-icon-default-message2"
											name="tienDoThucHien"
											></textarea>
											 <div class="form-text text-danger">*Bắt buộc</div>  	
											
									</div>
								</div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Dự án của bạn đạt được
										bao nhiêu phần trăm</label>
									<div class="col-sm-10">
									   
										 
										 
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i class='bx bxs-tachometer'></i></span> <input type="text"
												id="input_phantramtiendo" class="form-control"
												placeholder="Nhập phần trăm tiến độ" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2"
												maxlength="100"
												name="phanTramTienDoThucHien"
												 />
										</div> 
										  <div class="form-text">*Không bắt buộc</div> 
									</div>
								</div>
									<div class="divider text-start">
                        <div style="color:black;border-radius: 8px;" class="divider-text bg-danger">6.Các thông tin về thời gian thực hiện dự án</div>
                      </div>
								
								       <div class="row mb-3">
                        <label for="html5-datetime-local-input" class="col-md-2 col-form-label">Thời gian bắt đầu</label>
                        <div class="col-md-10">
                        <div class="input-group input-group-merge">
                        <span class="input-group-text"><i class='bx bxs-calendar' ></i></span>
                          <input
                          
                            class="form-control"
                          type="datetime-local"
                            name="thoiGianBatDau"
                            id="input_ngaybatdau"
                          />
                        </div>
                        </div>
                        
                      </div>
                      <div class="row mb-3">
                        <label for="html5-datetime-local-input" class="col-md-2 col-form-label">Thời gian kết thúc</label>
                        <div class="col-md-10">
                         <div class="input-group input-group-merge">
                        <span class="input-group-text"><i class='bx bxs-calendar' ></i></span>
                          <input
                            class="form-control"
                            type="datetime-local"
                            name="thoiGianKetThuc"
                           id="input_ngayketthuc"
                          />
                        </div>
                        </div>
                      </div>
                      <div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Thời gian thực hiện</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i class='bx bxs-time'></i></span> <input type="text"
												id="input_thoigianthuchien" class="form-control"
												placeholder="Thời gian thực hiện sẽ được tính tự động" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2"
												name="thoiGianThucHien"
												readonly
												 />
										</div>
										
									</div>
								</div>
							

						<!-- 		<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Dự án của bạn đạt được
										bao nhiêu phần trăm</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i
												class='bx bx-credit-card-front'></i></span> <input type="text"
												id="basic-icon-default-email" class="form-control"
												placeholder="Nhập phần trăm tiến độ" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2" />
										</div>
										<div class="form-text">Lưu ý chỉ cần ước lượng,không cần
											chính xác tuyệt đối</div>
									</div>
								</div>
 -->

								<!-- <div class="mb-3 row">
									<label for="html5-datetime-local-input"
										class="col-md-2 col-form-label">Ngày tạo dự án</label>
									<div class="col-md-10">
										<input class="form-control" type="datetime-local"
											value="2021-06-18T12:30:00" id="html5-datetime-local-input" />
									</div>
								</div> -->
							<div id="spinner" style="display:none">
							  <div class="spinner-border text-primary" role="status">
							    <span class="visually-hidden">Loading...</span>
							  </div>
							</div>
								    <div
                          class="modal fade"
                          id="modalToggle"
                          aria-labelledby="modalToggleLabel"
                          tabindex="-1"
                          style="display: none"
                          aria-hidden="true"
                        >
                          <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="modal-title" id="modalToggleLabel">Thông báo thành công! <i class='bx bx-list-check text-success'></i> </h5>
                               
                              </div>
                              <div class="modal-body">Dữ liệu của bạn vừa được lưu vào hệ thống!bạn có muốn tiếp tục upload các file minh chức không?</div>
                              <div class="modal-footer">
                                <a
                                href='<c:url value="/admin_them_file_dinhkem?action=them_file_dinhkem"/>'
                                  class="btn btn-primary"
                                 
                                >
                                  Tiếp tục
                                </a>
                               <a
                               href='<c:url value="/admin_quanly_duan?action=danhsach_duan_cuatoi&page=1&maxPageItem=20&sapxeptheothuoctinh=tenduan_tiengviet&sapxeptheochieu=desc"/>'
                                  class="btn btn-primary"
                                 
                                >
                                  Để sau
                                </a>
                              
                                 
                              </div>
                            </div>
                          </div>
                        </div>
                        
                        
                        	
								<div class="row justify-content-end" >
								
									<div class="col-sm-10">
									
										<button type="submit" class="btn btn-primary"   onclick="showSpinner()"  data-bs-toggle="modal"
                          >Lưu
											thông tin</button>
											
									</div>
									
								</div>
									
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>




		<!-- //Đây là xử lý cơ quan phê duyệt -->
		<form
			action="<c:url value='/admin_them_coquanpheduyet?action=them_coquanpheduyet'/>"
			id="form_submit" method="post">
			<div class="modal fade" id="basicModal" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm cơ quan
								phê duyệt</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<input type="hidden" id="nameBasic" class="form-control"
								name="maCoQuanPheDuyet" placeholder="Enter Name"
								value="<%=maNguoiDung%>" />
							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên cơ quan
										phê duyệt</label> <input type="text" id="nameBasic"
										class="form-control" name="tenCoQuanPheDuyet"
										placeholder="Vui lòng nhập tên cơ quan phê duyệt" />
								</div>
							</div>
							
						</div>
						<div class="modal-footer" >
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>



			<!-- //Đây là xử lý danh mục -->
		<form
			action="<c:url value='/admin_them_danhmuc?action=them_danhmuc'/>"
			id="form_submit" method="post">
			<div class="modal fade" id="basicModal2" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm danh
								mục</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên danh mục</label>
									<input type="text" id="nameBasic" class="form-control"
										name="tenDanhMuc"
										placeholder="Vui lòng nhập tên cơ quan phê duyệt" />
								</div>
							</div>
						
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
		
		
		
		<!-- //Đây là xử lý đơn vị trực thuộc -->
		<form
			action="<c:url value='/admin_them_donvitructhuoc?action=them_donvitructhuoc'/>"
			id="form_submit" method="post">
			<div class="modal fade" id="basicModal3" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm đơn vị trực thuộc</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên đơn vị trực thuộc</label>
									<input type="text" id="tenDonViTrucThuoc" class="form-control"
										name="tenDonViTrucThuoc"
										placeholder="Vui lòng nhập tên đơn vị trực thuộc" />
								</div>
							</div>
					
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
		
		
		<!-- //Đây là xử lý nhà tài trợ -->
		<form
			action="<c:url value='/admin_them_nhataitro?action=them_nhataitro'/>"
			id="form_submit" method="post">
			<div class="modal fade" id="basicModal4" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm nhà tài trợ</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên nhà tài trợ</label>
									<input type="text" id="nameBasic" class="form-control"
										name="tenNhaTaiTro"
										placeholder="Vui lòng nhập tên nhà tài trợ" />
								</div>
							</div>
						
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>
			<!-- //Đây là xử lý loại viện trợ -->
		<form
			action="<c:url value='/admin_them_loaivientro?action=them_loaivientro'/>"
			id="form_submit" method="post">
			<div class="modal fade" id="basicModal5" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm loại viện trợ</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên loại viện trợ</label>
									<input type="text" id="nameBasic" class="form-control"
										name="tenLoaiVienTro"
										placeholder="Vui lòng nhập tên loại viện trợ" />
								</div>
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
			<!-- //Đây là xử lý đối tác thực hiện -->
		<form
			action="<c:url value='/admin_them_doitacthuchien?action=them_doitacthuchien'/>"
			id="form_submit" method="post">
			<div class="modal fade" id="basicModal6" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm đối tác thực hiện</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên đối tác thực hiện</label>
									<input type="text" id="nameBasic" class="form-control"
										name="tenDoiTacThucHien"
										placeholder="Vui lòng nhập tên đối tác thực hiện" />
								</div>
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>
			<!-- //Đây là xử lý đối đơn vị tiền tệ -->
		<form
			action="<c:url value='/admin_them_donvitiente?action=them_donvitiente'/>"
			id="form_submit" method="post">
			<div class="modal fade" id="basicModal29" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm đơn vị tiền tệ</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên đơn vị tiền tệ</label>
									<input type="text" id="nameBasic" class="form-control"
										name="tenDonViTienTe"
										placeholder="Vui lòng nhập tên đơn vị tiền tệ" />
								</div>
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		 
	</div>
    <%
		}
	%>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

   <script>
   function formatNumber(inputId, spanId) {
	   var inputElement = document.getElementById(inputId);
	   var value = inputElement.value;

	   // Xóa tất cả các dấu phân cách hàng nghìn hiện có
	   var numberWithNoCommas = value.replace(/[,]/g, "");

	   // Gán giá trị đã xóa dấu phân cách hàng nghìn cho thẻ input
	   inputElement.value = numberWithNoCommas;

	   // Xử lý hiển thị thông tin trong thẻ span
	   var spanElement = document.getElementById(spanId);
	   var numberValue = parseFloat(numberWithNoCommas);
	   if (!isNaN(numberValue)) {
	     var info = formatInfo(numberValue);
	     spanElement.textContent = info;
	   } else {
	     spanElement.textContent = "";
	   }
	 }

	 function formatInfo(numberValue) {
	   var info = "";

	   if (numberValue >= 1000000000) {
	     var billions = Math.floor(numberValue / 1000000000);
	     info += toText(billions) + " tỷ";
	     numberValue %= 1000000000;
	   }

	   if (numberValue >= 1000000) {
	     var millions = Math.floor(numberValue / 1000000);
	     if (info !== "") {
	       info += " ";
	     }
	     info += toText(millions) + " triệu";
	     numberValue %= 1000000;
	   }

	   if (numberValue >= 1000) {
	     var thousands = Math.floor(numberValue / 1000);
	     if (info !== "") {
	       info += " ";
	     }
	     info += toText(thousands) + " nghìn";
	     numberValue %= 1000;
	   }

	   if (numberValue > 0) {
	     if (info !== "") {
	       info += " ";
	     }
	     info += toText(numberValue);
	   }

	   return info;
	 }

	 function toText(number) {
	   var units = [
	     "",
	     "một",
	     "hai",
	     "ba",
	     "bốn",
	     "năm",
	     "sáu",
	     "bảy",
	     "tám",
	     "chín",
	     "mười",
	     "mười một",
	     "mười hai",
	     "mười ba",
	     "mười bốn",
	     "mười lăm",
	     "mười sáu",
	     "mười bảy",
	     "mười tám",
	     "mười chín"
	   ];

	   var tens = [
	     "",
	     "mười",
	     "hai mươi",
	     "ba mươi",
	     "bốn mươi",
	     "năm mươi",
	     "sáu mươi",
	     "bảy mươi",
	     "tám mươi",
	     "chín mươi"
	   ];

	   var result = "";

	   if (number >= 100) {
	     var hundreds = Math.floor(number / 100);
	     result += units[hundreds] + " trăm";
	     number %= 100;
	   }

	   if (number >= 20) {
	     var tensDigit = Math.floor(number / 10);
	     result += " " + tens[tensDigit];
	     number %= 10;
	   }

	   if (number > 0) {
	     result += " " + units[number];
	   }

	   return result.trim();
	 }
  </script>
   <script>
        function convertNumberToText() {
            // Lấy giá trị từ thẻ input
            var inputElement = document.getElementById("input_tongvonthuchien");
            var value = inputElement.value;

            // Kiểm tra giá trị có hợp lệ
            if (!isNaN(value)) {
                // Xử lý chuyển đổi số thành chữ
                var text = "";
                if (value >= 1000000000) {
                    text = (value /1000000000) + " tỷ";
                }
                else if (value >= 1000000) {
                    text = (value / 1000000) + " triệu";
                } else if (value >= 1000) {
                    text = (value / 1000) + " nghìn";
                }
               
                else {
                    text = value;
                }

                // Hiển thị kết quả trong thẻ span
                var spanElement = document.getElementById("spanTongVon");
                spanElement.innerHTML = text;

                // Cập nhật giá trị của thẻ input
                inputElement.value = value;
            }
        }
    </script>

	<script>
	 // Lấy các đối tượng DOM của các input và select
	const capitalInput = document.getElementById("input_vontaitro");
	const capitalCurrencySelect = document.getElementById("capital-currency");
	
	const loanInput = document.getElementById("input_vonvay");
	const loanCurrencySelect = document.getElementById("loan-currency");
	
	const otherInput=document.getElementById("input_vonkhac");
	const otherCurrencySelect=document.getElementById("other-currency");
	
	const doiungInput=document.getElementById("input_vondoiung");
	const doiungCurrencySelect=document.getElementById("doiung-currency");
	
	const totalCapitalInput = document.getElementById("input_tongvonthuchien");
	const totalCurrencySelect = document.getElementById("total-currency");

	// Lắng nghe sự kiện onchange của các input và select
	capitalInput.addEventListener("change", calculateTotalCapital);
	capitalCurrencySelect.addEventListener("change", calculateTotalCapital);
	
	loanInput.addEventListener("change", calculateTotalCapital);
	loanCurrencySelect.addEventListener("change", calculateTotalCapital);
	
	otherInput.addEventListener("change", calculateTotalCapital);
	otherCurrencySelect.addEventListener("change", calculateTotalCapital);
	
	doiungInput.addEventListener("change", calculateTotalCapital);
	doiungCurrencySelect.addEventListener("change", calculateTotalCapital);
	
	totalCurrencySelect.addEventListener("change", calculateTotalCapital);

	// Hàm tính tổng vốn thực hiện
	function calculateTotalCapital() {
	  // Lấy giá trị của input và select
	  const capital = capitalInput.value;
	  const capitalCurrency = capitalCurrencySelect.value;
	  
	  const loan = loanInput.value;
	  const loanCurrency = loanCurrencySelect.value;
	  
	  const other=otherInput.value;
	  const otherCurrency= otherCurrencySelect.value;
	  
	  const doiung=doiungInput.value;
	  const doiungCurrency=doiungCurrencySelect.value;
	  
	  const totalCurrency = totalCurrencySelect.value;

	  // Tính tổng vốn thực hiện
	  let totalCapital = 0;
	  if (capitalCurrency === "VND") {
	    totalCapital += parseFloat(capital);
	  } else if(capitalCurrency === "Euro")
	  {
		  totalCapital += parseFloat(capital) * 27000;
	  }
	  else if(capitalCurrency === "CNY")
	  {
		  totalCapital += parseFloat(capital) * 4350;
	  }
	  else {
	    totalCapital += parseFloat(capital) * 23000;
	  }
	  ////////////////////////////////////////
	  if (loanCurrency === "VND") {
	    totalCapital += parseFloat(loan);
	  } 
	  else if(loanCurrency === "Euro")
	  {
		  totalCapital += parseFloat(loan) * 27000;
	  }
	  else if(loanCurrency === "CNY")
	  {
		  totalCapital += parseFloat(loan) * 4350;
	  }
	  else {
	    totalCapital += parseFloat(loan) * 23000;
	  }
	  /////////////////////////////////////////////////
	  if (otherCurrency === "VND") {
		    totalCapital += parseFloat(other);
		  }
	  else if(otherCurrency === "Euro")
	  {
		  totalCapital += parseFloat(other) * 27000;
	  }
	  else if(otherCurrency === "CNY")
	  {
		  totalCapital += parseFloat(other) * 4350;
	  }
	  else {
		    totalCapital += parseFloat(other) * 23000;
		  }
	  /////////////////////////////////////////////////////
	  if (doiungCurrency === "VND") {
		    totalCapital += parseFloat(doiung);
		  } 
	  else if(doiungCurrency === "Euro")
	  {
		  totalCapital += parseFloat(doiung) * 27000;
	  }
	  else if(doiungCurrency === "CNY")
	  {
		  totalCapital += parseFloat(doiung) * 4350;
	  }
	  else {
		    totalCapital += parseFloat(doiung) * 23000;
		  }

	  // Cập nhật giá trị cho input tổng vốn thực hiện
	  if (totalCurrency === "USD") {
	    totalCapital = totalCapital / 23000;
	  }
	  else if(totalCurrency === "Euro")
	  {
		  totalCapital = totalCapital / 27000;
	  }
	  else if(totalCurrency === "CNY")
	  {
		  totalCapital = totalCapital / 4350;
	  }
	  totalCapitalInput.value = totalCapital.toFixed(4);
	} 
    </script>

	
	<script>
  function calculateDuration() {
    var startDate = new Date(document.getElementById('input_ngaybatdau').value);
    var endDate = new Date(document.getElementById('input_ngayketthuc').value);
    var diff = Math.abs(endDate - startDate);
    var years = Math.floor(diff / (1000 * 60 * 60 * 24 * 365));
    diff -= years * (1000 * 60 * 60 * 24 * 365);
    var months = Math.floor(diff / (1000 * 60 * 60 * 24 * 30));
    diff -= months * (1000 * 60 * 60 * 24 * 30);
    var days = Math.floor(diff / (1000 * 60 * 60 * 24));
    var duration = '';
    if (years > 0) {
      duration += years + ' năm, ';
    }
    if (months > 0) {
      duration += months + ' tháng, ';
    }
    if (days > 0) {
      duration += days + ' ngày';
    }
    document.getElementById('input_thoigianthuchien').value = duration;
  }

  document.getElementById('input_ngaybatdau').addEventListener('change', calculateDuration);
  document.getElementById('input_ngayketthuc').addEventListener('change', calculateDuration);
</script>
	
<script>
function showSpinner() {
	  document.getElementById('spinner').style.display = 'block';
	  setTimeout(function() {
	    document.getElementById('spinner').style.display = 'none';
	    document.getElementById('modalToggle').style.display = 'block';
	  }, 2000);
	}

	function showSuccessModal() {
	  showSpinner();
	}
</script>
<script>
  $(document).ready(function() {
    $("#form_submit").submit(function(e) {
      e.preventDefault(); // ngăn chặn chuyển hướng đến trang khác khi submit form
      $.ajax({
        type: "POST",
        url: $(this).attr("action"),
        data: $(this).serialize(),
        success: function(response) {
          $("#modalToggle").addClass("show"); // thêm class show cho modal
          $("#modalToggle").attr("aria-hidden", "false"); // đặt aria-hidden=false cho modal
        },
        error: function(xhr, status, error) {
          // xử lý lỗi ở đây và hiển thị modal thông báo thất bại tương tự như ở đoạn mã trên
        }
      });
    });
  });
</script>

	<script type="text/javascript">
		// Lấy các phần tử input
		var input_tenduan_tiengviet = document.getElementById("input_tenduan_tiengviet");
		var input_tenduan_tienganh = document.getElementById("input_tenduan_tienganh");
		var input_kinhphinamtruoc = document.getElementById("input_kinhphinamtruoc");
		var input_tongvonthuchien = document.getElementById("input_tongvonthuchien");
		var input_vontaitro=document.getElementById("input_vontaitro");
		var input_vonvay=document.getElementById("input_vonvay");
		var input_vonkhac=document.getElementById("input_vonkhac");
		var input_vondoiung=document.getElementById("input_vondoiung");
		var input_thoigianthuchien=document.getElementById("input_thoigianthuchien");
		var textarea_tiendoduan=document.getElementById("textarea_tiendoduan");
		var input_phantramtiendo=document.getElementById("input_phantramtiendo");
		
		
		var textarea_thanhvienthamgia=document.getElementById("textarea_thanhvienthamgia");
		var textarea_muctieuduan=document.getElementById("textarea_muctieuduan");
		var textarea_noidungthuchien=document.getElementById("textarea_noidungthuchien");
		var textarea_thietbitaitro=document.getElementById("textarea_thietbitaitro");
		
		
		var input_ngaybatdau=document.getElementById("input_ngaybatdau");
		var input_ngayketthuc=document.getElementById("input_ngayketthuc");
		
	
		
		// Lưu trữ dữ liệu vào sessionStorage khi người dùng nhập liệu
		input_tenduan_tiengviet.addEventListener("input", function() {
			sessionStorage.setItem("input_tenduan_tiengviet", input_tenduan_tiengviet.value);
		});
		
		input_tenduan_tienganh.addEventListener("input", function() {
			sessionStorage.setItem("input_tenduan_tienganh", input_tenduan_tienganh.value);
		});
		input_kinhphinamtruoc.addEventListener("input", function() {
			sessionStorage.setItem("input_kinhphinamtruoc", input_kinhphinamtruoc.value);
		});
		input_tongvonthuchien.addEventListener("input", function() {
			sessionStorage.setItem("input_tongvonthuchien", input_tongvonthuchien.value);
		});
		input_vontaitro.addEventListener("input", function() {
			sessionStorage.setItem("input_vontaitro", input_vontaitro.value);
		});
		input_vonvay.addEventListener("input", function() {
			sessionStorage.setItem("input_vonvay", input_vonvay.value);
		});
		input_vonkhac.addEventListener("input", function() {
			sessionStorage.setItem("input_vonkhac", input_vonkhac.value);
		});
		input_vondoiung.addEventListener("input", function() {
			sessionStorage.setItem("input_vondoiung", input_vondoiung.value);
		});
		input_thoigianthuchien.addEventListener("input", function() {
			sessionStorage.setItem("input_thoigianthuchien", input_thoigianthuchien.value);
		});
		textarea_tiendoduan.addEventListener("input", function() {
			sessionStorage.setItem("textarea_tiendoduan", textarea_tiendoduan.value);
		});
		input_phantramtiendo.addEventListener("input", function() {
			sessionStorage.setItem("input_phantramtiendo", input_phantramtiendo.value);
		});
		
		textarea_thanhvienthamgia.addEventListener("input", function() {
			sessionStorage.setItem("textarea_thanhvienthamgia", textarea_thanhvienthamgia.value);
		});
		textarea_muctieuduan.addEventListener("input", function() {
			sessionStorage.setItem("textarea_muctieuduan", textarea_muctieuduan.value);
		});
		textarea_noidungthuchien.addEventListener("input", function() {
			sessionStorage.setItem("textarea_noidungthuchien", textarea_noidungthuchien.value);
		});
		textarea_thietbitaitro.addEventListener("input", function() {
			sessionStorage.setItem("textarea_thietbitaitro", textarea_thietbitaitro.value);
		});
		
		
		input_ngaybatdau.addEventListener("input", function() {
			sessionStorage.setItem("input_ngaybatdau", input_ngaybatdau.value);
		});
		
		input_ngayketthuc.addEventListener("input", function() {
			sessionStorage.setItem("input_ngayketthuc", input_ngayketthuc.value);
		});
		
		
		
		
		
		
	
	
	
	
	
	
		
		
		// Điền dữ liệu vào các ô input khi người dùng truy cập lại trang
		window.addEventListener("load", function() {
			input_tenduan_tiengviet.value = sessionStorage.getItem("input_tenduan_tiengviet");
			input_tenduan_tienganh.value = sessionStorage.getItem("input_tenduan_tienganh");
			input_kinhphinamtruoc.value = sessionStorage.getItem("input_kinhphinamtruoc");
			input_tongvonthuchien.value = sessionStorage.getItem("input_tongvonthuchien") || "0";
			input_vontaitro.value = sessionStorage.getItem("input_vontaitro") || "0";
			input_vonvay.value = sessionStorage.getItem("input_vonvay") || "0";
			input_vonkhac.value = sessionStorage.getItem("input_vonkhac") || "0";
			input_vondoiung.value = sessionStorage.getItem("input_vondoiung") || "0";
			input_thoigianthuchien.value = sessionStorage.getItem("input_thoigianthuchien") ;
			textarea_tiendoduan.value=sessionStorage.getItem("textarea_tiendoduan") ;
			input_phantramtiendo.value = sessionStorage.getItem("input_phantramtiendo") ;
			
			textarea_thanhvienthamgia.value=sessionStorage.getItem("textarea_thanhvienthamgia") ;
			textarea_muctieuduan.value=sessionStorage.getItem("textarea_muctieuduan") ;
			textarea_noidungthuchien.value=sessionStorage.getItem("textarea_noidungthuchien") ;
			textarea_thietbitaitro.value=sessionStorage.getItem("textarea_thietbitaitro") ;
			
			input_ngaybatdau.value = sessionStorage.getItem("input_ngaybatdau") ;
			input_ngayketthuc.value = sessionStorage.getItem("input_ngayketthuc") ;
		
			
			
			
			
			
		});
	</script>
	<script type="text/javascript">
	//Danh mục
	var select_danhmuc=document.getElementById("input_danhmuc");

	select_danhmuc.addEventListener("change", function() {
	   sessionStorage.setItem("select_danhmuc", select_danhmuc.value);
	});

	window.addEventListener("load", function() {
	   var defaultOption = document.querySelector("#input_danhmuc > option[selected]");
	   var defaultValue = defaultOption.value;
	   var savedValue = sessionStorage.getItem("select_danhmuc");
	   select_danhmuc.value = savedValue || defaultValue;
	});
	
	
	
	

	
	
    //Nhà tài trợ
	var select_nhataitro=document.getElementById("input_nhataitro");

	select_nhataitro.addEventListener("change", function() {
	   sessionStorage.setItem("select_nhataitro", select_nhataitro.value);
	});

	window.addEventListener("load", function() {
	   var defaultOption = document.querySelector("#input_nhataitro > option[selected]");
	   var defaultValue = defaultOption.value;
	   var savedValue = sessionStorage.getItem("select_nhataitro");
	   select_nhataitro.value = savedValue || defaultValue;
	});
	
	
	//Loại viện trợ
	var select_loaivientro=document.getElementById("input_loaivientro");

	select_loaivientro.addEventListener("change", function() {
	   sessionStorage.setItem("select_loaivientro", select_loaivientro.value);
	});

	window.addEventListener("load", function() {
	   var defaultOption = document.querySelector("#input_loaivientro > option[selected]");
	   var defaultValue = defaultOption.value;
	   var savedValue = sessionStorage.getItem("select_loaivientro");
	   select_loaivientro.value = savedValue || defaultValue;
	});
	
	
	
    //Cơ quan phê duyệt
	var select_coquanpheduyet=document.getElementById("input_coquanpheduyet");

	select_coquanpheduyet.addEventListener("change", function() {
	   sessionStorage.setItem("select_coquanpheduyet", select_coquanpheduyet.value);
	});

	window.addEventListener("load", function() {
	   var defaultOption = document.querySelector("#input_coquanpheduyet > option[selected]");
	   var defaultValue = defaultOption.value;
	   var savedValue = sessionStorage.getItem("select_coquanpheduyet");
	   select_coquanpheduyet.value = savedValue || defaultValue;
	});
	//Đối tác thực hiện
		var select_doitacthuchien=document.getElementById("input_doitacthuchien");

	select_doitacthuchien.addEventListener("change", function() {
	   sessionStorage.setItem("select_doitacthuchien", select_doitacthuchien.value);
	});

	window.addEventListener("load", function() {
	   var defaultOption = document.querySelector("#input_doitacthuchien > option[selected]");
	   var defaultValue = defaultOption.value;
	   var savedValue = sessionStorage.getItem("select_doitacthuchien");
	   select_doitacthuchien.value = savedValue || defaultValue;
	});
	
	
	//Đơn vị tiền tệ
	
	var select_donvitiente=document.getElementById("input_donvitiente");

	select_donvitiente.addEventListener("change", function() {
	   sessionStorage.setItem("select_donvitiente", select_donvitiente.value);
	});

	window.addEventListener("load", function() {
	   var defaultOption = document.querySelector("#input_donvitiente > option[selected]");
	   var defaultValue = defaultOption.value;
	   var savedValue = sessionStorage.getItem("select_donvitiente");
	   select_donvitiente.value = savedValue || defaultValue;
	});
	
	
	
	
	
	</script>

</body>
</html>