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
					<c:if test="${not empty successMessage_file}">
					<div class="alert alert-danger alert-dismissible" role="alert">
						${successMessage_file}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>
				</div>
						<div
							class="card-header d-flex align-items-center justify-content-between">
								
							<h5 class="mb-0">Upload các file tài liệu hình ảnh minh chứng cho dự án của bạn</h5>
							
							<small class="text-muted float-end">Vui lòng điền thông
								tin bên dưới!</small>
						</div>
						 <div class="card-body">
                <button onclick="goBack()" type="button" class="btn btn-primary">
                  <i class="bx bx-chevron-left scaleX-n1-rtl bx-sm"></i>
                  Quay lại trang trước
                </button>
              </div>
						<div class="card-header d-flex align-items-center justify-content-between"><span style="color:red;">*Lưu ý chỉ upload 1 file duy nhất trên mỗi dòng</span></div>
						<div class="card-body">
							<form action="<c:url value='/admin_them_file_dinhkem?action=them_file_dinhkem_post'/>"
								id="form_submit" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
									<div class="row mb-3">
									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Chọn dự án cần thêm</label>
									<div class="col-sm-8">
										<div class="input-group input-group-merge">
										   
										    <select id="input_danhmuc"  name="maDuAn" class="form-select"  required >
										     <option value="0" selected>Chọn dự án</option>
										    <c:forEach var="item" items="${duans}">
					
					                          <option value="${item.maDuAn}" >${item.tenDuAn_TiengViet} </option>
					                          	</c:forEach>
					                        </select>
										  
											
										
										</div>

									</div>
								</div>
                                        	<div class="row mb-3">
									<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">1.File (đề
										cương dự án/proposal)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												
												<input type="file" class="form-control"
												name="file_decuongduan"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
								<div class="row mb-3">
								<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">2.file(Thư
										chấp nhận thực hiện dự án)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
											
												<input type="file" class="form-control"
												name="file_thucahpnhanthuchien"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
										<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">3.file(Tờ
										trình xin phép thực hiện)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												
												<input type="file" class="form-control"
												name="file_totrinhxinphepthuchien"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
									<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">4.file(Quyết
										định giao kinh phí/ Thỏa thuận kinh phí)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												
												<input type="file" class="form-control"
												name="file_quyetdinhgiaokinhphi"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
										<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">5.file(Quyết
										định thành lập Ban quản lý dự án (thành viên tham gia dự án))</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												
												<input type="file" class="form-control"
												name="file_quyetdinhthanhlapbanquanly"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
									<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">6.file(Quyết
										định cho phép thực hiện)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												
												<input type="file" class="form-control"
												name="file_quyetdinhchophepthuchien"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
									<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">7.file(Hợp
										đồng/ Thỏa thuận/Agreement/ MOA tài trợ dự án)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
											
												<input type="file" class="form-control"
												name="file_hopdongthoathuan_moa"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
									<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">8.file( Kế
										hoạch triển khai dự án, minh chứng đoàn ra/đoàn vào để triển
										khai hợp tác)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
											
												<input type="file" class="form-control"
												name="file_kehoachtrienkhaiduan"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
									<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">9.file(Báo cáo
										tiến độ/giữa kỳ (nếu dự án còn đang thực hiện))</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
											
												<input type="file" class="form-control"
												name="file_baocaotiendogiuaky"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
									<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">10.file(Báo cáo
										tổng kết (nếu dự án đã kết thúc))</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												
												<input type="file" class="form-control"
												name="file_baocaotongket"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
										<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">11.file(Xác
										nhận kết thúc dự án)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												
												<input type="file" class="form-control"
												name="file_xacnhanketthucduan"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
								<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">12.file(Lý lịch
										khoa học của chủ nhiệm dự án và các cộng tác viên)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
											
												<input type="file" class="form-control"
												name="file_lylichkhoahoccuachunhiemduan"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
															<div class="row mb-3">
										<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">13.file( Biên
										bản giải trình (nếu dự án trễ tiến độ))</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												
												<input type="file" class="form-control"
												name="file_bienbangiaitrinh"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
								<div class="row mb-3">
									<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">14.file(Hình
										ảnh/Thông tin về các hoạt động triển khai hợp tác trên các
										phương tiện truyền thông: website, báo, đài,…)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
												
												<input type="file" class="form-control"
												name="file_hinhanhthongtinhoatdongtrienkhai"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
								<div class="row mb-3">
									<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">15.file(Các
										minh chứng khác file 1)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
											
												<input type="file" class="form-control"
												name="file_cacminhchungkhac"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>
														<div class="row mb-3">
									<label class="col-sm-4 col-form-label"
										for="basic-icon-default-company">16.file(Các
										minh chứng khác file 2)</label>
									<div class="col-sm-10">
										<div class="input-group input-group-merge">
											<div class="input-group">
											
												<input type="file" class="form-control"
												name="file_cacminhchungkhac_2"
													id="inputGroupFile01"
												
													 />
											</div>
										</div>
									</div>
								</div>


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



	</div>
	<%
		}
	%>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


   <script>
function goBack() {
  window.history.back();
}
</script>
	 <script>
    function validateForm() {
        var select = document.getElementById("input_danhmuc");
        if (select.value == "0") {
            alert("Vui lòng chọn dự án!");
            event.preventDefault(); // ngăn chặn sự kiện submit
            return false;
        }
        return true;
    }
</script>

</body>
</html>