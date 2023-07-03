<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="<c:url value='/admin_quanly_donvitructhuoc?action=danhsach_donvitructhuoc'/>" id="form_submit" method="get">
	<div class="content-wrapper">
	 <div class="container-xxl flex-grow-1 container-p-y">
		<!-- Content -->
		<div class="card">
			<h5 class="card-header">Danh sách đơn vị trực thuộc</h5>
			<div class="card-header">
			<c:if test="${not empty successMessage_xoathanhcong}">
					<div style="height:50px;"  class="alert alert-success alert-dismissible" role="alert">
						${successMessage_xoathanhcong}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
				</c:if></div>
			<div class="table-responsive text-nowrap">
				<table class="table table-striped">
					<thead class="table-dark">
						<tr>
							<th class="text-white">Mã đơn vị trực thuộc</th>
							<th class="text-white">Tên đơn vị trực thuộc </th>
							<th class="text-white">Ngày tạo</th>
							
							<th>Tùy chọn</th>
						</tr>
					</thead>
					<tbody class="table-border-bottom-0">
					
						<c:forEach var="item" items="${donvitructhuoc.danhsach}">
							<tr>
								<td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${item.maDonViTrucThuoc}
										</strong></td>
								<td>${item.tenDonViTrucThuoc}</td>
								<td>${item.ngayTao}</td>
								

								<td>
									<div class="dropdown">
										<button type="button"
											class="btn p-0 dropdown-toggle hide-arrow"
											data-bs-toggle="dropdown">
											<i class="bx bx-dots-vertical-rounded"></i>
										</button>
										<div class="dropdown-menu">
											 <a
														class="dropdown-item"
														
														   href='<c:url value="/admin_xoa_donvitructhuoc?maDonViTrucThuoc=${item.maDonViTrucThuoc}&action=xoa_donvitructhuoc"/>'
														onclick="return confirm('Cảnh báo!khi xóa dữ liệu này,dữ liệu về đơn vị trực thuộc bạn vừa xóa sẽ mất trên hồ sơ dự án!Bạn muốn tiếp tục ?');"><i
												class="bx bx-trash me-1"></i>Xóa</a>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
                       


					</tbody>
				</table>
		
				<nav aria-label="Page navigation">
								<ul class="pagination-sm" id="pagination">

								</ul>
							</nav>
						    <input type="hidden" value="" id="action" name="action"/>
							<input type="hidden" value="" id="page" name="page"/>
							<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
							<input type="hidden" value="" id="sapxeptheothuoctinh" name="sapxeptheothuoctinh"/>
							<input type="hidden" value="" id="sapxeptheochieu" name="sapxeptheochieu"/>
			</div>

		</div>
		<div class="container-xxl flex-grow-1 container-p-y"></div>
	</div>
	</div>
</form>
	<script src="<c:url value='/template/twb/table2excel.js' />"></script>
	<script src="<c:url value='/template/twb/script.js' />"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script >
	/* var totalPages=${nguoidung.totalPage};
	var currentPage=${nguoidung.page}; */
			var totalPages=${donvitructhuoc.totalPage};
			var currentPage=${donvitructhuoc.page};
			var limit=20;
				$(function() {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages : totalPages,
						visiblePages :10,
						startPage:currentPage,
						onPageClick : function(event, page) {
							if(currentPage!=page)
								{
								$('#action').val('danhsach_donvitructhuoc');
								$('#maxPageItem').val(limit);
								$('#page').val(page);
								$('#sapxeptheothuoctinh').val('madonvitructhuoc');
								$('#sapxeptheochieu').val('asc');
								$('#form_submit').submit();
								
								}
							
						}
					});
				});
	</script>
</body>
</html>
