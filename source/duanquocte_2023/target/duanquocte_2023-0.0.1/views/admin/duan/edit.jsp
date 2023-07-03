<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.duan.model.bang_nguoidung_model"%>
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
							<h5 class="mb-0">Sửa dự án</h5>
							<small class="text-muted float-end">Vui lòng điền thông
								tin bên dưới!</small>
						</div>
						 <div class="card-body">
                <button onclick="goBack()" type="button" class="btn btn-primary">
                  <i class="bx bx-chevron-left scaleX-n1-rtl bx-sm"></i>
                  Quay lại trang trước
                </button>
              </div>
						<div class="card-body">
							<c:set var="c" value="${requestScope.duan}" />
							<form action="<c:url value='/admin_sua_duan?action=sua_duan'/>"
							 method="post" >
								<div class="divider text-start">
									<div style="color: black; border-radius: 8px;"
										class="divider-text bg-danger">1.Thông tin về tên dự án</div>
								</div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-fullname">Tên dự án(Tiếng
										việt)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span id="basic-icon-default-fullname2"
												class="input-group-text"><i class='bx bxs-notepad'></i> </span> <input type="text"
												class="form-control" id="basic-icon-default-fullname"
												value="${c.tenDuAn_TiengViet}" name="tenDuAn_TiengViet"
												maxlength="700"
												placeholder="Nhập tên dự án" aria-label="John Doe"
												aria-describedby="basic-icon-default-fullname2" />

										</div>
										
									</div>
									
								</div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-fullname">Tên dự án(Tiếng anh)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span id="basic-icon-default-fullname2"
												class="input-group-text"><i class='bx bxs-notepad'></i> </span> <input type="text"
												class="form-control" id="basic-icon-default-fullname"
												value="${c.tenDuAn_TiengAnh}" name="tenDuAn_TiengAnh"
												maxlength="700"
												placeholder="Nhập tên dự án" aria-label="John Doe"
												aria-describedby="basic-icon-default-fullname2" />
										</div>
										
									</div>
								</div>
								<div class="divider text-start">
									<div style="color: black; border-radius: 8px;"
										class="divider-text bg-danger">2.Các thông tin liên quan</div>
								</div>

								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Danh mục dự án</label>
									<div class="col-sm-6">
										<div class="input-group input-group-merge">
                                           <span id="basic-icon-default-fullname2"
												class="input-group-text"><i class='bx bxs-category' ></i> </span>
											<select name="maDanhMuc" id="maDanhMuc"
												class="form-select">


												<c:if test="${empty duan.maDanhMuc }">
													<option value="0">Chọn danh mục</option>
													<c:forEach var="item" items="${danhmucs}">

														<option value="${item.maDanhMuc}" selected="selected">${item.tenDanhMuc}</option>
													</c:forEach>
												</c:if>



												<c:if test="${ not empty duan.maDanhMuc }">

													<c:forEach var="item" items="${danhmucs}">
														<c:if test="${item.maDanhMuc==duan.maDanhMuc }">
															<option value="${item.maDanhMuc}" selected="selected">${item.tenDanhMuc}</option>
														</c:if>
														<c:if test="${item.maDanhMuc!=duan.maDanhMuc }">
															<option value="${item.maDanhMuc}">${item.tenDanhMuc}</option>
														</c:if>
													</c:forEach>
													<option value="0">Chọn danh mục</option>

												</c:if>
											</select> <a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal2" href=""
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>
										</div>

									</div>
								</div>
							<%-- 	<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đơn vị trực thuộc</label>
									<div class="col-sm-6">
										<div class="input-group input-group-merge">
											<select name="maDonViTrucThuoc" id="maDonViTrucThuoc"
												class="form-select">


												<c:if test="${empty duan.maDonViTrucThuoc }">
													<option value="0">Chọn mã đơn vị trực thuộc</option>
													<c:forEach var="item" items="${donvitructhuocs}">

														<option value="${item.maDonViTrucThuoc}" selected="selected">${item.tenDonViTrucThuoc}</option>
													</c:forEach>
												</c:if>



												<c:if test="${ not empty duan.maDonViTrucThuoc }">

													<c:forEach var="item" items="${donvitructhuocs}">
														<c:if test="${item.maDonViTrucThuoc==duan.maDonViTrucThuoc }">
															<option value="${item.maDonViTrucThuoc}" selected="selected">${item.tenDonViTrucThuoc}</option>
														</c:if>
														<c:if test="${item.maDonViTrucThuoc!=duan.maDonViTrucThuoc }">
															<option value="${item.maDonViTrucThuoc}">${item.tenDonViTrucThuoc}</option>
														</c:if>
													</c:forEach>
													<option value="0">Chọn đơn vị trực thuộc</option>

												</c:if>
											</select> <a type="button" class="btn btn-primary"
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
											<select name="maNhaTaiTro" id="maNhaTaiTro"
												class="form-select">


												<c:if test="${empty duan.maNhaTaiTro }">
													<option value="0">Chọn đơn vị trực thuộc</option>
													<c:forEach var="item" items="${nhataitros}">

														<option value="${item.maNhaTaiTro}" selected="selected">${item.tenNhaTaiTro}</option>
													</c:forEach>
												</c:if>



												<c:if test="${ not empty duan.maNhaTaiTro }">

													<c:forEach var="item" items="${nhataitros}">
														<c:if test="${item.maNhaTaiTro==duan.maNhaTaiTro }">
															<option value="${item.maNhaTaiTro}" selected="selected">${item.tenNhaTaiTro}</option>
														</c:if>
														<c:if test="${item.maNhaTaiTro!=duan.maNhaTaiTro }">
															<option value="${item.maNhaTaiTro}">${item.tenNhaTaiTro}</option>
														</c:if>
													</c:forEach>
													<option value="0">Chọn nhà tài trợ</option>

												</c:if>
											</select> <a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal4" href=""
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>
										</div>
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
									
													name="file_dinhkem_nhataitro" id="inputGroupFile01" />
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
											<select name="maLoaiVienTro" id="maLoaiVienTro"
												class="form-select">


												<c:if test="${empty duan.maLoaiVienTro }">
													<option value="0">Chọn loại viện trợ</option>
													<c:forEach var="item" items="${loaivientros}">

														<option value="${item.maLoaiVienTro}" selected="selected">${item.tenLoaiVienTro}</option>
													</c:forEach>
												</c:if>



												<c:if test="${ not empty duan.maLoaiVienTro }">

													<c:forEach var="item" items="${loaivientros}">
														<c:if test="${item.maLoaiVienTro==duan.maLoaiVienTro }">
															<option value="${item.maLoaiVienTro}" selected="selected">${item.tenLoaiVienTro}</option>
														</c:if>
														<c:if test="${item.maLoaiVienTro!=duan.maLoaiVienTro }">
															<option value="${item.maLoaiVienTro}" >${item.tenLoaiVienTro}</option>
														</c:if>
													</c:forEach>
													<option value="0">Chọn loại viện trợ</option>

												</c:if>
											</select> <a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal5" href=""
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>
										</div>
									</div>
								</div>
								<!-- <div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đính kèm file(Loại
										viện trợ)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												<label class="input-group-text" for="inputGroupFile01">Upload</label>
												<input type="file" class="form-control"
												
													name="file_dinhkem_vientro" id="inputGroupFile01" />
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
											<select name="maCoQuanPheDuyet" id="maCoQuanPheDuyet"
												class="form-select">


												<c:if test="${empty duan.maCoQuanPheDuyet }">
													<option value="0">Chọn cơ quan phê duyệt</option>
													<c:forEach var="item" items="${coquanpheduyets}">

														<option value="${item.maCoQuanPheDuyet}" selected="selected">${item.tenCoQuanPheDuyet}</option>
													</c:forEach>
												</c:if>



												<c:if test="${ not empty duan.maCoQuanPheDuyet }">

													<c:forEach var="item" items="${coquanpheduyets}">
														<c:if test="${item.maCoQuanPheDuyet==duan.maCoQuanPheDuyet }">
															<option value="${item.maCoQuanPheDuyet}" selected="selected">${item.tenCoQuanPheDuyet}</option>
														</c:if>
														<c:if test="${item.maCoQuanPheDuyet!=duan.maCoQuanPheDuyet }">
															<option value="${item.maCoQuanPheDuyet}">${item.tenCoQuanPheDuyet}</option>
														</c:if>
													</c:forEach>
													<option value="0">Chọn cơ quan phê duyệt</option>

												</c:if>
											</select> <a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal"
												href='<c:url value="/admin_them_coquanpheduyet?action=them_coquanpheduyet"/>'
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>



										</div>
									</div>
								</div>
								<!-- <div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đính kèm file(cơ quan
										phê duyệt)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												<label class="input-group-text" for="inputGroupFile01">Upload</label>
												<input type="file" class="form-control"
											
													name="file_dinhkem_coquanpheduyet" id="inputGroupFile01" />
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
											<select name="maDoiTacThucHien" id="maDoiTacThucHien"
												class="form-select">


												<c:if test="${empty duan.maDoiTacThucHien }">
													<option value="0">Chọn đối tác thực hiện</option>
													<c:forEach var="item" items="${doitacthuchiens}">

														<option value="${item.maDoiTacThucHien}" selected="selected">${item.tenDoiTacThucHien}</option>
													</c:forEach>
												</c:if>



												<c:if test="${ not empty duan.maDoiTacThucHien }">

													<c:forEach var="item" items="${doitacthuchiens}">
														<c:if test="${item.maDoiTacThucHien==duan.maDoiTacThucHien }">
															<option value="${item.maDoiTacThucHien}" selected="selected">${item.tenDoiTacThucHien}</option>
														</c:if>
														<c:if test="${item.maDoiTacThucHien!=duan.maDoiTacThucHien }">
															<option value="${item.maDoiTacThucHien}">${item.tenDoiTacThucHien}</option>
														</c:if>
													</c:forEach>
													<option value="0">Chọn đối tác thực hiện</option>

												</c:if>
											</select> <a type="button" class="btn btn-primary"
												data-bs-toggle="modal" data-bs-target="#basicModal6" href=""
												type="button" class="btn btn-warning">+Thêm dữ liệu</a>
										</div>
									</div>
								</div>
		<!-- 						<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đính kèm file(đối tác
										thực hiện)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												<label class="input-group-text" for="inputGroupFile01">Upload</label>
												<input type="file" class="form-control"
											
													name="file_dinhkem_doitacthuchien" id="inputGroupFile01" />
											</div>
										</div>
									</div>
								</div> -->
										<div class="divider text-start">
                        <div style="color:black;border-radius: 8px;" class="divider-text bg-danger">3.Các thông tin về mục tiêu và nội dung và các loại thiết bị tài trợ của dự án</div>
                        
                      </div>
                
									<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-default-message">Mục tiêu dự án</label>
									<div class="col-sm-10">
										<textarea style="height:100px" id="textarea_muctieuduan" class="form-control"
											placeholder="Điền thông tin mục tiêu dự án?"
											aria-label="Hi, Do you have a moment to talk Joe?"
											aria-describedby="basic-icon-default-message2"
											name="mucTieuDuAn"
										
											> ${c.mucTieuDuAn}</textarea>
									</div>
								</div>
									<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-default-message">Nội dung thực hiện</label>
									<div class="col-sm-10">
										<textarea style="height:250px" id="textarea_noidungthuchien" class="form-control"
											placeholder="Nội dung thực hiện?"
											aria-label="Hi, Do you have a moment to talk Joe?"
											aria-describedby="basic-icon-default-message2"
											name="noiDungThucHien"
											
											> ${c.noiDungThucHien}</textarea>
									</div>
								</div>
									<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-default-message">Các thiết bị tài trợ</label>
									<div class="col-sm-10">
										<textarea style="height:100px" id="textarea_thietbitaitro" class="form-control"
											placeholder="Thiết bị được tài trợ?"
											aria-label="Hi, Do you have a moment to talk Joe?"
											 maxlength="700"
											aria-describedby="basic-icon-default-message2"
											name="thietBiTaiTro"
											
											> ${c.thietBiTaiTro}</textarea>
									</div>
								</div>
								
								<div class="divider text-start">
									<div style="color: black; border-radius: 8px;"
										class="divider-text bg-danger">4.Các thông tin về kinh
										phí dự án</div>
								</div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Kinh phí dự án năm
										trước</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i class='bx bxs-credit-card'></i></span> <input type="text"
												id="basic-icon-default-email" class="form-control"
												placeholder="Nhập kinh phí dự án năm trước"
												aria-label="john.doe" name="kinhPhiDuAnNamTruoc"
												 maxlength="700"
												aria-describedby="basic-icon-default-email2"
										    	value="${c.kinhPhiNamTruoc}"
												 />
										</div>
										 
									</div>
								</div>
						
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Vốn tài trợ,viện trợ</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i class='bx bxs-credit-card'></i></span> <input type="text"
												id="input_vontaitro" class="form-control"
												name="vonTaiTro" placeholder="Nhập vốn tài trợ"
												aria-label="john.doe"
												aria-describedby="basic-icon-default-email2"
												value="${c.vonTaiTro}"
												onchange="calculateTotal()"
												oninput="formatNumber('input_vontaitro', 'infoSpan_vontaitro')"
												 />
												  <select  id="capital-currency"  name="donViTienTe_VonTaiTro" class="form-select btn-success">
										          <option value="0" selected>Chọn đơn vị tiền tệ</option>
												  <option value="VND" ${c.donViTienTe_VonTaiTro == 'VND' ? 'selected' : ''}>VND</option>
												  <option value="USD" ${c.donViTienTe_VonTaiTro == 'USD' ? 'selected' : ''}>USD</option>
												  <option value="Euro" ${c.donViTienTe_VonTaiTro == 'Euro' ? 'selected' : ''}>Euro</option>
												  <option value="CNY" ${c.donViTienTe_VonTaiTro == 'CNY' ? 'selected' : ''}>CNY</option>
				
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
											<span class="input-group-text"><i class='bx bxs-credit-card'></i></span> <input type="text"
												id="input_vonvay" class="form-control"
												name="vonVay" value="${c.vonVay}" placeholder="Nhập vốn vay"
												aria-label="john.doe"
												aria-describedby="basic-icon-default-email2"
												value="${c.vonVay}"
												onchange="calculateTotal()"
												 oninput="formatNumber('input_vonvay', 'infoSpan_vonvay')"
												 />
												  <select  id="loan-currency"  name="donViTienTe_VonVay" class="form-select btn-success">
										          <option value="0" selected>Chọn đơn vị tiền tệ</option>
												  <option value="VND" ${c.donViTienTe_VonVay == 'VND' ? 'selected' : ''}>VND</option>
												  <option value="USD" ${c.donViTienTe_VonVay == 'USD' ? 'selected' : ''}>USD</option>
												  <option value="Euro" ${c.donViTienTe_VonVay == 'Euro' ? 'selected' : ''}>Euro</option>
												  <option value="CNY" ${c.donViTienTe_VonVay == 'CNY' ? 'selected' : ''}>CNY</option>
				
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
											<span class="input-group-text"><i class='bx bxs-credit-card'></i></span> <input type="text"
												id="input_vonkhac" class="form-control"
												placeholder="Nhập vốn khác" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2" name="vonKhac"
												value="${c.vonKhac}"
												onchange="calculateTotal()"
											    oninput="formatNumber('input_vonkhac', 'infoSpan_vonkhac')"
												
												 />
												  <select  id="other-currency"  name="donViTienTe_VonKhac" class="form-select btn-success">
										          <option value="0" selected>Chọn đơn vị tiền tệ</option>
												  <option value="VND" ${c.donViTienTe_VonKhac == 'VND' ? 'selected' : ''}>VND</option>
												  <option value="USD" ${c.donViTienTe_VonKhac == 'USD' ? 'selected' : ''}>USD</option>
												  <option value="Euro" ${c.donViTienTe_VonKhac == 'Euro' ? 'selected' : ''}>Euro</option>
												  <option value="CNY" ${c.donViTienTe_VonKhac == 'CNY' ? 'selected' : ''}>CNY</option>
				
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
												name="vonDoiUng"value="${c.vonDoiUng}"
												onchange="calculateTotal()"
												 oninput="formatNumber('input_vondoiung', 'infoSpan_vondoiung')"
												 />
												 <select  id="doiung-currency"  name="donViTienTe_VonDoiUng" class="form-select btn-success">
										    
										    
					                             <option value="0" selected>Chọn đơn vị tiền tệ</option>
												  <option value="VND" ${c.donViTienTe_VonDoiUng == 'VND' ? 'selected' : ''}>VND</option>
												  <option value="USD" ${c.donViTienTe_VonDoiUng == 'USD' ? 'selected' : ''}>USD</option>
												  <option value="Euro" ${c.donViTienTe_VonDoiUng == 'Euro' ? 'selected' : ''}>Euro</option>
												  <option value="CNY" ${c.donViTienTe_VonDoiUng == 'CNY' ? 'selected' : ''}>CNY</option>
				
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
											<span class="input-group-text text-info"><a  onclick="convertNumberToText()" ><i class='bx bxs-credit-card'></i></a></span> <input type="text"
												id="input_tongvonthuchien" class="form-control"
												name="tongVonThucHien" 
												placeholder="Nhập tổng vốn thực hiện" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2"
												value="${c.tongVonThucHien}"
												onchange="calculateTotal()"
												readonly
												 />
												 <select  id="total-currency" name="donViTienTe_TongVonThucHien"  class="form-select btn-warning">
										     <option value="0" selected>Quy đổi đơn vị tiền tệ</option>
												  <option value="VND" ${c.donViTienTe_TongVonThucHien == 'VND' ? 'selected' : ''}>VND</option>
												  <option value="USD" ${c.donViTienTe_TongVonThucHien == 'USD' ? 'selected' : ''}>USD</option>
												  <option value="Euro" ${c.donViTienTe_TongVonThucHien == 'Euro' ? 'selected' : ''}>Euro</option>
												  <option value="CNY" ${c.donViTienTe_TongVonThucHien == 'CNY' ? 'selected' : ''}>CNY</option>
				
					                        </select>
										</div>
										 <span id="spanTongVon"></span>
										 
									</div>
								</div>
							
								<div class="divider text-start">
									<div style="color: black; border-radius: 8px;"
										class="divider-text bg-danger">5.Các thông tin về tiến
										độ của dự án</div>
								</div>
									<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-default-message">Tình trạng tiến độ dự án(Bao gồm tiến độ triển khai và tiến độ giải ngân)</label>
									<div class="col-sm-10">
										<textarea style="height:250px;" id="basic-default-message" class="form-control"
											placeholder="Dự án của bạn đang trong tình trạng ra sao?"
											aria-label="Hi, Do you have a moment to talk Joe?"
											aria-describedby="basic-icon-default-message2"
											name="tienDoThucHien" >${c.tienDoThucHien}</textarea>
									</div>
								</div>
								<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-email">Dự án của bạn đạt được
										bao nhiêu phần trăm</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<span class="input-group-text"><i class='bx bxs-tachometer'></i></span> <input type="text"
												id="basic-icon-default-email" class="form-control"
												placeholder="Nhập phần trăm tiến độ" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2"
												 maxlength="100"
												name="phanTramTienDoThucHien" value="${c.phanTramTienDoThucHien}" />
										</div>
										<div class="form-text">Lưu ý chỉ cần ước lượng,không cần
											chính xác tuyệt đối</div>
									</div>
								</div>
								<div class="divider text-start">
									<div style="color: black; border-radius: 8px;"
										class="divider-text bg-danger">6.Các thông tin về thời gian thực hiện dự án</div>
								</div>
								
								    <div class="mb-3 row">
                        <label for="html5-datetime-local-input" class="col-md-2 col-form-label">Thời gian bắt đầu</label>
                        <div class="col-md-10">
                         <div class="input-group input-group-merge">
                        <span class="input-group-text"><i class='bx bxs-calendar' ></i></span>
                          <input
                            class="form-control"
                            type="datetime-local"
                            name="thoiGianBatDau"
                            value="${c.thoiGianBatDau}"
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
                              value="${c.thoiGianKetThuc}"
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
												placeholder="Nhập thời gian thực hiện" aria-label="john.doe"
												aria-describedby="basic-icon-default-email2"
												name="thoiGianThucHien" value="${c.thoiGianThucHien}"
												readonly
												 />
										</div>
										<!-- <div class="form-text">VD:5 tháng,1 năm</div> -->
									</div>
								</div>
                     
                       
                      
								
							    <input name="maDonViTienTe" value="${c.maDonViTienTe}" type="hidden">
								<input type="hidden" value="${c.maNguoiDung}" id="maNguoiDung" name="maNguoiDung"/>
								<input type="hidden" value="${c.maDuAn}" id="maDuAn" name="maDuAn"/>
								<input type="hidden" value="${c.maDonViTrucThuoc}" id="maDonViTrucThuoc" name="maDonViTrucThuoc"/>
								

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
								<div class="row justify-content-end">
									<div class="col-sm-10">
										<button type="submit" class="btn btn-primary">Lưu
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
			action="<c:url value='/admin_them_coquanpheduyet?action=them_coquanpheduyet_suaduan'/>"
			id="form_submit1" name="form_submit1" method="post">
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
							
							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên cơ quan
										phê duyệt</label> <input type="text" id="nameBasic"
										class="form-control" name="tenCoQuanPheDuyet"
										placeholder="Vui lòng nhập tên cơ quan phê duyệt" />
								</div>
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>



		<!-- //Đây là xử lý danh mục -->
		<form
			action="<c:url value='/admin_them_danhmuc?action=them_danhmuc_suaduan'/>"
			id="form_submit2" name="form_submit2" method="post">
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
							<button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>


		<!-- //Đây là xử lý đơn vị trực thuộc -->
		

		<!-- //Đây là xử lý nhà tài trợ -->
		<form
			action="<c:url value='/admin_them_nhataitro?action=them_nhataitro_suaduan'/>"
			id="form_submit3" name="form_submit3" method="post">
			<div class="modal fade" id="basicModal4" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm nhà tài
								trợ</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên nhà tài
										trợ</label> <input type="text" id="nameBasic" class="form-control"
										name="tenNhaTaiTro"
										placeholder="Vui lòng nhập tên nhà tài trợ" />
								</div>
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!-- //Đây là xử lý loại viện trợ -->
		<form
			action="<c:url value='/admin_them_loaivientro?action=them_loaivientro_suaduan'/>"
			id="form_submit4" name="form_submit4" method="post">
			<div class="modal fade" id="basicModal5" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm loại
								viện trợ</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên loại viện
										trợ</label> <input type="text" id="nameBasic" class="form-control"
										name="tenLoaiVienTro"
										placeholder="Vui lòng nhập tên loại viện trợ" />
								</div>
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button  type="submit" class="btn btn-primary" data-bs-dismiss="modal">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<!-- //Đây là xử lý đối tác thực hiện -->
		<form
			action="<c:url value='/admin_them_doitacthuchien?action=them_doitacthuchien_suaduan'/>"
			id="form_submit5" name="form_submit5" method="post">
			<div class="modal fade" id="basicModal6" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm đối tác
								thực hiện</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên đối tác
										thực hiện</label> <input type="text" id="nameBasic"
										class="form-control" name="tenDoiTacThucHien"
										placeholder="Vui lòng nhập tên đối tác thực hiện" />
								</div>
							</div>
						
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-outline-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Lưu thay
								đổi</button>
						</div>
					</div>
				</div>
			</div>
		</form>
				<!-- //Đây là xử lý đối đơn vị tiền tệ -->
		<form
			action="<c:url value='/admin_them_donvitiente?action=them_donvitiente_suaduan'/>"
			id="form_submit6" name="form_submit6" method="post">
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
							<button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Lưu thay
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
  // JavaScript
  window.onload = function() {
    // Danh sách các id của thẻ input cần xử lý
    var inputIds = [
      "input_vontaitro",
      "input_vonvay",
      "input_vonkhac",
      "input_vondoiung",
      "input_tongvonthuchien"
    ];

    // Lặp qua danh sách các id và áp dụng format cho từng thẻ input
    for (var i = 0; i < inputIds.length; i++) {
      var input = document.getElementById(inputIds[i]);
      var valueFromInput = parseFloat(input.value);

      var formattedValue = valueFromInput.toString().replace(".", "");

      input.value = formattedValue;
    }
  };
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
  $(document).ready(function() {
    $("#form_submit1").submit(function(e) {
      e.preventDefault(); // ngăn chặn chuyển hướng đến trang khác khi submit form
      $.ajax({
        type: "POST",
        url: $(this).attr("action"),
        data: $(this).serialize(),
        success: function(response) {
        
        },
        error: function(xhr, status, error) {
          // xử lý lỗi ở đây và hiển thị modal thông báo thất bại tương tự như ở đoạn mã trên
        }
      });
    });
  });
