	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Danh sách dự án</title>
</head>
<body>

       <!-- Bootstrap Table with Header - Dark -->
       <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <div class="card">
                <h5 class="card-header">Danh sách người dùng
              
                </h5>
                    <form action="<c:url value='/admin_timkiem_nguoidung_post?action=timkiem_nguoidung_post'/>"  method="post">
					  <div class="card-body">
                              <div class="row gx-3 gy-2 align-items-center">
                                  <span style="color:#CC0000"><span >*</span>Nhập <span>tên</span> hoặc <span>gmail</span> hoặc <span>chức vụ</span> mà bạn muốn tìm! </span>
                    <div class="col-md-4">
                     <input class="form-control me-2" type="search" name="key" placeholder="Hãy nhập từ khóa mong muốn" aria-label="Search" />
                      
                      
                    </div>
                     <div class="col-md-5">
                    <button class="btn btn-outline-info" type="submit">Tìm</button>
                   
						    
		                     <a  style="margin-left:10px;" href='<c:url value="/admin_quanly_nguoidung?action=danhsach_nguoidung&page=1&maxPageItem=40&sapxeptheothuoctinh=quyenhan&sapxeptheochieu=asc"/>' class="btn btn-info">Làm mới dữ liệu</a>
	                     <button onclick="tableToExcel()" style="margin-left:10px;" class="btn btn-primary ">Xuất file Excel</button>
                      </div>    
              
                          
                  </div>
                 
           
                  </div>
                  </form>
                  <form action="<c:url value='/admin_quanly_nguoidung?action=danhsach_nguoidung'/>" id="form_submit" method="get">
                <div class="table-responsive text-nowrap">
                  <table class="table">
                    <thead class="table-dark">
                      <tr>
                                        <th class="text-white">Mã người dùng</th>
									    <th class="text-white">Chức vụ</th>
									    <th class="text-white">Thuộc khoa</th>
										<th class="text-white">Họ người dùng</th>
										<th class="text-white">Tên người dùng</th>
										<th class="text-white">SDT</th>
										<th class="text-white">Gmail</th>
										<th class="text-white">Quyền hạn</th>
										<th class="text-white">Trạng thái</th>
										<th class="text-white">Tùy chọn</th>
                      </tr>
                    </thead>
                    <tbody class="table-border-bottom-0">
                    	<c:forEach var="item" items="${nguoidung.danhsach}" >
                      <tr>
                                        <td >USERID##${item.maNguoiDung}</td>
										<td>${item.bangchucvu.tenchucvu}</td>
										<td>${item.donvitructhuoc.tenDonViTrucThuoc}</td>
										<td>${item.hoNguoiDung}</td>
										<td>
										<img src="${pageContext.request.contextPath}/avatar_user/${item.anhDaiDien}" style="width: 30px; height: 30px;" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/image_not/imge_not.png';" alt="Avatar" class="rounded-circle" />
										${item.tenNguoiDung}</td>
										<td>${item.sdt}</td>
										<td>${item.gmail}</td>
										<td>${item.quyenHan}</td>
										<c:if test="${item.trangThai eq 1}">
                                          <td><span class="badge bg-label-success me-1">Đang hoạt động</span></td>
                                        </c:if>
                                       <c:if test="${item.trangThai eq 0}">
										    <td><span class="badge bg-label-warning me-1">Đang bị khóa</span></td>
										 </c:if>
                        <td>
                          <div class="dropdown">
                            <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                              <i class="bx bx-dots-vertical-rounded"></i>
                            </button>
                            <div class="dropdown-menu">
                            <c:if test="${item.trangThai eq 1}">
                              <a class="dropdown-item" href='<c:url value="/admin_capnhat_trangthai_nguoidung_them0?maNguoiDung=${item.maNguoiDung}&action=capnhat_trangthai_nguoidung_them0"/>'
								 >
								  <i class='bx bx-up-arrow'></i> Khóa tài khoản này
								</a>
                             </c:if>
                              <c:if test="${item.trangThai eq 0}">
                              <a class="dropdown-item" href='<c:url value="/admin_capnhat_trangthai_nguoidung_them0?maNguoiDung=${item.maNguoiDung}&action=capnhat_trangthai_nguoidung_them1"/>'
								 >
								  <i class='bx bx-up-arrow'></i> Mở khóa tài khoản này
								</a>
                             </c:if>
                            </div>
                          </div>
                        </td>
                      </tr>
                      </c:forEach>
      
                    </tbody>
                    		
                  </table>
                 
					 
						    <input type="hidden" value="" id="action" name="action"/>
							<input type="hidden" value="" id="page" name="page"/>
							<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
							<input type="hidden" value="" id="sapxeptheothuoctinh" name="sapxeptheothuoctinh"/>
							<input type="hidden" value="" id="sapxeptheochieu" name="sapxeptheochieu"/>		
                  
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
                 </div>
              </div>
        







<%-- <div class="main-content">
<form action="<c:url value='/admin_quanly_nguoidung'/>" id="form_submit" method="get">
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
				    <h4  class="card-title">Bảng 1</h4>	
					   <div style="display: flex; justify-content: flex-end;">
					    <h4 style="" class="card-title">
				      	<button onclick="tableToExcel()" class="btn btn-primary ">Xuất file Excel</button>
				      	<button  onclick="tableToExcel()" class="btn btn-primary ">Thêm thủ công</button>	
				      	</h4>
					   </div>
						<p class="card-description">
							Dữ liệu mới nhất được cập nhật vào ngày
							<code>2/2/2023</code>
						</p>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>Mã người dùng</th>
									    <th>Chức vụ</th>
										<th>Họ người dùng</th>
										<th>Tên người dùng</th>
										<th>SDT</th>
										<th>Gmail</th>
										<th>Quyền hạn</th>
										<th>Trạng thái</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="item" items="${nguoidung.danhsach}" >
								<tr>
								        <td style="color:yellow;">USERID##${item.maNguoiDung}</td>
										<td>${item.bangchucvu.tenchucvu}</td>
										<td>${item.hoNguoiDung}</td>
										<td>${item.tenNguoiDung}</td>
										<td>${item.sdt}</td>
										<td>${item.gmail}</td>
										<td>${item.quyenHan}</td>
										<c:if test="${item.trangThai eq 1}">
                                          <td><label class="badge badge-success">Đang hoạt động</label></td>
                                        </c:if>
                                       <c:if test="${item.trangThai eq 0}">
										    <td><label class="badge badge-danger">Đang bị khóa</label></td>
										 </c:if>
                                       
										
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
 <script src="<c:url value='/template/twb/table2excel.js' />"></script>
 <script src="<c:url value='/template/twb/script.js' />"></script>
   <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script >
	/* var totalPages=${nguoidung.totalPage};
	var currentPage=${nguoidung.page}; */
			var totalPages=${nguoidung.totalPage};
			var currentPage=${nguoidung.page};
			var limit=40;
				$(function() {
					window.pagObj = $('#pagination').twbsPagination({
						totalPages : totalPages,
						visiblePages :10,
						startPage:currentPage,
						onPageClick : function(event, page) {
							if(currentPage!=page)
								{
								$('#action').val('danhsach_nguoidung');
								$('#maxPageItem').val(limit);
								$('#page').val(page);
								$('#sapxeptheothuoctinh').val('quyenhan');
								$('#sapxeptheochieu').val('asc');
								$('#form_submit').submit();
								
								}
							
						}
					});
				});
	</script>
</body>
</html>

