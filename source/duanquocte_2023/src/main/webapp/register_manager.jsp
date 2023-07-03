<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%
		String baoLoi = request.getAttribute("baoLoi") + "";
		baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;

		String gmail = request.getAttribute("gmail") + "";
		gmail = (gmail.equals("null")) ? "" : gmail;
	%>
<form
			action="<c:url value='/dang-ky_them_donvitructhuoc?action=them_donvitructhuoc_trangquantri'/>"
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
	<div class="card">
		<div class="card-body">
			
			<!-- Logo -->
		   <a href='<c:url value="/dang-ky-taikhoan-quantri?action=dangky_taikhoan_quantri'"/>'>
			 <span style="font-size: 25px;"
					class="app-brand-text  text-info fw-bolder">Đăng ký tài
						khoản quản trị!</span>
						</a>
			<!-- /Logo -->
			  <c:if test="${not empty  dangerMessage_trungtaikhoan}">
					<div style="height:50px;"  class="alert alert-danger alert-dismissible" role="alert">
						${ dangerMessage_trungtaikhoan}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if>
				 
		
			<div style="color: red;" class="red" id="baoLoi">
				<%=baoLoi%>
				<form id="formAuthentication" class="mb-3"
					action="<c:url value='/dang-ky-taikhoan-quantri?action=dangky_taikhoan_quantri_post'/>" method="post">
					<input type="hidden" value="0" name="trangThai">
							<div class="mb-3">
						<label class="col-sm-10 col-form-label"
							for="basic-icon-default-company">Bạn đăng ký tài khoản với vai trò là ?<span
							style="color: red">*</span></label>
						<div class="col-sm-12">
							<div class="input-group input-group-merge">
								<select name="quyenHan" id="input_quyenhan"
									class="form-select" required>
									<option value="user" >Chọn vai trò</option>
									<option value="manager">Quản lý đơn vị</option>
									<option value="admin" >Quản trị hệ thống</option>
									 
								</select> 
							</div>
						</div>
					</div>
					<div class="mb-3">
						<label class="col-sm-10 col-form-label"
							for="basic-icon-default-company">Anh chị đến từ đơn vị nào?<span
							style="color: red">*</span></label>
						<div class="col-sm-12">
							<div class="input-group input-group-merge">
								<select name="maDonViTrucThuoc" id="input_donvitructhuoc"
									class="form-select" required>
									<option value="0" selected>Chọn đơn vị</option>
									<c:forEach var="item" items="${donvitructhuocs}">

										<option value="${item.maDonViTrucThuoc}">${item.tenDonViTrucThuoc}</option>
									</c:forEach>
								</select> 
								
								 <button
								 	data-bs-toggle="modal" data-bs-target="#basicModal3"
								  type="button" class="btn btn-icon btn-outline-secondary">
                             <i class='bx bx-plus-circle'></i>
                            </button>
							</div>
						</div>
					</div>
						<div class="mb-3">
						<label class="col-sm-10 col-form-label"
							for="basic-icon-default-company">Chức vụ của anh chị?<span
							style="color: red">*</span></label>
						<div class="col-sm-12">
							<div class="input-group input-group-merge">
								<select name="maChucVu" id="input_donvitructhuoc"
									class="form-select" required>
									<option value="0" selected>Chọn chức vụ</option>
									<c:forEach var="item" items="${chucvus}">

										<option value="${item.machucvu}">${item.tenchucvu}</option>
									</c:forEach>
								</select> 
							</div>
						</div>
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">Họ(VD:Võ,Trần,Lê)<span
							style="color: red">*</span></label> <input type="text"
							class="form-control" id="hoNguoiDung" name="hoNguoiDung" required
							placeholder="Nhập họ của bạn" autofocus />
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">Tên(VD:Tấn
							Khôi,Trung Tín)<span style="color: red">*</span>
						</label> <input type="text" class="form-control" id="tenNguoiDung"
							name="tenNguoiDung" required placeholder="Nhập tên của bạn"
							autofocus />
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email<span
							style="color: red">*</span></label> <input type="email"
							class="form-control" id="gmail" name="gmail" value="<%=gmail%>"
							required placeholder="Vui lòng nhập email" />
					</div>
					<div class="mb-3 form-password-toggle">
						<label class="form-label" for="password">Mật khẩu<span
							style="color: red">*</span><span style="color: red" id="msg1"></span></label>
						<div class="input-group input-group-merge">
							<input type="password" id="matKhau" name="matKhau"
								onkeyup="kiemTraMatKhau()" required class="form-control"
								placeholder="&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;"
								aria-describedby="password" /> <span
								class="input-group-text cursor-pointer"><i
								class="bx bx-hide"></i></span>
						</div>
					</div>
					<div class="mb-3 form-password-toggle">
						<label class="form-label" for="password">Nhập lại mật khẩu<span
							style="color: red">*</span><span style="color: red" id="msg"></span></label>
						<div class="input-group input-group-merge">
							<input type="password" id="matKhauNhapLai" name="matKhauNhapLai"
								onkeyup="kiemTraMatKhau()" required class="form-control"
								placeholder="&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;"
								aria-describedby="password" /> <span
								class="input-group-text cursor-pointer"><i
								class="bx bx-hide"></i></span>
						</div>
					</div>
					<div class="mb-3">
						<div class="form-check">
							<input class="form-check-input" type="checkbox"
								id="dongYDieuKhoan" name="dongYDieuKhoan" required="required"
								onchange="xuLyChonDongY()" /> <label style="color: black"
								class="form-check-label" for="terms-conditions"> Nhấn vào đây để tiếp tục! 
							</label>
						</div>
					</div>
					<button type="submit" class="btn btn-primary d-grid w-100"
						name="submit" id="submit" style="visibility: hidden;">Đăng
						ký</button>
				</form>

				<p class="text-center">
					<span>Bạn đã có tài khoản?</span> <a  href='<c:url value="/dang-nhap?action=login"/>'>
						<span>Đăng nhập</span>
					</a>
				</p>
			</div>
			
		</div>
		
	</div>


	<script type="text/javascript">
		function kiemTraMatKhau() {
			matKhau = document.getElementById("matKhau").value;
			matKhauNhapLai = document.getElementById("matKhauNhapLai").value;
			if (matKhau != matKhauNhapLai) {
				document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
				return false;
			} else {
				document.getElementById("msg").innerHTML = "<span style='color:#66FF66;'>Mật khẩu phù hợp</span>";
				return true;
			}
		}

		function xuLyChonDongY() {
			dongYDeuKhoan = document.getElementById("dongYDieuKhoan");
			if (dongYDeuKhoan.checked == true) {
				document.getElementById("submit").style.visibility = "visible";
			} else {
				document.getElementById("submit").style.visibility = "hidden";
			}
		}
	</script>
	<script type="text/javascript">
	var passwordInput = document.getElementById("matKhau");
	

	passwordInput.addEventListener("input", function(event) {
	    var password = event.target.value;
	    var passwordRegex = /^(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/;
	    
	    if (passwordRegex.test(password)) {
	    	document.getElementById("msg1").innerHTML = "<span style='color:#66FF66;'>Mật khẩu hợp lệ</span>";
	    	return true;
	    } else {
	    	document.getElementById("msg1").innerHTML = "Mật khẩu phải bao gồm chữ in hoa và số !";
	    	return false;
	    }
	});
	
	</script>
</body>
</html>