</script>
<script>
  $(document).ready(function() {
    $("#form_submit2").submit(function(e) {
      e.preventDefault(); // ngăn chặn chuyển hướng đến trang khác khi submit form
      $.ajax({
        type: "POST",
        url: $(this).attr("action"),
        data: $(this).serialize(),
        success: function(response) {
        
        },
        error: function(xhr, status, error) {
          // xử lý lỗi ở đây và hiển thị modal thông báo thất bại tương tự như ở đoạn mã trên
        }
      });
    });
  });
</script>
<script>
  $(document).ready(function() {
    $("#form_submit3").submit(function(e) {
      e.preventDefault(); // ngăn chặn chuyển hướng đến trang khác khi submit form
      $.ajax({
        type: "POST",
        url: $(this).attr("action"),
        data: $(this).serialize(),
        success: function(response) {
        
        },
        error: function(xhr, status, error) {
          // xử lý lỗi ở đây và hiển thị modal thông báo thất bại tương tự như ở đoạn mã trên
        }
      });
    });
  });
</script>
<script>
  $(document).ready(function() {
    $("#form_submit4").submit(function(e) {
      e.preventDefault(); // ngăn chặn chuyển hướng đến trang khác khi submit form
      $.ajax({
        type: "POST",
        url: $(this).attr("action"),
        data: $(this).serialize(),
        success: function(response) {
        
        },
        error: function(xhr, status, error) {
          // xử lý lỗi ở đây và hiển thị modal thông báo thất bại tương tự như ở đoạn mã trên
        }
      });
    });
  });
