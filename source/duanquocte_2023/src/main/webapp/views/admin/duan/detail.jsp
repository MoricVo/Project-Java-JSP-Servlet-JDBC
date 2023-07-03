<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<!-- / Navbar -->

	<!-- Content wrapper -->
	<div class="content-wrapper">
		<!-- Content -->

		<div class="container-xxl flex-grow-1 container-p-y">


			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<c:set var="c" value="${requestScope.duan}" />
						<c:set var="c1" value="${requestScope.files}" />
						<!-- Notifications -->
						<h5 class="card-header">Chi tiết dự án</h5>
						
             
						<div class="card-body">
							<span>Bạn đang xem chi tiết dự án có mã là <span
								class="notificationRequest text-danger">${c.maDuAn}</span>
							</span>
							
							<div class="error"></div>
						</div>
						  <div class="card-body">
                <button onclick="goBack()" type="button" class="btn btn-primary">
                  <i class="bx bx-chevron-left scaleX-n1-rtl bx-sm"></i>
                  Quay lại trang trước
                </button>
              </div>
						<div class="table-responsive text-nowrap">

							<table class="table table-striped table-borderless border-bottom">

								<thead>

									<tr class="table-danger">
										<th class="text-nowrap" style="font-weight: 600; color: black">Mã
											dự án:</th>

										<td style="border-right: 2px solid;">DA${c.maDuAn}</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Chủ
											dự án:</th>

										<td>${c.nguoidung.tenNguoiDung}</td>

									</tr>

								</thead>
								<tbody>
									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Tên
											dự án(Tiếng việt):</th>

										<td  style="border-right: 2px solid;white-space: pre-wrap;">${c.tenDuAn_TiengViet}</td>

										<th class="text-nowrap" style="font-weight: 600; color: black;">Tên
											dự án(Tiếng anh):</th>

										<td style="white-space:pre-wrap;">${c.tenDuAn_TiengAnh}</td>

									</tr>
									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Danh
											mục dự án:</th>
										<td style="border-right: 2px solid;">${c.danhmuc.tenDanhMuc}</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Đơn
											vị trực thuộc</th>
										<td>${c.donvitructhuoc.tenDonViTrucThuoc}</td>
									</tr>

									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Nhà
											tài trợ:</th>
										<td style="border-right: 2px solid;">${c.nhataitro.tenNhaTaiTro}
											<%-- <a href="${pageContext.request.contextPath}/source_file_upload/${c.file_dinhkem_nhataitro}" style="float:right;"  class="btn btn-icon btn-primary" download>
												<i class='bx bxs-download'></i>
												
											</a> --%>
										</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Loại
											viện trợ:</th>
										<td>${c.loaivientro.tenLoaiVienTro}<%-- <a href="${pageContext.request.contextPath}/source_file_upload/${c.file_dinhkem_vientro}" style="float:right;"  class="btn btn-icon btn-primary" download>
												<i class='bx bxs-download'></i>
												
											</a> --%>
										</td>


									</tr>
									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Cơ
											quan phê duyệt:</th>
										<td style="border-right: 2px solid;">${c.coquanpheduyet.tenCoQuanPheDuyet}
											<%-- <a href="${pageContext.request.contextPath}/source_file_upload/${c.file_dinhkem_coquanpheduyet}" style="float:right;"  class="btn btn-icon btn-primary" download>
												<i class='bx bxs-download'></i>
												
											</a> --%>
										</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Đối
											tác thực hiện:</th>
										<td>${c.doitacthuchien.tenDoiTacThucHien}<%-- <a href="${pageContext.request.contextPath}/source_file_upload/${c.file_dinhkem_doitacthuchien}" style="float:right;"  class="btn btn-icon btn-primary" download>
												<i class='bx bxs-download'></i>
												
											</a> --%>
										</td>


									</tr>
									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Các
											thành viên tham gia:</th>
										<td style="border-right: 2px solid;white-space: pre-wrap;">${c.thanhVienThamGia}
											<%-- <a href="${pageContext.request.contextPath}/source_file_upload/${c.file_dinhkem_coquanpheduyet}" style="float:right;"  class="btn btn-icon btn-primary" download>
												<i class='bx bxs-download'></i>
												
											</a> --%>
										</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Mục
											tiêu dự án:</th>
										<td style="white-space:pre-wrap;">${c.mucTieuDuAn}
										</td>


									</tr>
									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Nội
											dung thực hiện:</th>
										<td style="border-right: 2px solid;white-space: pre-wrap;">${c.noiDungThucHien}
											<%-- <a href="${pageContext.request.contextPath}/source_file_upload/${c.file_dinhkem_coquanpheduyet}" style="float:right;"  class="btn btn-icon btn-primary" download>
												<i class='bx bxs-download'></i>
												
											</a> --%>
										</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Các
											thiết bị được tài trợ:</th>
										<td style="white-space: pre-wrap;" >${c.thietBiTaiTro}<%-- <a href="${pageContext.request.contextPath}/source_file_upload/${c.file_dinhkem_doitacthuchien}" style="float:right;"  class="btn btn-icon btn-primary" download>
												<i class='bx bxs-download'></i>
												
											</a> --%>
										</td>


									</tr>
									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Kinh
											phí dự án năm trước:</th>
										<td style="border-right: 2px solid;">${c.kinhPhiNamTruoc}</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Tổng
											vốn thực hiện:</th>
										<td id="input_tongvonthuchien">${c.tongVonThucHien} ${c.donViTienTe_TongVonThucHien}</td>


									</tr>
									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Vốn
											tài trợ:</th>
										<td style="border-right: 2px solid;" id="input_vontaitro">${c.vonTaiTro} ${c.donViTienTe_VonTaiTro}</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Vốn
											vay:</th>
										<td id="input_vonvay">${c.vonVay} ${c.donViTienTe_VonVay}</td>



									</tr>
									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Vốn
											khác:</th>
										<td style="border-right: 2px solid;" id="input_vonkhac">${c.vonKhac}
											${c.donViTienTe_VonKhac}</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Vốn
											đối ứng:</th>
										<td id="input_vondoiung">${c.vonDoiUng} ${c.donViTienTe_VonDoiUng}</td>



									</tr>
								
									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Thời
											gian thực hiện:</th>
										<td style="border-right: 2px solid;">${c.thoiGianThucHien}</td>

										<th class="text-nowrap" style="font-weight: 600; color: black ;white-space: pre-wrap;">Tình
											trạng dự án:</th>
										<td style="white-space: pre-wrap;">${c.tienDoThucHien}</td>



									</tr>
									<tr>
										<th class="text-nowrap" style="font-weight: 600; color: black">Thời
											gian bắt đầu:</th>
										<td style="border-right: 2px solid;">${c.thoiGianBatDau}</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Thời gian kết thúc:</th>
										<td>${c.thoiGianKetThuc}</td>



									</tr>
									<tr>


										<th class="text-nowrap" style="font-weight: 600; color: black">Phần
											trăm tiến độ:</th>
										<td style="border-right: 2px solid;">${c.phanTramTienDoThucHien}</td>

										<th class="text-nowrap" style="font-weight: 600; color: black">Ngày
											tạo dự án:</th>
										<td>${c.ngayTao}</td>

									</tr>

								</tbody>
							</table>
							<div class="col-md-12 col-12">
								<div class="card">
									<h5 class="card-header">Tải file đính kèm,hình ảnh,minh
										chứng tại đây!</h5>
									<div class="card-body">
										<p>Tổng hợp các file minh chứng người dùng đã upload</p>
										<!-- Social Accounts -->
										<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">1.Đề cương dự án/ Proposal.</h6>
													<c:if test="${empty c1.file_decuongduan}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_decuongduan}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_decuongduan}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_decuongduan}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_decuongduan}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">2.Thư chấp nhận thực hiện dự án.</h6>
													<c:if test="${empty c1.file_thucahpnhanthuchien}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_thucahpnhanthuchien}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_thucahpnhanthuchien}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_thucahpnhanthuchien}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_thucahpnhanthuchien}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">3.Tờ trình xin phép thực hiện.</h6>
													<c:if test="${empty c1.file_totrinhxinphepthuchien}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_totrinhxinphepthuchien}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_totrinhxinphepthuchien}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_totrinhxinphepthuchien}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_totrinhxinphepthuchien}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">4.Quyết định giao kinh phí/ Thỏa thuận kinh phí.</h6>
													<c:if test="${empty c1.file_quyetdinhgiaokinhphi}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_quyetdinhgiaokinhphi}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_quyetdinhgiaokinhphi}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_quyetdinhgiaokinhphi}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_quyetdinhgiaokinhphi}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">5.Quyết định thành lập Ban quản lý dự án (thành viên tham gia dự án).</h6>
													<c:if test="${empty c1.file_quyetdinhthanhlapbanquanly}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_quyetdinhthanhlapbanquanly}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_quyetdinhthanhlapbanquanly}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_quyetdinhthanhlapbanquanly}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_quyetdinhthanhlapbanquanly}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">6.Quyết định cho phép thực hiện.</h6>
													<c:if test="${empty c1.file_quyetdinhchophepthuchien}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_quyetdinhchophepthuchien}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_quyetdinhchophepthuchien}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_quyetdinhchophepthuchien}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_quyetdinhchophepthuchien}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">7.Hợp đồng/ Thỏa thuận/Agreement/ MOA tài trợ dự án.</h6>
													<c:if test="${empty c1.file_hopdongthoathuan_moa}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_hopdongthoathuan_moa}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_hopdongthoathuan_moa}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_hopdongthoathuan_moa}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_hopdongthoathuan_moa}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">8.Kế hoạch triển khai dự án, minh chứng đoàn ra/đoàn vào để triển khai hợp tác.</h6>
													<c:if test="${empty c1.file_kehoachtrienkhaiduan}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_kehoachtrienkhaiduan}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_kehoachtrienkhaiduan}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_kehoachtrienkhaiduan}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_kehoachtrienkhaiduan}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">9.Báo cáo tiến độ/giữa kỳ (nếu dự án còn đang thực hiện).</h6>
													<c:if test="${empty c1.file_baocaotiendogiuaky}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_baocaotiendogiuaky}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_baocaotiendogiuaky}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_baocaotiendogiuaky}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_baocaotiendogiuaky}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">10.Báo cáo tổng kết (nếu dự án đã kết thúc).</h6>
													<c:if test="${empty c1.file_baocaotongket}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_baocaotongket}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_baocaotongket}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_baocaotongket}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_baocaotongket}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">11.Xác nhận kết thúc dự án.</h6>
													<c:if test="${empty c1.file_xacnhanketthucduan}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_xacnhanketthucduan}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_xacnhanketthucduan}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_xacnhanketthucduan}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_xacnhanketthucduan}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">12.Lý lịch khoa học của chủ nhiệm dự án và các cộng tác viên.</h6>
													<c:if test="${empty c1.file_lylichkhoahoccuachunhiemduan}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_lylichkhoahoccuachunhiemduan}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_lylichkhoahoccuachunhiemduan}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_lylichkhoahoccuachunhiemduan}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_lylichkhoahoccuachunhiemduan}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">13.Biên bản giải trình (nếu dự án trễ tiến độ).</h6>
													<c:if test="${empty c1.file_bienbangiaitrinh}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_bienbangiaitrinh}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_bienbangiaitrinh}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_bienbangiaitrinh}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_bienbangiaitrinh}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">14.Hình ảnh/Thông tin về các hoạt động triển khai hợp tác trên các phương tiện truyền thông.</h6>
													<c:if test="${empty c1.file_hinhanhthongtinhoatdongtrienkhai}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_hinhanhthongtinhoatdongtrienkhai}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_hinhanhthongtinhoatdongtrienkhai}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_hinhanhthongtinhoatdongtrienkhai}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_hinhanhthongtinhoatdongtrienkhai}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
											<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">15.Các minh chứng khác</h6>
													<c:if test="${empty c1.file_cacminhchungkhac}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_cacminhchungkhac}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_cacminhchungkhac}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_cacminhchungkhac}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_cacminhchungkhac}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>
																<div class="d-flex mb-3">

											<div class="flex-grow-1 row">
												<div class="col-8 col-sm-7 mb-sm-0 mb-2">
													<h6 class="mb-0">16.Các minh chứng khác 2</h6>
													<c:if test="${empty c1.file_cacminhchungkhac_2}">
														<small class="text-danger">File chưa được upload</small>
													</c:if>
													<c:if test="${ not empty c1.file_cacminhchungkhac_2}">
														<small class="text-success">File đã được upload</small>
													</c:if>
												</div>
												<div class="col-4 col-sm-1 text-end">
													<c:if test="${not empty c1.file_cacminhchungkhac_2}">
														<a type="button"
															href="${pageContext.request.contextPath}/source_file_upload/${c1.file_cacminhchungkhac_2}"
															class="btn btn-icon btn-outline-primary" download> <i
															class='bx bxs-download'></i></a>
													</c:if>
													<c:if test="${ empty c1.file_cacminhchungkhac_2}">
														<button type="button"
														
															class="btn btn-icon btn-outline-primary" disabled="disabled"> <i
															class='bx bxs-download' ></i></button>
													</c:if>
												</div>
											</div>
										</div>




										<!-- /Social Accounts -->
									</div>
								</div>
							</div>
						</div>


						<!-- /Notifications -->
					</div>

				</div>



			</div>


		</div>



		<!-- / Content -->


		<!-- / Footer -->

		<div class="content-backdrop fade"></div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  window.onload = function() {
    var inputIds = {
      "input_vontaitro": "${c.donViTienTe_VonTaiTro}",
      "input_vonvay": "${c.donViTienTe_VonVay}",
      "input_vonkhac": "${c.donViTienTe_VonKhac}",
      "input_vondoiung": "${c.donViTienTe_VonDoiUng}",
      "input_tongvonthuchien": "${c.donViTienTe_TongVonThucHien}"
    };

    for (var inputId in inputIds) {
      var input = document.getElementById(inputId);
      var valueFromInput = parseFloat(input.innerHTML);

      var formattedValue = valueFromInput.toLocaleString() + " " + inputIds[inputId];

      input.innerHTML = formattedValue;
    }
  };
</script>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>