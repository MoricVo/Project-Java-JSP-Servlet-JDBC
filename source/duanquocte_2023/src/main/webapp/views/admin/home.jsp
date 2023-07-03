
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="container-xxl flex-grow-1 container-p-y">
	<div class="row">
		<c:if test="${not empty USERMODEL }">
			<div class="col-lg-12 mb-4 order-0">
				<div class="card">
					<div class="d-flex align-items-end row">
						<div class="col-sm-7">
							<div class="card-body">
								<h5 class="card-title text-primary">Xin chào
									${USERMODEL.tenNguoiDung}! 🎉</h5>
								<p class="mb-4">Chúc bạn có một ngày tốt lành!</p>


							</div>
						</div>
						<div class="col-sm-5 text-center text-sm-left">
							<div class="card-body pb-0 px-0 px-md-4">
								<img
									src='<c:url value="/template/ad_template_new/assets/img/illustrations/man-with-laptop-light.png" />'
									height="140" alt="View Badge User"
									data-app-dark-img="illustrations/man-with-laptop-dark.png"
									data-app-light-img="illustrations/man-with-laptop-light.png" />
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</c:if>
		
		<div class="col-lg-12 col-md-4 order-1">
			<div class="col-md-6 col-lg-12 order-2 mb-4">
				<div class="card mb-4">
					<h5 class="card-header">Thống kê dự án của từng đơn vị</h5>
					<div class="card-body">
						<div class="demo-vertical-spacing demo-only-element">
							<c:set var="max" value="${duan[0].soluong}" />

							<c:forEach var="item" items="${duan}">
								<c:if test="${item.soluong > max}">
									<c:set var="max" value="${item.soluong}" />
								</c:if>
							</c:forEach>

							<c:forEach var="item" items="${duan}">
								<c:set var="percent" value="${(item.soluong / max) * 100}" />

								<div class="text-light small fw-semibold mb-1">${item.donvitructhuoc.tenDonViTrucThuoc}</div>
								<div class="progress">
									<c:if test="${item.soluong == max}">
										<div class="progress-bar progress-bar-striped "
											role="progressbar" style="width: 100%" aria-valuenow="100"
											aria-valuemin="0" aria-valuemax="100"></div>
									</c:if>
									<c:if test="${item.soluong != max}">
										<div class="progress-bar progress-bar-striped"
											role="progressbar" style="width: ${percent}%"
											aria-valuenow="${percent}" aria-valuemin="0"
											aria-valuemax="100"></div>
									</c:if>
								</div>
								<!-- rest of your code here -->
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			
			<c:if test="${USERMODEL.quyenHan eq 'admin'}">
				<h5 class="pb-1 mb-4">Thống kê số lượng dự án của từng đơn vị!</h5>
				<div class="row">
					<%
						int i = 1;
					%>

					<c:forEach var="item" items="${duan}">
						<div class="col-md-6 col-xl-6">
							<div
								class="card shadow-none bg-transparent border border-primary mb-3">
								<div class="card-body">
									<h5 class="card-title"><%=i++%>.${item.donvitructhuoc.tenDonViTrucThuoc}
									</h5>
									<h1 style="font-size: 50px;" class="card-text">${item.soluong}
										<i style="font-size: 50px;"
											class='menu-icon bx bxs-book-bookmark text-info'></i>
										<button style="float: right;" type="button"
											class="btn btn-warning text-nowrap" data-bs-toggle="popover"
											data-bs-offset="0,14" data-bs-placement="right"
											data-bs-html="true"
											data-bs-content="<p>Tổng số dự án còn hoạt động:${item.soluongduanconhoatdong}</p> 
                        <p>Tổng số dự án đã kết thúc:${item.soluongduanketthuc}</p>
                        <div class='d-flex justify-content-between'></div>"
											title="Thông tin chi tiết!">Xem chi tiết</button>

									</h1>
								</div>
							</div>
						</div>


					</c:forEach>


				</div>
			</c:if>
		</div>



		<!-- Total Revenue -->

		<!--/ Total Revenue -->

	</div>
	<div class="row">


		<c:if test="${USERMODEL.quyenHan eq 'user'}">
			<div class="col-md-6 col-lg-8 order-2 mb-4">
				<div class="card h-100">
					<div
						class="card-header d-flex align-items-center justify-content-between">
						<h5 class="card-title m-0 me-2">Top những dự án có tổng vốn
							đầu tư lớn</h5>
						
					</div>
					<div class="card-body">
						<ul class="p-0 m-0">
							<c:forEach var="item" items="${duan2}">
								<li class="d-flex mb-4 pb-1">
									<div class="avatar flex-shrink-0 me-3">

										<img
											src='<c:url value="/template/ad_template_new/assets/img/icons/unicons/cc-success.png" />'
											alt="User" class="rounded" />
									</div>
									<div
										class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
										<div class="me-2">

											<small class="text-muted d-block mb-1">
												${item.nhataitro.tenNhaTaiTro}</small>
											<h6 id="myText" class="mb-0">${item.tenDuAn_TiengViet}</h6>
										</div>
										<div class="user-progress d-flex align-items-center gap-1">
											<h6 class="post_tongvon_thuchien" id="input_tongvonthuchien" data-value="${item.tongVonThucHien}" data-unit="${item.donViTienTe_TongVonThucHien}" data-row-id="input_tongvonthuchien_i" >${item.tongVonThucHien} ${item.donViTienTe_TongVonThucHien}</h6>
											
										</div>
									</div>
								</li>
							</c:forEach>

						</ul>
					</div>
				</div>
			</div>

		</c:if>
		<c:if test="${USERMODEL.quyenHan eq 'admin'}">
			<div class="col-md-6 col-lg-10 order-2 mb-4">
				<div class="card h-100">
					<div
						class="card-header d-flex align-items-center justify-content-between">
						<h5 class="card-title m-0 me-2">Top những dự án có tổng vốn
							đầu tư lớn</h5>
						
					</div>
					<div class="card-body">
						<ul class="p-0 m-0">
							<c:forEach var="item" items="${duan3}">
								<li class="d-flex mb-4 pb-1">
									<div class="avatar flex-shrink-0 me-3">

										<img
											src='<c:url value="/template/ad_template_new/assets/img/icons/unicons/cc-success.png" />'
											alt="User" class="rounded" />
									</div>
									<div
										class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
										<div class="me-2">

											<small class="text-muted d-block mb-1">
												${item.donvitructhuoc.tenDonViTrucThuoc}</small>
											<h6 id="myText" class="mb-0">${item.tenDuAn_TiengViet}</h6>
										</div>
										<div class="user-progress d-flex align-items-center gap-1">
											<h6 class="post_tongvon_thuchien" id="input_tongvonthuchien" data-value="${item.tongVonThucHien}" data-unit="${item.donViTienTe_TongVonThucHien}" data-row-id="input_tongvonthuchien_i" >${item.tongVonThucHien} ${item.donViTienTe_TongVonThucHien}</h6>
											
										</div>
									</div>
								</li>
							</c:forEach>

						</ul>
					</div>
				</div>
			</div>

		</c:if>
	</div>


</div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
window.onload = function() {
	  var inputElements = document.querySelectorAll('.post_tongvon_thuchien');

	  for (var i = 0; i < inputElements.length; i++) {
	    var input = inputElements[i];
	    var valueFromData = parseFloat(input.getAttribute("data-value"));
	    var unitFromData = input.getAttribute("data-unit");

	    var formattedValue = valueFromData.toLocaleString() + " " + unitFromData;

	    input.innerHTML = formattedValue;
	  }
	};
</script>
<script>
	$(document).ready(function() {
		$("h6#myText").each(function() {
			var text = $(this).text();
			if (text.length > 30) {
				$(this).text(text.substr(0, 60) + "...");
			}
		});
	});
</script>
<script>
	function getRandomColor() {
		const bootstrapColors = [ 'bg-primary', 'bg-secondary', 'bg-success',
				'bg-danger', 'bg-warning', 'bg-info', 'bg-dark' ];
		return bootstrapColors[Math.floor(Math.random()
				* bootstrapColors.length)];
	}

	document.addEventListener('DOMContentLoaded', function() {
		const progressBars = document.querySelectorAll('.progress-bar');
		progressBars.forEach(function(progressBar) {
			progressBar.classList.add(getRandomColor());
		});
	});
</script>