</script>
<script>
  $(document).ready(function() {
    $("#form_submit5").submit(function(e) {
      e.preventDefault(); // ngăn chặn chuyển hướng đến trang khác khi submit form
      $.ajax({
        type: "POST",
        url: $(this).attr("action"),
        data: $(this).serialize(),
        success: function(response) {
        
        },
        error: function(xhr, status, error) {
          // xử lý lỗi ở đây và hiển thị modal thông báo thất bại tương tự như ở đoạn mã trên
        }
      });
    });
  });
</script>
<script>
  $(document).ready(function() {
    $("#form_submit6").submit(function(e) {
      e.preventDefault(); // ngăn chặn chuyển hướng đến trang khác khi submit form
      $.ajax({
        type: "POST",
        url: $(this).attr("action"),
        data: $(this).serialize(),
        success: function(response) {
        
        },
        error: function(xhr, status, error) {
          // xử lý lỗi ở đây và hiển thị modal thông báo thất bại tương tự như ở đoạn mã trên
        }
      });
    });
  });
</script>
<script>
function goBack() {
  window.history.back();
}
</script>
	<!-- Swap id thành tên thẻ input trong datalist -->
	<!--   <script type="text/javascript">
		var categoryInput = document.getElementById("maDanhMuc");
		categoryInput.addEventListener("change", function() {
		  var selectedOption = this.value;
		  var datalist = this.list;
		  var option = null;
		  for (var i = 0; i < datalist.options.length; i++) {
		    if (datalist.options[i].value === selectedOption) {
		      option = datalist.options[i];
		      break;
		    }
		  }
		  if (option !== null) {
		    this.value = option.label;
		  }
		});
	</script>  
	<script type="text/javascript">
		var categoryInput = document.getElementById("maDonViTrucThuoc");
		categoryInput.addEventListener("change", function() {
		  var selectedOption = this.value;
		  var datalist = this.list;
		  var option = null;
		  for (var i = 0; i < datalist.options.length; i++) {
		    if (datalist.options[i].value === selectedOption) {
		      option = datalist.options[i];
		      break;
		    }
		  }
		  if (option !== null) {
		    this.value = option.label;
		  }
		});
	</script> 
	<script type="text/javascript">
	var categoryInput = document.getElementById("maNhaTaiTro");
	categoryInput.addEventListener("change", function() {
	  var selectedOption = this.value;
	  var datalist = this.list;
	  var option = null;
	  for (var i = 0; i < datalist.options.length; i++) {
	    if (datalist.options[i].value === selectedOption) {
	      option = datalist.options[i];
	      break;
	    }
	  }
	  if (option !== null) {
	    this.value = option.label;
	  }
	});
	</script>
	<script type="text/javascript">
	var categoryInput = document.getElementById("maLoaiVienTro");
	categoryInput.addEventListener("change", function() {
	  var selectedOption = this.value;
	  var datalist = this.list;
	  var option = null;
	  for (var i = 0; i < datalist.options.length; i++) {
	    if (datalist.options[i].value === selectedOption) {
	      option = datalist.options[i];
	      break;
	    }
	  }
	  if (option !== null) {
	    this.value = option.label;
	  }
	});
	</script>
	<script type="text/javascript">
	var categoryInput = document.getElementById("maCoQuanPheDuyet");
	categoryInput.addEventListener("change", function() {
	  var selectedOption = this.value;
	  var datalist = this.list;
	  var option = null;
	  for (var i = 0; i < datalist.options.length; i++) {
	    if (datalist.options[i].value === selectedOption) {
	      option = datalist.options[i];
	      break;
	    }
	  }
	  if (option !== null) {
	    this.value = option.label;
	  }
	});
	</script>
		<script type="text/javascript">
	var categoryInput = document.getElementById("maDoiTacThucHien");
	categoryInput.addEventListener("change", function() {
	  var selectedOption = this.value;
	  var datalist = this.list;
	  var option = null;
	  for (var i = 0; i < datalist.options.length; i++) {
	    if (datalist.options[i].value === selectedOption) {
	      option = datalist.options[i];
	      break;
	    }
	  }
	  if (option !== null) {
	    this.value = option.label;
	  }
	});
	</script>  -->
</body>
</html>