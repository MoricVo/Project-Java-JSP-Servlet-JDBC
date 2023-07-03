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
	<form action="<c:url value='/admin_send_gmail?action=send_gmail'/>" id="form_submit"
		method="post" enctype="multipart/form-data">
		<!-- Content wrapper -->
		<div class="content-wrapper">
			<!-- Content -->

			<div class="container-xxl flex-grow-1 container-p-y">
				<%-- <c:if test="${not empty successMessage}">
					<div class="alert alert-success alert-dismissible" role="alert">
						${successMessage}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if> --%>
				<h4 class="fw-bold py-3 mb-4">
					<span class="text-muted fw-light">Quản trị viên/</span> Gửi email
				</h4>

				<!-- Basic Layout -->
				<div class="row">
					<div class="col-xl">
						<div class="card mb-4">
							<div
								class="card-header d-flex justify-content-between align-items-center">
								<h5 class="mb-0">Thông tin</h5>

							</div>

							<div class="card-body">

								<div class="mb-3">
									<div class="col-md">
										<small class="text-light fw-semibold">Chọn người dùng cần gửi</small> <input
										  class="form-control"
											type="text" list="nguoidungs" id="selectedNguoiDung"
											oninput="addNguoiDung()" />
											 <c:if test="${USERMODEL.quyenHan eq 'admin'}">
										<datalist id="nguoidungs">
											<c:forEach var="item" items="${nguoidungs}">
											
													<option value="${item.gmail}">Quản trị:${item.donvitructhuoc.tenDonViTrucThuoc} || ${item.tenNguoiDung}||${item.gmail}<img src="${pageContext.request.contextPath}/avatar_user/${item.anhDaiDien}"  onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/image_not/imge_not.png';" alt class="w-px-40 h-auto rounded-circle" /></option>
											</c:forEach>
										</datalist>
									</c:if>
									 <c:if test="${USERMODEL.quyenHan eq 'manager'}">
										<datalist id="nguoidungs">
											<c:forEach var="item" items="${nguoidungs_2}">
											
													<option value="${item.gmail}">Thuộc khoa:${item.donvitructhuoc.tenDonViTrucThuoc} || ${item.tenNguoiDung}||${item.gmail}<img src="${pageContext.request.contextPath}/avatar_user/${item.anhDaiDien}"  onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/image_not/imge_not.png';" alt class="w-px-40 h-auto rounded-circle" /></option>
											</c:forEach>
										</datalist>
									</c:if>
									</div>

									
								</div>
								<div class="card mb-4">
									<h5 class="card-header">Các thành viên được chọn</h5>
									<div class="row g-0" style=" display: inline-block;">
										<div class="col-md-6 p-4">
											<div class="text-light small fw-semibold mb-3">Bao gồm:</div>
												<input type="hidden" id="gmail" name="gmail"
											value="" />
											<div id="toast-container" ></div>
										</div>
									</div>
								</div>
								<div class="mb-3">
									<label class="form-label" for="basic-default-fullname">Tiêu
										đề:</label> <input type="text" name="subject" class="form-control"
										id="basic-default-fullname" placeholder="Tiêu đề?" />
								</div>

								<div class="mb-3">
									<label class="form-label" for="basic-default-message">Nội
										dung</label>
									<textarea name="content" id="basic-default-message"
										class="form-control" placeholder="Bạn muốn nhắn nhủ điều gì?"></textarea>
								</div>
							
								<div class="mb-3">

									<label class="col-sm-2 col-form-label"
										for="basic-icon-default-company">Đính kèm file </label>
									<div class="col-sm-12">
										<div class="input-group input-group-merge">
											<div class="input-group">
												<label class="input-group-text" for="inputGroupFile01">Upload</label>
												<input type="file" class="form-control" name="attachment"
													id="inputGroupFile01" />
											</div>
										</div>
									</div>

								</div>
								<button type="submit" class="btn btn-primary">Gửi</button>

							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- / Content -->

			<!-- Footer -->

			<!-- / Footer -->

			<div class="content-backdrop fade"></div>
		</div>
	</form>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function addNguoiDung() {
	  var input = document.getElementById("selectedNguoiDung");
	  var selectedValue = input.value;
	  var datalist = document.getElementById("nguoidungs");
	  var option = datalist.querySelector('option[value="' + selectedValue + '"]');

	  if (option) {
	    var tennguoidung = option.textContent;
	    var gmail = option.value; // lấy giá trị value của option (mã người dùng)
	    var anhdaidien = option.querySelector('img').src; // lấy đường dẫn ảnh đại diện

	    // Thêm dữ liệu người dùng vào input hidden
	    var hiddenInput = document.getElementById("gmail");
	    var currentValue = hiddenInput.value;
	    if (currentValue) {
	      hiddenInput.value = currentValue + "," + gmail;
	    } else {
	      hiddenInput.value = gmail;
	    }

	    // Hiển thị toast
	    var toast = $('<div class="bs-toast toast show bg-primary" role="alert" aria-live="assertive" aria-atomic="true">\
	                  <div class="toast-header">\
	                  <img src="' + anhdaidien + '" alt="" class="rounded-circle me-2" style="width: 30px; height: 30px;">\
	                    <i class="bx bx-bell me-2"></i>\
	                    <div class="me-auto fw-semibold" name="gmail" value="' + gmail + '">'
	                    + tennguoidung
	                    + '</div>\
	                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close" onclick="removeNguoiDung(' + gmail + ')"></button>\
	                  </div>\
	                </div>');
	    $('#toast-container').append(toast);

	    input.value = '';
	  }
	}

	function removeNguoiDung(gmail) {
	  // Xóa người dùng khỏi input hidden
	  var hiddenInput = document.getElementById("gmail");
	  var currentValue = hiddenInput.value;
	  var newValue = "";
	  if (currentValue) {
	    var values = currentValue.split(",");
	    for (var i = 0; i < values.length; i++) {
	      if (values[i] != gmail) {
	        if (newValue) {
	          newValue += ",";
	        }
	        newValue += values[i];
	      }
	    }
	  }
	  hiddenInput.value = newValue;

	  // Xóa toast
	  var toast = $('[name="' + gmail + '"]').closest(".bs-toast");
	  toast.remove();
	}
</script>
</body>

</html>