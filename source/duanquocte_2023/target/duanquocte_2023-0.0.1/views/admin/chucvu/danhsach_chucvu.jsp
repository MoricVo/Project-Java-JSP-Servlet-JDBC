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

<form action="<c:url value='/admin_quanly_chucvu?action=danhsach_chucvu'/>" id="form_submit" id="form_submit" method="get">
<div class="content-wrapper">
	 <div class="container-xxl flex-grow-1 container-p-y">
		<!-- Content -->
		<div class="card">
			<h5 class="card-header">Danh sách chức vụ
			  <a href="" data-bs-toggle="modal" data-bs-target="#basicModal2" href="" type="button" class="btn btn-success"><i class='bx bx-add-to-queue'></i> Thêm chức vụ</a>
			</h5>
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
							 <th class="text-white">Mã chức vụ</th>
									    <th class="text-white">Tên chức vụ</th>
									      <th class="text-white">Tùy chọn</th>
									   
						</tr>
					</thead>
				 <tbody class="table-border-bottom-0">
                    		<c:forEach var="item" items="${chucvu.danhsach}" >
                      <tr>
                        <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${item.machucvu}</strong></td>
                      
                                    
										<td>${item.tenchucvu}</td>
									<td>
									<div class="dropdown">
										<button type="button"
											class="btn p-0 dropdown-toggle hide-arrow"
											data-bs-toggle="dropdown">
											<i class="bx bx-dots-vertical-rounded"></i>
										</button>
										<div class="dropdown-menu">
											 <!-- <a
												class="dropdown-item" href="javascript:void(0);"><i
												class="bx bx-trash me-1"></i> Delete</a> -->
												 <a
														class="dropdown-item"
														
														   href='<c:url value="/admin_xoa_chucvu?machucvu=${item.machucvu}&action=xoa_chucvu"/>'
														onclick="return confirm('Bạn có chắc chắn muốn xóa không ?');"><i
												class="bx bx-trash me-1"></i>Xóa </a>
										</div>
									</div>
								</td>	
                       
                      </tr>
                      </c:forEach>
      
                    </tbody>
				</table>
		
				<ul class="pagination-sm" id="pagination">

								</ul>
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

<form
			action="<c:url value='/admin_them_chucvu?action=them_chucvu'/>"
			id="form_submit" method="post">
			<div class="modal fade" id="basicModal2" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel1">Thêm chức vụ</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col mb-3">
									<label for="nameBasic" class="form-label">Tên chức vụ</label>
									<input type="text" id="nameBasic" class="form-control"
										name="tenChucVu"
										placeholder="Vui lòng nhập tên chức vụ" />
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
 <script src="<c:url value='/template/twb/table2excel.js' />"></script>
 <script src="<c:url value='/template/twb/script.js' />"></script>
   <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script >
	/* var totalPages=${nguoidung.totalPage};
	var currentPage=${nguoidung.page}; */
			var totalPages=${chucvu.totalPage};
			var currentPage=${chucvu.page};
			var limit=20;
				$(function() {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages : totalPages,
						visiblePages :10,
						startPage:currentPage,
						onPageClick : function(event, page) {
							if(currentPage!=page)
								{
								
								$('#maxPageItem').val(limit);
								$('#page').val(page);
								$('#sapxeptheothuoctinh').val('tenchucvu');
								$('#sapxeptheochieu').val('desc');
								$('#form_submit').submit();
								
								}
							
						}
					});
				});
	</script>
</body>
</html>