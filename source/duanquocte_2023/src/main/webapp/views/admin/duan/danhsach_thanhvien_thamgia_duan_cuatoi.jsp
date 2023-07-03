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


	<form action="<c:url value='/admin_quanly_thanhvien_cuatoi?action=danhsach_thanhvien_cuatoi'/>"
		id="form_submit" method="get">
		<div class="content-wrapper">
			<div class="container-xxl flex-grow-1 container-p-y">
				<!-- Content -->
				<div class="card">
					<h5 class="card-header">Danh sách thành viên đang tham gia các dự án của bạn
					
					
					</h5>
					<div class="table-responsive text-nowrap">
						<table class="table table-striped">
							<thead class="table-dark">
								<tr>
								    <th class="text-white">STT</th>
									<th class="text-white">ID</th>
									<th class="text-white">Tên dự án</th>
									<th class="text-white">Thành viên</th>
									<th class="text-white">Ngày tham gia</th>
									
									<th class="text-white">Ghi chú</th>
									<th class="text-white">Tùy chọn</th>
								</tr>
							</thead>
							<tbody class="table-border-bottom-0">
	                              <%
				                      int i=1;
				                    %>
								<c:forEach var="item" items="${thamgiaduan.danhsach}">
									<tr>
									   <td ><%=i++ %></td>
										<td><i class="fab fa-angular fa-lg text-danger me-3"></i>
											<strong>${item.maThamGia} </strong></td>
										<td style="white-space: pre-wrap;">${item.duan.tenDuAn_TiengViet}</td>
										 
										<td >
										  	   <img src="${pageContext.request.contextPath}/avatar_user/${item.nguoidung.anhDaiDien}" style="width: 30px; height: 30px;" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/image_not/imge_not.png';" alt="Avatar" class="rounded-circle" />
											   ${item.nguoidung.tenNguoiDung}
					                            
					                      
										
												</td>
										<td>${item.ngayThamGia}</td>
									
									    <td>${item.ghiChu}</td>
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
														
														   href='<c:url value="/admin_xoa_thanhvien?maThamGia=${item.maThamGia}&action=xoa_thanhvien"/>'
														onclick="return confirm('Bạn có muốn xóa người dùng này không?');"><i
														class="bx bx-trash me-1"></i>Xóa thành viên</a>
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>



							</tbody>
						</table>

						 
						<input type="hidden" value="" id="action" name="action" />
						 <input
							type="hidden" value="" id="page" name="page" /> <input
							type="hidden" value="" id="maxPageItem" name="maxPageItem" /> <input
							type="hidden" value="" id="sapxeptheothuoctinh"
							name="sapxeptheothuoctinh" /> <input type="hidden" value=""
							id="sapxeptheochieu" name="sapxeptheochieu" />
					</div>

				</div>
				 <div class="demo-inline-spacing">
                        <!-- Basic Pagination -->
                        <nav aria-label="Page navigation">
                          <ul class="pagination"  id="pagination">
                	

								</ul>
								</nav>
								</div>
				<div class="container-xxl flex-grow-1 container-p-y"></div>
			</div>
		</div>
	</form>
	<script src="<c:url value='/template/twb/table2excel.js' />"></script>
	<script src="<c:url value='/template/twb/script.js' />"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script >
			var totalPages=${thamgiaduan.totalPage};
			var currentPage=${thamgiaduan.page};
			var limit=40;
				$(function() {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages : totalPages,
						visiblePages :10,
						startPage:currentPage,
						onPageClick : function(event, page) {
							if(currentPage!=page)
								{
								$('#action').val('danhsach_thanhvien_cuatoi');
								$('#maxPageItem').val(limit);
								$('#page').val(page);
								$('#sapxeptheothuoctinh').val('maduan');
								$('#sapxeptheochieu').val('desc');
								$('#form_submit').submit();
								}
							
						}
					});
				});
	</script>
	<script type="text/javascript">
	function confirmDelete() {
		  var result = confirm("Bạn có chắc chắn muốn xóa bài viết này?");
		  if (result) {
		    // Xóa bài viết
		  } else {
		    // Không xóa bài viết
		  }
		}
	
	</script>
</body>
</html>
<%-- <div class="main-content">
<form action="<c:url value='/admin_quanly_coquanpheduyet'/>" id="form_submit" method="get">
	<div class="content-wrapper">
		<div class="page-header">
			<h3 class="page-title">Danh sách người dùng</h3>
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Danh sách</a></li>
					<li class="breadcrumb-item active" aria-current="page">Thêm người dùng</li>
				</ol>
			</nav>
		</div>
		<div class="row">
			<div class="col-lg-12 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Bảng 1 	<button style="float:right" onclick="tableToExcel()" class="btn btn-primary ">Xuất file Excel</button></h4>
						<p class="card-description">
							Dữ liệu được cập nhật từ ngày
							<code>2/2/2023</code>
						</p>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>Mã cơ quan phê duyệt</th>
									    <th>Tên cơ quan phê duyệt</th>
										<th>Ngày tạo</th>
										<th>Ngày cập nhật</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="item" items="${coquanpheduyet.danhsach}" >
								<tr>
										
										<td>${item.maCoQuanPheDuyet}</td>
										<td>${item.tenCoQuanPheDuyet}</td>
										<td>${item.ngayTao}</td>
										<td>${item.ngayCapNhat}</td>
										
									</tr>
								</c:forEach>
								
								</tbody>
							</table>
							<nav aria-label="Page navigation">
								<ul class="pagination-sm" id="pagination">

								</ul>
							</nav>
						
							<input type="hidden" value="" id="page" name="page"/>
							<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
							<input type="hidden" value="" id="sapxeptheothuoctinh" name="sapxeptheothuoctinh"/>
							<input type="hidden" value="" id="sapxeptheochieu" name="sapxeptheochieu"/>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</form>
</div> --%>