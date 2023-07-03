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
	%>
	<!-- Content wrapper -->
	<div class="content-wrapper">
		<!-- Content -->

		<div class="container-xxl flex-grow-1 container-p-y">
			<h4 class="fw-bold py-3 mb-4">
				<span class="text-muted fw-light">Thêm/</span> Thêm thành viên tham
				gia
			</h4>
          
			<!-- Basic Layout -->
			<div class="row">
				<div class="col-xl">
					<div class="card mb-4">
						<div
							class="card-header d-flex justify-content-between align-items-center">
							<h5 class="mb-0">Thêm thành viên tham gia dự án</h5>
							<small class="text-muted float-end">Default label</small>
						</div>
								 <div class="card-body">
                <button onclick="goBack()" type="button" class="btn btn-primary">
                  <i class="bx bx-chevron-left scaleX-n1-rtl bx-sm"></i>
                  Quay lại trang trước
                </button>
              </div>
						<div class="card-body">
							<c:set var="c" value="${requestScope.duan}" />
							<form
								action="<c:url value='/admin_quanly_thamgiaduan?action=them_thanhvien'/>"
								id="form_submit" method="post">
								<input type="hidden" value="${c.maDuAn}" id="maDuAn"
									name="maDuAn" />

								<div class="mb-3">
									<label class="form-label" for="basic-default-company">Ghi
										chú</label> <input type="text" class="form-control" name=ghiChu
										id="basic-default-company" placeholder="Nhập ghi chú" />
								</div>
								
								
								<div class="mb-3">
									<div class="col-md">
										<small class="text-light fw-semibold">Chọn thành viên tham gia dự án của bạn</small> <input
										  class="form-control"
											type="text" list="nguoidungs" id="selectedNguoiDung"
											oninput="addNguoiDung()"  />
										<datalist id="nguoidungs" >
											<c:forEach var="item" items="${nguoidungs_2}">
												<option value="${item.maNguoiDung}">${item.tenNguoiDung}. ${item.gmail}<img src="${pageContext.request.contextPath}/avatar_user/${item.anhDaiDien}"  onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/image_not/imge_not.png';" alt class="w-px-40 h-auto rounded-circle" /></option>
											</c:forEach>
										</datalist>
									
									</div>

									
								</div>
								<div class="card mb-4">
									<h5 class="card-header">Các thành viên được chọn</h5>
									<div class="row g-0" style=" display: inline-block;">
										<div class="col-md-6 p-4">
											<div class="text-light small fw-semibold mb-3">Bao gồm:</div>
												<input type="hidden" id="maNguoiDung" name="maNguoiDung"
											value="" />
											<div id="toast-container" ></div>
										</div>
									</div>
								</div>



								<button type="submit" class="btn btn-primary">Thêm thành viên</button>
							</form>
						</div>
					</div>
				</div>


			</div>
		</div>
		<!-- / Content -->


		<!-- / Footer -->

		<div class="content-backdrop fade"></div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
	function addNguoiDung() {
		  var input = document.getElementById("selectedNguoiDung");
		  var selectedValue = input.value;
		  var datalist = document.getElementById("nguoidungs");
		  var option = datalist.querySelector('option[value="' + selectedValue + '"]');

		  if (option) {
		    var tennguoidung = option.textContent;
		    var manguoidung = option.value; // lấy giá trị value của option (mã người dùng)
		    var anhdaidien = option.querySelector('img').src; // lấy đường dẫn ảnh đại diện

		    // Thêm dữ liệu người dùng vào input hidden
		    var hiddenInput = document.getElementById("maNguoiDung");
		    var currentValue = hiddenInput.value;
		    if (currentValue) {
		      hiddenInput.value = currentValue + "," + manguoidung;
		    } else {
		      hiddenInput.value = manguoidung;
		    }

		    // Hiển thị toast
		    var toast = $('<div class="bs-toast toast show bg-primary" role="alert" aria-live="assertive" aria-atomic="true">\
		                  <div class="toast-header">\
		                  <img src="' + anhdaidien + '" alt="" class="rounded-circle me-2" style="width: 30px; height: 30px;">\
		                    <i class="bx bx-bell me-2"></i>\
		                    <div class="me-auto fw-semibold" name="maNguoiDung" value="' + manguoidung + '">'
		                    + tennguoidung
		                    + '</div>\
		                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close" onclick="removeNguoiDung(' + manguoidung + ')"></button>\
		                  </div>\
		                </div>');
		    $('#toast-container').append(toast);

		    input.value = '';
		  }
		}

		function removeNguoiDung(manguoidung) {
		  // Xóa người dùng khỏi input hidden
		  var hiddenInput = document.getElementById("maNguoiDung");
		  var currentValue = hiddenInput.value;
		  var newValue = "";
		  if (currentValue) {
		    var values = currentValue.split(",");
		    for (var i = 0; i < values.length; i++) {
		      if (values[i] != manguoidung) {
		        if (newValue) {
		          newValue += ",";
		        }
		        newValue += values[i];
		      }
		    }
		  }
		  hiddenInput.value = newValue;

		  // Xóa toast
		  var toast = $('[name="' + manguoidung + '"]').closest(".bs-toast");
		  toast.remove();
		}
	</script>
   <script>
function goBack() {
  window.history.back();
}
</script>


</body>
</html>