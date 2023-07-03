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


	
		<div class="content-wrapper">
			<div class="container-xxl flex-grow-1 container-p-y">
				<!-- Content -->
				<div class="card">
					<h5 class="card-header">Danh sách dự án đã cập nhật
					
					</h5>
				
                  <form action="<c:url value='/admin_timkiem_duan_dacapnhat_post?action=timkiem_duan_dacapnhat_post'/>"  method="post">
					  <div class="card-body">
                              <div class="row gx-3 gy-2 align-items-center">
                                  <span style="color:#CC0000"><span >*</span>Nhập tên dự án mà bạn muốn tìm! </span>
                    <div class="col-md-4">
                     <input class="form-control me-2" type="search" name="tenDuAn_TiengViet" placeholder="Bạn muốn tìm dự án nào" aria-label="Search" />
                      
                      
                    </div>
                     <div class="col-md-4">
                    <button class="btn btn-outline-primary" type="submit">Tìm</button>
                        <a  style="margin-left:10px;" href='<c:url value="/admin_quanly_lichsucapnhat?action=danhsach_lichsucapnhat&page=1&maxPageItem=40&sapxeptheothuoctinh=ngaycapnhat&sapxeptheochieu=asc"/>' class="btn btn-info">Làm mới dữ liệu</a>
                      </div>    
                    
                  </div>
                 
           
                  </div>
                  </form>
                <form action="<c:url value='/admin_quanly_lichsucapnhat?action=danhsach_lichsucapnhat'/>"
		id="form_submit" method="get">
		
					<div class="table-responsive text-nowrap">
					
						<table class="table table-striped">
							<thead class="table-dark">
								<tr>
								   <th class="text-white">STT</th>
									<th class="text-white">ID</th>
								
									
									<th class="text-white">Tên dự án(TV)</th>
									<th class="text-white">Tên dự án(TA)</th>
									 <th class="text-info">Người cập nhật</th>
									<th class="text-white">Ngày cập nhật</th>
									
									<th class="text-white">Tùy chọn</th>
								</tr>
							</thead>
							<tbody class="table-border-bottom-0">
                               <%
				                      int i=1;
				                    %>
								<c:forEach var="item" items="${lichsucapnhat.danhsach}">
									<tr>
									  <td ><%=i++ %></td>
										<td><i class="fab fa-angular fa-lg text-danger me-3"></i>
											<strong>${item.maLichSuCapNhat} </strong></td>
									
										<td style="white-space: pre-wrap;">${item.duanquocte.tenDuAn_TiengViet}</td>
									   	<td style="white-space: pre-wrap;">${item.duanquocte.tenDuAn_TiengAnh}</td>
										<td>${item.nguoidung.tenNguoiDung}</td>	
										<td>${item.ngayCapNhat}</td>
										
									  
									    
										<td>
											<div class="dropdown">
												<button type="button"
													class="btn p-0 dropdown-toggle hide-arrow"
													data-bs-toggle="dropdown">
													<i class="bx bx-dots-vertical-rounded"></i>
												</button>
												<div class="dropdown-menu">
										
														<a class="dropdown-item"href='<c:url value="/admin_chitiet_duan?maDuAn=${item.maDuAn}&action=chitiet_duan"/>'  ><i class='bx bxs-detail'></i> Xem chi tiết dự án</a
                              >
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>



							</tbody>
							
						</table>
				
		
						<input type="hidden" value="" id="action" name="action" /> <input
							type="hidden" value="" id="page" name="page" /> <input
							type="hidden" value="" id="maxPageItem" name="maxPageItem" /> <input
							type="hidden" value="" id="sapxeptheothuoctinh"
							name="sapxeptheothuoctinh" /> <input type="hidden" value=""
							id="sapxeptheochieu" name="sapxeptheochieu" />
					</div>
             	</form>
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

	<script src="<c:url value='/template/twb/table2excel.js' />"></script>
	<script src="<c:url value='/template/twb/script.js' />"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	  
		<script >
			var totalPages=${lichsucapnhat.totalPage};
			var currentPage=${lichsucapnhat.page};
			var limit=40;
				$(function() {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages : totalPages,
						visiblePages :10,
						startPage:currentPage,
						onPageClick : function(event, page) {
							if(currentPage!=page)
								{
								$('#action').val('danhsach_lichsucapnhat');
								$('#maxPageItem').val(limit);
								$('#page').val(page);
								$('#sapxeptheothuoctinh').val('ngaycapnhat');
								$('#sapxeptheochieu').val('asc');
								$('#form_submit').submit();
								}
							
						}
					});
				});
	</script>
</body>
</html>
